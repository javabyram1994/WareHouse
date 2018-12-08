<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<title>OrderMethod Data</title>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h1>OrderMethod Data</h1>
			</div>
			<!-- this is card head -->
			<div class="d-flex flex-row-reverse bg-secondary">
				<div class="p-2 bg-primary">
					<a href="excel" class="btn btn-dark">EXCEL Export</a>
				</div>
				<div class="p-2 bg-info">
					<a href="pdf" class="btn btn-dark">PDF Export</a>
				</div>
			</div>
			
			
			<div class="card-body">
			<c:choose>
					<c:when test="${!empty list}">
				<table class="table table-hover ">
					<tr class="thead-dark">

						<th>id</th>
						<th>mode</th>
						<th>code</th>
						<th>method</th>
						<th>accept</th>
						<th>dsc</th>
						<th colspan="2">options</th>
					</tr>
					<c:forEach items="${list}" var="om">
						<tr class="table-primary">
							<td><c:out value="${om.id}" /></td>
							<td><c:out value="${om.mode}" /></td>
							<td><c:out value="${om.code}" /></td>
							<td><c:out value="${om.method}" /></td>
							<td><c:out value="${om.accept}" /></td>
							<td><c:out value="${om.dsc}" /></td>
							<td><a href="delete?id=${om.id}"  class="btn btn-secondary"> Delete </a></td>
							<td><a href="edit?id=${om.id}" class="btn btn-secondary">Edit</a></td>
					</c:forEach>
				</table>
				</c:when>
				<c:otherwise>
						<div class="text-info">No Data Found in Database</div>
			    </c:otherwise>
			    </c:choose>
			</div>
			<!-- this is end of cardBody -->

			<!-- card footer -->
			<c:if test="${message ne null }">
				<div class="card-footer bg-warning">${message}</div>
			</c:if>
		</div>
		<!-- this is div card -->
	</div>
	<!-- this is container Class -->
</body>
</html>