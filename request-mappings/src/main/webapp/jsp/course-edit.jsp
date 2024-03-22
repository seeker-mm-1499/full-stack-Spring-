<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Edit</title>
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
		<h1>${empty course? 'Add New ': 'Edit ' }Course</h1> 
		<div class="row">
			<div class="col-6">
				<c:url value="/course" var="saveUrl"></c:url>
				<form method="post" action="${saveUrl }">
					<c:if test="${not empty course }">		
						<input type="hidden" name="id" value="${course.id}" />
					</c:if>
					<div class="mb-3">
						<label class="form-label mb-1" for="name">Course Name</label> <input
							id="name" value="${course.name}" name="name" type="text"
							placeholder="Enter Course Name" class="form-control" />
					</div>
					<div class="mb-3">
						<label class="form-label mb-1" for="level">Course level</label> <select
							id="level" name="level" class="form-select">
							<option value="">Select One</option>
							<c:forEach var="item" items="${levels }">
								<c:choose>
									<c:when test="${course.level eq item }">
										<option selected="selected" value="${item }">${item}</option>
									</c:when>

									<c:otherwise>
										<option value="${item }">${item}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<div class="mb-3">
						<label class="form-label mb-1" for="duration">Course
							duration</label> <input id="duration" value="${course.duration}"
							name="duration" type="number" placeholder="Enter Course duration"
							class="form-control" />
					</div>
					<div class="mb-3">
						<label class="form-label mb-1" for="fees">Course fees</label> <input
							id="fees" value="${course.fees}" name="fees" type="number"
							placeholder="Enter Course fees" class="form-control" />
					</div>
					<div class="mb-3">
						<button type="submit" class="btn btn-danger">Save Couse</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>