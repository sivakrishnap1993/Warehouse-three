<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

</style>
</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>
	<div class="container">

		<div class="card">
			<div class="card-header text-success">
				<h2>Welcome To Uom Data PAGE</h2>
			</div>
			<div class="card-body text-danger bg-info text-white">
				
				<c:if test="${empty list }">

					<h2>No Data Found</h2>
				</c:if>
				<c:if test="${!empty list}">
					<table class="table table-bordered table-hover text-white">
						<tr class="table-info table-success">
							<th>ID</th>
							<th>TYPE</th>
							<th>CODE</th>
							<th>ENABLE</th>
							<th>META</th>
							<th>SIZE</th>
							<th>NOTE</th>
							<th colspan="5">NOTIFICATION</th>
						</tr>
						<c:forEach items="${list}" var="uo">
							<tr>
								<td><c:out value="${uo.uomId}" /></td>
								<td><c:out value="${uo.uonType}" /></td>
								<td><c:out value="${uo.uomCode}" /></td>
								<td><c:out value="${uo.uomEnable}" /></td>
								<td><c:out value="${uo.metaCode}" /></td>
								<td><c:out value="${uo.adjst}" /></td>
								<td><c:out value="${uo.note}" /></td>

								<td><a href="viewOne?id=${uo.uomId}"><img
										src="../resources/images/view.png" width="40" height="40"></a></td>
								<td><a href="delete?id=${uo.uomId}"><img
										src="../resources/images/delete.png" width="40" height="40"></a></td>
								<td><a href="edit?id=${uo.uomId}"><img
										src="../resources/images/edit.png" width="40" height="40"></a></td>
								<td><a href="excel?id=${uo.uomId}"><img
										src="../resources/images/excel.png" width="40" height="40"></a></td>
								<td><a href="pdf?id=${uo.uomId}"><img
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
					<div class="card-footer bg-warning text-danger">
						<b>${msg}</b>
					</div>
				</c:if>
			</div>
	</div>
</body>
</html>