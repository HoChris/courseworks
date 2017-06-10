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
<title>Transaction History</title>
</head>
<body>
	<div class="container">

		<div class="page-header">
			<h1>
				Transaction History<small> </small>
			</h1>
		</div>
		<hr>
		<c:choose>
			<c:when test="${empty historylist }">
				<div class="jumbotron">
					<h1>
						Uh-Oh! <small>There are no items in the History.</small>
					</h1>
				</div>
				<a href="Store" class="btn btn-primary btn-sm">Back to Store</a>
			</c:when>
			<c:otherwise>
				<div class="table-responsive">
					<table class="table table-bordered table-striped table-hover">
						<thead>
							<tr>
								<th>Id</th>
								<th>Order</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${historylist}">
								<tr>
									<td><c:out value="${item.id }" /></td>
									<td><c:out value="${item.order }" /></td>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<a href="Store" class="btn btn-primary btn-sm">Back to Store</a>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>