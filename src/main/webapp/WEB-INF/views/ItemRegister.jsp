<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
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
<title>Item Register Page</title>
</head>
<body>


<!-- container start -->
	<div class="container">

		<!-- card start -->
		<div class="card">

			<!-- card Header -->
			<div class="card-header bg-primary text-white">
				<h1>Welcome to Item Register page</h1>
			</div>
			<div class="card-body">
			<form:form action="insert" method="post" modelAttribute="item" cssClass="form">
			<div class="form-group">
						<label for="uomType" class="control-label col-sm-4">itemCode      :
							</label> 
             <form:input path="code"   cssClass="form-control col-sm-4"/>
               <form:errors path="code" cssClass="text-danger"></form:errors><br>
               </div>
               <div class="form-group">
						<label for="uomType" class="control-label col-sm-4">itemDimessions     :
							</label> 
               
W:<form:input path="width" size="5" /> L<form:input path="length" size="5" /> H<form:input path="height" size="5" />
                 <form:errors path="length" cssClass="text-danger"></form:errors>
                 </div>
                 <div class="form-group">
						<label for="uomType" class="control-label col-sm-4">BaseCost      :
							</label> 
      <form:input path="baseCost" class="control-label col-sm-4"/>
               <form:errors path="baseCost" cssClass="text-danger"></form:errors>
               </div>
               <div class="form-group">
						<label for="uomType" class="control-label col-sm-4">BaseCurrency      :
							</label> 
               
<form:select path="baseCurrency" class="form-control">
               <form:option value="">--select--</form:option>
               <form:option value="INR">INR</form:option>
               <form:option value="USD">USD</form:option>
               <form:option value="AUS">AUS</form:option>
               <form:option value="ERU">ERU</form:option>
               </form:select>
               <form:errors path="baseCurrency" cssClass="text-danger"></form:errors></div>
<div class="form-group">
						<label for="uomType" class="control-label col-sm-4">itemUom      :
							</label> 
							<form:select path="uom.id" class="form-control">
               <form:option value="">--select--</form:option>
               <form:options items="${uoms}" itemLabel="model" itemValue="id"/>
               </form:select>
               <form:errors path="uom" cssClass="text-danger"></form:errors></div>
---------------------------------------------------------------------------------------------------------------------------------------
     
      <div class="form-group">
						<label for="uomType" class="control-label col-sm-4"> OrderMethod saleType      :
							</label> 
      <form:select path="saleType.id" class="form-control">
      <form:option value="">--select--</form:option>
      <form:options items="${oms}" itemLabel="code" itemValue="id"/>
      </form:select>     
      <form:errors path="saleType" cssClass="text-danger"></form:errors> </div>
      <div class="form-group">
						<label for="uomType" class="control-label col-sm-4">OrderMethod PurchaseType      :
							</label>          
      
      <form:select path="purchaseType.id" class="form-control">
      <form:option value="">--select--</form:option>
      <form:options items="${omp}" itemLabel="code" itemValue="id"/>
      </form:select>
      <form:errors path="purchaseType" cssClass="text-danger"></form:errors></div>
------------------------------------------------------------------------------------------------------------------------------------------
      <div class="form-group">
						<label for="uomType" class="control-label col-sm-4">WhUser ItemVendor      :
							</label> 
   
      <form:select path="venUser" class="form-control">
      <form:option value="">-select-</form:option>
      <form:options items="${vens}" itemLabel="code" itemValue="id"/>
      </form:select>
      <form:errors path="venUser" cssClass="text-danger"></form:errors></div>
      <div class="form-group">
						<label for="uomType" class="control-label col-sm-4">WhUser ItemCustomer      :
							</label> 
      
       <form:select path="custUser" class="form-control">
      <form:option value="">-select-</form:option>
      <form:options items="${custs}" itemLabel="code" itemValue="id"/>
      </form:select>
      <form:errors path="custUser" cssClass="text-danger"></form:errors>
       </div>
       <div class="form-group">
						<label for="uomType" class="control-label col-sm-4">Discription      :
							</label> 
    <form:textarea path="discr" class="form-control" rows="5"/>
                <form:errors path="discr" cssClass="text-danger"></form:errors></div>
<input type="submit" value="create Item"/>

</form:form>
</div> <!-- this card body -->
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