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
        console.log(bookingDetails)
        for(let bd of bookingDetails){
            view.append(setReservation(bd))
        }

    }).fail(function (xhr, status, error) {
        console.log(`${xhr.status}: ${xhr.statusText}`)
    })
}

function setReservation({id, hotelName, checkInDate, checkOutDate, noRooms, status, userName, checkInTime, checkOutTime}){
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
        <h3 class="card-header">${hotelName}</h3>
        <div class="card-body" bookingId=${id}>
            <div class="row">
                <div class="col-9">
                    <div class="row">
                        <div class="col-4"><h5>Check In Time</h5><p>${checkInDate}</p><p>Check in at ${checkInTime}</p></div>
                        <div class="col-4"><h5>Check Out Time</h5><p>${checkOutDate}</p><p>Check out at ${checkOutTime}</p></div>
                        <div class="col-4"><p>${noRooms} rooms, ${days} nights</p> <p>${userName}</p></div>
                    </div>
                </div>
                <div class="col-3">${action}</div>
            </div>
        </div>
    </div>`
}