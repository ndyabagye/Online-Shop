<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="views/bootstrap.min.css" >
<link rel="stylesheet" href="views/styles.css" >
<title>Online Shop Welcome</title>
</head>
<body>
<div class="grid-container text-center">
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
	
	response.setHeader("Pragma","no-cache");  //HTTP 1.0
	
	response.setHeader("Expires", "0"); //proxy server
	
	if(session.getAttribute("uname")==null){
		response.sendRedirect("userLogin.jsp");
	}
	%>
	<%@include file="header.jsp" %>
	<h5>Welcome to online shop ${uname }</h5>
	
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/onlineshop"
		user="root" password=""/>
	<sql:query var="rs" dataSource="${db}">
		select * from products
	</sql:query>
	
	<section class="container">
    <div class="row">
        <c:forEach items="${rs.rows}" var="prod">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 25px">
            <c:if test="${prod.productImage ==null}">
             <img src="views/shop-item.svg" class="product-image"/>
             </c:if>
             <c:if test="${ prod.productImage != null}">
             <img src="Images/${prod.productImage }" class="product-image"/>
             </c:if>
                <div class="thumbnail">
                    <div class="caption">
                        <h3>${prod.productName}</h3>
                        <p>UGX ${prod.cost}</p>
                        <p class="desc">UGX ${prod.description}</p>
                        <div class="buttons">
    <c:if test="${adminToken==null}">
			<form action="productDetails" class="mx-auto">
				<input type="hidden" value="${prod.id}" name="id"/>
				<input type="submit" class="btn btn-primary" value="Add To Cart"/>
			</form>
			</c:if>
			<c:if test="${adminToken!=null}">
			<form action="productUpdate" class="mx-auto">
				<input type="hidden"  value="${prod.id}" name="id"/>
				<input type="submit"class="btn btn-success" value="Update"/>
			</form>
			</c:if>
    			<c:if test="${adminToken!=null}">
			<form action="productDelete" class="mr-6">
				<input type="hidden" value="${prod.id}" name="id"/>
				<input type="submit" class="btn btn-danger" value="Delete"/>
			</form>
			</c:if>
			<c:if test="${adminToken==null}">
			<form action="productDetails" class="mr-6">
				<input type="hidden" value="${prod.id}" name="id"/>
				<input type="submit" class="btn btn-success" value="View Details"/>
			</form>
			</c:if>
    </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>

	
	
	
	</div>
	
	
</body>
</html>