<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
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
	width: calc(100% - 10px);
}
</style>
<meta charset="ISO-8859-1">
<title>Master Book Format View</title>
</head>
<body bgcolor="#DCDCDC">
	<jsp:include page="LeftBar.jsp" />

	<section id="header1">
		<jsp:include page="Header.jsp" />

	</section>
	<section id="interface1">
		<form action="Master-book-view.jsp">
			<%
			List<com.narola.bookstore.msbookformat.model.MasterBookFormat> mslist = (ArrayList) request.getAttribute("listOfMasterBook");
			%>
			<table border=1>
				<caption>
					<td colspan=6 align="center" height="30"><font size="5"><b>
								Master Book Records</b></font></td>
				</caption>
				<tr>
					<th>MasterBook Id</th>
					<th>Master Book Name</th>
					<th>Createdon</th>
					<th>Updatedon</th>
				</tr>
				<%
				for (com.narola.bookstore.msbookformat.model.MasterBookFormat mb : mslist) {
				%>
				<tr>
					<td><%=mb.getMsBookId()%></td>
					<td><%=mb.getMsBookName()%></td>
					<td><%=mb.getCreatedOn()%></td>
					<td><%=mb.getUpdatedOn()%></td>
				</tr>
				<%
				}
				%>
				<tr>
					<td colspan="4" align="center"><a
						href="<%=request.getContextPath()%>/DisplayMSBooks"><input
							type="button" value="Cancel" /></a></td>

				</tr>
			</table>
		</form>
	</section>
	<section id="footer">
		<jsp:include page="Footer.jsp" />
	</section>
</body>
</html>