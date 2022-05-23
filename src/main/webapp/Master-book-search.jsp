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
	width: calc(100% - 10px);
}
</style>
<meta charset="ISO-8859-1">
<title>Master Book Format Searches</title>
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
		<form action="<%=request.getContextPath()%>/SearchMSBook" method="get">
			<table border=1>
				<caption>
					<td colspan=6 align="center" height="30"><font size="5"><b>Search
								Master Book</b></font></td>
				</caption>
				<tr>
					<td>Master Book Name :</td>
					<td><input type="text" name="msBookName" /></td>
				</tr>
				<tr>
					<td colspan=4 align="center"><input type="submit"
						name="submit" value="Search" /> <a
						href="<%=request.getContextPath()%>/DisplayMSBooks"><input
							type="button" value="Cancel" /></a></td>
					</td>
				</tr>
			</table>
		</form>
	</section>
	<section id="footer1">
		<jsp:include page="Footer.jsp" />
	</section>
</body>
</html>