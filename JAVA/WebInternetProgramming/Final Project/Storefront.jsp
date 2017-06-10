<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Store Front</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/css/bootstrap.min.css"
	integrity="sha384-AysaV+vQoT3kOAXZkl02PThvDr8HYKPZhNT5h/CXfBThSRXQ6jW5DO2ekP5ViFdi"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/js/bootstrap.min.js"
	integrity="sha384-BLiI7JTZm+JWlgKa0M0kGRpJbF2J8q+qreVrKBC47e3K6BW78kGLrCkeRX6I9RoK"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">

		<!-- Page Header -->
		<div class="page-header">
			<h1>
				<c:choose>
					<c:when test="${empty totalQuantity}">
						Shop <small> There are/is <span id="remaining"><i><b><u>0</u></b></i></span> 
						item(s) in your --> </small>
						<small>
							[ <a href="ShoppingCart">Shopping Cart</a> ]
						</small>
					</c:when>
					<c:otherwise>
						Shop <small> There are/is <span id="remaining"><i><b><u>${totalQuantity}</u></b></i></span> 
						item(s) in your --> </small>
						<small>
							[ <a href="ShoppingCart">Shopping Cart</a> ]
						</small>
					</c:otherwise>
				</c:choose>
			</h1>
			
		</div>
		
		<a class="btn btn-danger" href="History">View Order History</a>
			<a class="btn btn-primary" href="Inventory">Edit Inventory</a>
			<br><br>
			<a class="btn btn-success" href="ShoppingCart" >Go to Shopping Cart</a>
			
			<br><br>
			
		
		<c:if test="${not empty quantityError}">	     
 			<h4 style='color: #f00'>${quantityError}</h4>
		</c:if>
		
		<c:if test="${empty CurrPro}">
			<div class="jumbotron">
				<h1>
					Uh-Oh! <small>There are no items in our Store</small>
				</h1>
			</div>
		</c:if>
		
		<c:if test="${not empty CurrPro}">
			<table class="table table-hover table-striped table-bordered">
				<thead>
					<tr>
						<th>Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>How many would you like to buy?</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${CurrPro}" var="CurrPro">
						<tr>
							<td>
								<%-- Construct the Update URL --%> 
								<c:url value="Details" var="updateUrl">
									<c:param name="id" value="${CurrPro.id}" />
								</c:url> 
								
								<a class="btn btn-info btn-sm" href="${updateUrl}">${CurrPro.name}</a>
							</td>
							
							<td>$ ${CurrPro.price}</td>
							
							<td>${CurrPro.quantity}</td>

							<td>
							<%-- Construct the Update URL --%> 
								<c:url value="ShoppingCart" var="updateUrl">
									<c:param name="id" value="${CurrPro.id}" />
									<c:param name="name" value="${CurrPro.name}" />
									<c:param name="description" value="${CurrPro.description}" />
									<c:param name="quantity" value="${CurrPro.quantity}" />
									<c:param name="price" value="${CurrPro.price}" />
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
		
		<a class="btn btn-success" href="ShoppingCart" >Go to Shopping Cart</a>
		<br><br>
		<a class="btn btn-danger" href="History">View Order History</a>
		<a class="btn btn-primary" href="Inventory">Edit Inventory</a>
		
		
</body>
</html>