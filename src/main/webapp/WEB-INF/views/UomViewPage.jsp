<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<%@include file="ShipmentTypeMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>Welcome To Uom View page</h2>
			</div>
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr class="table-info text-success">
						<th>ID</th>
						<td>${us.uomId}</td>
					</tr>
					<tr>
						<th>TYPE</th>
						<td>${us.uonType}</td>
					</tr>
					<tr>
						<th>CODE</th>
						<td>${us.uomCode}</td>
					</tr>
					<tr>
						<th>ENABLE</th>
						<td>${us.uomEnable}</td>
					</tr>
					<tr>
						<th>META</th>
						<td>${us.metaCode}</td>
					</tr>
					<tr>
						<th>SIZE</th>
						<td>${us.adjst}</td>
					</tr>
					<tr>
						<th>NOTE</th>
						<td>${us.note}</td>
					</tr>
				</table>
			</div>
		</div>

	</div>
</body>
</html>