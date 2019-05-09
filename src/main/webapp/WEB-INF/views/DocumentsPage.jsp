<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome To Documents Page</h2>
	<form action="upload" method="post" enctype="multipart/form-data">
		<pre>
				
FILE : <input type="file" name="fob" />

	<input type="submit" value="Upload" />

</pre>
	</form>
	<table border="1">
		<tr>
			<th>File Name</th>
			<th>Download Link</th>
		</tr>
		<c:forEach items="${list}" var="ob">
			<tr>
				<td><c:out value="${ob[1]}" /></td>
				<td><a href="download?fileId=${ob[0]}">DOWNLOAD</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>