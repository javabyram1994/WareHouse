<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Data Page</h1>
<table border="1">
<tr>
    <th>ID</th>
    <th>OrdercODE</th>
    <th>ShipCode</th>
    <th>Vendor</th>
    <th>RefNumber</th>
    <th>QualifyCheek</th>
    <th>status</th>
    <th>Discription</th>
    <th colspan="2">Options</th>
</tr>
<c:forEach items="${list}" var="sh">
<tr>
<td><c:out value="${sh.id}"/></td>
<td><c:out value="${sh.code}"/></td>
<td><c:out value="${sh.shcode.code}"/></td>
<td><c:out value="${sh.ven.code}"/></td>
<td><c:out value="${sh.refNum}"/></td>
<td><c:out value="${sh.quachk}"/></td>
<td><c:out value="${sh.defstu}"/></td>
<td><c:out value="${sh.dsc}"/></td>
<td><a href="delete?id=${i.id}"> Delete </a></td>
<td><a href="edit?id=${i.id}" >Edit</a></td>
</tr>
</c:forEach>
</table>
${message}

</body>
</html>