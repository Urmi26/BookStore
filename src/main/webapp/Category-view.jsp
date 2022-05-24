<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.narola.bookstore.category.model.Categorry"%>
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
	width: calc(100% - 475px);
	margin-left: 475px;
	position: relative;
	padding: 50px 0;
}

#footer {
	width: calc(100% - 10px);
}
</style>
<meta charset="ISO-8859-1">
<title>Category Views</title>
</head>
<body bgcolor="#DCDCDC">
	<jsp:include page="LeftBar.jsp" />

	<section id="header1">
		<jsp:include page="Header.jsp" />

	</section>
	<section id="interface1">
		<form action="Category-View.jsp">
			<%
			List<Categorry> clist = (ArrayList) request.getAttribute("listOfCategory");
			%>
			<table border=1>
				<tr>
					<td colspan=4 align="center"><b>Category Records</b></td>
				</tr>
				<tr>
					<th>Category Id</th>
					<th>Category Name</th>
					<th>Createdon</th>
					<th>Updatedon</th>
				</tr>
				<%
				for (Categorry categorry : clist) {
				%>
				<tr>
					<td><%=categorry.getCategoryId()%></td>
					<td><%=categorry.getCategoryName()%></td>
					<td><%=categorry.getCreatedOn()%></td>
					<td><%=categorry.getUpdatedOn()%></td>
				</tr>
				<%
				}
				%>
				<tr>
					<td colspan="4" align="center"><a
						href="<%=request.getContextPath()%>/DisplayCategories"><input
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