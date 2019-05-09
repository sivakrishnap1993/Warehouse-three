<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase</title>
</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>

	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>Welcome To View Page</h2>
			</div>
			<div class="crd-body">
				<table class="table table-bordered bg-info">
					<tr class="table table-success">
						<th>ID</th>
						<td>${pr.ordId}</td>
					</tr>
					<tr>
						<th>CODE</th>
						<td>${pr.ordCode}</td>
					</tr>
					<tr>
						<th>MODE</th>
						<td>${pr.shipMode}</td>
					</tr>
					<tr>
						<th>REFERENCE NO</th>
						<td>${pr.refNo}</td>
					</tr>
					<tr>
						<th>QUALITY</th>
						<td>${pr.qtyCk}</td>
					</tr>
					<tr>
						<th>STATUS</th>
						<td>${pr.ordSts}</td>
					</tr>
					<tr>
						<th>SHIPMENT-TYPE</th>
						<td>${pr.ship.shipmentId}</td>
					</tr>
					<tr>
						<th>WHUSER-TYPE</th>
						<td>${pr.venwhuser.usrCode}</td>
					</tr>
					<tr>
						<th>NOTE</th>
						<td>${pr.node}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>

</body>
</html>