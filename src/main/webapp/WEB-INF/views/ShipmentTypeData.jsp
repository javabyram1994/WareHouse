<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipment Type Data</title>
</head>
<body>
	<h1>Shipment Type Data</h1>
	<a href="excel">EXCEL Export</a> | <a href="pdf">PDF Export</a>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>mode</th>
			<th>code</th>
			<th>enableing</th>
			<th>grade</th>
			<th>Discription</th>
			<th colspan="2">options</th>
		</tr>
		<c:forEach items="${list}" var="st">
			<tr>
				<td><c:out value="${st.id}" /></td>
				<td><c:out value="${st.mode}" /></td>
				<td><c:out value="${st.code}" /></td>
				<td><c:out value="${st.enabled}" /></td>
				<td><c:out value="${st.grade}" /></td>
				<td><c:out value="${st.dsc}" /></td>
				<td><a href="delete?id=${st.id}">Delete</a></td>
				<td><a href="edit?id=${st.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	${message}
</body>
</html>