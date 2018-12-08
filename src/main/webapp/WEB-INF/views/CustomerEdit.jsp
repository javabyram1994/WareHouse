<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Edit Page</title>
</head>
<body>
<h1>Customer Edit Page</h1>
<form:form action="update" method="post" modelAttribute="cust">
<pre>
CustomerCode    :<form:input path="custId" readonly="true"/>
CoustomerCode   : <form:input path="custCode"/>
CustomerAddress : <form:textarea path="custAddr"/>
CustomerLocs    : <form:select path="custLocs">
                  <form:option value="">--select--</form:option>
                  <form:option value="HYD">hyd</form:option>
                  <form:option value="BAN">ban</form:option>
                  <form:option value="CHN">chn</form:option>
                  </form:select>
Enabled         : <form:radiobutton path="custEnabled" value="YES"/>yes
                  <form:radiobutton path="custEnabled" value="NO"/>no
Email           : <form:input path="custEmail"/>
Contact         : <form:input path="custContact"/>
    <input type="submit" value="update">
</pre>
</form:form>
${message}
</body>
</html>