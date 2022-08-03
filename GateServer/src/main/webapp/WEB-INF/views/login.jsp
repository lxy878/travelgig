<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link rel='stylesheet' href='/css/login.css'>
<script src="/js/register.js"></script>
</head>
<body>
<div class="login">
  <h1>Login to Web App</h1>
  <p>${Message}</p>
  <form action="/login" method="POST">
    <p><input type="text" name="username" value="" placeholder="Email" required="required"></p>
    <p><input type="password" name="password" value="" placeholder="Password" required="required"></p>
    <p class="submit"><input type="submit" name="submit" value="Login"></p>
  </form>
</div>

<div class="login-help">
  <p>Create an account <a role="button" data-toggle="modal" data-target="#userRegister">Click here</a>.</p>
</div>

<div class="modal" id="userRegister">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Enter Your Information</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">        
        <div class="col" id="userInfo">
        	
        	Email: <input class="form-control" type="email" name="email"/>
        	Password: <input class="form-control" type="password" name="password"/>
        	First Name: <input class="form-control" type="text" name="firstName"/>
        	Last Name: <input class="form-control" type="text" name="lastName"/>
          <input value="user" class="roleNames" hidden/>

        	<input id="userSubmit" style="margin-top:25px" class="btn btn-searchHotelRooms btn-primary" type="button" data-dismiss="modal" data-toggle="modal" data-target="#roomSearchResult" value="Create a Account"/>       	
        </div>
        
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
      </div>

    </div>
  </div>
</div>

</body>
</html>