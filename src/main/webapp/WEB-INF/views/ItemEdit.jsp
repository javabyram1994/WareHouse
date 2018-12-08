<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.err{
color:red;
}
</style>
</head>
<body>
<h1>Item Register page</h1>
<form:form action="update" method="post" modelAttribute="item">
<pre>
Id            :<form:input path="id"/>
itemCode      :<form:input path="code"/>
               <form:errors path="code" cssClass="err"></form:errors>
itemDimessions:W <form:input path="width" size="5"/> L<form:input path="length" size="5"/> H<form:input path="height" size="5"/>
                 <form:errors path="length" cssClass="err"></form:errors>
BaseCost      :<form:input path="baseCost"/>
               <form:errors path="baseCost" cssClass="err"></form:errors>
BaseCurrency  :<form:select path="baseCurrency">
               <form:option value="">--select--</form:option>
               <form:option value="INR">INR</form:option>
               <form:option value="USD">USD</form:option>
               <form:option value="AUS">AUS</form:option>
               <form:option value="ERU">ERU</form:option>
               </form:select>
               <form:errors path="baseCurrency" cssClass="err"></form:errors>
<%-- ItemUom       :<form:select path="uom.id">
               <form:option value="">--select--</form:option>
               <form:options items="${uoms}" itemLabel="model" itemValue="id"/>
               </form:select> --%>
ItemUom       :<form:select path="uom.id">
               <form:option value="">--select--</form:option>
               <form:options items="${uoms}" itemLabel="model" itemValue="id"/>
               </form:select>
      OrderMethod saleType
      <form:select path="saleType.id">
      <form:option value="">--select--</form:option>
      <form:options items="${oms}" itemLabel="code" itemValue="id"/>
      </form:select>               
      OrderMethod PurchaseType
      <form:select path="purchaseType.id">
      <form:option value="">--select--</form:option>
      <form:options items="${omp}" itemLabel="code" itemValue="id"/>
      </form:select>
------------------------------------------------------------------------------------------------------------------------------------------

WhUser ItemVendor:   
      <form:select path="venUser">
      <form:option value="">-select-</form:option>
      <form:options items="${vens}" itemLabel="code" itemValue="id"/>
      </form:select>
      ItemCustomer:
       <form:select path="custUser">
      <form:option value="">-select-</form:option>
      <form:options items="${custs}" itemLabel="code" itemValue="id"/>
      </form:select>
      
    
Discription    :<form:textarea path="discr"/>
                <form:errors path="discr" cssClass="err"></form:errors>
<input type="submit" value="create Item"/>
</pre>
</form:form>
${message}

</body>
</html>