<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.narola.bookstore.user.User"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	width: 100%;
	position: relative;
	display: flex;
}

#header {
	width: calc(100% - 300px);
	margin-left: 300px;
}

#interface1 {
	display: flex;
	width: calc(100% - 300px);
	margin-left: 100px;
	position: relative;
	font-family: Times New Roman;
	font-size: 20px;
}

#interface1 .text-center {
	padding: 30px 0;
}

#interface1 .tables {
	padding: 30px 30px;
}

#footer {
	width: calc(100% - 10px);
}
</style>
<meta charset="ISO-8859-1">
<title>Contact US</title>
</head>
<body bgcolor="#DCDCDC">
	<jsp:include page="LeftBar.jsp" />

	<section id="header">
		<jsp:include page="Header.jsp" />
	</section>

	<section id="interface1">
		<div class="text-center">
			<img src="images\book.jfif" class="rounded" width="500" height="380">
		</div>

		<div class="tables">
			<table>
				<tr>
					<td><b>Contact Us</b></td>
				</tr>
				<tr>
					<td colspan="2"><p>
							<b>Have any Questions? We'd love to hear from you.</b>
						</p></td>
				</tr>
				<tr>
					<td><label for="exampleFormControlInput1" class="form-label">Full
							Name</label></td>
					<td><input type="text" class="form-control"
						placeholder="First name" aria-label="First name" size="50"></td>
				</tr>
				<tr>
					<td><label for="exampleFormControlInput2" class="form-label">Email
							address</label></td>
					<td><input type="email" class="form-control"
						id="exampleFormControlInput1" placeholder="name@example.com"
						size="50"></td>
				</tr>
				<tr>
					<td><label for="exampleFormControlTextarea1"
						class="form-label">Massage</label></td>
					<td><textarea class="form-control"
							id="exampleFormControlTextarea1" placeholder="Massage" rows="3"
							style="width: 380px; height: 110px;"></textarea></td>
				</tr>
				<tr>
					<td><button type="submit" class="btn btn-primary">Send
							Massage</button></td>
				</tr>
			</table>
		</div>
	</section>
	<section id="footer">
		<jsp:include page="Footer.jsp" />
	</section>
</body>
</html>