<%@page import="com.narola.bookstore.utility.Constant"%>
<%@page
	import="com.narola.bookstore.msbookformat.model.MasterBookFormat"%>
<%@page import="com.narola.bookstore.category.model.Categorry"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.narola.bookstore.utility.DBConnect"%>
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
	padding: 50px 0;
}

#footer {
	width: calc(100% - 5px);
}
</style>
<meta charset="ISO-8859-1">
<title>book form</title>
</head>
<body bgcolor="#DCDCDC">
	<jsp:include page="LeftBar.jsp" />

	<section id="header1">
		<jsp:include page="Header.jsp" />
	</section>
	<section id="interface1">
			<form action="<%=request.getContextPath()%>/AddBook" method="post"
				enctype="multipart/form-data">
				<div class="text">

					<table cellpadding="5" border="1">
						<caption>
							<td colspan="12" align="center" height="30"><b><font
									size="5px">Add New Book</font></b></td>
						</caption>
						<tr>
							<th align="left">Book Name :</th>
							<td><input type="text" name="bookName" size="45" /></td>
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
							<th align="left">Author Name :</th>
							<td><input type="text" name="authorName" size="45" /></td>
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
							<th align="left">Book Description :</th>
							<td><textarea name="description" rows="3"
									style="width: 350px; height: 110px;"></textarea></td>
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
							<th align="left">Book Amount :</th>
							<td><input type="text" name="bookAmount" size="45" /></td>
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
							<th align="left">Category :</th>
							<td><select name="bookCategoryId">
									<option value="-1" selected="selected">Select</option>
									<%
									for (Categorry cat : category) {
									%>
									<option value="<%=cat.getCategoryId()%>"><%=cat.getCategoryName()%></option>
									<%
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
							<th align="left">Publisher Name:</th>
							<td><input type="text" name="publisherName" size="45" /></td>
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
						List<MasterBookFormat> masterBookFormat = (ArrayList) request.getAttribute("listOfMsBookFormat");
						%>
						<tr>
							<th align="left">Book Format :</th>

							<td>
								<%
								for (MasterBookFormat msBookFormat : masterBookFormat) {
								%> <input type="checkbox" name="msBookId"
								value="<%=msBookFormat.getMsBookId()%>"><%=msBookFormat.getMsBookName()%>
								<%
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
							<th align="left">Image:</th>
							<td><input type="file" name="bookImage" multiple="multiple" /></td>
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
							<td colspan="2"><a
								href="<%=request.getContextPath()%>/DisplayBooks"><input
									type="submit" value="Save" /></a> <a
								href="<%=request.getContextPath()%>/DisplayBooks"><input
									type="button" value="Cancel" /></a></td>
						</tr>
					</table>
				</div>
			</form>
	</section>
	<section id="footer">
		<jsp:include page="Footer.jsp" />
	</section>
</body>
</html>