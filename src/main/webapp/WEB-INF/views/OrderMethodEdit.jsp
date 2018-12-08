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
<h1>OrderMethod Edit Page</h1>
<form:form action="update" method="post" modelAttribute="om">
<pre>
OrderMethId :<form:input path="id" readOnly="true"/>
OrderMode   :<form:radiobutton path="mode" value="sale"/>SALE
             <form:radiobutton path="mode" value="purchase"/>PURCHASE
             <form:errors path="mode" cssClass="err"/>
OrderCode   :<form:input path="code"/>
             <form:errors path="code" cssClass="err"/>
OrderMethod :<form:select path="method">
<form:option value="">--Select--</form:option>
<form:option value="fifo">FIFO</form:option>
<form:option value="lifo">LIFO</form:option>
<form:option value="fcfo">FCFO</form:option>
<form:option value="fefo">FEFO</form:option>
</form:select>
             <form:errors path="method" cssClass="err"/>
OderAccept  :<form:checkbox path="accept" value="multimodel"/>Multi-Model
             <form:checkbox path="accept" value="acceptreturn"/>Accept-Return
             <form:errors path="accept" cssClass="err"/>
Discription :<form:textarea path="dsc"/>
             <form:errors path="dsc" cssClass="err"></form:errors>
<input type="submit" value="update Order Method">
</pre>
</form:form>
${message}
</body>
</html>