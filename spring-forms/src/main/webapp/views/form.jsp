<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Form</title>
<style type="text/css">
.radios-box>span {
	margin-right: 16px;
}

.radios-box input {
	margin-right: 6px;
}
</style>

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
		<h1><sp:message code="app.title"></sp:message></h1>

		<c:if test="${not empty allErrors }">
			<div class="alert alert-warning">
				<c:forEach var="e" items="${allErrors }" varStatus="sts">
					<span>${e }</span>
					 <c:if test="${not sts.last }">
						<br/>
					</c:if>
				</c:forEach>
			</div>
		</c:if>

		<f:form modelAttribute="userInput">
		

			<div class="row mt-4">
				<div class="col">
					<f:label path="name">Student Name</f:label>
					<f:input path="name" placeHolder="Enter student name"
						cssClass="form-control" />
					<f:errors path="name" cssClass="text-danger"></f:errors>
				</div>
				<div class="col">
					<f:label path="phone">Phone</f:label>
					<f:input type="tel" path="phone" placeHolder="Enter phone number"
						cssClass="form-control" />
					<f:errors path="phone" cssClass="text-danger"></f:errors>
				</div>
				<div class="col">
					<f:label path="email">Email</f:label>
					<f:input path="email" placeHolder="Enter email"
						cssClass="form-control" />
					<f:errors path="email" cssClass="text-danger"></f:errors>
				</div>
			</div>
			<div class="row mt-4">
				<div class="col">
					<f:label path="password">Password</f:label>
					<f:password path="password" placeHolder="Enter password"
						cssClass="form-control" />
				</div>
				<div class="col">
					<f:label path="course">Select Course</f:label>
					<f:select path="course" cssClass="form-select">
						<option value="">Select Course</option>
						<f:options items="${courses }" itemValue="id" />
					</f:select>
					<f:errors path="course" cssClass="text-danger"></f:errors>
				</div>
				<div class="col">
					<f:label path="registration">Registration Date</f:label>
					<f:input path="registration" type="date" cssClass="form-control" />
				</div>
			</div>
			<div class="row mt-4">
				<div class="col">
					<f:label path="gender">Gender</f:label>
					<div class="radios-box">
						<f:radiobuttons path="gender" />
					</div>
				</div>
				<div class="col">
					<f:label path="foundations">Knowledges</f:label>
					<div class="radios-box">
						<f:checkboxes items="${knowledges }" path="foundations" />
					</div>
				</div>
				<div class="col">
					<f:label path="agree">Agree Conditions</f:label>
					<div class="radios-box">
						<f:checkbox path="agree" label="Yes, I agree" />
					</div>
				</div>
				<div class="row mt-4">
					<f:label path="remark">Remark</f:label>
					<f:textarea path="remark" cssClass="form-control" />
				</div>
				<div class="row mt-4">
					<button type="submit" class="col-auto btn btn-primary">Send
						Data</button>
				</div>
			</div>
		</f:form>

		<h3 class="mt-4 mb-4">Data List</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Registration</th>
					<th>Course</th>
					<th>Remark</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="d" items="${list }">
					<tr>
						<td>${d.id }</td>
						<td>${d.name }</td>
						<td>${d.phone }</td>
						<td>${d.email }</td>
						<td>${d.gender }</td>
						<td>${d.registration }</td>
						<td>${d.course.name }</td>
						<td>${d.remark }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>