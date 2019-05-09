<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase</title>
</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info">
				<h2>Welcome To Purchase Data Page</h2>
			</div>
			<div class="card-body bg-success">
			
				<c:if test="${empty list}">
					<h3>No Data Found</h3>
				</c:if>
				<c:if test="${!empty list}">
					<table class="table table-boarderd text-danger">
						<tr class="table-info table-success">
							<th>ID</th>
							<th>CODE</th>
							<th>MODE</th>
							<th>SHIPMENT-TYPE</th>
							<th>VENDOR</th>
							<th colspan="5">OPERATIONS</th>
						</tr>
						<c:forEach items="${list}" var="oss">
							<tr>
								<td><c:out value="${oss.ordId}" /></td>
								<td><c:out value="${oss.ordCode}" /></td>
								<td><c:out value="${oss.shipMode}" /></td>
								
								<td><c:out value="${oss.ship.shipmentCode}"></c:out>  </td>
								<td><c:out value="${oss.venwhuser.usrCode}"></c:out>  </td>
								
								<td><a href="delete?id=${oss.ordId}"> <img
										src="../resources/images/delete.png" height="30" width="40">
								</a></td>
								<td><a href="viewOne?id=${oss.ordId}"> <img
										src="../resources/images/view.png" height="30" width="40">
								</a></td>
								<td><a href="edit?id=${oss.ordId}"> <img
										src="../resources/images/edit.png" height="30" width="40">

								</a></td>
								<td><a href="excel?id=${oss.ordId}"> <img
										src="../resources/images/excel.png" height="30" width="40">

								</a></td>
								<td><a href="pdf?id=${oss.ordId}"> <img
										src="../resources/images/pdf.png" height="30" width="40">

								</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
					<a href="charts"><img src="../resources/images/charts.png"
					height="30" width="80"></a> <a href="excel"><img
					src="../resources/images/BulkExcel.png" height="30" width="80"></a>
				<a href="pdf"><img src="../resources/images/BulkPdf.png"
					height="30" width="80"></a>
			</div>
			<c:if test="${msg ne null}">
				<div class="card-footer">
					<b>${msg}</b>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>