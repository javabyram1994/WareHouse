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

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<title>Order Method Register Page</title>

</head>
<body>

	<!-- container start -->
	<div class="container">

		<!-- card start -->
		<div class="card">


			<!-- card Header -->
			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO Order Method REGISTER PAGE</h2>
			</div>
			<!-- card body -->
			<div class="card-body">
				<form:form action="insert" method="post" modelAttribute="om">

					<div class="form-group">
						<label for="uomType" class="control-label col-sm-4">OrderMethod:
						</label>
						<form:radiobutton path="mode" value="sale" />
						SALE
						<form:radiobutton path="mode" value="purchase" />
						PURCHASE
						<form:errors path="mode" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="usr">Code:</label>
						<form:input path="code" />
						<form:errors path="code" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="sel1">OrderMethod:</label>

						<form:select class="form-control" path="method">
							<form:option value="">--Select--</form:option>
							<form:option value="fifo">FIFO</form:option>
							<form:option value="lifo">LIFO</form:option>
							<form:option value="fcfo">FCFO</form:option>
							<form:option value="fefo">FEFO</form:option>
						</form:select>

						<form:errors path="method" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="sel1">OrderAceept:</label>
						<div class="form-check-inline">
							<label class="form-check-label"> OderAccept :<form:checkbox
									path="accept" class="form-check-input" value="multimodel" />Multi-Model
							</label>
						</div>
						<div class="form-check-inline">
							<label class="form-check-label"> <form:checkbox
									path="accept" class="form-check-input" value="acceptreturn" />Accept-Return
							</label>
						</div>
						<form:errors path="accept" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="comment">Discription:</label>

						<form:textarea class="form-control" rows="5" path="dsc" />
						<form:errors path="dsc" cssClass="text-danger"></form:errors>
					</div>
					<input type="submit" value="Creat Order Method">

				</form:form>
			</div>
			<!-- this is body -->
				<c:if test="${message ne null }">
				<div class="card-footer bg-warning">${message}</div>
			</c:if>

		</div>
		<!-- this is card -->

	</div>
	<!-- this is container -->
</body>
</html>