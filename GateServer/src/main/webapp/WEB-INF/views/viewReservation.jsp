<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Reservation Page of Travel Gig</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<script src="/js/reservationControl.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-light" id="user" uId="${uId}">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">TravelGig</a>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="nav nav-tabs">
                <li class="nav-item">
                <a class="nav-link"  role="button" id="upcoming_button">Upcoming</a>
                </li>
                <li class="nav-item">
                <a class="nav-link"  role="button" id="cancelled_button">Cancelled</a>
                </li>
                <li class="nav-item">
                <a class="nav-link"  role="button" id="completed_button">Completed</a>
                </li>
            </ul>
            </div>
        </div>
    </nav>

    <div class="container" id="reservationView">
        <div class="card">
            <h3 class="card-header">Hotel Name</h3>
            
            <div class="card-body">
                <div class="row">
                    <div class="col-9">
                        <div class="row">
                            <div class="col-4"><h5>Check In Time</h5><p>2022-01-01</p><p>Check in at 00:00</p></div>
                            <div class="col-4"><h5>Check Out Time</h5><p>2022-01-01</p><p>Check out at 00:00</p></div>
                            <div class="col-4"><p>n rooms, n nights</p> <p>Last Name, First Name</p></div>
                        </div>
                    </div>
                    <%-- <div class="col-3"><h2>Completed</h2></div> --%>
                    <div class="col-3"><button class="btn btn-primary">Cancel Reservation</button></div>
                </div>
            </div>
        </div>
    </div>
   
</body>
</html>