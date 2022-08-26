<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
	<link rel="stylesheet" href="/css/home.css" />
    <title>Booking Status</title>
</head>

<body>
    <div align="center">
        <a href="${pageContext.request.contextPath}/home">Home</a>
    </div>

    <%-- <form action='/charge' method='POST' id='checkout-form' modelAttribute="bookingDetail">
        <h3>View Booking Detail</h3>
        <div><input value="${hotelId}" path="hotelId" class="form-control" type="hidden" id="booking_hotelId"
                name="bd.hotelId" /></div>
        <div><input value="${bookingDetail.hotelRoomId}" path="hotelRoomId" class="form-control" type="hidden" id="booking_hotelRoomId"
                name="bd.hotelRoomId" /></div>
        <div>Hotel Name: <input value="${bookingDetail.hotelName}" path="hotelName" readonly="true" class="form-control" type="text"
                id="booking_hotelName" name="bd.hotelName" /></div>
        <div>Email: <input value="${bookingDetail.email}" path="email" class="form-control" type="email"
                id="booking_email" name="bd.email" readonly="true"/></div>
        <div id="noGuestsDiv">No. Guests: <input value="${noGuests}" path="noGuests" readonly="true" class="form-control"
                type="number" id="booking_noGuests" name="bd.noGuests" /></div>
        <div>No. Rooms: <input value="${noRooms}" path="noRooms" readonly="true" class="form-control" type="number"
                id="booking_noRooms" name="bd.noRooms" /></div>
        <div>Check-In Date: <input value="${bookingDetail.checkInDate}" path="checkInDate" readonly="true" class="form-control" type="text"
                id="booking_checkInDate" name="bd.checkInDate" /></div>
        <div>Check-Out Date: <input value="${bookingDetail.checkOutDate}" path="checkOutDate" readonly="true" class="form-control" type="text"
                id="booking_checkOutDate" name="bd.checkOutDate" /></div>
        <div>Room Type: <input value="${bookingDetail.roomType}" path="roomType" readonly="true" class="form-control" type="text"
                id="booking_roomType" name="bd.roomType" /></div>
        <div>Total Price: $<input value="${price/100}" class="form-control" type="number" id="booking_price"
                name="bd.price" readonly="true"></div>
        <input type='hidden' value="${price}" name='amount' />

        <script src='https://checkout.stripe.com/checkout.js' class='stripe-button' 
            data-key="${stripePublicKey}" 
            data-amount="${price}" 
            data-currency="${currency}"
            data-name='Payment' 
            data-description="Booking"
            data-image="https://desitecoreprod-cd.azureedge.net/_/media/images/png/svg/icon-credit-card-hand.svg?la=en&rev=8ccff093864643b7b8d8863595f1e4b0?h=180&w=180"
            data-locale='auto' data-zip-code='false'>
        </script>
    </form> --%>
</body>

</html>