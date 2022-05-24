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
	width: calc(100% - 400px);
	margin-left: 400px;
	position: relative;
	padding: 50px 0;
}

#footer {
	width: calc(100% - 10px);
}
</style>
<meta charset="ISO-8859-1">
<title>Category Searches</title>
</head>
<body bgcolor="#DCDCDC">
	<jsp:include page="LeftBar.jsp" />

	<section id="header1">
		<jsp:include page="Header.jsp" />

	</section>
	<section id="interface1">
		<form action="<%=request.getContextPath()%>/SearchCategory"
			method="get">
			<table border=1>
				<caption>
					<td colspan=6 align="center" height="30"><font size="5"><b>Search
								Category</b></font></td>
				</caption>
				<tr>
					<td>Category Name :</td>
					<td><input type="text" name="categoryName" size="45" /></td>
				</tr>
				<tr>
					<td colspan=4 align="center"><input type="submit"
						name="submit" value="Search" /> <a
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