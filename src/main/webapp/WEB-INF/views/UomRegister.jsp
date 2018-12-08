<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Uom Register Page</title>
<style type="text/css">
.err {
	color: red;
}
</style>
</head>
<body>
	<!-- container start -->
	<div class="container">

		<!-- card start -->
		<div class="card">

			<!-- card Header -->
			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO UOM REGISTER PAGE</h2>
			</div>
			<div class="card-body">
				<form:form action="insert" method="post" modelAttribute="uom"
					cssClass="form">
					<div class="form-group">
						<label for="uomType" class="control-label col-sm-4">UOM
							TYPE</label> :
						<form:select path="type" cssClass="form-control col-sm-4">
							<form:option value="">---Select---</form:option>
							<form:option value="packing">PACKING</form:option>
							<form:option value="Nopacking">NOPACKING</form:option>
							<form:option value="na">-NA-</form:option>
						</form:select>
						<br>
						<form:errors path="type" cssClass="text-danger" />
						<br>
					</div>
					<div class="form-group">
						<label for="uomModel" class="control-label col-sm-4">UOM
							MODEL</label>
						<form:input path="model" cssClass="form-control col-sm-4" />
						<br>
						<form:errors path="model" cssClass="text-danger" />
						<br>
					</div>
					<div class="form-group">
						<label for="uomModel" class="control-label col-sm-4">UOM
							NOTE</label>

						<form:textarea path="dsc" cssClass="form-control col-sm-4" />
						<br> <br>
						<form:errors path="dsc" cssClass="text-danger" />
						<br>
					</div>
					<div class="form-group">
						<input type="submit" value="create Uom" class="btn btn-success">

					</div>
				</form:form>
			</div>

			<!-- card footer -->
			<c:if test="${message ne null }">
				<div class="card-footer bg-info text-white">${message}</div>
			</c:if>

			<!-- card end -->
		</div>

		<!-- container end -->
	</div>
</body>
</html>