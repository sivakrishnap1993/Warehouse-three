<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="ShipmentTypeMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header">
				<h2>WELCOME TO VIEWONE PAGE</h2>
			</div>
			<div class="card-body">
				<table class="table table-striped table-bordered">
					<tr class="table-info table-success">
						<td>ID</td>
						<th>${st.itemId}</th>
					</tr>
					<tr>
						<th>CODE</th>
						<td>${st.itmCode}</td>
					</tr>
					<tr>
						<th>WIDTH</th>
						<td>${st.itmWidth}</td>
					</tr>
					<tr>
						<th>HEIGHT</th>
						<td>${st.itemHeight}</td>
					</tr>
					<tr>
						<th>LENGTH</th>
						<td>${st.itemLength}</td>
					</tr>
					<tr>
						<th>COST</th>
						<td>${st.baseCost}</td>
					</tr>
					<tr>
						<th>CURRENCY</th>
						<td>${st.baseCurrency}</td>
					</tr>
					<tr>
						<th>UOM</th>
						<td>${st.uom.uomId}</td>
					</tr>
					<tr>
						<th>ORDER-METHOD</th>
						<td>${st.om.ordMId}</td>
					</tr>
					<tr>
					<th>VENDOR</th>
					<th>${st.wuven.urdId}</th>
					</tr>
					<tr>
					<th>CUSTOMER</th>
					<th>${st.wucust.urdId}</th>
					</tr>
					
					<tr>
						<th>NOTE</th>
						<td>${st.note}</td>
					</tr>

				</table>

			</div>


		</div>

	</div>
</body>
</html>