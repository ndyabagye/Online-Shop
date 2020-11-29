<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="views/bootstrap.min.css" >
<title>Product Details</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
	
	response.setHeader("Pragma","no-cache");  //HTTP 1.0
	
	response.setHeader("Expires", "0"); //proxy server
	
	if(session.getAttribute("uname")==null){
		response.sendRedirect("userLogin.jsp");
	}
	%>
	<%@include file="header.jsp" %>
	
	<div align="center" style="padding-top: 50px;">
	<div class="card mb-3" style="max-width: 540px;">
  <div class="row no-gutters">
    <div class="col-md-4">
       <c:if test="${productImage ==null}">
             <img src="views/shop-item.svg" class="card-img mt-3"/>
             </c:if>
             <c:if test="${productImage != null}">
             <img src="Images/${productImage }" class="card-img mt"/>
             </c:if>
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">${productName }</h5>
        <p class="card-text">${description }</p>
        <p class="card-text">Price : UGX ${cost }</p>
      </div>
    </div>
  </div>
</div>

<form action="addToCart">
<label for="quantity">Quantity</label>
				<input type="hidden" value="${prodId}" name="prodId"/>
				<input type="hidden" value="${productName}" name="prodName"/>
				<input type="hidden" value="${cost}" name="prodCost"/>
				<input type="text" class="form-control col-md-4 mb-4"
				placeholder="Enter Quantity" min="1" max="100" required name="quantity"/>
				<input type="submit" class="btn btn-primary"value="Add To Cart"/>
	</form>
</div>
</body>
</html>