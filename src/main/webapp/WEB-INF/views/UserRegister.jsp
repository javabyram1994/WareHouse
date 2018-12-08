<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Register Page</title>
</head>
<body>
<%@include file="HomeMenu.jsp"%>
	<div class="container">
		<!-- card start -->
		<div class="card">


			<!-- card Header -->
			<div class="card-header bg-light ">
				<h2>WELCOME TO USER REGISTER PAGE</h2>
			</div>

			<!-- card body -->
			<div class="card-body">

				<form:form action="insert" method="post" modelAttribute="user"
					cssClass="form">

					<div class="form-group">
						<label for="username" class="control-label col-sm-4">Name
							:</label>
						<form:input path="userName" required="required" />
					</div>

					<div class="form-group">
						<label for="userEmail" class="control-label col-sm-4">Email
							:</label>
						<form:input path="userEmail" required="required" />
					</div>


					<div class="form-group">
						<label for="userPwd" class="control-label col-sm-4">Password:</label>
						<form:password path="userPwd" required="required" />
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4">Roles :</label>
						<form:checkbox path="roles" value="ADMIN" />
						ADMIN
						<form:checkbox path="roles" value="USER" />
						USER
					</div>
					<div class="form-group">
						<input type="submit" value="Create User" />
					</div>
				</form:form>
			</div>

			<c:if test="${message ne null }">
				<div class="card-footer bg-info text-white">${message}</div>
			</c:if>
		</div>
	</div>
</body>
</html>