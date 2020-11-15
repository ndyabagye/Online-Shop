<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="views/bootstrap.min.css" >
<title>Insert title here</title>
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
<img class="mb-2" src="views/online-shop.svg" alt="" width="20" height="20">
  <a class="navbar-brand" href="#">Online Shop</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="welcomePage.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">View Cart</a>
      </li>
      
      <c:if test="${adminToken!=null }">
      <li class="nav-item">
        <a class="nav-link" href="productCreate">Create Products</a>
      </li>
      </c:if>
     
    </ul>
  </div>
    <li class="nav-link mr">
       <b> ${uname }</b>
      </li>
      <form action="Logout">
		<input type="submit" class="btn btn-primary" value="Logout">
	</form>
</nav><br><br>

</html>