<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.narola.bookstore.category.model.Categorry"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	width: 100%;
	position: relative;
}

#menu {
	width: 300px;
	background-color: navy;
	color: white;
	height: 100%;
	position: fixed;
	top: 0;
	left: 0;
}

#menu .logo {
	display: flex;
	color: white;
	align-items: center;
	padding: 20px 0 0 30px;
}

#menu .logo i {
	color: white;
}

#menu .logo h3 {
	font-size: 22px;
	font-family: Times New Roman;
	font-weight: bold;
}

#menu .items {
	margin-top: 30px;
}

#menu .items h3 {
	padding: 2px 0 0 35px;
	font-family: Times New Roman;
	font-size: 20px;
	font-weight: bold;
}

#menu .items li {
	list-style: none;
	font-family: Times New Roman;;
	padding: 15px 0;
}

#menu .items li:hover {
	background: #4682b4;
	font-size: 18px;
}

#menu .items li a {
	text-decoration: none;
	color: #fff;
	font-weight: 300px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<section id="menu">
		<div class="logo">
			<i class="bi bi-book-fill"></i>
			<h3>BookStore</h3>
		</div>

		<div class="items">
			<%
			List<Categorry> category = (ArrayList) request.getAttribute("listOfCategory"); 			
			%>
			<h3>Categories</h3>
			<ul>
				<%
				for (Categorry cat : category) {
				%>

				<li><a
					href="<%=request.getContextPath()%>/SearchCategoryHome?categoryId=<%=cat.getCategoryId()%>">
						<%=cat.getCategoryName()%></a> <%

 %></li>
				<%
				}
				%>
			</ul>
		</div>
	</section>
</body>
</html>