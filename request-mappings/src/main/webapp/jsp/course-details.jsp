<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Details</title>
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
		<h1>Course Edit</h1>

		<c:if test="${not empty result }">
			<div class="alert alert-info">${result.message }</div>
		</c:if>

		<div class="row">
			<div class="col-6">
				<c:url value="/course" var="saveUrl"></c:url>
				<form method="post" action="${saveUrl }">
					<div class="mb-3">
						<label class="form-label mb-1" for="id">Course Id</label> <input
							id="id" name="id" type="number" value="${course.id }"
							readonly="readonly" class="form-control" />
					</div>
					<div class="mb-3">
						<label class="form-label mb-1" for="name">Course Name</label> <input
							id="name" name="name" type="text" value="${course.name }"
							readonly="readonly" class="form-control" />
					</div>
					<div class="mb-3">
						<label class="form-label mb-1" for="level">Course level</label> <input
							id="level" name="level" type="text" value="${course.level }"
							readonly="readonly" class="form-control" />
					</div>
					<div class="mb-3">
						<label class="form-label mb-1" for="duration">Course
							duration</label> <input id="duration" name="duration" type="number"
							value="${course.duration }" readonly="readonly"
							class="form-control" />
					</div>
					<div class="mb-3">
						<label class="form-label mb-1" for="fees">Course fees</label> <input
							id="fees" name="fees" type="number" value="${course.fees }"
							readonly="readonly" class="form-control" />
					</div>

					<div>
						<c:url value="/course/edit" var="editLink">
							<c:param name="id" value="${course.id }"></c:param>
						</c:url>
						<a href="${editLink }" class="btn btn-danger">Edit Course</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>