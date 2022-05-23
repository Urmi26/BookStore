<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="com.narola.bookstore.book.model.Book"%>
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
	padding: 50px 0;
}

#footer {
	width: calc(100% - 10px);
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
}
</style>
<meta charset="ISO-8859-1">
<title>Book Views</title>
</head>
<body bgcolor="#DCDCDC">
	<jsp:include page="LeftBar.jsp" />

	<section id="header1">
		<jsp:include page="Header.jsp" />

	</section>

	<section id="interface1">
		<form action="Book-View.jsp">
			<%
			List<Book> blist = (ArrayList) request.getAttribute("listOfBook");
			%>
			<table border=1>
				<tr>
					<td colspan=10 align="center"><b>Book Records</b></td>
				</tr>
				<tr>
					<th>Book Id</th>
					<th>Book Name</th>
					<th>Author Name</th>
					<th>Description</th>
					<th>Amount</th>
					<th>Category Name</th>
					<th>Publisher Name</th>
					<th>Createdon</th>
					<th>Updatedon</th>
					<th>Images</th>
				</tr>
				<%
				for (Book book : blist) {
				%>
				<tr>
					<td><%=book.getBookId()%></td>
					<td><%=book.getBookName()%></td>
					<td><%=book.getAuthorName()%></td>
					<td><%=book.getDescription()%></td>
					<td><%=book.getAmount()%></td>
					<td><%=book.category.getCategoryName()%></td>
					<td><%=book.getPublisherName()%></td>
					<td><%=book.getCreatedOn()%></td>
					<td><%=book.getUpdatedOn()%></td>

					<%
					String path = getServletContext().getRealPath("/").concat("Book-Image");
					path = path + "\\" + book.getBookId();
					File file = new File(path);
					String[] imgNames = file.list();
					List<String> imgPaths = new ArrayList<String>();
					String str = request.getContextPath().concat("/Book-Image/") + book.getBookId() + "/";

					for (String imgName : imgNames) {
						imgPaths.add(str + imgName);
					}
					book.setImagesPathList(imgPaths);
					%>

					<td>
						<%
						for (String image : book.getImagesPathList()) {
						%> <img src="<%=image%>" width=100 height=150 /> <%
 }
 %> <%
 }
 %>

					</td>
				</tr>
				<tr>
					<td colspan="10" align="center"><a
						href="<%=request.getContextPath()%>/DisplayBooks"><input
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