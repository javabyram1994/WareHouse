<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VendorEdit page</title>
</head>
<body>
<h1>Vendor Edit Page</h1>
<form:form action="update" method="post" modelAttribute="ven">
<pre>
VendorId     :<form:input path="venId" readonly="true"/>
VendorName   :<form:input path="venName"/>
VendorCode   :<form:input path="venCode"/>
Disegnation  :<form:input path="venDesg"/>
Preservative :<form:checkbox path="venPreserve" value="A"/>A
              <form:checkbox path="venPreserve" value="B"/>B
              <form:checkbox path="venPreserve" value="C"/>C
    <input type="submit" value="update">
</pre>
</form:form>
${message}
</body>
</html>