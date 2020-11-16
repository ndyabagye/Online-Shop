<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="views/bootstrap.min.css" >
<title>Error Page</title>
</head>
<body>
<div class="col d-flex justify-content-center">
		
	  		<div class="card-body">
		<div class="alert-success">
		
		<h3>Error <%=exception.getMessage() %></h3>
		</div>
	</div>

	</div>
</body>
</html>