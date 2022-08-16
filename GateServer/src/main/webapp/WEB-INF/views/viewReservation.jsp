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
<link rel="stylesheet" href="/css/view.css"/>
<script src="/js/reservationControl.js"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg bg-light" id="user" uId="${uId}">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">TravelGig</a>
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
            <a role="button" class="btn btn-primary" href="/login?logout">Log out</a>
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
                    <button type="button" class="btn btn-primary" data-dismiss="modal" data-toggle="modal" data-target="#comment">Leave a Comment</button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal" id="comment">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Leave a Comment</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <div class="modal-body" id="hotelRooms_modalBody">        
                <div class="form-floating comment">
                    <textarea class="form-control" name="comment" placeholder="Leave a comment here" id="textarea"></textarea>
                </div>
                Rate: 
                <div class="form-check form-check-inline comment_rate">
                    <input class="form-check-input" type="radio" name="rate" value="1">
                    <label class="form-check-label" >1</label>
                </div>
                <div class="form-check form-check-inline comment_rate">
                    <input class="form-check-input " type="radio" name="rate" value="2">
                    <label class="form-check-label" >2</label>
                </div>
                <div class="form-check form-check-inline comment_rate">
                    <input class="form-check-input" type="radio" name="rate" value="3">
                    <label class="form-check-label" >3</label>
                </div>
                <div class="form-check form-check-inline comment_rate">
                    <input class="form-check-input" type="radio" name="rate" value="4">
                    <label class="form-check-label" >4</label>
                </div>
                <div class="form-check form-check-inline comment_rate">
                    <input class="form-check-input" type="radio" name="rate" value="5">
                    <label class="form-check-label" >5</label>
                </div>

                <br><input style="margin-top:25px" class="btn btn-primary" type="button" data-dismiss="modal" value="Comment" id="commentSubmit"/>       	
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                
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
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
            </div>

            </div>
        </div>
    </div>
    
     <div class="modal" id="QuestionForm">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Submit a Question</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <div class="modal-body" id="QuestionForm_body">        
                <input class="form_input" name="hotelId" id="hotelId" hidden/>
                <input class="form_input" name="userEmail" id="userEmail" hidden/>
                <textarea class="form-control form_input" name="question" placeholder="Type your Question" id="textarea"></textarea>

                <br><input style="margin-top:25px" class="btn btn-primary" type="button" data-dismiss="modal" value="Send a Question" id="qa_submit"/>       	
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                
            </div>
        </div>
    </div>
</body>
</html>