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
	width: calc(100% - 400px);
	margin-left: 400px;
	position: relative;
	padding: 30px 0;
}

#footer1 {
	width: calc(100% - 10px);
}
</style>
<meta charset="ISO-8859-1">
<title>Category Form</title>
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
		<form action="<%=request.getContextPath()%>/AddCategory" method="post">
			<table border="1" cellpadding="5">
				<caption>
					<td colspan=12 align="center" height="30"><font size="5"><b>Add
								New Category</b></font></td>
				</caption>
				<tr>
					<th>Category Name :</th>
					<td colspan=2><input type="text" name="categoryName" size="45" /></td>
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
					<td colspan="3" align="center"><a
						href="<%=request.getContextPath()%>/DisplayCategories"><input
							type="submit" value="Submit" /></a> <a
						href="<%=request.getContextPath()%>/DisplayCategories"><input
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