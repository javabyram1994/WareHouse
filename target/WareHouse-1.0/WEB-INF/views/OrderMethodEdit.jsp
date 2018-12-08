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
<h1>OrderMethod Edit Page</h1>
<form:form action="update" method="post" modelAttribute="om">
<pre>
OrderMethId :<form:input path="id" readOnly="true"/>
OrderCode   :<form:input path="code"/>
OrderMethod :<form:select path="method">
<form:option value="">--Select--</form:option>
<form:option value="fifo">FIFO</form:option>
<form:option value="lifo">LIFO</form:option>
<form:option value="fcfo">FCFO</form:option>
<form:option value="fefo">FEFO</form:option>
</form:select>
OderAccept  :<form:checkbox path="accept" value="multimodel"/>Multi-Model
             <form:checkbox path="accept" value="acceptreturn"/>Accept-Return
Discription :<form:textarea path="dsc"/>
<input type="submit" value="update Order Method">
</pre>
</form:form>
${message}
</body>
</html>