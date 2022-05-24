<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.*" pageEncoding="ISO-8859-1"%>
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

#header {
	width: calc(100% - 300px);
	margin-left: 300px;
}

#interface1 {
	width: calc(100% - 300px);
	margin-left: 300px;
	position: relative;
	padding: 50px 0;
}

#footer1 {
	width: calc(100% - 5px);
}
</style>
<meta charset="ISO-8859-1">
<title>Category Lists</title>
</head>
<body bgcolor="#DCDCDC">
	<jsp:include page="LeftBar.jsp" />

	<section id="header">
		<jsp:include page="Header.jsp" />

	</section>

	<section id="interface1">
		<form action="<%=request.getContextPath()%>/DisplayCategories"
			method="get">
			<%
			List<com.narola.bookstore.category.model.Categorry> categorries = (ArrayList) request.getAttribute("listOfCategory");
			%>
			<table border="1">
				<caption>
					<td colspan=6 align="center" height="30"><font size="5"><b>Category
								Data</b></font></td>
				</caption>
				<tr>
					<td colspan=6 align="left" height="20"><b> <a
							href="<%=request.getContextPath()%>/Category-search.jsp">Search
								Category</a></b></td>
				</tr>
				<tr>
					<td colspan=6 align="right" height="20"><b> <a
							href="<%=request.getContextPath()%>/Category-form.jsp">Add
								New Category</a></b></td>
				</tr>

				<tr height="20">
					<th>Category Id</th>
					<th>Category Name</th>
					<th>Createdon</th>
					<th>Updatedon</th>
					<th colspan=2>Action</th>
				</tr>
				<%
				for (com.narola.bookstore.category.model.Categorry categorry : categorries) {
				%>
				<tr>
					<td><%=categorry.getCategoryId()%></td>
					<td><%=categorry.getCategoryName()%></td>
					<td><%=categorry.getCreatedOn()%></td>
					<td><%=categorry.getUpdatedOn()%></td>
					<td><a
						href="<%=request.getContextPath()%>/UpdateCategoryForm?categoryId=<%=categorry.getCategoryId()%>">Update</a></td>
				</tr>
				<%
				}
				%>
			</table>
		</form>
	</section>

	<section id="footer1">
		<jsp:include page="Footer.jsp" />
	</section>
</body>
</html>