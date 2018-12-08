<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.err{
color:red;}
</style>
</head>
<body>
<h1>Shipment Type EditPage</h1>
<form:form action="update" method="post" modelAttribute="st">
<pre>
Shipment Id    :<form:input path="Id" readonly="true"/>
Shipment Mode   :<form:select path="mode">
                 <form:option value="">--select--</form:option>
                 <form:option value="air">AIR</form:option>
                 <form:option value="truck">TRUCK</form:option>
                 <form:option value="ship">SHIP</form:option>
                 <form:option value="train">TRAIN</form:option>
                 </form:select>
                 <form:errors path="mode" cssClass="err"></form:errors>
Shopment Code    :<form:input path="code"/>
                  <form:errors path="code" cssClass="err"></form:errors>
Enabled Shipment :<form:checkbox path="enabled" value="yes"/>YES
ShipmentGrade    :<form:radiobutton path="grade" value="a"/>A
                 <form:radiobutton path="grade" value="b"/>B
                 <form:radiobutton path="grade" value="c"/>C
                 <form:errors path="grade" cssClass="err"></form:errors>
Discription      :<form:textarea path="dsc"/>
                  <form:errors path="dsc" cssClass="err"></form:errors>
        <input type="submit" value="Update Shipment">
</pre>
</form:form>
${message}

</body>
</html>