<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Shop</title>
<link rel="stylesheet" href="views/bootstrap.min.css" >
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<img class="mb-2" src="views/online-shop.svg" alt="" width="20" height="20">
  <a class="navbar-brand" href="#">Online Shop</a>
  <div class="ml-auto row">  
  <form action="userLogin" class="mr-2">
		<input type="submit" class="btn btn-primary" value="Login">
	</form>
      <form action="userRegister" class="mr-2">
		<input type="submit" class="btn btn-primary" value="Register">
	</form>
  </div>
</nav><br><br>
<div align="center" style="padding-top: 100px;">
<div class="col d-flex justify-content-center">
	  		<div class="card-body">
	  		<img class="mb-4" src="views/online-shop.svg" alt="" width="150" height="150">
	  		<h5 class="card-title ">Welcome to Online shop</h5>	
		</div>
		</div>
	</div>
</body>
</html>