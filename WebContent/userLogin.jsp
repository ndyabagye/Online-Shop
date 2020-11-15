<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="views/bootstrap.min.css" >
<title>User Login Page</title>
</head>
<body>
<div align="center" style="padding-top: 100px;">
<div class="col d-flex justify-content-center">
		<div class="card col-md-8">
	  		<div class="card-body">
	  		<img class="mb-4" src="views/online-shop.svg" alt="" width="72" height="72">
	  		<h5 class="card-title ">User Login Page</h5>
			<form action="userLogin" method="post">
			<div class="form-group">
	    		<label for="fullname">Full Name</label>
	   			<input type="text" class="form-control col-md-6" name="fullname" placeholder="Enter your name">
	  		</div>
	  		<div class="form-group">
	    		<label for="password">Password</label>
	   			<input type="password" class="form-control col-sm-6" name="password" placeholder="Enter password">
	  		</div>
				<input type="submit" class="btn btn-primary" value="Sign in "/>
			</form>
			<br><br>
			<a class="btn btn-danger" href="adminLogin">Sign in  as Admin</a>
		</div>
		</div>
	</div>
	</div>
</body>
</html>