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
				<h2>Welcome To Where House User Page</h2>
			</div>
			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="whUserType">
					<div class="row">
						<div class="col-3">
							<label for="userOneType" class="control-label">USER-TYPE</label>
						</div>
						<div class="col-5">
							<form:radiobutton path="userOneType" value="VENDOR" />
							Vendor
							<form:radiobutton path="userOneType" value="CUSTOMER" />
							Customer
						</div>
						<div class="col-4">
							<form:errors path="userOneType" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="" class="control-label">USER CODE</label>
						</div>
						<div class="col-5">
							<form:input path="usrCode" cssClass="form-control" />
						</div>
						<div class="col-4">
							<form:errors path="usrCode" cssClass="text-danger" />
							<br>
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="" class="control-label">USER FOR</label>
						</div>
						<div class="col-5">
							<form:select path="usrFor">
								<form:option value="">SELECT</form:option>
								<form:option value="PURCHASE">Purchase</form:option>
								<form:option value="SALE">Sale</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<form:errors path="usrFor" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="" class="control-label">USER EMAIL</label>
						</div>
						<div class="col-5">
							<form:input path="usrEmail" cssClass="form-control" />
						</div>
						<div class="col-4">
							<form:errors path="usrEmail" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="" class="control-label">USER CONTACT</label>
						</div>
						<div class="col-5">
							<form:input path="usrContact" cssClass="form-control" />
						</div>
						<div class="col-4">
							<form:errors path="usrContact" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="" class="control-label">USERID-TYPE</label>
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
						<div class="col-4">
							<form:errors path="userType" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="" class="control-label">USER NUMBER</label>
						</div>
						<div class="col-5">
							<form:input path="usrNum" cssClass="form-control" />
						</div>
						<div class="col-4">
							<form:errors path="usrNum" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-5">
							<input type="submit" value="Create User" class="btn btn-success">
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