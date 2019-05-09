<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OrderMethod</title>
</head>
<body>
<%@include file="ShipmentTypeMenu.jsp"%>
	<h2>Welcome To OrderMethod View Page</h2>
	<table class="table table-success bg-info">
		<tr class="btn brn-success">
			<th>ID</th>
			<td>${md.ordMId}</td>
		</tr>
		<tr>
			<th>MODE</th>
			<td>${md.ordMode}</td>
		</tr>
		<tr>
			<th>CODE</th>
			<td>${md.ordCode}</td>
		</tr>
		<tr>
			<th>TYPE</th>
			<td>${md.ordExType}</td>
		</tr>
		<tr>
			<th>ACCEPT</th>
			<td>${md.ordAccept}</td>
		</tr>
		<tr>
			<th>NOTE</th>
			<td>${md.note}</td>
		</tr>
		

	</table>
</body>
</html>