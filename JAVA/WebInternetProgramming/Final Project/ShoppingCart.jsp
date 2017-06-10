<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Cart</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<div class="page-header">
		<h1>Shopping Cart</h1>
	</div>
	
		<c:if test="${empty ShopPro}">
			<div class="jumbotron">
				<h1>
					Uh-Oh! <small>There are no items in your shopping cart.</small>
				</h1>
			</div>
		</c:if>


		<c:if test="${not empty ShopPro}">

			<table class="table table-bordered table-striped table-hover">
				<thead>
					<tr>
						<th>Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Total Product Price</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${ShopPro}" var="product">
						<tr>
							<td>${product.name}</td>
							<td>${product.price}</td>
							<td>${product.quantity}</td>
							<td>${product.price * product.quantity}</td>
						</tr>
					</c:forEach>
				</tbody>
				
			</table>

		</c:if>
		
		
		<c:choose>
			<c:when test="${empty ShopPro}">
				<h3>Total Cost of Cart: <b><i><u>$ 0.00</u></i></b></h3>
			</c:when>
			<c:otherwise>
				<h3>Total Cost of Cart: <b><i><u>$ ${totalPrice}</u></i></b></h3>
				<a class="btn btn-primary" href="Checkout" >Proceed to Checkout</a>
			</c:otherwise>
		</c:choose>
		
		<a class="btn btn-default" href="Store" >Back to Store</a>

</div>
</body>
</html>