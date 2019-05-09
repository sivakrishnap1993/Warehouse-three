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
			<div class="card-header bg-primary text-white">
				<h2>Welcome To Admin View Page</h2>
			</div>
			<div class="card-body">
				<table class="table table-striped table-bordered">
					<tr>
						<th>ID</th>
						<td>${ad.admId}</td>
					</tr>
					<tr>
						<th>NAME</th>
						<td>${ad.admName}</td>
					</tr>
					<tr>
						<th>SALARY</th>
						<td>${ad.admType}</td>
					</tr>
					<tr>
						<th>SALARY</th>
						<td>${ad.admSalary}</td>
					</tr>
					<tr>
						<th>DEPT</th>
						<td>${ad.dept}</td>
					</tr>
					<tr>
						<th>MODES</th>
						<td>${ad.admModes}</td>
					</tr>

				</table>

			</div>
		</div>

	</div>

</body>
</html>