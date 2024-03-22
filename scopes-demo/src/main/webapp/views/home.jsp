<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scope Demo</title>
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
		<h1>Scope Demo</h1>
		<div class="row mt-4">
			<div class="col">
				<div class="card">
					<div class="card-header">Request Scope</div>
					<div class="card-body">
						<h2 class="text-center">${requestCount }</h2>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card">
					<div class="card-header">Session Scope</div>
					<div class="card-body">
						<h2 class="text-center">${sessionCount }</h2>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card">
					<div class="card-header">Application Scope</div>
					<div class="card-body">
						<h2 class="text-center">${applicationCount }</h2>
					</div>
				</div>
			</div>
		</div>
		<h1 class="mt-4">Access Scope Object</h1>
		<div class="row mt-4">
			<div class="col">
				<div class="card">
					<div class="card-header">Request Scope</div>
					<div class="card-body">
						<h2 class="text-center">${requestScope.counter.count }</h2>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card">
					<div class="card-header">Session Scope</div>
					<div class="card-body">
						<h2 class="text-center">${sessionScope.counter.count }</h2>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card">
					<div class="card-header">Application Scope</div>
					<div class="card-body">
						<h2 class="text-center">${applicationScope.counter.count }</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container pt-4">
		<c:url value="/" var="scopeLink"></c:url>
		<a href="${scopeLink }" class="btn btn-danger mt-4">Load Home</a>
		<c:url value="/create-session" var="createSession"></c:url>
		<a href="${createSession }" class="btn btn-danger mt-4">Session Demo</a>
	</div>
</body>
</html>