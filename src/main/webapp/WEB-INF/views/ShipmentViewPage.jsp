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
				<h2>Welcome To Shipment Type View Page</h2>
			</div>
			<div class="card-body">
				<table class="table table-striped table-bordered">
					<tr>
						<th>ID</th>
						<td>${st.shipmentId}</td>
					</tr>
					<tr>
						<th>MODE</th>
						<td>${st.shipmentMode}</td>

					</tr>
					<tr>
						<th>CODE</th>
						<td>${st.shipmentCode}</td>

					</tr>

					<tr>
						<th>ENABLE</th>
						<td>${st.enableShipment}</td>

					</tr>
					<tr>
						<th>GRADE</th>
						<td>${st.shipmentGrade}</td>

					</tr>
					<tr>
						<th>NOTE</th>
						<td>${st.note}</td>

					</tr>

				</table>
			</div>
		</div>

	</div>
</body>
</html>