<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>
	<div class="container">

		<div class="card">
			<div class="card-header bg-info">
				<h2>Welcome To Admin Page</h2>
			</div>
			<div class="card-body bg-light">
				<form:form action="save" method="POST" modelAttribute="admin">

					<div class="row">
						<div class="col-4">
							<label for="admName" class="control-form">NAME</label>
						</div>
						<div class="col-4">
							<form:input path="admName" class="form-control" />
						</div>
						<div class="col-4">
							<form:errors path="admName" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="admType" class="control-form">ADMIN-TYPE</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="admType" value="REGULAR" />REGULAR
							<form:radiobutton path="admType" value="IRR-REGULAR" />IRR-REGULAR
							<form:radiobutton path="admType" value="CONTRACT" />CONTRACT
							<form:radiobutton path="admType" value="PERMINENT" />PERMINENT
						</div>
						<div class="col-4">
							<form:errors path="admType" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="admSalary" class="control-form">SALARY</label>
						</div>
						<div class="col-4">
							<form:input path="admSalary" class="form-control" />
						</div>
						<div class="col-4">
							<form:errors path="admSalary" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="dept" class="control-form">DEPT</label>
						</div>
						<div class="col-4">
							<form:select path="dept">
								<form:option value="">SELECT</form:option>
								<form:option value="DEV">DEV</form:option>
								<form:option value="QA">QA</form:option>
								<form:option value="MS">MS</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<form:errors path="dept" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="admModes" class="control-form">MODES</label>
						</div>
						<div class="col-4">
							<form:checkbox path="admModes" value="ACCEPT" />
							Accept
							<form:checkbox path="admModes" value="GRANT" />
							Grant
							<form:checkbox path="admModes" value="INTAKE" />
							Intake
							<form:errors path="admModes" cssClass="text-danger" />
						</div>
						<div class="col-4"></div>
					</div>
					<div class="card-footer">
						<input type="submit" value="Register" class="btn btn-success" />
					</div>
				</form:form>
			</div>

			<c:if test="${map ne null }">
				<div class="card-footer bg-info text-white">${map}</div>
			</c:if>
		</div>
	</div>
</body>
</html>