<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Unit of Measurements Edit Page</h1>
<form:form action="update" method="post" modelAttribute="uom">
<pre>
UomId       :<form:input path="id" readOnly="true"/>
UomType     :<form:select path="type">
            <form:option value="">---Select---</form:option>
            <form:option value="packing">PACKING</form:option>
            <form:option value="Nopacking">NOPACKING</form:option>
            <form:option value="na">-NA-</form:option>
            </form:select><br>
UomModel    :<form:input path="model"/><br>
Description :<form:textarea path="dsc"/><br><br>
       <input type="submit" value="Creat Uom">
</pre>
</form:form>

</body>
</html>