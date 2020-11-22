<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="views/bootstrap.min.css" >
<title>Cart Page</title>
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
	
	<div class="col d-flex justify-content-center">
<table class="table table-hover table-responsive-lg">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Product Name</th>
      <th scope="col">Quantity</th>
      <th scope="col">Product Cost</th>
      <th scope="col">Total Cost</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${cart}" var="prod">
    <tr>
      <td>${prod.productName}</td>
      <td>${prod.quantity }</td>
      <td>UGX ${prod.cost }</td>
      <td>UGX ${prod.totalCost }</td>
      <td>
      	<c:if test="${adminToken==null}">
			<form action="deleteItem" class="mr-6">
				<input type="hidden" value="${prod}" name="cartItem"/>
				<input type="hidden" value="${prod.quantity}" name="cartQuantity"/>
				<input type="hidden" value="${prod.productId}" name="cartId"/>
				<input type="submit" class="btn btn-danger" value="Delete"/>
			</form>
			</c:if>
      </td>
    </tr>
    </c:forEach>    
  </tbody>
</table>
</div>
	<section class="container">
    <div class="row">
            <div style="padding-bottom: 25px">
                <div class="thumbnail">
                    <div class="caption">
                    	<h4>Grand Total = UGX ${GrandTotal }</h4>
                    </div></div></div></div></section>
</body>
</html>