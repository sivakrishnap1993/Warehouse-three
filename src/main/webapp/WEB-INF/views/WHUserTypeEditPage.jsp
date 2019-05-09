<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.readMode {
	background-color: maroon;
}
</style>
</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>

	<div class="container">
		<div class="card">
			<div class="card-header bg-success">
				<h2>Welcome To Where House Edit Page</h2>
			</div>
			<div class="card-body bg-info">
				<form:form action="update" method="post" modelAttribute="whUserType">
					<div class="row">
						<div class="col-3">
							<label for="urdId" class="control-label">USER-ID</label>
						</div>
						<div class="col-5">
							<form:input path="urdId" readonly="true" cssClass="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="userOneType" class="control-label">USER TYPE</label>
						</div>
						<div class="col-5">
							<form:radiobutton path="userOneType" value="VENDOR" />Vendor
							<form:radiobutton path="userOneType" value="CUSTOMER"/>Customer
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="usrCode" class="control-label">USER-CODE</label>
						</div>
						<div class="col-5">
							<form:input path="usrCode" cssClass="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="usrFor" class="control-label">USER-FOR </label>
						</div>
						<div class="col-5">
							<form:select path="usrFor">
								<form:option value="">SELECT</form:option>
								<form:option value="PURCHASE">Purchase</form:option>
								<form:option value="SALE">Sale</form:option>
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="usrEmail" class="control-label">USER-EMAIL</label>
						</div>
						<div class="col-5">
							<form:input path="usrEmail" cssClass="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="usrContact" class="control-label">USER-CONTACT</label>
						</div>
						<div class="col-5">
							<form:input path="usrContact" cssClass="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="userType" class="control-label">USERID-TYPE</label>
						</div>
						<div class="col-5">
							<form:select path="userType">
								<form:option value="">SELECT</form:option>
								<form:option value="PANCARD">Pancard</form:option>
								<form:option value="AADHAR">Aadhar</form:option>
								<form:option value="VOTERID">VoterId</form:option>
								<form:option value="OTHER">Other</form:option>
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="usrNum" class="control-label">USER-NUMBER</label>
						</div>
						<div class="col-5">
							<form:input path="usrNum" cssClass="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-5">
							<input type="submit" value="update" class="btn btn-success">
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>