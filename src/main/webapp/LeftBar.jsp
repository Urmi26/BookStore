<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.narola.bookstore.user.User" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	width: 100%;
	position: relative;
	font-family : Times New Roman;
}

#menu {
	width: 300px;
	background-color: navy;
	color: white;
	height: 100%;
	position:fixed;
	top: 0;
	left: 0;
}

#menu .logo {
	display: flex;
	color: white;
	align-items: center;
	padding: 30px 0 0 30px;
}

#menu .logo h3 {
	font-size: 22px;
	font-weight: bold;
}

#menu .logo i {
	color: white;
}

#menu .items {
	margin-top: 30px;
}

#menu .items li {
	list-style: none;
	padding: 15px 0;
}

#menu .items li:hover {
	background: #4682b4;
	font-size: 20px;
}

#menu .items li a {
	text-decoration: none;
	color: #fff;
	font-weight: 300px;
}

</style>
<meta charset="ISO-8859-1">
<title>LeftBar menu</title>
</head>
<body>
	<section id="menu">
		<div class="logo">
			<i class="bi bi-book-fill"></i>
			<h3>BookStore</h3>
		</div>
		<div class="items">
			<ul>
				<li><a href="AdminHomePage.jsp">Dashboard</a></li>
				<li><a href="<%=request.getContextPath()%>/DisplayCategories" >Category</a></li>
				<li><a href="<%=request.getContextPath()%>/DisplayBooks" >Books</a></li>
				<li><a href="<%=request.getContextPath()%>/DisplayMSBooks" >Master Book Format</a></li>
				<li><a href="Contact.jsp">Contact</a></li>
				<%HttpSession session1 = request.getSession(true);
				User user = (User) session1.getAttribute("user");
				if(user!=null){
					%>
				<li><a href="login.jsp">Logout</a></li>
				<%} %>
			</ul>
			<div class="main-container" id="section">
			
			</div>
		</div>
	</section>
	
</body>
</html>