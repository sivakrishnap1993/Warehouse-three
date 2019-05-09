<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
</head>
<body>
<%@include file="ShipmentTypeMenu.jsp"%>
	<h2>Welcome To Employee View Page</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${emp.empId}</td>
		</tr>
		<tr>
			<th>NAME</th>
			<td>${emp.empName}</td>
		</tr>
		<tr>
			<th>LOCATION</th>
			<td>${emp.cmpLoc}</td>
		</tr>
		<tr>
			<th>PWD</th>
			<td>${emp.empPwd}</td>
		</tr>
		<tr>
			<th>GEN</th>
			<td>${emp.empGen}</td>
		</tr>
		<tr>
			<th>ADDR</th>
			<td>${emp.empAddr}</td>
		</tr>

	</table>

</body>
</html>