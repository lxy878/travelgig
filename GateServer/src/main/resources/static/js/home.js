$(function(){
    $("#searchBtn").on("click", function(){
        const divs = $("#searchForm").children("div")
        const data = {}
        for(let d of divs){
            const input = $(d).find("input")
            data[$(input).attr("name")] = $(input).val()
        }
        $.ajax({
            url: `http://localhost:8080/searchHotels`,
            type: "post",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(data),
            cache: false
        }).done(function(hotels){
            const list = $("#listHotel")
            list.empty()
            for(let h of hotels){
                list.append(showHotel(h, data))
            }
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
    })

    $('#roomSearch').on('shown.bs.modal', function(event) {
        const button = $(event.relatedTarget)
        const roomSearchInputs = $("#roomSearchInputs")
        const hotelId = button.attr("hotelId")
        const hotelName = button.parent().parent().parent().find("h5").text()
        const inputs = {}
        const hotelSearchDivs = $("#searchForm").children("div")
        for(let d of hotelSearchDivs){
            const input = $(d).find("input")
            inputs[$(input).attr("name")] = input.val()
        }
        fetchRooTypes()
        roomSearchInputs.find("#modal_hotelId").val(hotelId)
        roomSearchInputs.find("#modal_hotelName").val(hotelName)
        roomSearchInputs.find("#modal_noGuests").val(inputs["noGuests"])
        roomSearchInputs.find("#modal_checkInDate").val(inputs["checkInDate"])
        roomSearchInputs.find("#modal_checkOutDate").val(inputs["checkOutDate"])
        roomSearchInputs.find("#modal_noRooms").val(inputs["noRooms"])
       
    })

    $("#roomSearchResult").on('shown.bs.modal', function(){
        const roomSearchInputs = $("#roomSearchInputs").children("[id^=modal_]")
        const data = {}
        for(let i of roomSearchInputs){
            data[$(i).attr("name")] = $(i).val()
        }

        $.ajax({
            url: `http://localhost:8080/getRooms`,
            type: "post",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(data),
            cache: false
        }).done(function(rooms){
            
            const list = $("#roomList")
            list.empty()
            for(let r of rooms){
                list.append(setRoom(r))
            }
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
        
    })

    $("#roomList").on("change", "tr td select", function(){
        const selectTag = $(this)
        const v = selectTag.val()
        const tr = selectTag.parent().parent()
        const price = tr.find("td[name=price]").text()
        const discount = tr.find("td[name=discount]").text()
        const cost = parseFloat(price)*v*(1-parseFloat(discount))
        tr.find("td span").text(`${cost}`)

    })

    $("#bookingHotelRoomModal").on("shown.bs.modal", function(event){
        const button = $(event.relatedTarget)
        const roomSearchInputs = $("#roomSearchInputs").children(".form-control")

        const bookingRooms = $("#bookingRoom_modalBody")
        for(let i of roomSearchInputs){
            const idName =$(i).attr("id").replace("modal_","")
            const input = bookingRooms.find(`div input[id=booking_${idName}]`)
            input.val($(i).val())
        }

        const roomTrs = $("#roomList").children("tr")

        for(let tr of roomTrs){
            const isSelected = $(tr).find("td input").prop("checked")
            if(isSelected){
                // set roomId
                $("#booking_hotelRoomId").val($(tr).attr("roomId"))
                const price = $(tr).find("td[name=price]").text()
                const discount = $(tr).find("td[name=discount]").text()
                const noRooms = $("#booking_noRooms").val()
                const totalCost = parseFloat(price)*(1-parseFloat(discount))*noRooms
                $("#booking_price").val(totalCost)
                break
            }
            
        }
        
    })
})

function setRoom({hotelRoomId, type, noRooms, description, policies, price, discount, amenities}){
    
    return `<tr roomId=${hotelRoomId}>
        <td>${type.name}/amenities</td>
        <td>${noRooms}</td>
        <td><p>${description}</p><p>${policies}</p></td>
        <td name="discount">${discount}</td>
        <td name="price" >${price}</td>
        <td><input type="radio" name="option"/></td>
    </tr>`
}
function fetchRooTypes(){
    // only get room type from the hotel
    $.ajax({
        url: `http://localhost:8080/getRoomTypes`,
        type: "get",
        contentType: "application/json",
        cache: false
    }).done(function(types){
        const select = $("#modal_roomType")
        select.empty()
        for(let type of types){
            select.append(setRoomType(type))
        }
    }).fail(function (xhr, status, error) {
        console.log(`${xhr.status}: ${xhr.statusText}`)
    })
}

function setRoomType({name}){
    return `<option value="${name}">${name}</option>`
}
function showHotel({imageURL, city, state, averagePrice, discount, hotelId, hotelName, starRating, amenities}){
    let as = ""
    let stars = ""
    for(let a of amenities.slice(0,3)){
        as += `<i class="bi bi-check"></i><div class="col-md-3 font-small">${a.name}</div>`
    }
    for(let i=0; i<starRating; i++){
        stars += `<i class="bi bi-star-fill"></i>`
    }
    return `<div class="card mb-3">
                <div class="row g-0">
                    <div class="col-md-4">
                        <img src=${imageURL} class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title text-truncate">${hotelName}</h5>
                            <p class="card-text"><small class="text-muted">${city}, ${state} </small> ${stars}</p>
                            <div class="row g-0">${as}</div><br>
                            <div class="row g-0">
                                <div class="col-md-9"></div>
                                <div class="col-md-3 font-large">
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#roomSearch" hotelId=${hotelId}>
                                        <strong>$${averagePrice-averagePrice*discount}</strong>
                                    </button>   
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>`
}