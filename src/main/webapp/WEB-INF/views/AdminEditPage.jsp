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
				<h2>Welcome To Edit Page</h2>
			</div>
			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="admin">
					<div class="row">
						<div class="col-4">
							<label for="admId" class="control-label">ADMIN-ID</label>
						</div>
						<div class="col-6">
							<form:input path="admId" readonly="true" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="" class="control-label">NAME</label>
						</div>
						<div class="col-6">
							<form:input path="admName" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="admType" class="control-label">ADMIN-TYPE</label>
						</div>
						<div class="col-6">
							<form:radiobutton path="admType" value="REGULAR" />
							REGULAR
							<form:radiobutton path="admType" value="IRR-REGULAR" />
							IRR-REGULAR
							<form:radiobutton path="admType" value="CONTRACT" />
							CONTRACT
							<form:radiobutton path="admType" value="PERMINENT" />
							PERMINENT
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="admSalary" class="control-label">SALARY</label>
						</div>
						<div class="col-6">
							<form:input path="admSalary" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="dept" class="control-label">DEPT</label>
						</div>
						<div class="col-6">
							<form:select path="dept">
								<form:option value="">SELECT</form:option>
								<form:option value="DEV">DEV</form:option>
								<form:option value="QA">QA</form:option>
								<form:option value="MS">MS</form:option>
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="admModes" class="control-label">MODES</label>
						</div>
						<div class="col-6">
							<form:checkbox path="admModes" value="ACCEPT" />
							Accpet
							<form:checkbox path="admModes" value="GRANT" />
							Grant
							<form:checkbox path="admModes" value="INTAKE" />
							Intake
						</div>
					</div>

					<div class="card-footer">
						<input type="submit" value="update" class="text-danger" />
					</div>

				</form:form>
			</div>
		</div>
	</div>
</body>
</html>