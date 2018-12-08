<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Shipment Type Register Page</h1>
<form:form action="insert" method="post" modelAttribute="st">
<pre>
Shipment Mode  :<form:select path="mode">
<form:option value="">--select--</form:option>
<form:option value="air">AIR</form:option>
<form:option value="truck">TRUCK</form:option>
<form:option value="ship">SHIP</form:option>
<form:option value="train">TRAIN</form:option>
</form:select>
Shopment Code   :<form:input path="code"/>
Enabled Shipment:<form:checkbox path="enabled" value="yes"/>YES
ShipmentGrade   :<form:radiobutton path="grade" value="a"/>A
                 <form:radiobutton path="grade" value="b"/>B
                 <form:radiobutton path="grade" value="c"/>C
Discription     :<form:textarea path="dsc"/>
        <input type="submit" value="Create Shipment">
</pre>
</form:form>
${message}
</body>
</html>