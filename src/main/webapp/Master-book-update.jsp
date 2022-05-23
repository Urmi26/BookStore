<%@page
	import="com.narola.bookstore.msbookformat.model.MasterBookFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

#footer1 {
	width: calc(100% - 5px);
}
</style>
<meta charset="ISO-8859-1">
<title>Master Book Format Update</title>
</head>
<body bgcolor="#DCDCDC">
	<jsp:include page="LeftBar.jsp" />

	<section id="header1">
		<jsp:include page="Header.jsp" />

	</section>
	<section id="interface1">
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
		<form action="<%=request.getContextPath()%>/UpdateMSBook"
			method="post">
			<table border="1" cellpadding="3">
				<caption>
					<td colspan=6 align="center" height="30"><font size="5"><b>Update
								Master Book Data</b></font></td>
				</caption>
				<%
				MasterBookFormat masterBookFormat = (MasterBookFormat) request.getAttribute("MasterBook");
				%>
				<tr>
					<td>MasterBook ID :</td>
					<td><input type="hidden" name="msBookId"
						value="<%=masterBookFormat.getMsBookId()%>" size="45" /> <%=masterBookFormat.getMsBookId()%></td>
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

				</tr>
				<tr>
					<td>Master Book Name :</td>
					<td><input type="text" name="msBookName"
						value="<%=masterBookFormat.getMsBookName() == null ? " " : masterBookFormat.getMsBookName()%>"
						size="45" /></td>
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
						value="Sabmit" /><a
						href="<%=request.getContextPath()%>/DisplayMSBooks"><input
							type="button" value="Cancel" /></a></td>

				</tr>
			</table>

		</form>
	</section>
	<section id="footer1">
		<jsp:include page="Footer.jsp" />
	</section>
</body>
</html>