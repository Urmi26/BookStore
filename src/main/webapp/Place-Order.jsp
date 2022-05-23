<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.narola.bookstore.user.User"%>
<%@page import="jakarta.servlet.http.HttpSession"%>

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
	padding: 30px 0 0 30px;
	margin-left: 300px;
	background-color: white;
	display: block;
}

#interface1 #table1 table {
	border-collapse: separate;
	border-spacing: 5px;
}

#interface1 #table1 table tr td .title {
	font-weight: bold;
	font-size: 20px;
	color: light;
}

#interface1 #table1 table tr td {
	font-weight: bold;
	font-size: 14px;
}

#interface2 {
	width: calc(100% - 300px);
	padding: 30px 0 0 30px;
}

#interface2 #order {
	margin-left: 600px;
}

#interface2 #order .orderSummary table {
	border-collapse: separate;
	border-spacing: 5px;
}

#footer {
	width: calc(100% - 5px);
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="LeftBarUserOfCategory.jsp" />

	<section id="header">
		<jsp:include page="HeaderOfUser.jsp" />
	</section>
	<form action="<%=request.getContextPath()%>/OrderAdd"
		method="post">
	<section id="interface1">
		<%
		HttpSession session1 = request.getSession(true);
		User user = (User) session1.getAttribute("user");
		%>
		<div id="table1">
			<table style="width: 40%; height: 50%;" border="1">
				<tr align="center">
					<td colspan="2"><div class="title">Enter Your Address</div></td>
				</tr>
				<tr>
					<td>Company Name</td>
					<td><input type="text" name="addressLine1" size="25" /></td>
				</tr>
				<tr>
					<td>Steel Address</td>
					<td><textarea name="addressLine2" rows="3"
							style="width: 200px; height: 110px;"></textarea></td>

				</tr>
				<tr>
					<td>LandMark</td>
					<td><input type="text" name="landmark" size="25" /></td>
				</tr>
				<tr>
					<td>State</td>
					<td><input type="text" name="state" size="25" /></td>
				</tr>
				<tr>
					<td>PIN Code</td>
					<td><input type="text" name="pincode" size="25" /></td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" name="city" size="25" /></td>
				</tr>
				<tr>
					<td>Address Type</td>
					<td><input type="text" name="addresstype" size="25" /></td>
				</tr>
				<tr>
					<td>Mobile No</td>
					<td><input type="text" name="mobileNo" size="25" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						name="Save&Continue"
						style="font-weight: bold; color: black; background-color: red;"
						value="Save & Continue" /></td>
				</tr>
			</table>
		</div>
	</section>
	<section id="interface2">
		<hr>
		<div id="order">
			<div class="orderSummary" align="right">
				<table style="width: 30%; height: 30%;">
					<tr>
						<td colspan="2"><b>Order Summary</b></td>
					</tr>
					<tr>
						<td>Items</td>
						<td><input type="hidden" name="items" value="<%=request.getAttribute("Items")%>"/> <%=request.getAttribute("Items")%></td>
					</tr>
					<tr>
						<td><b>TotalAmount</b></td>
						<td><input type="hidden" name="totalAmount" value="<%=request.getAttribute("TotalAmount")%>"/><b><font color="red">&#8377;<%=request.getAttribute("TotalAmount")%></font></b></td>
					</tr>
				</table>
			</div>
		</div>
		<hr>
	</section>
	</form>
	<section id="footer">
		<jsp:include page="Footer.jsp" />
	</section>
</body>
</html>