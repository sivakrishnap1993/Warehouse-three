<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OrderMethod</title>
</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>Welcome To Data Page</h2>
			</div>
			<div class="card-body">
				<c:if test="${empty list}">
					<h1>No Data Found</h1>
				</c:if>
				<c:if test="${!empty list }">
					<table class="table table-boardered table-hover">
						<tr class="table-info table-success">
							<th>ID</th>
							<th>MODE</th>
						
							<th colspan="5">OPERATIONS</th>
						</tr>
						<c:forEach items="${list}" var="ls">
							<tr>
								<td><c:out value="${ls.ordMId}" /></td>
								<td><c:out value="${ls.ordMode}" /></td>
								
								<td><a href="viewOne?id=${ls.ordMId}"><img
										src="../resources/images/view.png" width="40" height="40"></a></td>
								<td><a href="delete?id=${ls.ordMId}"><img
										src="../resources/images/delete.png" width="40" height="40"></a></td>
								<td><a href="edit?id=${ls.ordMId}"><img
										src="../resources/images/edit.png" width="40" height="40"></a></td>
								<td><a href="excel?id=${ls.ordMId}"><img
										src="../resources/images/excel.png" width="40" height="40"></a></td>
								<td><a href="pdf?id=${ls.ordMId}"><img
										src="../resources/images/pdf.png" width="40" height="40"></a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
				<a href="charts"><img src="../resources/images/charts.png"
					width="80" height="40"></a> <a href="excel"><img
					src="../resources/images/BulkExcel.png" width="80" height="40"></a>
				<a href="pdf"><img src="../resources/images/BulkPdf.png"
					width="80" height="40"></a>
			</div>
			<c:if test="${msg ne null}">
				<div class="card-footer bg-success text-danger">
					<b>${msg}</b>
				</div>
			</c:if>
		</div>

	</div>
</body>
</html>