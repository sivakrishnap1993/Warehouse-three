<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>
	<h2>Welcome To User View Page</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<td>${us.useId}</td>
		</tr>
		<tr>
			<th>NAME</th>
			<td>${us.usrName}</td>
		</tr>
		<tr>
			<th>TYPE</th>
			<td>${us.gender}</td>
		</tr>
		<tr>
			<th>EMAIL</th>
			<td>${us.usrMail}</td>
		</tr>
		<tr>
			<td>MOBILE</td>
			<td>${us.userMobile}</td>
		</tr>
		<tr>
			<th>PASSWORD</th>
			<td>${us.usrPwd}</td>
		</tr>
		<tr>
			<th>ROLES</th>
			<td>${us.usrRoles}</td>
		</tr>

	</table>
	<div class="card-footer">
		<a href="view">Back</a>
	</div>
</body>
</html>