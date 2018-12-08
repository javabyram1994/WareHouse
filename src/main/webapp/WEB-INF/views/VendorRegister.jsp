<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VendorRegister</title>
</head>
<body>
<h1>VendorRegister page</h1>
<form:form action="insert" method="post" modelAttribute="ven">
<pre>
VendorName   :<form:input path="venName"/>
VendorCode   :<form:input path="venCode"/>
Disegnation  :<form:input path="venDesg"/>
Preservative :<form:checkbox path="venPreserve" value="A"/>A
              <form:checkbox path="venPreserve" value="B"/>B
              <form:checkbox path="venPreserve" value="C"/>C
    <input type="submit" value="Create">
</pre>
</form:form>
${message}
</body>
</html>