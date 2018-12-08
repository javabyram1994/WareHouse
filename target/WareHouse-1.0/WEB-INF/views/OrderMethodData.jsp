<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OrderMethod Data</title>
</head>
<body>
<h1>OrderMethod Data</h1>
<a href="excel">Excel Export</a> | <a href="pdf">PDF Export</a>
<table border="1">
<tr>
<th>id</th>
<th>mode</th>
<th>code</th>
<th>method</th>
<th>accept</th>
<th>dsc</th>
<th colspan="2">options</th>
</tr>
<c:forEach items="${list}" var="om">
<tr>
<td><c:out value="${om.id}"/></td>
<td><c:out value="${om.mode}"/></td>
<td><c:out value="${om.code}"/></td>
<td><c:out value="${om.method}"/></td>
<td><c:out value="${om.accept}"/></td>
<td><c:out value="${om.dsc}"/></td>
<td><a href="delete?id=${om.id}"> Delete </a></td>
<td><a href="edit?id=${om.id}" >Edit</a></td>
</c:forEach>
</table>
${message}
</body>
</html>