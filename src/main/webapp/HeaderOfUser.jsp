<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="com.narola.bookstore.user.User"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#interface .navigation {
	display: flex;
	align-items: center;
	font-family: Times New Roman;
	justify-content: space-between;
	padding: 5px 30px;
	border-bottom: 3px solid #7874EC;
}

#interface .navigation .n1 {
	display: flex;
}

#interface .navigation .n1 li a {
	text-decoration: none;
	color: black;
}

#interface .navigation .n1 li:hover {
	background: aliceblue;
	font-size: 18px;
}

#interface .navigation .profile .search {
	display: flex;
	align-items: center;
	justify-content: flex-end;
	padding: 5px 14px;
	border: 3px solid #d7dbe6;
	border-radius: 4px;
	margin-right: 5px;
}

#interface .navigation .profile .search i {
	margin-right: 14px;
}

#interface .navigation .profile .search input {
	border: none;
	outline: none;
	font-size: 14px;
}

#interface .navigation .profile {
	display: flex;
	justify-content: flex-end;
	align-items: center;
}

#interface .navigation .profile i {
	margin-right: 10px;
	font-size: 20px;
	color: gray;
	font-weight: 400;
}

#interface .navigation .profile label {
	margin-right: 8px;
	font-size: 20px;
	color: red;
}

#interface .navigation .profile #useOfUser li a {
	font-weight: bold;
}

/* #interface .navigation .profile .search input:hover {
	background: aliceblue;
	font-size: 18px;
}

#interface .navigation .profile .search i:hover {
	background: aliceblue;
	font-size: 24px;
} */

#interface .navigation .profile #icon:hover {
	background: aliceblue;
	font-size: 24px;
}

/* #interface .navigation .profile img {
	width: 35px;
	height: 35px;
	object-fit: cover;
	border-radius: 50%;
} */
</style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>

	<section id="interface">
		<div class="navigation">
			<div class="n1">
				<ul class="nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page"
						href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">About</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contact
							Us</a></li>
				</ul>
			</div>

			<div class="profile">
				<div class="search">
					<i id="show" class="bi bi-search" id="icon"></i> <input type="text"
						placeholder="Search">
				</div>
				<a href="<%=request.getContextPath()%>/DisplaySelectedBook"> <i 
					class="bi bi-cart-fill" id="icon"></i></a> <i id="show" class="bi bi-bell-fill"
					id="icon"></i> 
				<%
				HttpSession session1 = request.getSession(true);
				User user = (User) session1.getAttribute("user");
				if (user != null) {
				%>
				<i id="show" class="bi bi-person-circle" id="icon"></i> 
				<label><%=user.getEmailId()%></label>
				<div class="dropdown" id="useOfUser">
					<a class="btn btn-secondary dropdown-toggle" href="#" role="button"
						id="dropdownMenuLink" data-bs-toggle="dropdown"
						aria-expanded="false"> </a>

					<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<li><a class="dropdown-item"
							href="<%=request.getContextPath()%>/UserUpdateFormServlet"><i
								class="bi bi-person-fill"> Profile</i> </a></li>
						<li><a class="dropdown-item" href="Sign_up.jsp"><i
								class="bi bi-key"> Change Password</i></a></li>
						<li><a class="dropdown-item" href="login.jsp"><i
								class="bi bi-power"> Logout</i></a></li>
					</ul>
				</div>
				<%
				} else {
				%>
				<div class="dropdown" id="useOfUser">
					<a class="btn btn-light dropdown-toggle" href="#" role="button"
						id="dropdownMenuLink" data-bs-toggle="dropdown"
						aria-expanded="false"> </a>

					<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<li><a class="dropdown-item" href="login.jsp">Log In</a></li>
						<li><a class="dropdown-item" href="Sign_up.jsp">Sign In</a></li>

					</ul>
				</div>
				<%
				}
				%>
			</div>
		</div>
</body>
</html>