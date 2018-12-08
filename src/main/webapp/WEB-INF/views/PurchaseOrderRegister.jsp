<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PurchaseOrder Register</title>
<style type="text/css">
.err{
color:red;
}
</style>
</head>
<body>
<h1>Welcome to Purchase Order Register</h1>
<form:form action="insert" method="post" modelAttribute="purchase">
<pre>
OrderCode      : <form:input path="code"/>
ShipmentCode   : <form:select path="shcode.id">
                 <form:option value="">--select--</form:option>
                 <form:options items="${codes}" itemLabel="code" itemValue="id"/>
                 </form:select>
WhUserVendor   :<form:select path="ven" multiple="false">
                <form:option value="">--select--</form:option>
                <form:options items="${vens}" itemLabel="code" itemValue="id"/>
                </form:select>   
                 
RefernceNum    :<form:input path="refNum"/>
QualityCheek   :<form:radiobutton path="quachk" value="required"/>Required
               <form:radiobutton path="quachk" value="notrequired"/>NotRequired
DefaultStatus  :<form:input path="defstu" value="open" readonly="true"/>
Discription    :<form:textarea path="dsc"/>
            <input type="submit" value="create placeorder"/>
</pre>
</form:form>
${message}
</body>
</html>