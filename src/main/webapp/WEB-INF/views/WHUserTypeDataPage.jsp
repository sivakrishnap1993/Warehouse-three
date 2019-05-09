<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WHUserType</title>
</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-primary text-white">
				<h2>Welcome To WhuserType Data Page</h2>
			</div>
			<div class="card-body">
				<c:if test="${empty list}">
						<h2>No Data Found</h2>
					</c:if>
				   <c:if test="${!empty list}">
						<table class="table table-bordered table-success text-white">
							<tr class="table-info table-hover">
								<th>ID</th>
								<th>TYPE</th>
								<th>CODE</th>

								<th colspan="5">OPERATIONS</th>
							</tr>
							<c:forEach items="${list}" var="lts">
								<tr>
									<td><c:out value="${lts.urdId}" /></td>
									<td><c:out value="${lts.userOneType}" /></td>
									<td><c:out value="${lts.usrCode}" /></td>

									<td><a href="viewOne?id=${lts.urdId}"> <img
											src="../resources/images/view.png" width="40" height="40"></a></td>
									<td><a href="delete?id=${lts.urdId}"> <img
											src="../resources/images/delete.png" width="40" height="40"></a></td>
									<td><a href="edit?id=${lts.urdId}"> <img
											src="../resources/images/edit.png" width="40" height="40"></a></td>
									<td><a href="excel?id=${lts.urdId}"> <img
											src="../resources/images/excel.png" width="40" height="40"></a></td>
									<td><a href="pdf?id=${lts.urdId}"> <img
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
				<div class="card-footer">
					<b>${mes}</b>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>