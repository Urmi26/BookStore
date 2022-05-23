<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.narola.bookstore.user.User"%>
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
	width: calc(100% - 350px);
	padding: 30px 0 0 30px;
	margin-left: 350px;
	display: block;
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
	<section id="interface1">

		<form action="<%=request.getContextPath()%>/UserUpdateAction"
			method="post">
			<%
			User user = (User) request.getAttribute("userForm");
			%>
			<div class="table">
				<table border="1">
					<caption>
						<td colspan="2" align="center" height="30"><b><font
								size="5px">Profile</font></b></td>
					</caption>
					<tr>
						<td><input type="hidden" name="userId"
							value="<%=user.getUserId()%>" size="45" /><input type="hidden"
							name="userType" value="<%=user.getUserType()%>" /></td>
					</tr>
					<tr>
						<td colspan="2"><b>User Details</b></td>
					</tr>

					<%
					if (request.getAttribute("errorMsgOfUserId") == null) {
					%>
					<%
					} else {
					%><tr>
						<td colspan="3"><font color="red"><b><%=request.getAttribute("errorMsgOfUserId")%></b></font>
						</td>
					</tr>
					<%
					}
					%>
					<tr>
						<td align="left">First Name</td>
						<td><input type="text" name="firstName"
							value="<%=user.getFirstName() == null ? " " : user.getFirstName()%>"
							size="45" /></td>
						<%
						if (request.getAttribute("errorMsgOfFirstname") == null) {
						%>
						<%
						} else {
						%>
						<td><font color="red"><b><%=request.getAttribute("errorMsgOfFirstname")%></b></font>
						</td>
						<%
						}
						%>

					</tr>
					<tr>
						<td align="left">Last Name</td>
						<td><input type="text" name="lastName"
							value="<%=user.getLastName() == null ? " " : user.getLastName()%>"
							size="45" /></td>
						<%
						if (request.getAttribute("errorMsgOflastName") == null) {
						%>
						<%
						} else {
						%>
						<td><font color="red"><b><%=request.getAttribute("errorMsgOflastName")%></b></font>
						</td>
						<%
						}
						%>

					</tr>
					<tr>
						<td align="left">Contact</td>
						<td><input type="text" name="contact"
							value="<%=user.getContact()%>" size="45" /></td>
						<%
						if (request.getAttribute("errorMsgOfContact") == null) {
						%>
						<%
						} else {
						%>
						<td><font color="red"><b><%=request.getAttribute("errorMsgOfContact")%></b></font>
						</td>
						<%
						}
						%>
					</tr>
					<tr>
						<td align="left">Email</td>
						<td><input type="email" name="emailId"
							value="<%=user.getEmailId() == null ? " " : user.getEmailId()%>"
							size="45" /></td>
						<%
						if (request.getAttribute("errorMsgOfEmail") == null) {
						%>
						<%
						} else {
						%>
						<td><font color="red"><b><%=request.getAttribute("errorMsgOfEmail")%></b></font>
						</td>
						<%
						}
						%>

					</tr>
					<tr>
						<td align="left">Password</td>
						<td><input type="password" name="password"
							value="<%=user.getPassword() == null ? " " : user.getPassword()%>"
							size="45" /></td>
						<%
						if (request.getAttribute("errorMsgOfPassword") == null) {
						%>
						<%
						} else {
						%>
						<td><font color="red"><b><%=request.getAttribute("errorMsgOfPassword")%></b></font>
						</td>
						<%
						}
						%>
					</tr>
					<tr>
						<td><input type="hidden" name="addressId"
							value="<%=user.getAddress().getAddressId() == 0 ? " " : user.getAddress().getAddressId()%>"
							size="45" /></td>
					</tr>
					<%
					if (request.getAttribute("errorMsgOfAddressId") == null) {
					%>
					<%
					} else {
					%><tr>
						<td colspan="3"><font color="red"><b><%=request.getAttribute("errorMsgOfAddressId")%></b></font>
						</td>
					</tr>
					<%
					}
					%>
					<tr>
						<td><b>Address Details</b></td>
					</tr>
					<tr>
						<td align="left">Address Line1</td>
						<td><input type="text" name="addressLine1"
							value="<%=user.getAddress().getAddressLine1() == null ? " " : user.getAddress().getAddressLine1()%>"
							size="45" /></td>
						<%
						if (request.getAttribute("errorMsgOfAddressLine1") == null) {
						%>
						<%
						} else {
						%>
						<td><font color="red"><b><%=request.getAttribute("errorMsgOfAddressLine1")%></b></font>
						</td>
						<%
						}
						%>

					</tr>
					<tr>
						<td align="left">Address Line2</td>
						<td><input type="text" name="addressLine2"
							value="<%=user.getAddress().getAddressLine2() == null ? " " : user.getAddress().getAddressLine2()%>"
							size="45" /></td>
						<%
						if (request.getAttribute("errorMsgOfAddressLine2") == null) {
						%>
						<%
						} else {
						%>
						<td><font color="red"><b><%=request.getAttribute("errorMsgOfAddressLine2")%></b></font>
						</td>
						<%
						}
						%>

					</tr>
					<tr>
						<td align="left">Landmark</td>
						<td><input type="text" name="landmark"
							value="<%=user.getAddress().getLandmark() == null ? " " : user.getAddress().getLandmark()%>"
							size="45" /></td>
						<%
						if (request.getAttribute("errorMsgOfLandMark") == null) {
						%>
						<%
						} else {
						%>
						<td><font color="red"><b><%=request.getAttribute("errorMsgOfLandMark")%></b></font>
						</td>
						<%
						}
						%>

					</tr>
					<tr>
						<td align="left">State</td>
						<td><input type="text" name="state"
							value="<%=user.getAddress().getState() == null ? " " : user.getAddress().getState()%>"
							size="45" /></td>
						<%
						if (request.getAttribute("errorMsgOfState") == null) {
						%>
						<%
						} else {
						%>
						<td><font color="red"><b><%=request.getAttribute("errorMsgOfState")%></b></font>
						</td>
						<%
						}
						%>
					</tr>
					<tr>
						<td align="left">Pin code</td>
						<td><input type="text" name="pincode"
							value="<%=user.getAddress().getPincode() == 0 ? " " : user.getAddress().getPincode()%>"
							size="45" /></td>
						<%
						if (request.getAttribute("errorMsgOfPincode") == null) {
						%>
						<%
						} else {
						%>
						<td><font color="red"><b><%=request.getAttribute("errorMsgOfPincode")%></b></font>
						</td>
						<%
						}
						%>
					</tr>
					<tr>
						<td align="left">city</td>
						<td><input type="text" name="city"
							value="<%=user.getAddress().getCity() == null ? " " : user.getAddress().getCity()%>"
							size="45" /></td>
						<%
						if (request.getAttribute("errorMsgOfCity") == null) {
						%>
						<%
						} else {
						%>
						<td><font color="red"><b><%=request.getAttribute("errorMsgOfCity")%></b></font>
						</td>
						<%
						}
						%>
					</tr>
					<tr>
						<td align="left">Address Type</td>
						<td><input type="text" name="addressType"
							value="<%=user.getAddress().getAddressType() == null ? " " : user.getAddress().getAddressType()%>"
							size="45" /></td>
						<%
						if (request.getAttribute("errorMsgOfAddressType") == null) {
						%>
						<%
						} else {
						%>
						<td><font color="red"><b><%=request.getAttribute("errorMsgOfAddressType")%></b></font>
						</td>
						<%
						}
						%>
					</tr>
					<tr>
						<td>Mobile No</td>
						<td><input type="text" name="mobile"
							value="<%=user.getAddress().getMobile()%>" size="45" /></td>
						<%
						if (request.getAttribute("errorMsgOfMobileNo") == null) {
						%>
						<%
						} else {
						%>
						<td><font color="red"><b><%=request.getAttribute("errorMsgOfMobileNo")%></b></font>
						</td>
						<%
						}
						%>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit" /> <input
							type="button" value="Cancel" /></td>
					</tr>
				</table>
			</div>

		</form>
	</section>
	<section id="footer">
		<jsp:include page="Footer.jsp" />
	</section>

</body>
</html>