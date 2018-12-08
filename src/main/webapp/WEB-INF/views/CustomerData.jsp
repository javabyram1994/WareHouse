<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Data</title>
</head>
<body>
<h1>Welcome to Customer Data</h1>
<a href="excel">EXCEL Export</a> | <a href="pdf">PDF Export</a>
<table border="1">
<tr>
<th>ID</th>
<th>Code</th>
<th>Address</th>
<th>Locs</th>
<th>Enabled</th>
<th>Email</th>
<th>Contact</th>
<th colspan="2">Options</th>
</tr>
<c:forEach items="${list}" var="c">
<tr>
<td><c:out value="${c.custId}"/></td>
<td><c:out value="${c.custCode}"/></td>
<td><c:out value="${c.custAddr}"/></td>
<td><c:out value="${c.custLocs}"/></td>
<td><c:out value="${c.custEnabled}"/></td>
<td><c:out value="${c.custEmail}"/></td>
<td><c:out value="${c.custContact}"/></td>
<td><a href="delete?id=${c.custId}"> Delete </a></td>
<td><a href="edit?id=${c.custId}" >Edit</a></td>
</tr>
</c:forEach>
</table>
${message}
</body>
</html>