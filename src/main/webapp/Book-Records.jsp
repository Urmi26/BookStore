<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="java.io.*"%>
<%@page import="com.narola.bookstore.book.model.Book"%>
<%@page import="com.narola.bookstore.utility.Constant"%>
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
	display: flex;
}

#interface1 .items {
	display: inline-flex;
}

#interface1 .items .col {
	margin-top: 5px;
}

#interface1 .items .col .books {
	padding: 0 0 20px;
	border: solid 1px;
	background-color: #DCDCDC;
}

#footer {
	width: calc(100% - 5px);
}
</style>
<meta charset="ISO-8859-1">
<title>Book Records</title>
</head>
<body>
	<section id="menu">
		<jsp:include page="LeftBarUserOfCategory.jsp" />
	</section>

	<section id="header">
		<jsp:include page="HeaderOfUser.jsp" />
	</section>

	<section id="interface1">
		<div class="container">
			<%
			List<Book> blist = (ArrayList) request.getAttribute("listOfBook");
			%>
			<%
			int i = 1;
			for (Book book : blist) {
			%>

			<%
			String path = getServletContext().getRealPath("/").concat("Book-Image");
			path = path + "\\" + book.getBookId();
			System.out.println(path);
			File file = new File(path);
			String[] imgNames = file.list();
			List<String> imgPaths = new ArrayList<String>();
			String str = request.getContextPath().concat("/Book-Image/") + book.getBookId() + "/";
			System.out.println(str);
			for (String imgName : imgNames) {
				imgPaths.add(str + imgName);
			}
			%>
			<div class="items">
				<div class="col">
					<div class="books">
						<span><%=i%></span><br>
						<div class="bookImage">

							<a
								href="<%=request.getContextPath()%>/BookDetails?bookId=<%=book.getBookId()%>">
								<img src="<%=imgPaths.get(0)%>" alt="<%=book.getBookName()%>"
								width=250 height=300 />
							</a>
						</div>
						<div class="bookDetails">
							<p class="card-text text-center">
								<span><%=book.getBookName()%></span> <br> <span><%=book.getAuthorName()%></span>
								<br> <br> <span>&#8377;<%=book.getAmount()%></span>
							</p>
						</div>
					</div>
				</div>
				<%
				i++;
				}
				%>
			</div>
		</div>

	</section>
	<section id="footer">
		<jsp:include page="Footer.jsp" />
	</section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>