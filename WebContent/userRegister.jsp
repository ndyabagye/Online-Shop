<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="views/bootstrap.min.css" >
<title>User Registration Page</title>
</head>
<body class="text-center">
	<div align="center" style="padding-top: 100px;">
<div class="col d-flex justify-content-center">
		<div class="card col-md-8">
	  		<div class="card-body">
	  		<img class="mb-4" src="views/online-shop.svg" alt="" width="72" height="72">
	  		<h5 class="card-title ">User Register Page</h5>
			<form action="userRegister" method="post">
			<div class="form-group">
	    		<label for="fullname">Full Name</label>
	   			<input type="text" class="form-control col-md-6" name="fullname" placeholder="Enter your name">
	  		</div>
	  		<div class="form-group">
	    		<label for="email">Email Address</label>
	   			<input type="email" class="form-control col-md-6" name="email" placeholder="Enter your email">
	  		</div>
	  		<div class="form-group">
	    		<label for="phone">Phone Number</label>
	   			<input type="phone" class="form-control col-md-6" name="phone" placeholder="Enter your phoneNumber">
	  		</div>
	  		<div class="form-group">
	    		<label for="password">Password</label>
	   			<input type="password" class="form-control col-sm-6" name="password" placeholder="Enter password">
	  		</div>
				<input type="submit" class="btn btn-primary" value="Sign Up"/>
				<span class="text-muted">Already have an account? <a href="userLogin">Sign In!</a></span>
			</form>
			<br><br>
		</div>
		</div>
	</div>
	</div>
</body>
</html>