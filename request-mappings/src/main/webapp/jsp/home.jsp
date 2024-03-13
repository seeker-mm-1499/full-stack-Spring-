<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Mappings</title>
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
	<h1> Request Mappings</h1>
	<ul>
		<li>
			<c:url value="/multi" var="multi"></c:url>
			<a href="multi">Multi Actions</a>
		</li>
		<li>
			<c:url value="/inputs" var="inputs"></c:url>
			<a href="inputs">Users Input</a>
		</li>
		<li>
			<c:url value="/course" var="course"></c:url>
			<a href="course">Course List</a>
		</li>
	</ul>
</body>
</html>