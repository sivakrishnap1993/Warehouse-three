<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
<style type="text/css">
.readMode {
	background-color: fuchsia;
}
</style>
</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>Welcome To Employee Show Page</h2>
			</div>
			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="employee">

					<div class="row">
						<div class="col-3">
							<label for="empId" class="control-lable">EMPLOYEE-ID</label>
						</div>
						<div class="col-5">
							<form:input path="empId" readonly="true" cssClass="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="empName" class="control-lable">EMPLOYEE NAME</label>
						</div>
						<div class="col-5">
							<form:input path="empName" cssClass="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="cmpLoc" class="control-lable">COMPANY LOCATION</label>
						</div>
						<div class="col-5">
							<form:radiobutton path="cmpLoc" value="HYDERABAD" />
							HYDERABAD
							<form:radiobutton path="cmpLoc" value="BENGULLOR" />
							BENGULLOR
							<form:radiobutton path="cmpLoc" value="CHENNIE" />
							CHENNIE
							<form:radiobutton path="cmpLoc" value="KOLKATHA" />
							KOLKATHA
							<form:radiobutton path="cmpLoc" value="MUMBAI" />
							MUMBAI <br>
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="empPwd" class="control-lable">EMPLOYEE
								PASSWORD</label>
						</div>
						<div class="col-5">
							<form:password path="empPwd" cssClass="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="empGen" class="control-lable">EMPLOYEE GENDER</label>
						</div>
						<div class="col-5">
							<form:radiobutton path="empGen" value="MALE" />
							MALE
							<form:radiobutton path="empGen" value="FEMALE" />
							FEMALE
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="empAddr" class="control-lable">EMPLOYEE
								ADDRESS</label>
						</div>
						<div class="col-5">
							<form:textarea path="empAddr" cssClass="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<input type="submit" value="update" class="form-control" />
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>