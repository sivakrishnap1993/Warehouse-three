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
			<div class="card-header bg-success text-white ">
				<h2>Welcome To Show Page</h2>
			</div>
			<div class="card-body bg-info ">
				<form:form action="save" method="POST" modelAttribute="uom">

					<div class="row">
						<div class="col-3">
							<label for="uonType" class="control-label">UOM-TYPE</label>
						</div>
						<div class="col-5">
							<form:select path="uonType" class="form-container">
								<form:option value="">SELECT</form:option>
								<form:option value="PACK">Pack</form:option>
								<form:option value="NOPACK">Nopack</form:option>
								<form:option value="NA">Na</form:option>
							</form:select>
						</div>
						<div class="col-3">
							<form:errors path="uonType" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="uomCode" class="control-label">UOM-CODE</label>
						</div>
						<div class="col-5">
							<form:input path="uomCode" class="form-control" />
						</div>
						<div class="col-3">
							<form:errors path="uomCode" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="" class="control-label">ENABLED</label>
						</div>
						<div class="col-5"><form:radiobutton path="uomEnable" value="YES" />Yes
										   <form:radiobutton path="uomEnable" value="NO" />No
						</div>
						<div class="col-3">
							<form:errors path="uomEnable" cssClass="text-danger" />
							<br>
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="" class="control-label">META-CODE</label>
						</div>
						<div class="col-5">
							<form:input path="metaCode" class="form-control" />
						</div>
						<div class="col-3">
							<form:errors path="metaCode" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="" class="control-label">ADJUST-SIZE</label>
						</div>
						<div class="col-5 ">
							<form:radiobutton path="adjst" value="L" />L
							<form:radiobutton path="adjst" value="M" />M
							<form:radiobutton path="adjst" value="R" />R
						</div>
						<div class="col-3">
							<form:errors path="adjst" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="" class="control-label">NOTE</label>
						</div>
						<div class="col-5">
							<form:textarea path="note" class="form-control" />
						</div>
						<div class="col-3">
							<form:errors path="note" cssClass="text-danger" />

						</div>

						<div class="col-4">
							<input type="submit" value="submit" class="text-danger">

						</div>
					</div>
				</form:form>
			</div>
			<c:if test="${message ne null }">
				<div class="card-footer bg-info text-white">${message}</div>
			</c:if>
		</div>
	</div>
</body>
</html>