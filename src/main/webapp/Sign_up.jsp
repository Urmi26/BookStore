<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.narola.bookstore.user.User"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
	align-items: center;
	margin-left: 600px;
	margin-top: 150px;
	height: 100px;
	color: black;
	background-color: gainsboro;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="whitesmoke">
	<%
	String click = (String) request.getAttribute("No");
	%>
	<%
	System.out.print(click);
	if (click == null || click.matches("1")) {
	%>
	<form action="<%=request.getContextPath()%>/UserSignUpServlet"
		method="post">
		<table>
			<tr>
				<td colspan="2"><b>Sign Up</b></td>
			</tr>
			<tr>
				<td>Email Id <font color="red">*</font></td>
				<td>
				<input type="email" name="emailId" size="25"
					placeholder="Email Id" />
				</td>
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
				<td align="center" colspan="2"><input type="submit"
					name="Continue" value="Submit" />
			</tr>
		</table>
	</form>
	<%
	} else if (click.matches("12")) {
	%>
	<form action="<%=request.getContextPath()%>/CheckOtpServlet"
		method="post">
		<table>
			<tr>
				<td colspan="2"><b>Check OTP</b></td>
			</tr>
			<tr>
				<td><input type="hidden" name="email"
					value="<%=request.getAttribute("emailId")%>" /></td>
				<%
				System.out.print(request.getAttribute("emailId"));
				%>
				<td>Enter OTP <font color="red">*</font></td>
				<td><input type="text" name="otp" size="25" /></td>
				<%
				if (request.getAttribute("errorMsgOfOtp") == null) {
				%>
				<%
				} else {
				%>
				<td><font color="red"><b><%=request.getAttribute("errorMsgOfOtp")%></b></font></td>
				<%
				}
				%>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit"
					name="Continue" value="Submit" />
			</tr>
		</table>
	</form>
	<%
	} else if (click.matches("123")) {
	%>
	<form action="<%=request.getContextPath()%>/CheckOtpServlet"
		method="post">
		<table>
			<tr>
				<td colspan="2"><b>Password Details</b></td>
			</tr>
			<tr>
				<td><input type="hidden" name="userId"
					value="<%=request.getAttribute("userId")%>" /></td>
				<td>Enter Password <font color="red">*</font></td>
				<td><input type="text" name="password" size="25" /></td>
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
			<tr>
				<td align="center" colspan="2"><input type="submit"
					name="Continue" value="Submit" />
			</tr>
		</table>
	</form>
	<%
	}
	%>
</body>
</html>