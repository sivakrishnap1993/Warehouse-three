<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShipmentType</title>
</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>

	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>Welcome To Shipment Data Page</h2>
			</div>
			<div class="card-body">
				
				<c:if test="${empty list}">
					<h2>No Data Found</h2>
				</c:if>

				<c:if test="${!empty list}">
					<table class="table table-bordered table-hover">
						<tr class="table-info text-success">
							<th>ID</th>
							<th>MODE</th>
							<th>CODE</th>
							
			<th colspan="5">OPERATIONS</th>
				</tr>
				<c:forEach items="${list}" var="oss">
					<tr>
					<td><c:out value="${oss.shipmentId}" /></td>
					<td><c:out value="${oss.shipmentMode}" /></td>
					<td><c:out value="${oss.shipmentCode}" /></td>
				
					<td><a href="viewOne?id=${oss.shipmentId}">
					<img src="../resources/images/view.png" width="35" height="35">	</a></td>
					<td><a href="delete?id=${oss.shipmentId}">
					<img src="../resources/images/delete.png" width="35" height="35"></a></td>
					<td><a href="edit?id=${oss.shipmentId}">
					<img src="../resources/images/edit.png" width="35" height="35"></a></td>
					<td><a href="excel?id=${oss.shipmentId}">
					<img src="../resources/images/excel.png" width="35" height="35"></a></td>
					<td><a href="pdf?id=${oss.shipmentId}">
					<img src="../resources/images/pdf.png" width="35" height="35"></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
				<a href="charts"><img src="../resources/images/charts.png"
					width="80" height="40"></a> <a href="excel"><img
					src="../resources/images/BulkExcel.png" width="80" height="40"></a>
				<a href="pdf"><img src="../resources/images/BulkPdf.png"
					width="80" height="40"> </a>
			</div>
			<c:if test="${msg ne null}">
				<div class="card-footer bg-warning text-danger">
					<b>${msg}</b>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>