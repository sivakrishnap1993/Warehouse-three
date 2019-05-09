<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase</title>
<style type="text/css">
.err {
	color: green;
}
</style>
</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>Welcome To Purchase Show Page</h2>
			</div>
			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="purchase">
					<div class="row">
						<div class="col-3">
							<label for="ordCode" class="control-label">ORDER-CODE</label>
						</div>
						<div class="col-5">
							<form:input path="ordCode" cssClass="form-control" />
						</div>
						<div class="col-4">
							<form:errors path="ordCode" cssClass="text-danger" />
						</div>
					</div>

					<div class="row">
						<div class="col-3">
							<label for="shipMode" class="control-label">SHIPMENT-MODE</label>
						</div>
						<div class="col-5">
							<form:select path="shipMode">
								<form:option value="">SELECT</form:option>
								<form:option value="SHIP">SHIP</form:option>
								<form:option value="TRAIN">TRAIN</form:option>
								<form:option value="TRUCK">TRUCK</form:option>
								<form:option value="SHIP">SHIP</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<form:errors path="shipMode" cssClass="text-danger" />
						</div>
					</div>

					<div class="row">
						<div class="col-3">
							<label for="ship.shipmentId" class="control-label">SHIPMENT-CODE</label>
						</div>
						<div class="col-5">
							<form:select path="ship.shipmentId">
								<form:option value="">SELECT</form:option>
								<form:options items="${ships}" itemLabel="shipmentCode"
									itemValue="shipmentId" />
							</form:select>
						</div>
					</div>

					<div class="row">
						<div class="col-3">
							<label for="venwhuser.urdId" class="control-label">VENDOR</label>
						</div>
						<div class="col-5">
							<form:select path="venwhuser.urdId">
								<form:option value="">SELECT</form:option>
								<form:options items="${whusers}" itemLabel="usrCode"
									itemValue="urdId" />
							</form:select>
						</div>
					</div>

					<div class="row">
						<div class="col-3">
							<label for="refNo" class="control-label">REFERENCE-NUMBER</label>
						</div>
						<div class="col-5">
							<form:input path="refNo" cssClass="form-control" />
						</div>
						<div class="col-4">
							<form:errors path="refNo" cssClass="text-danger" />
						</div>
					</div>

					<div class="row">
						<div class="col-3">
							<label for="qtyCk" class="control-label">QUALITY-CHECK</label>
						</div>
						<div class="col-5">
							<form:radiobutton path="qtyCk" value="REQUIRED" />
							Required
							<form:radiobutton path="qtyCk" value="NOTREQUIRED" />
							NotRequired
						</div>
						<div class="col-4">
							<form:errors path="qtyCk" cssClass="text-danger" />
						</div>
					</div>

					<div class="row">
						<div class="col-3">
							<label for="ordSts" class="control-label">DEFAULT-STATUS</label>
						</div>
						<div class="col-5">
							<form:input path="ordSts" cssClass="form-control" />
						</div>
						<div class="col-4">
							<form:errors path="ordSts" cssClass="text-danger" />
						</div>
					</div>

					<div class="row">
						<div class="col-3">
							<label for="node" class="control-label">DESCRIPTION</label>
						</div>
						<div class="col-5">
							<form:textarea path="node" cssClass="form-class" />
						</div>
						<div class="col-4">
							<form:errors path="node" cssClass="text-danger" />
						</div>
					</div>

					<div class="row">
						<div class="col-4">
							<input type="submit" value="Place Order"
								class="btn btn-success text-danger" />
						</div>
					</div>
				</form:form>
			</div>
			<c:if test="${msg ne null}">
				<div class="card-footer">
					<b>${msg}</b>
				</div>
			</c:if>
		</div>
	</div>


</body>
</html>