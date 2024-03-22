<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container mt-4">
		<div class="card">
			<div class="card-header">Using Session</div>
			<div class="card-body">
				<div class="row">
					<c:url value="/add-item" var="action"></c:url>
					<form method="post" class="row" action="${action }">
						<div class="col-7">
							<input type="text" name="data" placeholder="Enter item name" class="form-control"/>
						</div>
						<div class="col-auto ">
							<button type="submit" class="btn btn-primary mr-4">Add
								item</button>
							<c:url value="/clear-session" var="clearSession"></c:url>
							<a href="${clearSession }" class="btn btn-danger">Clear Items</a>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="mt-4 list-group">
			<div class="list-group-item active">Item in Cart
				:${sessionScope.cart.count }</div>
			<c:forEach var="item" items="${sessionScope.cart.list }">
				<div class="list-group-item ">${item }</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>