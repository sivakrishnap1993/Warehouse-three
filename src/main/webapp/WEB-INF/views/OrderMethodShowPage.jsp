<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OrderMethod</title>
<style type="text/css">
.err {
	color: maroon;
}
</style>
</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>OrderMethod Creation Page</h2>
			</div>
			<div class="card-body">
				<form:form action="save" method="post" modelAttribute="orderMethod">

					<div class="row">
						<div class="col-3">
							<label for="ordMode" class="control-label">ORDER-MODE</label>
						</div>
						<div class="col-5">
							<form:radiobutton path="ordMode" value="SALE" />
							Sale
							<form:radiobutton path="ordMode" value="PURCHASE" />
							Purchase
						</div>
						<div class="col-4">
							<form:errors path="ordMode" cssClass="text-danger" />
						</div>
					</div>
					<div class=row>
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
					<div class=row>
						<div class="col-3">
							<label for="ordExType" class="control-label">EXECUTIVE-TYPE</label>
						</div>
						<div class="col-5">
							<form:select path="ordExType">
								<form:option value="">SELECT</form:option>
								<form:option value="FIFO">FIFO</form:option>
								<form:option value="LIFO">LIFO</form:option>
								<form:option value="FCFO">FCFO</form:option>
								<form:option value="FEFO">FEFO</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<form:errors path="ordExType" cssClass="text-danger" />
						</div>
					</div>
					<div class=row>
						<div class="col-3">
							<label for="ordAccept" class="control-label">ORDER-ACCEPT</label>
						</div>
						<div class="col-5">
							<form:checkbox path="ordAccept" value="MULTI MODEL" />
							MULTI MODEL
							<form:checkbox path="ordAccept" value="ACCEPT RETURN" />
							ACCEPT RETURN
							<form:checkbox path="ordAccept" value="SERVICE EXTEND" />
							SERVICE EXTEND
						</div>
						<div class="col-4">
							<form:errors path="ordAccept" cssClass="text-danger" />
						</div>
					</div>
					<div class=row>
						<div class="col-3">
							<label for="note" class="control-label">DESCRIPTION</label>
						</div>
						<div class="col-5">
							<form:input path="note" cssClass="form-control" />
						</div>
						<div class="col-4">
							<form:errors path="note" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-5">
							<input type="submit" value="Create Order Method"
								class="btn btn-success">
						</div>
					</div>
				</form:form>
			</div>
			<c:if test="${clg ne null}">
					<div class="card-footer">
						<b>${clg}</b>
					</div>
				</c:if>
		</div>
	</div>
</body>
</html>