<%@page import="com.narola.bookstore.category.model.Categorry"%>
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
	width: calc(100% - 410px);
	margin-left: 410px;
	position: relative;
	padding: 50px 0;
}

#footer {
	width: calc(100% - 10px);
}
</style>
<meta charset="ISO-8859-1">
<title>Category Updates</title>
</head>
<body bgcolor="#DCDCDC">
	<jsp:include page="LeftBar.jsp" />

	<section id="header1">
		<jsp:include page="Header.jsp" />

	</section>
	<section id="interface1">
		<form action="<%=request.getContextPath()%>/UpdateCategory"
			method="post">
			<table border="1" cellpadding="3">
				<caption>
					<td colspan=6 align="center" height="30"><font size="5"><b>Update
								Category Data</b></font></td>
				</caption>
				<%
				Categorry c = (Categorry) request.getAttribute("category");
				%>
				<tr>
					<td>Category ID :</td>
					<td><input type="hidden" name="categoryId"
						value="<%=c.getCategoryId()%>" size="45" /> <%=c.getCategoryId()%></td>
					<%
					if (request.getAttribute("errorMsgCategoryId") == null) {
					%>
					<%
					} else {
					%>
					<td><font color="red"><b><%=request.getAttribute("errorMsgCategoryId")%></b></font></td>
					<%
					}
					%>
				</tr>
				<tr>
					<td>Category Name :</td>
					<td><input type="text" name="categoryName"
						value="<%=c.getCategoryName() == null ? " " : c.getCategoryName()%>"
						size="45" /></td>
					<%
					if (request.getAttribute("errorMsgCategoryName") == null) {
					%>
					<%
					} else {
					%>
					<td><font color="red"><b><%=request.getAttribute("errorMsgCategoryName")%></b></font></td>
					<%
					}
					%>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Submit" /><a
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