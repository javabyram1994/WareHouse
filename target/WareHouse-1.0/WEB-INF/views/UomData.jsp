<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unit of Measurements</title>
</head>
<body>
<h1>Unit of Measurements Data Page</h1>
<a href="excel">EXCEL Export</a> | <a href="pdf">PDF Export</a>
<table border="1">
<tr>
<th>ID</th>
<th>Type</th>
<th>Model</th>
<th>Discription</th>
<th colspan="2">Options</th>
</tr>
<c:forEach items="${list}" var="uom">
<tr>
<td><c:out value="${uom.id}"/></td>
<td><c:out value="${uom.type}"/></td>
<td><c:out value="${uom.model}"/></td>
<td><c:out value="${uom.dsc}"/></td>
<td><a href="delete?id=${uom.id}"> Delete </a></td>
<td><a href="edit?id=${uom.id}" >Edit</a></td>
</tr>
</c:forEach>
</table>
${message} 
</body>
</html>