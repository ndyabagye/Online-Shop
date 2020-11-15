<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="views/bootstrap.min.css" >
<title>Online Shop Welcome</title>
</head>
<body>
<div align="center">
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
	
	response.setHeader("Pragma","no-cache");  //HTTP 1.0
	
	response.setHeader("Expires", "0"); //proxy server
	
	if(session.getAttribute("uname")==null){
		response.sendRedirect("userLogin.jsp");
	}
	%>
	<%@include file="header.jsp" %>
	Welcome to online shop ${uname }
	
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/onlineshop"
		user="root" password=""/>
	<sql:query var="rs" dataSource="${db}">
		select * from products
	</sql:query>
	
	<div class="col-lg-10">
	
<table class="table table-hover table-responsive-lg">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Product Name</th>
      <th scope="col">Product Cost</th>
      <th scope="col">Action</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${rs.rows }" var="prod">
    <tr>
      <th scope="row">${prod.id }</th>
      <td>${prod.productName }</td>
      <td>${prod.cost }</td>
      <td><c:if test="${adminToken==null}">
			<form action="addToCart">
				<input type="hidden" value="${prod.id}" name="id"/>
				<input type="submit" value="Add To Cart"/>
			</form>
			</c:if>
			<c:if test="${adminToken!=null}">
			<form action="productUpdate">
				<input type="hidden" class="btn btn-primary" value="${prod.id}" name="id"/>
				<input type="submit" value="Update"/>
			</form>
			</c:if>
		</td>
		<td>
		<c:if test="${adminToken!=null}">
			<form action="productDelete">
				<input type="hidden" class="btn btn-danger" value="${prod.id}" name="id"/>
				<input type="submit" value="Delete"/>
			</form>
			</c:if>
			<c:if test="${adminToken==null}">
			<form action="productDetails">
				<input type="hidden" class="btn btn-primary" value="${prod.id}" name="id"/>
				<input type="submit" value="View Details"/>
			</form>
			</c:if>
		</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
	</div>


	</div>
</body>
</html>