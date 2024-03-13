<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input Variable</title>
</head>
<body>

	<h1>User Input</h1>

	<div>
		<c:if test="${not empty type and not empty id}">
			<p>${type }/${id }</p>
		</c:if>
		<c:if test="${not empty date }">
			<p>${date }</p>
		</c:if>
		<c:if test="${not empty level }">
			<p>${level }</p>
		</c:if>
		<c:if test="${not empty Message }">
			<p>${Message }</p>
		</c:if>
	</div>

	<ul>
		<li>
			<c:url value="/inputs/PathType/search/1001" var="pathLink"></c:url>
			<a href="${pathLink }">Path Variable</a>
		</li>
		<li>
			<c:url value="/inputs/2024-12-11" var="dateLink"></c:url>
			<a href="${dateLink }">2024-12-11</a>
		</li>
		<li>
			<c:url value="/inputs/Basic" var="enumLink"></c:url>
			<a href="${enumLink }">Using Enum</a>
		</li>
		<li>
			<c:url value="/inputs/request?p=Jeans&w=32&l=29" var="requestLink"></c:url>
			<a href="${requestLink }">Using Request Params</a>
		</li>
		
	</ul>

</body>
</html>