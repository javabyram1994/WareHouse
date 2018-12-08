<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WhUserTable Data</title>
</head>
<body>
<h1>WhUserTable Data</h1>
<a href="excel">EXCEL Export</a> | <a href="pdf">PDF Export</a>
<table border="1">
<tr>
<th>Id</th>
<th>Type</th>
<th>code</th>
<th>userfor</th>
<th>Email</th>
<th>Contact</th>
<th>IdType</th>
<th>IfOther</th>
<th>Id number</th>
<th colspan="2">options</th>
</tr>
<c:forEach items="${list}" var="wu">
<tr>
<td><c:out value="${wu.id}"/></td>
<td><c:out value="${wu.type}"/></td>
<td><c:out value="${wu.code}"/></td>
<td><c:out value="${wu.forType}"/></td>
<td><c:out value="${wu.email}"/></td>
<td><c:out value="${wu.contact}"/></td>
<td><c:out value="${wu.idType}"/></td>
<td><c:out value="${wu.ifOthers}"/></td>
<td><c:out value="${wu.ifNum}"/></td>
<td><a href="delete?id=${wu.id}"> Delete </a></td>
<td><a href="edit?id=${wu.id}" >Edit</a></td>
</tr>
</c:forEach>

</table>
${message}
</body>
</html>