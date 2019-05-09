<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>

	<div class="container">

		<div class="card">

			<div class="card-header">
				<h1>Welcome To Shipment Type Edit Page</h1>
			</div>

			<div class="card-body">

				<form:form action="update" method="POST"
					modelAttribute="shipmentType">

					<div class="row">
						<div class="col-3"><label for="shipmentId" class="control-form">SHIPMENT-ID</label></div>
						<div class="col-5"><form:input path="shipmentId" readonly="true" class="form-controller" /></div>
					</div>
					<div class="row">
						<div class="col-3"><label for="shipmentMode" class="control-form">SHIPMENT-MODE</label></div>
						<div class="col-5"><form:select path="shipmentMode" class="form-controller">
											<form:option value="">SELECT</form:option>
											<form:option value="AIR">AIR</form:option>
											<form:option value="TRUCK">TRUCK</form:option>
											<form:option value="SHIP">SHIP</form:option>
											<form:option value="TRAIN">TRAIN</form:option>
											</form:select></div>
					</div>

					<div class="row">
						<div class="col-3">	<label for="shipmentCode" class="control-form">SHIPMENT-CODE</label></div>
						<div class="col-5"><form:input path="shipmentCode" class="form-controller" /></div>
					</div>
					<div class="row">
						<div class="col-3"><label for="enableShipment" class="control-form">ENABLE-SHIPMENT</label></div>
						<div class="col-5"><form:select path="enableShipment" class="form-controller">
										   <form:option value="">SELECT</form:option>
										   <form:option value="YES">Yes</form:option>
										   <form:option value="NO">No</form:option>
										   </form:select></div>
					</div>

					<div class="row">
						<div class="col-3"><label for="shipmentGrade" class="control-form">SHIPMENT-GRADE</label></div>
						<div class="col-5"><form:radiobutton path="shipmentGrade" value="A" />A
											<form:radiobutton path="shipmentGrade" value="B" />B
											<form:radiobutton path="shipmentGrade" value="C" />C </div>
					</div>
					<div class="row">
						<div class="col-3"><label for="note" class="control-label">DESCRIPTION</label></div>
						<div class="col-5"><form:textarea path="note" class="form-control" /></div>
					</div>

					<div class="card-footer bg-info text-white">
						<input type="submit" value="Update" class="bg-danger" />
					</div>
				</form:form>
			</div>

		</div>

	</div>
</body>
</html>