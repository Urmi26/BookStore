<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
	align-items: center;
	margin-left: 600px;
	margin-top: 150px;
	width: 250px;
	height: 250px;
	color: black;
	background-color: powderblue;
}
</style>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body bgcolor="gainsboro">
	<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
		<table>
			<caption><b>Log in</b></caption>
			<tr>
				<td><input type="email" name="email" size="45"
					placeholder="Email Id" /></td>
					<%
						if (request.getAttribute("errorMsgOfEmailId") == null) {
						%>
						<%
						} else {
						%>
						<td><font color="red"><b><%=request.getAttribute("errorMsgOfEmailId")%></b></font></td>
						<%
						}
						%>
			</tr>
			<tr>
				<td><input type="password" name="password" size="45"
					placeholder="Password" />
					<%
						if (request.getAttribute("errorMsgOfPassword") == null) {
						%>
						<%
						} else {
						%>
						<td><font color="red"><b><%=request.getAttribute("errorMsgOfPassword")%></b></font></td>
						<%
						}
						%>
			</tr>
			<%
			if (request.getAttribute("errorMsgOfData") == null) {
				%>
				<%
				} else {
				%>
				<tr>
				<td>
				<font color="tomato"><b><%=request.getAttribute("errorMsgOfData")%></b></font>
				</td>
				</tr>
				<%
				}
			%>
			<tr>
				<td align="right"><a href="Sign_up.jsp"><label>Forgot your Password?</label></a></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" name="login" value="Submit"/>
			</tr>
			<tr>
				<td align="center"><a href="Sign_up.jsp">New User?Sign in</a></td>
			</tr>
		</table>
	</form>
</body>
</html>