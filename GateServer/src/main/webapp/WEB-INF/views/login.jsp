<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel='stylesheet' href='/css/login.css'>
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
  <p>Create an account <a href="#">Click here</a>.</p>
</div>
</body>
</html>