$(function(){
    $("#searchBtn").on("click", function(){
        const divs = $("#searchForm").children("div")
        const data = {}
        for(let d of divs){
            const input = $(d).find("input")
            data[$(input).attr("name")] = $(input).val()
        }
        console.log(data)
        $.ajax({
            url: `http://localhost:8080/searchHotels`,
            type: "post",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(data),
            cache: false
        }).done(function(hotels){
            console.log(hotels)
            const list = $("#listHotel")
            list.empty()
            for(let h of hotels){
                list.append(showHotel(h, data))
            }
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
    })
})


function showHotel({imageURL, city, state, averagePrice, discount, hotelId, hotelName, starRating, amenities},{searchLocation, noRooms, noGuests, checkInDate, checkOutDate}){
    let as = ""
    let stars = ""
    for(let a of amenities.slice(0,3)){
        as += `<i class="bi bi-check"></i><div class="col-md-3 font-small">${a.name}</div>`
    }
    for(let i=0; i<starRating; i++){
        stars += `<i class="bi bi-star-fill"></i>`
    }
    return `<a href="/${hotelId}?searchLocation=${searchLocation}&noRooms=${noRooms}&noGuests=${noGuests}&checkInDate=${checkInDate}&checkOutDate=${checkOutDate}" class="a-none">
        <div class="card mb-3">
            <div class="row g-0">
                <div class="col-md-4">
                    <img src=${imageURL} class="img-fluid rounded-start" alt="...">
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title text-truncate">${hotelName}</h5>
                        <p class="card-text"><small class="text-muted">${city}, ${state} </small> ${stars}</p>
                        <div class="row g-0">${as}</div><br>
                        <div class="row g-0"><div class="col-md-9"></div><div class="col-md-3 font-large"><strong>$${averagePrice-averagePrice*discount}</strong></div></div>
                    </div>
                </div>
            </div>
        </div>
    </a>`
}