<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inventory Manager</title>
</head>
<body>
	<div class="container">

		<div class="page-header">
			<h1>
				Inventory Manager <small>Admin </small>
			</h1>
		</div>
		<hr>
		<c:if test="${error == true }">
		
			<h2 class="text-danger"> Please Fill out all 4 fields correctly. </h2>
		
		</c:if>
		<form class="form-inline" action="Inventory" method="post">
			<div class="form-group">
				<input type="text" name="name" class="form-control"
					placeholder="Enter item name">
			</div>
			<div class='form-group'>
				<input type="text" name="description" class="form-control"
					placeholder="Enter item description">
			</div>
			<div class="form-group">
				<input type="text" name="price" class="form-control"
					placeholder="Enter price">
			</div>
			<div class='form-group'>
				<input type="text" name="quantity" class="form-control"
					placeholder="Quantity">
			</div>
			
			<div class='form-group'>
				<button type="submit" name=action value="1" class="btn btn-primary">Add</button>
			</div>
			<br><br>
			<div class='form-group'>
				<input type="text" name="id" class="form-control"
					placeholder="ID to Remove">
			</div>

			<div class='form-group'>
				<button type="submit" name=action value="0" class="btn btn-primary">Remove</button>
			</div>
		</form>
		<br>
		<div class="table-responsive">
			<table class="table table-bordered table-striped table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Description</th>
						<th>Price</th>
						<th>Quantity</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${items}">
						<tr>
							<td><c:out value="${item.id }" /></td>
							<td><c:out value="${item.name }" /></td>
							<td><c:out value="${item.description }" /></td>
							<td><c:out value="${item.price }" /></td>
							<td><c:out value="${item.quantity }" /></td>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<a href="Store" class="btn btn-primary btn-sm">Back to Store</a>
	</div>
</body>
</html>