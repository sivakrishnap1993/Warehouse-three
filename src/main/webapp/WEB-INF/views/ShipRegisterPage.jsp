<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>

	<div class="contaoner">

		<div class="card">

			<div class="card-header">
				<h1>Welcome To Shipment Type Register Page</h1>
			</div>
			<div class="card-body">
				<form:form action="save" method="POST" modelAttribute="shipmentType">

					<div class="row">
						<div class="col-4"><label for="shipmentMode" class="control-label">SHIPMENT-MODE</label></div>
						<div class="col-4">
								<form:select path="shipmentMode" class="form-control">
								<form:option value="">SELECT</form:option>
								<form:option value="AIR">AIR</form:option>
								<form:option value="TRUCK">TRUCK</form:option>
								<form:option value="SHIP">SHIP</form:option>
								<form:option value="TRAIN">TRAIN</form:option>
							    </form:select>
						<div class="col-4"><form:errors path="shipmentMode" cssClass="text-danger" /></div>
						</div>
					</div>
			
					<div class="row">
						<div class="col-4"><label for="shipmentCode" class="control-label">SHIPMENT-CODE</label></div>
						<div class="col-4">
						<form:input path="shipmentCode" class="form-control" />
						</div>
						<div class="col-4">
						<form:errors path="shipmentCode" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="enableShipment" class="control-label">ENABLE-SHIPMENT</label>
						</div>
						<div class="col-4">
							<form:select path="enableShipment" class="form-control">
							<form:option value="">SELECT</form:option>
							<form:option value="YES">Yes</form:option>
							<form:option value="NO">No</form:option>
							</form:select>
						</div>
						<div class="col-4">
						<form:errors path="enableShipment" cssClass="text-danger"  />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="shipmentGrade" class="control-label">SHIPMENT-GRADE</label>
						</div>
						<div class="col-4">
						<form:radiobutton path="shipmentGrade" value="A" />A 
						<form:radiobutton path="shipmentGrade" value="B" />B
						<form:radiobutton path="shipmentGrade" value="C" />C
						</div>
						<div class="col-4">
	      				<form:errors path="shipmentGrade" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="note" class="control-label">DESCRIPTION</label>
						</div>
						<div class="col-4">
						<form:textarea path="note"  class="form-control"/>
						</div>
						<div class="col-4">
						<form:errors path="note" cssClass="text-danger" />
						</div>
					</div>
				
				<div class="row">
					<div class="col-3">
					<input type="submit" value="Register"  class="btn btn-success"/>
					</div>
				</div>
 		</form:form>
			</div>
			<c:if test="${msg ne null }">
				<div class="card-footer bg-info text-white">${msg}</div>
			</c:if>
			
		</div>
	</div>
</body>
</html>