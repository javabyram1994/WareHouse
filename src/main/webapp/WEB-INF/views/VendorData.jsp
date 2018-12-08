<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VendorData Page</title>
</head>
<body>
<h1>VendorData Page</h1>
<a href="excel">EXCEL Export</a> | <a href="pdf">PDF Export</a>
<table border="1"> 
<tr>
<th>Id</th>
<th>Name</th>
<th>Code</th>
<th>Desg</th>
<th>preser</th>
<th colspan="2">Options</th>
</tr>
<c:forEach items="${list}" var="v">
<tr>
<td><c:out value="${v.venId}"/></td>
<td><c:out value="${v.venName}"/></td>
<td><c:out value="${v.venCode}"/></td>
<td><c:out value="${v.venDesg}"/></td>
<td><c:out value="${v.venPreserve}"/></td>
<td><a href="delete?id=${v.venId}"> Delete </a></td>
<td><a href="edit?id=${v.venId}" >Edit</a></td>
</c:forEach>
</table>
${message}
</body>
</html>