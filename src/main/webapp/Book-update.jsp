<%@page import="java.util.zip.CheckedInputStream"%>
<%@page import="com.narola.bookstore.book.model.Book"%>
<%@page import="com.narola.bookstore.utility.Constant"%>
<%@page
	import="com.narola.bookstore.msbookformat.model.MasterBookFormat"%>
<%@page import="com.narola.bookstore.category.model.Categorry"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.narola.bookstore.utility.DBConnect"%>
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
<title>Books Updates</title>
</head>
<body bgcolor="#DCDCDC">
	<jsp:include page="LeftBar.jsp" />

	<section id="header1">
		<jsp:include page="Header.jsp" />
	</section>
	<section id="interface1">
		<%
		Book book = (Book) request.getAttribute("Book");
		%>
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
		<form action="<%=request.getContextPath()%>/UpdateBook" method="post"
			enctype="multipart/form-data">
			<table border="1" cellpadding="3">
				<caption>
					<td colspan=12 align="center" height="30"><font size="5"><b>Update
								Book Data</b></font></td>
				</caption>
				<tr>
					<td>Book ID :</td>
					<td><input type="hidden" name="bookId"
						value="<%=book.getBookId()%>" size="45" /> <%=book.getBookId()%></td>
					<%
					if (request.getAttribute("errorMsgOfBookId") == null) {
					%>
					<%
					} else {
					%>
					<td><font color="red"><b><%=request.getAttribute("errorMsgOfBookId")%></b></font></td>
					<%
					}
					%>
				</tr>
				<tr>
					<td>Book Name :</td>
					<td><input type="text" name="bookName"
						value="<%=book.getBookName() == null ? " " : book.getBookName()%>"
						size="45" /></td>
					<%
					if (request.getAttribute("errorMsgOfBookname") == null) {
					%>
					<%
					} else {
					%>
					<td><font color="red"><b><%=request.getAttribute("errorMsgOfBookname")%></b></font></td>
					<%
					}
					%>
				</tr>
				<tr>
					<td>Author Name :</td>
					<td><input type="text" name="authorName"
						value="<%=book.getAuthorName()%>" size="45" /></td>
					<%
					if (request.getAttribute("errorMsgOfAuthorName") == null) {
					%>
					<%
					} else {
					%>
					<td><font color="red"><b><%=request.getAttribute("errorMsgOfAuthorName")%></b></font></td>
					<%
					}
					%>
				</tr>
				<tr>
					<td>Description :</td>
					<td><input type="text" name="description"
						value="<%=book.getDescription()%>" size="45" /></td>
					<%
					if (request.getAttribute("errorMsgOfDescription") == null) {
					%>
					<%
					} else {
					%>
					<td><font color="red"><b><%=request.getAttribute("errorMsgOfDescription")%></b></font></td>
					<%
					}
					%>

				</tr>
				<tr>
					<td>Amount :</td>
					<td><input type="text" name="bookAmount"
						value="<%=book.getAmount()%>" size="45" /></td>
					<%
					if (request.getAttribute("errorMsgOfAmount") == null) {
					%>
					<%
					} else {
					%>
					<td><font color="red"><b><%=request.getAttribute("errorMsgOfAmount")%></b></font></td>
					<%
					}
					%>
				</tr>
				<%
				List<Categorry> category = (ArrayList) request.getAttribute("listOfCategory");
				%>
				<tr>
					<td align="left">Category :</td>
					<td><select name="bookCategoryId">
							<%
							for (Categorry cat : category) {
								if (book.getCategoryId() == cat.getCategoryId()) {
							%>
							<option value="<%=cat.getCategoryId()%>" selected="selected"><%=cat.getCategoryName()%></option>
							<%
							} else {
							%>
							<option value="<%=cat.getCategoryId()%>"><%=cat.getCategoryName()%></option>
							<%
							}
							}
							%>
					</select></td>
					<%
					if (request.getAttribute("errorMsgOfBookCategoryId") == null) {
					%>
					<%
					} else {
					%>
					<td><font color="red"><b><%=request.getAttribute("errorMsgOfBookCategoryId")%></b></font></td>
					<%
					}
					%>
				</tr>
				<tr>
					<td>Publisher Name :</td>
					<td><input type="text" name="publisherName"
						value="<%=book.getPublisherName()%>" size="45" /></td>
					<%
					if (request.getAttribute("errorMsgOfPublisherName") == null) {
					%>
					<%
					} else {
					%>
					<td><font color="red"><b><%=request.getAttribute("errorMsgOfPublisherName")%></b></font></td>
					<%
					}
					%>
				</tr>
				<%
				List<MasterBookFormat> msbkFormat = (ArrayList) request.getAttribute("listOfMsBookFormat");
				%>
				<tr>
					<td align="left">Book Format :</td>
					<td>
						<%
						List<Integer> msBookID = (List) request.getAttribute("msBookId");

						for (MasterBookFormat msBookFormat : msbkFormat) {
							if (msBookID.contains(msBookFormat.getMsBookId())) {
						%> <input type="checkbox" name="msBookId"
						value="<%=msBookFormat.getMsBookId()%>" checked="checked"><%=msBookFormat.getMsBookName()%>
						<%
						} else {
						%> <input type="checkbox" name="msBookId"
						value="<%=msBookFormat.getMsBookId()%>"><%=msBookFormat.getMsBookName()%>
						<%
						}
						}
						%>
					</td>
					<%
					if (request.getAttribute("errorMsgOfMsbookId") == null) {
					%>
					<%
					} else {
					%>
					<td><font color="red"><b><%=request.getAttribute("errorMsgOfMsbookId")%></b></font></td>
					<%
					}
					%>
				</tr>
				<tr>
					<td>Image :</td>
					<td><input type="file" name="bookImage" size="45"
						multiple="multiple" /></td>
					<%
					if (request.getAttribute("errorMsgOfImage") == null) {
					%>
					<%
					} else {
					%>
					<td><font color="red"><b><%=request.getAttribute("errorMsgOfImage")%></b></font></td>
					<%
					}
					%>
				</tr>
				<tr>
					<td>Images :</td>
					<td>
						<%
						for (String path : book.getImagesPathList()) {
						%> <img name="imagename" src="<%=path%>" width=150 height=150 />
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close">
							<a
								href="<%=request.getContextPath()%>/DeleteImage?bookId=<%=book.getBookId()%>&imageName=<%=path%>">
								&times;</a>
						</button> <%
 }
 %>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save" /><a
						href="<%=request.getContextPath()%>/DisplayBooks"><input
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