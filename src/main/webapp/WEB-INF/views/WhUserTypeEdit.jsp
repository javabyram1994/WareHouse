<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>WhUserType Edit page</h1>
<form:form action="update" method="post" modelAttribute="whu">
<pre>
UserId     :<form:input path="id" readonly="true"/>
UserCode   :<form:radiobutton path="type" value="vendor"/>VENDOE
            <form:radiobutton path="type" value="customer"/>CUSTOMER
UserCode   :<form:input path="code"/>
UserFor    :<form:input path="forType"/>
UserEmail  :<form:input path="email"/>
UserContact:<form:input path="contact"/>
UserIdType :<form:select path="idType">
<form:option value="">--select--</form:option>
<form:option value="pancard">PANCARD</form:option>
<form:option value="adharcard">ADHARCARD</form:option>
<form:option value="votercard">VOTERCARD</form:option>
</form:select>
IF Other   :<form:input path="ifOthers"/>
ID Number  :<form:input path="ifNum"/>
      <input type="submit" value="Update User">
</pre>
</form:form>
${message}

</body>
</html>