<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	width: 100%;
	position: relative;
	display: flex;
}

.i-name {
	padding: 30px 30px 0 30px;
	font-size: 24px;
	font-weight: 700;
}

.values {
	padding: 30px 30px 0 30px;
	display: flex;
	justify-content: space-between;
	align-content: center;
	flex-wrap: wrap;
}

.values .val-box {
	padding: 16px 20px;
	border-radius: 5px;
	color: #fff;
	display: flex;
	justify-content: flext-start;
	align-items: center;
	width: 235px;
}

.values .val-box:nth-child(1) {
	background: gray;
}

.values .val-box:nth-child(2) {
	background: purple;
}

.values .val-box:nth-child(3) {
	background: #5f9ea0;
}

.values .val-box:nth-child(4) {
	background: #8A2BE2;
}

.values .val-box:nth-child(1) i {
	background: #7874EC;
}

.values .val-box:nth-child(2) i {
	background: #008080;
}

.values .val-box:nth-child(3) i {
	background:#8b0000;
}

.values .val-box:nth-child(4) i {
	background: gray;
}

.values .val-box i {
	font-size: 25px;
	width: 60px;
	height: 60px;
	line-height: 60px;
	border-radius: 50%;
	text-align: center;
	margin-right: 15px;
	width: 60px;
}

.values .val-box h3 {
	font-size: 18px;
	font-weight: 600;
}

.values .val-box span {
	font-size: 15px;
	font-weight: 600;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body bgcolor="#DCDCDC">
<section id="interface">
		<h3 class="i-name">Dashboard</h3>
		<div class="values">
			<div class="val-box">
				<i class="bi bi-people"></i>
				<div>
					<h3>123</h3>
					<span>New Users</span>
				</div>
			</div>
			<div class="val-box">
				<i class="bi bi-cart2"></i>
				<div>
					<h3>100</h3>
					<span>Total Orders</span>
				</div>
			</div>
			<div class="val-box">
				<i class="bi bi-basket3-fill"></i>
				<div>
					<h3>230</h3>
					<span>Products sell</span>
				</div>
			</div>
			<div class="val-box">
				<i class="bi bi-currency-dollar"></i>
				<div>
					<h3>$677.89</h3>
					<span>This Month</span>
				</div>
			</div>
		</div>
	</section>
</body>
</html>