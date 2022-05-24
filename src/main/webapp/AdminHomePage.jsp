<%@page import="com.narola.bookstore.utility.Constant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	width: 100%;
	position: relative;
}

#header1 {
	width: calc(100% - 300px);
	margin-left: 300px;
}

#interface2 {
	width: calc(100% - 300px);
	margin-left: 100px;
	position: relative;
	padding: 50px 0;
}

#footer1 {
	width: calc(100% - 10px);
}
</style>
<meta charset="ISO-8859-1">
<title>Admin Home Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<body bgcolor="#DCDCDC">
	<jsp:include page="LeftBar.jsp" />
	<section id="header1">
		<jsp:include page="Header.jsp" />
	</section>
	<section id="interface2">
			<jsp:include page="Dashboard.jsp" />
	</section>
	<section id="footer1">
		<jsp:include page="Footer.jsp" />
	</section>
</body>
</html>