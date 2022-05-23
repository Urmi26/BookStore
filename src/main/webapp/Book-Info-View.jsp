<%@page import="com.narola.bookstore.book.model.Book"%>
<%@page import="com.narola.bookstore.category.model.Categorry"%>
<%@page
	import="com.narola.bookstore.msbookformat.model.MasterBookFormat"%>
<%@page import="java.util.*"%>

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
	width: calc(100% - 300px);
	margin-left: 100px;
	position: relative;
	padding: 20px 0;
}

#footer {
	width: calc(100% - 10px);
}
</style>
<meta charset="ISO-8859-1">
<title>View</title>
</head>
<body bgcolor="	lightgray">

	<jsp:include page="LeftBar.jsp" />

	<section id="header1">
		<jsp:include page="Header.jsp" />
	</section>
	<section id="interface1">

		<form action="<%=request.getContextPath()%>/ViewBook" method="post"
			enctype="multipart/form-data">
			<table align="center" cellspacing="10">
				<tr>
					<caption>
						<td colspan=12 align="center" height="30"><b><font
								size="5px">Book Information</font></b></td>
					</caption>
				</tr>
				<%
				Book b = (Book) request.getAttribute("book");
				%>
				<tr>
					<td><b>Book Id </b></td>
					<td><%=b.getBookId()%></td>
				</tr>
				<tr>
					<td><b>Book Name </b></td>
					<td><%=b.getBookName()%></td>

				</tr>
				<tr>
					<td><b>Book Author Name </b></td>
					<td><%=b.getAuthorName()%></td>

				</tr>
				<tr>
					<td><b>Book Description </b></td>
					<td><%=b.getDescription()%></td>

				</tr>
				<tr>
					<td><b>Book Amount </b></td>
					<td><%=b.getAmount()%></td>

				</tr>
				<tr>
					<td><b>Book Publisher Name </b></td>
					<td><%=b.getPublisherName()%></td>

				</tr>
				<tr>
					<td><b>Book Category Name </b></td>
					<td><%=b.category.getCategoryName()%></td>
				</tr>
				<tr>
					<td><b>Book Format </b></td>
					<%
					for (MasterBookFormat masterBookFormat : b.getMasterBookFormatt()) {
					%>

					<td><input type="hidden"
						value="<%=masterBookFormat.getMsBookId()%>" /><%=masterBookFormat.getMsBookName()%></td>

					<%
					}
					%>
				</tr>

			</table>
			<table align="center">
				<caption>
					<td colspan=6 align="center" height="30"><font size="5"><b>Images</b></font></td>
				</caption>
				<tr>
					<td>
						<div>
							<%
							for (String path : b.getImagesPathList()) {
							%>
							<img src="<%=path%>" width=150 height=200 />
							<%
							}
							%>
						</div>
					</td>
				</tr>
				<tr>
					<td><a href="<%=request.getContextPath()%>/DisplayBooks">Back</a></td>
				</tr>
			</table>
		</form>
	</section>
	<section id="footer">
		<jsp:include page="Footer.jsp" />
	</section>
</body>
</html>