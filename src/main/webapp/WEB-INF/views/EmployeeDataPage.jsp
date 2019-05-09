<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>Welcome To Employee Data Page</h2>
			</div>
			<div class="card-body">
				<a href="charts"><img src="../resources/images/charts.png"
					width="80" height="40"></a> || <a href="excel"><img
					src="../resources/images/BulkExcel.png" width="80" height="40"></a>
				|| <a href="pdf"><img src="../resources/images/BulkPdf.png"
					width="80" height="40"></a>
				<c:if test="${empty list}">
					<h5>No Data Found</h5>
				</c:if>
				<c:if test="${!empty list}">
					<table class="table table-boardered table-hover">
						<tr class="table-info table-success">
							<th>ID</th>
							<th>NAME</th>
							<th>LOC</th>
							<th>PWD</th>
							<th>GEN</th>
							<th>ADDR</th>
							<th colspan="4">NOTIFICATION</th>
						</tr>
						<c:forEach items="${list}" var="ls">
							<tr>
								<td><c:out value="${ls.empId}" /></td>
								<td><c:out value="${ls.empName}" /></td>
								<td><c:out value="${ls.cmpLoc}" /></td>
								<td><c:out value="${ls.empPwd}" /></td>
								<td><c:out value="${ls.empGen}" /></td>
								<td><c:out value="${ls.empAddr}" /></td>
								<td><a href="viewOne?id=${ls.empId}"><img
										src="../resources/images/view.png" width="40" height="40"></a></td>
								<td><a href="delete?id=${ls.empId}"><img
										src="../resources/images/delete.png" width="40" height="40"></a></td>
								<td><a href="edit?id=${ls.empId}"><img
										src="../resources/images/edit.png" width="40" height="40"></a></td>
								<td><a href="excel?id=${ls.empId}"><img
										src="../resources/images/excel.png" width="40" height="40"></a></td>
								<td><a href="pdf?id=${ls.empId}"><img
										src="../resources/images/pdf.png" width="40" height="40"></a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
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