<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="views/bootstrap.min.css" >
<title>Update Product</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
	
	response.setHeader("Pragma","no-cache");  //HTTP 1.0
	
	response.setHeader("Expires", "0"); //proxy server
	
 	 //check to verify if admin
	if(session.getAttribute("uname")==null || session.getAttribute("adminToken")==null){
		response.sendRedirect("adminLogin.jsp");
	}
	%>
	
	<%@include file="header.jsp" %>
	
	<div class="col d-flex justify-content-center">
		<div class="card col-md-10">
	  		<div class="card-body">
	  		<h5 class="card-title ">Update Product</h5>
			<form action="productUpdate" method="post">
			<div class="form-group">
	    		<label for="productName">Product Name</label>
	   			<input type="text" class="form-control col-md-10" value="${productName}" name="productName" placeholder="Enter name">
	  		</div>
	  		<div class="form-group">
	    		<label for="cost">Product Cost</label>
	   			<input type="text" class="form-control col-sm-10" value="${cost}" name="cost" placeholder="Enter cost">
	  		</div>
	  		<div class="form-group">
	    		<label for="description">Product Description</label>
	   			<textarea class="form-control col-sm-10" rows="3" name="description" placeholder="Enter description">
	   			${description}
	   			</textarea>
	  		</div>
	  		<input type="hidden" value="${prodId }" name="id"/>
				<input type="submit" class="btn btn-primary" value="Update Product"/>
			</form>
		</div>
		</div>
	</div>
</body>
</html>