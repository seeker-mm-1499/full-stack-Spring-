<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Multi Controller</title>
</head>
<body>
	<h3>Multi Controller</h3>
	
	<p>${not empty message? message : 'Default Action' }</p>
	
	<ul>
		<li>
			<c:url value="/multi/action1" var="action1"></c:url>
			<a href="${action1 }">Action 1</a>
		</li>
		<li>
			<c:url value="/multi/action1?id=10" var="action1Withparam"></c:url>
			<a href="${action1Withparam }">Action 1 with id</a>
		</li>
		<li>
			<c:url value="/multi/action2" var="action2"></c:url>
			<a href="${action2 }">Action 2</a>
		</li>
		<li>
			<c:url value="/multi/200" var="action2withDigit"></c:url>
			<a href="${action2withDigit }">Action 2 with Digit</a>
		</li>
		<li>
			<c:url value="/multi/actionerirh" var="actionWildCard"></c:url>
			<a href="${actionWildCard }">Action Wild Card</a>
		</li>
		
	</ul>
</body>
</html>