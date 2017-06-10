<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/css/bootstrap.min.css"
	integrity="sha384-AysaV+vQoT3kOAXZkl02PThvDr8HYKPZhNT5h/CXfBThSRXQ6jW5DO2ekP5ViFdi"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/js/bootstrap.min.js"
	integrity="sha384-BLiI7JTZm+JWlgKa0M0kGRpJbF2J8q+qreVrKBC47e3K6BW78kGLrCkeRX6I9RoK"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Information</title>
</head>
<body>
	<div class="container">

		<!-- Page Header -->
		<div class="page-header">
			<h1>
				<c:choose>
					<c:when test="${empty totalQuantity}">
						Product Information <small> There are/is <span id="remaining"><i><b><u>0</u></b></i></span> 
						item(s) in your --> </small>
						<small>
						[ <a href="ShoppingCart">Shopping Cart</a> ] 
						</small>
					</c:when>
					<c:otherwise>
						Product Information <small> There are/is <span id="remaining"><i><b><u>${totalQuantity}</u></b></i></span> 
						item(s) in your --> </small>
						<small>
						[ <a href="ShoppingCart">Shopping Cart</a> ] 
						</small>
					</c:otherwise>
				</c:choose>
			</h1>
		</div>
		
		<c:if test="${not empty DetPro}">
			<table class="table table-hover table-striped table-bordered">
				<thead>
					<tr>
						<th>Name</th>
						<th>Description</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>How many would you like to buy?</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${DetPro}" var="DetPro">
						<tr>
						
							<td>${DetPro.name}</td>
							
							<td>${DetPro.description}</td>
							
							<td>$ ${DetPro.price}</td>
							
							<td>${DetPro.quantity}</td>
							
							<td>
							<%-- Construct the Update URL --%> 
								<c:url value="ShoppingCart" var="updateUrl">
									<c:param name="id" value="${DetPro.id}" />
									<c:param name="name" value="${DetPro.name}" />
									<c:param name="description" value="${DetPro.description}" />
									<c:param name="quantity" value="${DetPro.quantity}" />
									<c:param name="price" value="${DetPro.price}" />
								</c:url> 
							
								<form class action="${updateUrl}" method="post">
									<div class="form-group">
										<input type="text" class="form-control" name="reqQuantity" id="reqQuantity" placeholder="Quantity">
									</div>
									<button type="submit" class="btn btn-warning">Add to Cart</button>
								</form>
							</td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	
		<a class="btn btn-primary " href="Store">Go
			back Store Front</a>
			</div>
</body>
</html>