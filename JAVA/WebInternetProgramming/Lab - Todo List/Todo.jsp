<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/css/bootstrap.min.css" integrity="sha384-AysaV+vQoT3kOAXZkl02PThvDr8HYKPZhNT5h/CXfBThSRXQ6jW5DO2ekP5ViFdi" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/js/bootstrap.min.js" integrity="sha384-BLiI7JTZm+JWlgKa0M0kGRpJbF2J8q+qreVrKBC47e3K6BW78kGLrCkeRX6I9RoK" crossorigin="anonymous"></script><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
	html,body, .jumbotron {background-color:black;}
	h1, body {color: white;}
</style>
<title>ToDo List</title>
</head>
<body>
<div class ="container">

<div class="page-header">
	<h1> ToDo <small>cs3220</small></h1>
</div>

		<div class="page-header">
			<h2>
				Todo <small> <span id="remaining">${total - remaining }</span> of <span
					id="total">${total}</span> remaining <small> [<a
						href="Archive">Archive</a>]
				</small>
				</small>
			</h2>
		</div>

		<form class="form-inline" action="Todo" method="post">
		<div class='form-group'>
			<input type="text" name="todo" class="form-control" placeholder="Enter a ToDo">
		</div>
		<div class='form-group'>
			<button type="submit" class="btn btn-default">Add</button>
		</div>
	
	</form></br>
	<div class="table-responsive">
		<table class="table table-inverse table-bordered table-striped table-hover">
			<tr>
				<th>Title</th>
				<th>Action</th>
				<c:if test="${empty todos}">
					<div class="jumbotron">
						<h1>Uh-Oh! <small>There are no tasks to display.</small></h1>
					</div>
				</c:if>
			</tr>
			<c:forEach var="todo" items="${todos }">
				<tr>
					<c:choose>
						<c:when test="${todo.state.equals('done') }">
							<td><s><c:out value="${todo.todo }" /></s></td>
							<td><a href="Update?id=${todo.id }&state=${todo.state }" class="btn btn-primary btn-sm">Done</a></td>
						</c:when>
						<c:otherwise>
							<td><c:out value="${todo.todo }" /></td>
							<td><a href="Update?id=${todo.id }&state=${todo.state }" class="btn btn-primary btn-sm">Not Done</a></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<div class="page-header">
		<h2>Archived 
			<small>
				<span id="totalArchived">${archived_total} todo(s)</span> 
				have been archived.
			</small></h2>
	</div>
	
	<div class="table-responsive">
		<table class="table table-inverse table-bordered table-striped table-hover">
			<tr>
				<th>Title</th>
				<th>Action</th>
				<c:if test="${empty archived}">
					<div class="jumbotron">
						<h1>Uh-Oh! <small>There are no tasks to display.</small></h1>
					</div>
				</c:if>
			</tr>
			<c:forEach var="archived" items="${archived }">
				<tr>
					<c:choose>
						<c:when test="${archived.state.equals('archived') }">
							<td><s><c:out value="${archived.todo }" /></s></td>
							<td><a href="Archive?id=${archived.id }&state=${archived.state }" class="btn btn-primary btn-sm">Done</a></td>
						</c:when>
						<c:otherwise>
							<td><c:out value="${archived.todo }" /></td>
							<td><a href="Archive?id=${archived.id }&state=${archived.state }" class="btn btn-primary btn-sm">Not Done</a></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>