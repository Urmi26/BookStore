<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="com.narola.bookstore.msbookformat.model.MasterBookFormat"%>
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
	width: calc(100% - 440px);
	margin-left: 440px;
	position: relative;
	padding: 50px 0;
}

#footer {
	width: calc(100% - 10px);
}
</style>
<meta charset="ISO-8859-1">
<title>Master Book Format Lists</title>
</head>
<body bgcolor="#DCDCDC">
	<jsp:include page="LeftBar.jsp" />

	<section id="header1">
		<jsp:include page="Header.jsp" />

	</section>
	<section id="interface1">
		<form action="<%=request.getContextPath()%>/DisplayMSBooks"
			method="get">
			<%
			List<MasterBookFormat> msblist = (ArrayList) request.getAttribute("listOfMsBookFormat");
			%>
			<table border="1">
				<caption>
					<td colspan=6 align="center" height="30"><font size="5"><b>Master
								Book Data</b></font></td>
				</caption>
				<tr>
					<td colspan=6 align="left" height="20"><b> <a
							href="<%=request.getContextPath()%>/Master-book-search.jsp">Search
								Master Book</a></b></td>
				</tr>
				<tr>
					<td colspan=6 align="right" height="20"><b> <a
							href="<%=request.getContextPath()%>/Master-book-form.jsp">Add
								New Master Book</a></b></td>
				</tr>

				<tr height="20">
					<th>Master Book Id</th>
					<th>Master Book Name</th>
					<th>Createdon</th>
					<th>Updatedon</th>
					<th colspan=2>Action</th>
				</tr>
				<%
				for (com.narola.bookstore.msbookformat.model.MasterBookFormat msbook : msblist) {
				%>
				<tr>
					<td><%=msbook.getMsBookId()%></td>
					<td><%=msbook.getMsBookName()%></td>
					<td><%=msbook.getCreatedOn()%></td>
					<td><%=msbook.getUpdatedOn()%></td>
					<td><a
						href="<%=request.getContextPath()%>/UpdateMSBookForm?msBookId=<%=msbook.getMsBookId()%>">Update</a></td>
				</tr>
				<%
				}
				%>
			</table>
		</form>
	</section>
	<section id="footer">
		<jsp:include page="Footer.jsp" />
	</section>
</body>
</html>
