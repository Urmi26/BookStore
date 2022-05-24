<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.narola.bookstore.utility.Constant"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	width: 100%;
	position: relative;
	display: flex;
}

#header1 {
	width: calc(100% - 300px);
	margin-left: 300px;
}

#interface1 {
	width: calc(100% - 450px);
	margin-left: 450px;
	position: relative;
	padding: 50px 0;
}

#footer {
	width: calc(100% - 5px);
}
</style>
<meta charset="ISO-8859-1">
<title>Master Book Format Form</title>
</head>
<body bgcolor="#DCDCDC">
	<jsp:include page="LeftBar.jsp" />

	<section id="header1">
		<jsp:include page="Header.jsp" />

	</section>
	<section id="interface1">
		<form action="<%=request.getContextPath()%>/AddMSBook" method="post">
			<table border="1">
				<caption>
					<td colspan=6 align="center" height="30"><font size="5"><b>Master
								Book</b></font></td>
					<%
					if (request.getAttribute("errorMsgOfMsBookId") == null) {
					%>

					<%
					} else {
					%>
					<td><font color="red"><b><%=request.getAttribute("errorMsgOfMsBookId")%></b></font></td>
					<%
					}
					%>
				</caption>
				<tr>
					<td><b>Master Book Name </b></td>
					<td><input type="text" name="msBookName" size="45" /></td>
					<%
					if (request.getAttribute("errorMsgOfMsBookName") == null) {
					%>

					<%
					} else {
					%>
					<td><font color="red"><b><%=request.getAttribute("errorMsgOfMsBookName")%></b></font></td>
					<%
					}
					%>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="submit" value="Submit" /> <a
						href="<%=request.getContextPath()%>/DisplayMSBooks"><input
							type="button" name="cancle" value="Cancel" /></a></td>

				</tr>
			</table>
			<div>
				<%
				if (request.getAttribute("ErrorMessage") == null) {
				%>
				<%
				} else {
				%>
				<p>
					<font color="red"><b><%=request.getAttribute("ErrorMessage")%></b></font>
				</p>
				<%
				}
				%>
			</div>
		</form>
	</section>
	<section id="footer">
		<jsp:include page="Footer.jsp" />
	</section>
</body>
</html>