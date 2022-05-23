<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="java.io.*"%>
<%@page import="com.narola.bookstore.book.model.Book"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	width: 100%;
	font-family: Times New Roman;
	position: relative;
}

#header {
	width: calc(100% - 300px);
	margin-left: 300px;
	position: relative;
}

#interface1 {
	width: calc(100% - 300px);
	background-color: white;
	display: block;
}

#interface1 .container {
	display: flex;
}

#interface1 .container .col-sm-20 {
	margin-top: 5px;
	display: flex;
	border: 1px;
	background-color: #DCDCDC;
}

#interface1 .bookDetails {
	margin-left: 10px;
}

#interface1 .bookDetails .bookName .name {
	color: red;
	font: bold;
	font: italic;
	font-size: 22px;
}

#interface1 .bookDetails .authordetails .author {
	color: red;
	font: bold;
	font: italic;
	font-size: 22px;
}

#interface1 .bookDetails .bookName i {
	font: bold;
	font: italic;
	font-size: 36px;
}

#interface1 .bookDetails .available .available1 {
	color: green;
	font: bold;
	font: italic;
	font: bold;
}

#interface1 .bookDetails .buttonAddToCart input {
	color: white;
	background-color: Tomato;
}

#interface1 .row {
	margin-left: 2px;
}

#footer1 {
	width: calc(100% - 5px);
}
</style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="LeftBarUserOfCategory.jsp" />

	<section id="header">
		<jsp:include page="HeaderOfUser.jsp" />
	</section>

	<section id="interface1">
		<div class="container">
			<%
			Book book = (Book) request.getAttribute("BookDetails");
			%>
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
			<div class="col-sm-20">
				<div class="bookImage">
					<%
					for (String s : book.getImagesPathList()) {
					%>
					<a
						href="<%=request.getContextPath()%>/BookDetails?bookId=<%=book.getBookId()%>">
						<img src="<%=s%>" alt="<%=book.getBookName()%>" width=200
						height=250 />
					</a>
					<%
					}
					%>
				</div>
			</div>
			<div class="col-sm-20"></div>
			<div class="bookDetails">
				<div class="bookName">
					<span class="name"><%=book.getBookName()%></span> <span> |
						Released: 18 October 2008</span>

				</div>
				<div class="authordetails">
					<span>By: </span> <span class="author"><%=book.getAuthorName()%></span>
					<label>(Author)</label> <span> | Publisher Imprint:</span> <span><%=book.getPublisherName()%></span>
				</div>
				<hr>
				<div class="amount">
					<span> <i class="fa fa-rupee"></i> <%=book.getAmount()%></span>
				</div>
				<div class="available">
					<span class="available1">Available</span>
					<p>
						<label>Ships within <b>2-4 Business Days</b></label><br> <label>&#8377;39
							shipping in India per item and Low cost Worldwide.</label>
					</p>
				</div>
				<div class="buttonAddToCart">
					<a href="AddtoCart?bookId=<%=book.getBookId()%>"><input
						type="submit" class="Add_To_Cart" value="Add To Cart" /></a>
				</div>
			</div>
		</div>
		<div class="row">
			<h4>About the Book</h4>
			<label><%=book.getDescription()%></label>
		</div>

	</section>
	<section id="footer1">
		<jsp:include page="Footer.jsp" />
	</section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>