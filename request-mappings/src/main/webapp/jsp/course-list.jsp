<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course List</title>
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
	<div class="container pt-4">
		<h1>Course List</h1>
		<div calss="mt-4">
			<div>
				<c:url value="/course/edit" var="courseEdit"></c:url>
				<a href="${courseEdit }" class="btn btn-primary">Add New Course</a>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Level</th>
						<th>Duration</th>
						<th>Fees</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${list}">
						<tr>
							<td>${c.id }</td>
							<td>
							<c:url value="/course/${c.id }" var="courseDetailUrl"></c:url>
							<a href="${courseDetailUrl}">${c.name }</a>
							</td>
							<td>${c.level }</td>
							<td>${c.duration }</td>
							<td>${c.fees }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>