<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/ForgotPassword" method="post"
			enctype="multipart/form-data">
<table>
	<caption>Forgot Password</caption>
<tr>
	<td><input type="email" type="password" name="email" name="password" placeholder="Mobile No/E-mail"/>
</tr>
<tr>
	<td><input type="submit" name="continue" value="continue"/>
</tr>
</table>
</form>
</body>
</html>