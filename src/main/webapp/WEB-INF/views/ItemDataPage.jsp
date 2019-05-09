<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>WELCOME TO ITEM DATA OAGE</h2>
			</div>
			<div class="card-body">

				<c:if test="${empty list}">
					<h3>No Data Found</h3>
				</c:if>
				<c:if test="${!empty list}">
					<table class="table table-bordered table-hover">
						<tr class="table-info table-success">
							<th>ID</th>
							<th>CODE</th>
							<th>WEIDTH</th>
							<th>UOM</th>
							<th>ORDER-METHOD</th>
							<th>VENDOR</th>
							<th>CUSTOMER</th>
							
							<th colspan="5">OPERATIONS</th>
						</tr>
						<c:forEach items="${list}" var="oss">
							<tr>
								<td><c:out value="${oss.itemId}" /></td>
								<td><c:out value="${oss.itmCode}" /></td>
								<td><c:out value="${oss.itmWidth}" /></td>
								
								<td><c:out value="${oss.uom.uomEnable}"></c:out></td>
								<td><c:out value="${oss.om.ordMode}"></c:out></td>
								
								<td><c:if test="${oss.wuven.usrCode}"></c:if> </td>
								<td><c:if test="${oss.wucust.usrCode}"></c:if> </td>
							
								<td><a href="delete?id=${oss.itemId}"> <img
										src="../resources/images/delete.png" height="30" width="40">
								</a></td>
								
								<td><a href="viewOne?id=${oss.itemId}"> <img
										src="../resources/images/view.png" height="30" width="40">
								</a></td>
								<td><a href="edit?id=${oss.itemId}"> <img
										src="../resources/images/edit.png" height="30" width="40">

								</a></td>
								<td><a href="excel?id=${oss.itemId}"> <img
										src="../resources/images/excel.png" height="30" width="40">

								</a></td>
								<td><a href="pdf?id=${oss.itemId}"> <img
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
			<c:if test="${message ne null}">
				<div class="card-footer bg-warning text-danger">
					<b>${message}</b>
				</div>
			</c:if>
		</div>

	</div>
</body>
</html>