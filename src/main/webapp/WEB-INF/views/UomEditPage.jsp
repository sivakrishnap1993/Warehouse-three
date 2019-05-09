<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<%@include file="UomMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>Welcome To Edit Page</h2>
			</div>
			<div class="card-body">
				<form:form action="update" method="POST" modelAttribute="uom">

					<div class="row">
						<div class="col-3">
							<label for="" class="control-label">uomId</label>
						</div>
						<div class="col-5">
							<form:input path="uomId" readonly="true" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="uonType" class="control-label">UOM-TYPE</label>
						</div>
						<div class="col-5">
							<form:select path="uonType">
								<form:option value="">SELECT</form:option>
								<form:option value="PACK">Pack</form:option>
								<form:option value="NOPACK">NoPack</form:option>
								<form:option value="NA">NA</form:option>
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="uomCode" class="control-label">UOM-CODE</label>
						</div>
						<div class="col-5">
							<form:input path="uomCode" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="" class="control-label">ENABLED</label>
						</div>
						<div class="col-5">
							<form:radiobutton path="uomEnable" value="YES" />
							Yes
							<form:radiobutton path="uomEnable" value="NO" />
							No
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="" class="control-label">META-CODE</label>
						</div>
						<div class="col-5">
							<form:input path="metaCode" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="" class="control-label">ADJUST-SIZE</label>
						</div>
						<div class="col-5">
							<form:radiobutton path="adjst" value="L" />
							L
							<form:radiobutton path="adjst" value="M" />
							M
							<form:radiobutton path="adjst" value="R" />
							R
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<label for="" class="control-label">NOTE</label>
						</div>
						<div class="col-5">
							<form:textarea path="note" />
						</div>
					</div>
					<div class="row">
						<div class="col-3">
							<input type="submit" value="update"  class="text-danger"/>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>