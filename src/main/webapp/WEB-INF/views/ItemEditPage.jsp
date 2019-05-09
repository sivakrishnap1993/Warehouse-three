<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>Welcome To Item Register Page</h2>
			</div>
			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="item">

					<div class="row">
						<div class="col-3">
							<label for="itemId" class="control-label">ITEM-ID</label>
						</div>
						<div class="col-5">
							<form:input path="itemId" readonly="true" cssClass="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="itmCode" class="control-label">ITEM-CODE</label>
						</div>
						<div class="col-5">
							<form:input path="itmCode" cssClass="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="itmWidth" class="control-label">ITEM-DIMENTTIONS</label>
							<label for="itemHeight" class="control-label">ITEM-DIMENTTIONS</label>
							<label for="itemLength" class="control-label">ITEM-DIMENTTIONS</label>
						</div>
						<div class="col-5">
							W:
							<form:input path="itmWidth" cssClass="form-control" />
							L:
							<form:input path="itemHeight" cssClass="form-control" />
							H:
							<form:input path="itemLength" cssClass="form-control" />
						</div>
					</div>

					<div class="row">
						<div class="col-3">
							<label for="uom.uomId" class="control-form">UOM</label>
						</div>
						<div class="col-5">
							<form:select path="uom.uomId">
								<form:option value="">SELECT</form:option>
								<form:options items="${uoms}" itemLabel="uomEnable"
									itemValue="uomId" cssClass="form-control" />
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="om.ordMId" class="control-label">ORDER-METHOD</label>
						</div>
						<div class="col-5">
							<form:select path="om.ordMId">
								<form:option value="">SELECT</form:option>
								<form:options items="${orms}" itemLabel="ordMode"
									itemValue="ordMId" cssClass="form-control" />
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="wuven.urdId" class="control-label">VENDOR</label>
						</div>
						<div class="col-5">
							<form:select path="wuven.urdId">
								<form:option value="">SELECT</form:option>
								<form:options items="${vens}" itemLabel="usrCode"
									itemValue="urdId" />
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="wucust.urdId" class="control-label">CUSTOMER</label>
						</div>
						<div class="col-5">
							<form:select path="wucust.urdId">
								<form:option value="">SELECT</form:option>
								<form:options items="${custs}" itemLabel="usrCode"
									itemValue="urdId" />
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="baseCost" class="control-label">BASE-COST</label>
						</div>
						<div class="col-5">
							<form:input path="baseCost" cssClass="form-control" />
						</div>
					</div>

					<div class="row">
						<div class="col-3">
							<label for="baseCurrency" class="control-label">BASE-CURRENCY</label>
						</div>
						<div class="col-5">
							<form:select path="baseCurrency" cssClass="text-danger">
								<form:option value="">SELECT</form:option>
								<form:option value="INR">INR</form:option>
								<form:option value="UID">UID</form:option>
								<form:option value="AUS">AUS</form:option>
								<form:option value="ERU">ERU</form:option>
								<form:option value="FOUND">FOUND</form:option>
							</form:select>
						</div>
					</div>

					<div class="row">
						<div class="col-3">
							<label for="note" class="control-label">NOTE</label>
						</div>
						<div class="col-5">
							<form:input path="note" cssClass="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<input type="submit" value="UPDATE" class="btn btn-success">
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>

