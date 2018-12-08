<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>Item Data jsp</title>
</head>
<body>
<div class="container">
		<div class="card">
			<div class="card-header">
<h1>Item Data Jsp</h1>
			</div>
<div class="card-body">
			<c:choose>
					<c:when test="${!empty list}">
					<div class="table-responsive">
<table class="table table-hover ">
<tr class="thead-dark">
    <th>ID</th>
    <th>CODE</th>
    <th>DImenssions</th>
    <th>Cost</th>
    <th>UOM</th>
    <th>Currency</th>
    <th>sale</th>
    <th>purchase</th>
    <th>WhVendor</th>
    <th>WhCustomer</th>
    <th colspan="2">Options</th>
</tr>
<c:forEach items="${list}" var="i">
<tr class="table-primary">
<td><c:out value="${i.id}"/></td>
<td><c:out value="${i.code}"/></td>
<td>W:<c:out value="${i.width}"/>L:<c:out value="${i.length}"/>H:<c:out value="${i.height}"/></td>
<td><c:out value="${i.baseCost}"/></td>
<td><c:out value="${i.uom.model}"/></td>
<td><c:out value="${i.baseCurrency}"/></td>
<td><c:out value="${i.saleType.code}"/></td>
<td><c:out value="${i.purchaseType.code}"/></td>
<td>
	<c:forEach items="${i.venUser}" var="ven">
		<c:out value="${ven.code}"/>,
	</c:forEach>
</td>
<td>
	<c:forEach items="${i.custUser}" var="cust">
		<c:out value="${cust.code}"/>,
	</c:forEach>
</td>
<td><a href="delete?id=${i.id}" class="btn btn-secondary"> Delete </a></td>
<td><a href="edit?id=${i.id}" class="btn btn-info">Edit</a></td>
</tr>
</c:forEach>
</table>
</div>
</c:when>
				<c:otherwise>
						<div class="text-info">No Data Found in Database</div>
			    </c:otherwise>
			    </c:choose>
			</div>
			<!-- this is end of cardBody -->

<!-- card footer -->
			<c:if test="${message ne null }">
				<div class="card-footer bg-warning">${message}</div>
			</c:if>

</div>
		<!-- this is closing tag of card -->
	</div>
	<!-- this is closing tag of container -->
</body>
</html>