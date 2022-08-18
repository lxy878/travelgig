<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Home Page of Travel Gig</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
	<link rel="stylesheet" href="/css/home.css" />
	<script src="/js/home.js"></script>
</head>

<body>
	<div class="container" style="margin-left:100px">
		<h1>Welcome to Travel Gig</h1>
		<c:choose>
			<c:when test="${not empty uId}">
				<a href="/user/upcomeReservation/${uId}">View</a>
				<a href="/login?logout">logout</a>
			</c:when>
			<c:otherwise>
				<a href="/login\">login</a>
			</c:otherwise>
		</c:choose>
		<h2>Search your desired hotel</h2>
	</div>

	<div class="container border rounded" style="margin:auto;padding:50px;margin-top:50px;margin-bottom:50px">
		<h3>Narrow your search results</h3>
		<div class="form-row" id="searchForm">
			<div class="col-3">
				Hotel/City/State/Address <input class="form-control" type="text" id="searchLocation"
					name="searchLocation" />
			</div>
			<div class="col-2">
				No. Rooms: <input class="form-control" type="number" id="noRooms" name="noRooms" />
			</div>
			<div class="col-2">
				No. Guests: <input class="form-control" type="number" id="noGuests" name="noGuests" />
			</div>
			<div class="col">
				Check-In Date: <input type="date" id="checkInDate" name="checkInDate" />
			</div>
			<div class="col">
				Check-Out Date: <input type="date" id="checkOutDate" name="checkOutDate" />
			</div>
			<input class="btn-sm btn-primary" type="button" id="searchBtn" value="SEARCH" />
		</div>
	</div>

	<div class="row">
		<div class="col-2 border rounded" style="margin-left:50px;padding:25px">

			<br>
			Star Rating:<br>
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="checkbox" class="star_rating form-check-input" id="1_star_rating" name="stars"
						value=1>1
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="checkbox" class="star_rating form-check-input" id="2_star_rating" name="stars"
						value=2>2
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="checkbox" class="star_rating form-check-input" id="3_star_rating" name="stars"
						value=3>3
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="checkbox" class="star_rating form-check-input" id="4_star_rating" name="stars"
						value=4>4
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label">
					<input type="checkbox" class="star_rating form-check-input" id="5_star_rating" name="stars"
						value=5>5
				</label>
			</div><br><br>

			Range:
			<div class="slidecontainer">
				<input type="range" min="1" max="2000" value="500" class="slider" id="priceRange">
				<p>Price: $<span id="priceValue"></span></p>
			</div>

			<div class="form-check">
				<input type="checkbox" class="hotel_amenity form-check-input" id="amenity_parking"
					name="amenities" value="Parking" />
				<label class="form-check-label" for="amenity_parking">Parking</label><br>

				<input type="checkbox" class="hotel_amenity form-check-input" id="amenity_room_service"
					name="amenities" value="Room service" />
				<label class="form-check-label" for="amenity_checkin_checkout">Room Service</label><br>

				<input type="checkbox" class="hotel_amenity form-check-input" id="amenity_breakfast"
					name="amenities" value="Breakfast" />
				<label class="form-check-label" for="amenity_breakfast">Breakfast</label><br>

				<input type="checkbox" class="hotel_amenity form-check-input" id="amenity_bar_lounge"
					name="amenities" value="Bar or Lounge" />
				<label class="form-check-label" for="amenity_bar_lounge">Bar / Lounge</label><br>

				<input type="checkbox" class="hotel_amenity form-check-input" id="amenity_fitness_center"
					name="amenities" value="Fitness c	enter" />
				<label class="form-check-label" for="amenity_fitness_center">Fitness Center</label><br>
			</div>

			<input style="margin-top:25px" class="btn btn-primary" type="button" id="filterBtn"
				value="FILTER" />
		</div>


		<div class="col-7 border rounded" style="margin-left:50px;">
			<div style='text-align:center;font-size:20px;font-family:"Trebuchet MS", Helvetica, sans-serif'>List
				of Hotels:</div>

			<div id="listHotel">
			</div>

		</div>
	</div>

	<div class="modal" id="roomSearch">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Search Hotel Rooms</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="col" id="roomSearchInputs">
						<input class="form-control" type="hidden" id="modal_hotelId" name="hotelId" />
						Hotel Name: <input readonly="true" class="form-control" type="text" id="modal_hotelName"
							name="hotelName" />
						No. Guests: <input class="form-control" type="number" id="modal_noGuests"
							name="noGuests" />
						Check-In Date: <input class="form-control" type="date" id="modal_checkInDate"
							name="checkInDate" />
						Check-Out Date: <input class="form-control" type="date" id="modal_checkOutDate"
							name="checkOutDate" />
						Room Type:
						<select class="form-control" id="modal_roomType" name="roomTypes">
						</select>
						No. Rooms: <input class="form-control" type="number" id="modal_noRooms"
							name="noRooms" />
						<input style="margin-top:25px" class="btn btn-searchHotelRooms btn-primary"
							type="button" data-dismiss="modal" data-toggle="modal"
							data-target="#roomSearchResult" value="SEARCH" />
					</div>

				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

	<div class="modal" id="roomSearchResult">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Room Options</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body" id="hotelRooms_modalBody">

					<table class="table table-hover">
						<thead>
							<tr>
								<th>Room Type/Amenities</th>
								<th>Number of Rooms</th>
								<th>Description/Policies</th>
								<th>Discount</th>
								<th>Price</th>
								<th>Select Amount</th>
							</tr>
						</thead>
						<tbody id="roomList">
						</tbody>
					</table>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal" data-toggle="modal"
						data-target="#bookingHotelRoomModal">View Amount</button>
				</div>

			</div>
		</div>
	</div>

	<div class="modal" id="bookingHotelRoomModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title"></h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body" id="bookingRoom_modalBody">
					<div class="col">
						<form action="/bookingStatus" method="post">
							<div><input class="form-control" type="hidden" id="booking_hotelId"
									name="hotelId" /></div>
							<div><input class="form-control" type="hidden" id="booking_hotelRoomId"
									name="hotelRoomId" /></div>
							<div>Hotel Name: <input readonly="true" class="form-control" type="text"
									id="booking_hotelName" name="hotelName" /></div>
							<div>Email: <input value="${uId}" class="form-control" type="email"
									id="booking_email" name="email" /></div>
							<div id="noGuestsDiv">No. Guests: <input readonly="true" class="form-control"
									type="number" id="booking_noGuests" name="noGuests" /></div>
							<div>No. Rooms: <input readonly="true" class="form-control" type="number"
									id="booking_noRooms" name="noRooms" /></div>
							<div>Check-In Date: <input readonly="true" class="form-control" type="text"
									id="booking_checkInDate" name="checkInDate" /></div>
							<div>Check-Out Date: <input readonly="true" class="form-control" type="text"
									id="booking_checkOutDate" name="checkOutDate" /></div>
							<div>Room Type: <input readonly="true" class="form-control" type="text"
									id="booking_roomType" name="roomType" /></div>
							<div>Total Price: $<input class="form-control" type="number" id="booking_price"
									name="price" readonly="true"></span></div>
							<div style='margin-top:20px'>
								<input type="submit" class='btn-confirm-booking btn btn-primary' id="booking"
									value="Confirm Booking" />
								<button class='btn btn-primary' data-dismiss="modal" data-toggle="modal"
									data-target="#roomSearch" id="book_edit">Edit</button>
							</div>
						</form>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

	<div class="modal" id="hotelViews">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<div id="hotel_viewHeader"></div>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body" id="hotel_viewBody">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">userEmail</h5>
							<div>rate/5</div>
							<p class="card-text">comment</p>
						</div>
					</div><br>
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">userEmail</h5>
							<div>rate/5</div>
							<p class="card-text">comment</p>
						</div>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
				</div>

			</div>
		</div>
	</div>

	<div class="modal" id="qasView">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">View Questions </h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body" id="questions_body">

                    <div class="accordion" id="commonQuestions">
                        <div class="card">
                            <div class="card-header" id="q1">
                                <h2 class="mb-0">
                                    <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#a1" aria-expanded="false" aria-controls="a1">
                                        Q1
                                    </button>
                                </h2>
                            </div>
                            <div id="a1" class="collapse" aria-labelledby="q1" data-parent="#commonQuestions">
                                <div class="card-body">
                                    A1
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <!-- Modal footer -->
                <div class="modal-footer">

                </div>
            </div>
        </div>
    </div>

	<div class="modal" id="userQAs">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">View Other Users' Questions </h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body" id="userQAs_body">

                    <div class="accordion" id="userQuestions">
                        <div class="card">
                            <div class="card-header" id="q1">
                                <h2 class="mb-0">
                                    <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#a1" aria-expanded="false" aria-controls="a1">
                                        Q1
                                    </button>
                                </h2>
                            </div>
                            <div id="a1" class="collapse" aria-labelledby="q1" data-parent="#userQuestions">
                                <div class="card-body">
                                    A1
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <!-- Modal footer -->
                <div class="modal-footer">

                </div>
            </div>
        </div>
    </div>

	<script>
		var slider = document.getElementById("priceRange");
		var output = document.getElementById("priceValue");
		output.innerHTML = slider.value;
		slider.oninput = function () {
			output.innerHTML = this.value;
		}
	</script>
</body>

</html>