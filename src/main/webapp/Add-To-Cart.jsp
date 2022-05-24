<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="java.io.File"%>
<%@page import="com.narola.bookstore.cart.Cart"%>
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
	padding: 30px 0 0 30px;
	margin-left: 100px;
	background-color: white;
	display: block;
}

#interface1 table {
	border-collapse: separate;
	border-spacing: 20px;
}

#interface1 table tr td {
	align-items: center;
}

#interface2 label {
	display: block;
	margin-left: 600px;
}

#footer {
	width: calc(100% - 5px);
}
</style>
<meta charset="ISO-8859-1">
<title>Add to Cart</title>
</head>
<body>
	<jsp:include page="LeftBarUserOfCategory.jsp" />

	<section id="header">
		<jsp:include page="HeaderOfUser.jsp" />
	</section>
	<section id="interface1">
		<%
		if (request.getAttribute("isMessage") != null) {
		%>
		<p>
			<font style="font-family: Times New Roman"><b><%=request.getAttribute("isMessage")%></b></font>
		</p>
		<%
		} else {
		%>
		<%
		List<Cart> cart = (ArrayList) request.getAttribute("listOfSelectedBook");
		int i = 1;
		double val = 0.0;
		%>
		<table border="1">
			<tr>
				<td colspan="8" align="center"><b>My Cart</b></td>
			</tr>
			<tr>
				<th>Sr. No</th>
				<th></th>
				<th>Book Name</th>
				<th>Author Name</th>
				<th>Category</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Total Amount</th>
				<th>Remove</th>
			</tr>
			<%
			for (Cart cart1 : cart) {
			%>

			<%
			String path = getServletContext().getRealPath("/").concat("Book-Image");
			path = path + "\\" + cart1.getBook().getBookId();
			File file = new File(path);
			String[] imgNames = file.list();
			List<String> imgPaths = new ArrayList<String>();
			String str = request.getContextPath().concat("/Book-Image/") + cart1.getBook().getBookId() + "/";
			for (String imgName : imgNames) {
				imgPaths.add(str + imgName);
			}
			%>
			<tr>
				<td><%=i%></td>
				<td><img src="<%=imgPaths.get(0)%>" width=100 height=100 /></td>
				<td><%=cart1.getBook().getBookName()%></td>
				<td><%=cart1.getBook().getAuthorName()%></td>
				<td><%=cart1.getBook().category.getCategoryName()%></td>
				<td><%=cart1.getAmount()%></td>
				<td>
					<form action="<%=request.getContextPath()%>/UpdateQuantity"
						method="post">
						<input type="hidden" name="cartId" value="<%=cart1.getCartId()%>" />
						<input type="text" name="quantity"
							value="<%=cart1.getQuantity()%>" maxlength="2" size="2" />
						<button type="submit" name="update">
							<i class="bi bi-arrow-repeat"></i>
						</button>
					</form>
				</td>
				<td><%=cart1.getTotalprice()%></td>
				<td><a
					href="<%=request.getContextPath()%>/DeleteSelectedBook?cartId=<%=cart1.getCartId()%>">remove</a></td>
			</tr>
			<%
			i++;
			val = val + cart1.getTotalprice();
			}
			%>
		</table>

		<hr>
		<div id="interface2" align="right">
			<form action="<%=request.getContextPath()%>/UserPlaceOrder"
				method="post">
				<table style="width: 30%; height: 30%;">
					<tr>
						<td><b>Items</b></td>
						<td><input type="hidden" name="totalItemsOfPlaceOrder"
							value="<%=i - 1%>" /><%=i - 1%></td>
					</tr>
					<tr>
						<td><b>Total Gross</b></td>
						<td><input type="hidden" name="totalAmountOfPlaceOrder"
							value="<%=val%>" /><%=val%></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><a
							href="<%=request.getContextPath()%>/UserPlaceOrder"><input
								type="submit" name="Place-Order" value="Place Order"
								style="background-color: Tomato; color: black; font-weight: bold;"></a></td>
					</tr>
				</table>
			</form>

		</div>
		<hr>
		<%
		}
		%>


	</section>
	<section id="footer">
		<jsp:include page="Footer.jsp" />
	</section>
</body>
</html>