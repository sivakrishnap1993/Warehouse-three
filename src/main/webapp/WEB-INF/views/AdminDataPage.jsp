<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>

	<div class="container">

		<div class="card">
			<div class="card-header bg-primary text-white">
				<h4>Welcome To Admin Data Page</h4>
			</div>
			<div class="card-body">

				<c:if test="${empty list}">
					<h2>No Data Found</h2>
				</c:if>
				<c:if test="${!empty list}">
					<table class="table table-bordered table-hover">
						<tr class="table-info table-success">
							<th>ID</th>
							<th>NAME</th>
							<th>TYPE</th>

							<th colspan="5">NOTIFICATION</th>
						</tr>
						<c:forEach items="${list}" var="la">
							<tr>
								<td><c:out value="${la.admId}" /></td>
								<td><c:out value="${la.admName}" /></td>
								<td><c:out value="${la.admType}" /></td>

								<td><a href="viewOne?id=${la.admId}"><img
										src="../resources/images/view.png" width="40" height="40"></a></td>
								<td><a href="delete?id=${la.admId}"><img
										src="../resources/images/delete.png" width="40" height="40"></a></td>
								<td><a href="edit?id=${la.admId}"><img
										src="../resources/images/edit.png" width="40" height="40"></a></td>
								<td><a href="excel?id=${la.admId}"><img
										src="../resources/images/excel.png" width="40" height="40"></a></td>
								<td><a href="pdf?id=${la.admId}"><img
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
			<c:if test="${mes ne null}">
				<div class="card-footer bg-warning text-danger">
					<b>${mes}</b>
				</div>
			</c:if>

		</div>
	</div>
</body>
</html>