<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<%@include file="HomeMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">
				<h2>Wlecome To User Register Page</h2>
			</div>
			<div class="card-body">

				<form:form action="insert" method="post" modelAttribute="user">

					<div class="row">
					<div class="col-3"></div>
						<div class="col-2">
							<label for="usrName">Name</label>
						</div>
						<div class="col-3">
							<form:input path="usrName"  cssClass="form-control"/>
						</div>
					</div>
					
					<div class="row">
						<div class="col-5"></div>
						<div class="col-6">
							<form:errors path="usrName" cssClass="text-danger" />
						</div>
					</div>
					
					
					<div class="row">
					<div class="col-3"></div>
						<div class="col-2">
							<label for="gender">Gender</label>
						</div>
						<div class="col-3">
							<form:radiobutton path="gender" value="MALE" />
							Male
							<form:radiobutton path="gender" value="FEMALE" />
							Female
							
						</div>
					</div>
					
					<div class="row">
						<div class="col-5"></div>
						<div class="col-6">
							<form:errors path="gender" cssClass="text-danger" />
						</div>
					</div>
					
					
					<div class="row">
					<div class="col-3"></div>
						<div class="col-2">
							<label for="usrMail">Email</label>
						</div>
						<div class="col-3">
							<form:input path="usrMail" cssClass="form-control"/>
						</div>
					</div>
					
					<div class="row">
						<div class="col-5"></div>
						<div class="col-6">
							<form:errors path="usrMail" cssClass="text-danger" />
						</div>
					</div>
					
					
					<div class="row">
					<div class="col-3"></div>
						<div class="col-2">
							<label for="userMobile">Mobile Number</label>
						</div>
						<div class="col-3">
							<form:input path="userMobile" cssClass="form-control"/>
						</div>
					</div>
					
					<div class="row">
						<div class="col-5"></div>
						<div class="col-6">
							<form:errors path="userMobile" cssClass="text-danger" />
						</div>
					</div>
					
					
					<div class="row">
					<div class="col-3"></div>
						<div class="col-2">
							<label for="usrPwd">Password</label>
						</div>
						<div class="col-3">
							<form:password path="usrPwd" cssClass="form-control"/>
						</div>
					</div>
					
					<div class="row">
						<div class="col-5"></div>
						<div class="col-6">
							<form:errors path="usrPwd" cssClass="text-danger" />
						</div>
					</div>
					
					
					<div class="row">
					<div class="col-3"></div>
						<div class="col-2">
							<label for="usrRoles">Roles</label>
						</div>
						<div class="col-3">
							<form:checkbox path="usrRoles" value="ADMIN" />
							Admin
							<form:checkbox path="usrRoles" value="APP USER" />
							App User
						</div>
					</div>
					
					<div class="row">
						<div class="col-5"></div>
						<div class="col-6">
							<form:errors path="usrRoles" cssClass="text-danger" />
						</div>
					</div>
					
					<br>
					<br>
					<div class="row">
					<div class="col-5"></div>
						<div class="col-3">
							<input type="submit" value="Register" class="btn btn-primary" />
						</div>
					</div>
				</form:form>
			</div>
			
			<c:if test="${message !=null}">
				<div class="card-footer">${message}</div>
			</c:if>
		</div>
	</div>
	<br>
</body>
</html>