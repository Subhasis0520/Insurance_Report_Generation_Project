<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en" xmlns:th="www.thymeleaf.org">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Report Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
</head>
<body>

	<div class="container">
		<h3 class="pt-2 pb-3">Report App</h3>

		<form:form action="/" modelAttribute="search" method="POST">
			<table>
				<tr class="mb-2 mt-1">
					<td><label for="endDate" class="form-label text-primary">Plan
							Name:- </label></td>
					<td><form:select path="planName">
							<form:option value="">-Select-</form:option>
							<form:options items="${names}" />
						</form:select></td>

					<td><label for="endDate" class="form-label text-primary">Plan
							Status:-</label></td>
					<td><form:select path="planStatus">
							<form:option value="">-Select-</form:option>
							<form:options items="${status}" />
						</form:select></td>

					<td><label for="endDate" class="form-label text-primary">Gender:-
					</label></td>
					<td><form:select path="gender">
							<form:option value="">-Select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Female">Female</form:option>
						</form:select></td>
				</tr>

				<tr class="mb-2 mt-1">
					<td><label for="startDate" class="form-label text-primary">Start
							Date:-</label></td>
					<td><form:input type="date" path="planStartDate" />
					<td><label for="endDate" class="form-label text-primary">End
							Date:- </label></td>
					<td><form:input type="date" path="planEndDate" />
				</tr>
				<tr class="mb-2 mt-1">
					<td><input type="submit" value="Search" class="btn btn-danger">
			</table>
		</form:form>

		<hr />
		<!--  To view record 
		  <%@include  file="../../resources\templates\view.html" %>
		<hr />
-->
		Export:- <a class="btn btn-success" href="">Pdf</a> <a
			class="btn btn-success" href="">Excel</a>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>
