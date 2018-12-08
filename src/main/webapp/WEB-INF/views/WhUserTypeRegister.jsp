<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//default background color is grey
		if ('others' == $("#idType").val()) {
			$('#ifOthers').attr('readonly', false);
			$('#ifOthers').css('background-color', '#FFFFFF');
		} else {
			$('#ifOthers').attr('readonly', true);
			$('#ifOthers').css('background-color', '#DCDCDC');
		}

		//on click radio button user type-execute this
		$("input[type=radio][name=type]").click(function() {
			if (this.value == 'vendor') {
				$("#forType").val("Purchase");
			} else if (this.value == 'customer') {
				$("#forType").val("Sale");
			}
		});

		//on change dropdown value of user id type
		$("#idType").change(function() {
			var opt = $("#idType").val();
			if (opt != 'others') {
				$('#ifOthers').attr('readonly', true);
				$('#ifOthers').css('background-color', '#DCDCDC');
				$('#ifOthers').val("");
			} else {
				$('#ifOthers').attr('readonly', false);
				$('#ifOthers').css('background-color', '#FFFFFF');
			}
		});
	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Whuser Register Page</title>
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
				<h2>WELCOME TO WhUser Type REGISTER PAGE</h2>
			</div>
			<div class="card-body">
				<form:form action="insert" method="post" modelAttribute="whu"
					cssClass="form">

					<div class="form-group">
						<label for="UserType" class="control-label col-sm-4">UserType
							: </label>
						<div class="form-check-inline">
							<form:radiobutton path="type" value="vendor"
								class="form-check-input" />
							VENDORE
						</div>
						<div class="form-check-inline">
							<form:radiobutton path="type" value="customer"
								class="form-check-input" />
							CUSTOMER
						</div>
						<form:errors path="type" cssClass="text-danger"></form:errors>
					</div>

					<div class="form-group">
						<label for="UserCode" class="control-label col-sm-4">UserCode
							: </label>
						<form:input path="code" class="form-control" />
						<form:errors path="code" cssClass="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="UserFor" class="control-label col-sm-4">UserFor
							: </label>
						<form:input path="forType" readonly="true" class="form-control" />
						<form:errors path="forType" cssClass="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="UserEmail" class="control-label col-sm-4">UserEmail
							: </label>
						<form:input path="email" class="form-control" />
						<form:errors path="email" cssClass="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="UserContact" class="control-label col-sm-4">UserContact
							: </label>
						<form:input path="contact" class="form-control" />
						<form:errors path="contact" cssClass="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="UserIdType" class="control-label col-sm-4">UserIdType
							: </label>
						<form:select path="idType" class="form-control">
							<form:option value="">--select--</form:option>
							<form:option value="pancard">PANCARD</form:option>
							<form:option value="adharcard">ADHARCARD</form:option>
							<form:option value="votercard">VOTERCARD</form:option>
							<form:option value="others">OTHERS</form:option>
						</form:select>
						<form:errors path="idType" cssClass="text-danger"></form:errors>
					</div>
					<div class="form-group">
						<label for="IfOthers" class="control-label col-sm-4">*IfOthers
							: </label>
						<form:input path="ifOthers" class="form-control" />
					</div>
					<div class="form-group">
						<label for="IdNumber" class="control-label col-sm-4">IdNumber
							: </label>
						<form:input path="ifNum" class="form-control" />
						<form:errors path="ifNum" cssClass="text-danger"></form:errors>
					</div>
					<input type="submit" value="Create User">

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