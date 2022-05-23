<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#interface .navigation{
	display: flex;
	align-items: center;
	font-family: Times New Roman;
	justify-content: space-between;
	background: #fff;
	padding: 5px 30px;
	border-bottom: 3px solid #7874EC;
}

#interface .navigation .search{
	display: flex;
	align-items: center;
	justify-content: flex-start;
	padding: 5px 14px;
	border: 3px solid #d7dbe6;
	border-radius: 4px;
}

#interface .navigation .search i{
	margin-right: 14px;
}

#interface .navigation .search input{
	border: none;
	outline: none;
	font-size: 14px;
}

#interface .navigation .profile{
	display: flex;
	justify-content: flex-end;
	align-items: center;
}

#interface .navigation .profile i{
	margin-right: 20px;
	font-size: 19px;
	color: gray;
	font-weight: 400;
}

 #interface .navigation .profile img{
	width: 30px;
	height: 30px;
	object-fit: cover;
	border-radius: 50%;
} 
 

</style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<meta charset="ISO-8859-1">
<title>header</title>
</head>
<body background="#DCDCDC">
<section id="interface">
		<div class="navigation">
			<div class="n1">
				<div class="search">
					<i class="bi bi-search"></i>
					<input type="text" placeholder="Search">
				</div>
			</div>
			
			<div class="profile">
				<i class="bi bi-cart-fill"></i>
				<i class="bi bi-bell-fill"></i>
				<i class="bi bi-person-circle"></i>
				<a href="login.jsp"><input type="submit" value="Log In" style="background-color: blue; color: white"></a>
				<a href="Sign_up.jsp"><input type="submit" value="Sign In" style="background-color: blue; color: white"></a>
			</div>
		</div>
</body>
</html>