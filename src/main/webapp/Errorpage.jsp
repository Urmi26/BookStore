<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.narola.bookstore.utility.Constant"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="height: 100%; width: 100%;">
		<div>
			<%
			if (request.getAttribute(Constant.ERROR) == null) {
			%>
			<%
			} else {
			%>
			<p>
				<h1><font color="red"><b><%=request.getAttribute(Constant.ERROR)%></b></font></h1>
			</p>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>