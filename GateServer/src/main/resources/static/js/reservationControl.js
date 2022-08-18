$(function(){
    getReservations("booked")

    $("#upcoming_button").on("click", function(){
        getReservations("booked")
    })

    $("#cancelled_button").on("click", function(){
        
        getReservations("cancelled")
    }) 

    $("#completed_button").on("click", function(){
        getReservations("completed")
    })

    $("#reservationView").on("click", "button[name=cancel]", function(){
        const body = $(this).parent().parent().parent()
        
        $.ajax({
            url: `http://localhost:8080/user/cancelBooking/${body.attr("bookingId")}`,
            type: "get",
            contentType: "application/json",
            cache: false
        }).done(function(cancelBooking){
            console.log(cancelBooking)
            getReservations("booked")
    
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
    })
})

function getReservations(status){
    const data = {
        uId: $("#user").attr("uId"),
        status: status
    }
    $.ajax({
        url: `http://localhost:8080/user/getBookingDetails`,
        type: "post",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(data),
        cache: false
    }).done(function(bookingDetails){
        const view = $("#reservationView")
        view.empty()
        for(let bd of bookingDetails){
            view.append(setReservation(bd))
        }

    }).fail(function (xhr, status, error) {
        console.log(`${xhr.status}: ${xhr.statusText}`)
    })

    $("#comment").on("shown.bs.modal", function(event){
        const hotelName = $(event.relatedTarget).attr("hotelName")
        $("#commentSubmit").attr("hotelName", hotelName)
        $(this).off('shown.bs.modal');
    })
    
    $("#commentSubmit").on('click', function(){
        const data = {hotelName: $(this).attr("hotelName"), userId: $("#user").attr("uId")}
        const body = $(this).parent()
        const comment = body.find(".comment").find("textarea")
        data[$(comment).attr("name")] = $(comment).val()
        const rates = body.children(".comment_rate")
        for(let r of rates){
            const input = $(r).find("input")
            if(input.is(":checked")){
                data[input.attr("name")] = input.val()
                break
            }
        }
        $.ajax({
            url: `http://localhost:8080/user/makeComment`,
            type: "post",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(data),
            cache: false
        }).done(function(data){
            console.log(data)
    
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
        
    })

    $("#hotelViews").on("shown.bs.modal", function(event){
        const hotelId = $(event.relatedTarget).attr("hotelId")
        // get hotel and show info in #hotel_viewHeader
        $.ajax({
            url: `http://localhost:8080/getHotel/${hotelId}`,
            type: "get",
            contentType: "application/json",
            cache: false
        }).done(function(hotel){
            const header = $("#hotel_viewHeader")
            header.empty()
            // add css
            header.append(`<h3>${hotel.hotelName}</h3>`)
           
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
        // get comments and show in #hotel_viewBody
        $.ajax({
            url: `http://localhost:8080/getComments/${hotelId}`,
            type: "get",
            contentType: "application/json",
            cache: false
        }).done(function(comments){
            const body = $("#hotel_viewBody")
            body.empty()
            for(let c of comments){
                body.append(loadComment(c))
            }
           
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
    })

    $("#QuestionForm").on("shown.bs.modal", function(event){
        const hotelId = $(event.relatedTarget).attr("hotelId")
        $("#hotelId").val(hotelId)
        $("#userEmail").val($("#user").attr("uId"))
        $(this).off('shown.bs.modal');
    })

    $("#qa_submit").on("click", function(){
        const body = $(this).parent()
        const inputs = $(body).children(".form_input")
        const today = new Date().toLocaleDateString("en-CA")
        const data = {status: "pending", createDate: today}
        for(let i of inputs){
            data[$(i).attr("name")] = $(i).val()
        }
        $.ajax({
            url: "http://localhost:8080/user/sumbitQuestion",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(data),
            dataType: "json"
        }).done(function(data){
            console.log(data)
        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
    })

    $("#qasView").on("shown.bs.modal", function(event){
        const hotelId = $(event.relatedTarget).attr("hotelId")
        $.ajax({
            url: `http://localhost:8080/getQuestions?hotelId=${hotelId}&status=common`,
            type: "get",
            contentType: "application/json",
            cache: false
        }).done(function(qas){
            const body = $("#commonQuestions")
            body.empty()
            for(let qa of qas){
                body.append(setQA(qa))
            }

        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
    })

    $("#userQAs").on("shown.bs.modal", function(event){
        const hotelId = $(event.relatedTarget).attr("hotelId")
        
        $.ajax({
            url: `http://localhost:8080/getQuestions?hotelId=${hotelId}&status=answered`,
            type: "get",
            contentType: "application/json",
            cache: false
        }).done(function(qas){
            console.log(qas)
            const body = $("#userQuestions")
            body.empty()
            for(let qa of qas){
                body.append(setUserQA(qa))
            }

        }).fail(function (xhr, status, error) {
            console.log(`${xhr.status}: ${xhr.statusText}`)
        })
    })
}

function setUserQA({id, userEmail, question, serviceId, answer}){
    return `
    <div class="card">
        <div class="card-header" id="q${id}">
            <h2 class="mb-0">
                <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#a${id}" aria-expanded="false" aria-controls="a${id}">
                    ${userEmail}: ${question}
                </button>
            </h2>
        </div>
        <div id="a${id}" class="collapse" aria-labelledby="q${id}" data-parent="#userQuestions">
            <div class="card-body">
                ${serviceId}: ${answer}
            </div>
        </div>
    </div>
    `
}

function setQA({id, question, answer }){
    return `
    <div class="card">
        <div class="card-header" id="q${id}">
            <h2 class="mb-0">
                <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#a${id}" aria-expanded="false" aria-controls="a${id}">
                    ${question}
                </button>
            </h2>
        </div>
        <div id="a${id}" class="collapse" aria-labelledby="q${id}" data-parent="#commonQuestions">
            <div class="card-body">
                ${answer}
            </div>
        </div>
    </div>
    `
}

function loadComment({userId, rate, comment}){
    let stars = ratingStars(rate)

    return `<div class="card">
                <div class="card-header">${userId} ${stars}</div>
                <div class="card-body">
                    <p class="card-text">${comment}</p>
                </div>
            </div><br>`
}

function ratingStars(rate){
    let stars = ""
    let i;
    for(i=1; i<=rate; i++){
        stars += `<i class="bi bi-star-fill"></i>`
    }
    for(i; i<=5; i++){
        stars += `<i class="bi bi-star"></i>`
    }
    return stars
}

function setReservation({id, hotelName, checkInDate, checkOutDate, noRooms, status, userName, checkInTime, checkOutTime, hotelId}){
    let action = ""
    const i = new Date(checkInDate)
    const o = new Date(checkOutDate)
    const days = (o-i)/1000/3600/24

    if(status === "booked"){
        action = `<button class="btn btn-primary" name="cancel">Cancel Reservation</button>`
    }else if(status === "completed"){
        action = `<h2>Completed</h2>`
    }else if(status === "cancelled"){
        action = `<h2>Cancelled</h2>`
    }

    
    return `<br><div class="card">
        <h3 class="card-header">
            <a href="#" role="button" data-toggle="modal" data-target="#hotelViews" hotelId=${hotelId}>${hotelName}</a>
        </h3>
        <div class="card-body" bookingId=${id}>
            <div class="row">
                <div class="col-9">
                    <div class="row">
                        <div class="col-4"><h5>Check In Time</h5><p>${checkInDate}</p><p>Check in at ${checkInTime}</p></div>
                        <div class="col-4"><h5>Check Out Time</h5><p>${checkOutDate}</p><p>Check out at ${checkOutTime}</p></div>
                        <div class="col-4"><p>${noRooms} rooms, ${days} nights</p> <p>${userName}</p></div>
                    </div>
                </div>
                <div class="col-3">
                    ${action}<br><br>
                    <button hotelName='${hotelName}' type="button" class="btn btn-primary" data-toggle="modal" data-target="#comment">Leave a Comment</button>
                </div>
                <div class="col-4"><a role="button" data-toggle="modal" data-target="#QuestionForm" href="#" hotelId=${hotelId}>Ask a Question</a></div>
                <div class="col-4"><a role="button" data-toggle="modal" data-target="#qasView" href="#" hotelId=${hotelId}>View QA's</a></div>
                <div class="col-4"><a role="button" data-toggle="modal" data-target="#userQAs" href="#" hotelId=${hotelId}>View Users' QAs</a></div>
            </div>
        </div>
    </div>`
}