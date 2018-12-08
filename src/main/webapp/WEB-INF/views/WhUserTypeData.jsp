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
<title>WhUserTable Data</title>
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h1>WhUserTable Data Page</h1>
			</div>

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
					<div class="table-responsive">
						<table class="table table-hover ">
							<tr class="thead-dark">
								<th>Id</th>
								<th>Type</th>
								<th>code</th>
								<th>userfor</th>
								<th>Email</th>
								<th>Contact</th>
								<th>IdType</th>
								<th>IfOther</th>
								<th>Id number</th>
								<th colspan="2">options</th>
							</tr>
							<c:forEach items="${list}" var="wu">
								<tr class="table-primary">
									<td><c:out value="${wu.id}" /></td>
									<td><c:out value="${wu.type}" /></td>
									<td><c:out value="${wu.code}" /></td>
									<td><c:out value="${wu.forType}" /></td>
									<td><c:out value="${wu.email}" /></td>
									<td><c:out value="${wu.contact}" /></td>
									<td><c:out value="${wu.idType}" /></td>
									<td><c:out value="${wu.ifOthers}" /></td>
									<td><c:out value="${wu.ifNum}" /></td>
									<td><a href="delete?id=${wu.id}" class="btn btn-secondary">
											Delete </a></td>
									<td><a href="edit?id=${wu.id}" class="btn btn-info">Edit</a></td>
								</tr>
							</c:forEach>
                       
						</table>
						</div>
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
		<!-- this is closing tag of card -->
	</div>
	<!-- this is closing tag of container -->
</body>
</html>