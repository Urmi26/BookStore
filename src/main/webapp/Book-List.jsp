<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.narola.bookstore.book.model.Book"%>
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
	width: calc(100% - 300px);
	margin-left: 150px;
	position: relative;
	padding: 50px 0;
}

#footer {
	width: calc(100% - 10px);
}
</style>
<meta charset="ISO-8859-1">
<title>Books Lists</title>
</head>
<body bgcolor="#DCDCDC">
	<jsp:include page="LeftBar.jsp" />

	<section id="header1">
		<jsp:include page="Header.jsp" />
	</section>
	<section id="interface1">
			<form action="<%=request.getContextPath()%>/DisplayBooks"
				method="get">
				<%
				List<Book> books = (ArrayList) request.getAttribute("listOfBook");
				%>
				<table border="1">
					<caption>
						<td colspan=12 align="center" height="20"><b><font
								size="5px">Book Data</font></b></td>
					</caption>
					<tr>
						<td colspan=12 align="left" height="20"><b><font
								size="4px"><a
									href="<%=request.getContextPath()%>/Book-Search.jsp">Search
										Book</a></font></b></td>
					</tr>
					<tr>
						<td colspan=12 align="right" height="20"><b><font
								size="4px"><a
									href="<%=request.getContextPath()%>/addbookform">Add New
										Book</a></font></b></td>
					</tr>

					<tr height="20">
						<th>Books Id</th>
						<th>Book Name</th>
						<th>Author Name</th>
						<th>Description</th>
						<th>Amount</th>
						<th>Category Name</th>
						<th>Publisher Name</th>
						<th>Createdon</th>
						<th>Updatedon</th>
						<th colspan=2>Action</th>
					</tr>
					<%
					for (Book book : books) {
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
						<td><a
							href="<%=request.getContextPath()%>/UpdateBookForm?bookId=<%=book.getBookId()%>">Update</a></td>
						<td><a
							href="<%=request.getContextPath()%>/ViewBookForm?bookId=<%=book.getBookId()%>">View</a></td>
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