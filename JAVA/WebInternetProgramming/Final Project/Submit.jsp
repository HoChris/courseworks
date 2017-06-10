<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Successful Submission</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>Successful Submission</h1>
		</div>
		
		<h2>Your Order has been Successfully Submitted!</h2>
		<h3><i><u>Confirmation Number:</u> </i><span style='color: #f00'>${confirmationNumber}</span></h3>

		<a class="btn btn-primary" href="Store">Back to Store</a>
		<a class="btn btn-danger" href="Inventory">Check Inventory</a>
	</div>
</body>
</html>