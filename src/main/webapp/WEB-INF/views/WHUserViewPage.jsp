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
			<div class="card-header bg-success">
				<h2>Welcome To WHUSerType View Page</h2>
			</div>
			<div class="card-body bg-info">
				<table class="table table-boardered table-info">
					<tr class="table-info table-success">
						<th>ID</th>
						<td>${whu.urdId}</td>
					</tr>
					<tr>
						<th>TYPE</th>
						<td>${whu.userOneType}</td>
					</tr>
					<tr>
						<th>CODE</th>
						<td>${whu.usrCode}</td>
					</tr>
					<tr>
						<th>UFOR</th>
						<td>${whu.usrFor}</td>
					</tr>
					<tr>
						<th>EMAIL</th>
						<td>${whu.usrEmail}</td>
					</tr>
					<tr>
						<th>CONTACT</th>
						<td>${whu.usrContact}</td>
					</tr>
					<tr>
						<th>IDTYPE</th>
						<td>${whu.userType}</td>
					</tr>
					<tr>
						<th>NUMBER</th>
						<td>${whu.usrNum}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>