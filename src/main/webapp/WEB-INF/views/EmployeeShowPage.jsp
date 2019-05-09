<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
<style type="text/css">
.eone {
	color: green;
}
</style>
</head>
<body>
<%@include file="ShipmentTypeMenu.jsp"%>
	<h2>Welcome To Employee Show Page</h2>
	<form:form action="save" method="POST" modelAttribute="employee">
		<pre>

Employee Name    : <form:input path="empName" /> 
				
				<form:errors path="empName" cssClass="eone" />	<br>

COMPANY LOCATION : <form:radiobutton path="cmpLoc" value="HYDERABAD" />HYDERABAD
		   <form:radiobutton path="cmpLoc" value="BENGULLOR" />BENGULLOR
		   <form:radiobutton path="cmpLoc" value="CHENNIE" />CHENNIE
		   <form:radiobutton path="cmpLoc" value="KOLKATHA" />KOLKATHA
		   <form:radiobutton path="cmpLoc" value="MUMBAI" />MUMBAI
			<form:errors path="cmpLoc" cssClass="eone" />	<br>

Employee Password: <form:password path="empPwd" />
				<form:errors path="empPwd" cssClass="eone" />	<br>

Employee Gender  : <form:radiobutton path="empGen" value="MALE" />MALE  <form:radiobutton
				path="empGen" value="FEMALE" />FEMALE 
			<form:errors path="empGen" cssClass="eone" />	<br>

Employee Address: <form:textarea path="empAddr" />
			<form:errors path="empAddr" cssClass="eone" />	<br>
			<br>

				<input type="submit" value="Submit Employee Data" />
</pre>
	</form:form>
	${one}
	<br>
	<a href="all">VIEW ALL</a>
</body>
</html>