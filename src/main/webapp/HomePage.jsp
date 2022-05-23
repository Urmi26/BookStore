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
#menu .items h3{
	padding: 5px 0 0 35px;
}
#header {
	width: calc(100% - 300px);
	margin-left: 300px;
	position: relative;
}
#interface1 {
	width: calc(100% - 5px);
	position: relative;
}
#interface2 {
	width: calc(100% - 5px);
}
#footer {
	width: calc(100% - 5px);
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
}
</style>
<meta charset="ISO-8859-1">
<title>Home page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<section id="menu">
		<jsp:include page="LeftBarUserOfCategory.jsp" />
	</section>

	<section id="header">
	<jsp:include page="HeaderOfUser.jsp"/>
	</section>
	
	<section id="interface1">
		<div id="carouselExampleCaptions" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleCaptions"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="images\horror.jpg" class="d-block w-100" width="1400"
					height="350" alt="...">
				<div class="carousel-caption d-none d-md-block"></div>
			</div>
			<div class="carousel-item">
				<img src="images\img2.jpg" class="d-block w-100" width="1400"
					height="350" alt="...">
				<div class="carousel-caption d-none d-md-block"></div>
			</div>
			<div class="carousel-item">
				<img src="images\poetry-to-book.png" class="d-block w-100"
					width="1400" height="350" alt="...">
				<div class="carousel-caption d-none d-md-block"></div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
	</section>
	<section id="interface2">
		<div class="container my-4">
			<div class="row mb-4">
				<div class="col-md-6">
					<div
						class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
						<div class="col p-4 d-flex flex-column position-static">
							<h3 class="mb-0">The name of Love</h3>
							<div class="mb-1 text-muted">Nov 12</div>
							<p class="card-text mb-auto">On her 20th birthday, Mary
								Hepburn - daughter of the local magistrate - learns that she is
								to marry John Aitken, a much older man. Unhappy with this, Mary
								walks to the local moor to clear her mind. Instead, she meets
								and falls in love with the handsome Captain Ferintosh, when he
								saves her from whiskey smugglers. The situation gets even more
								complicated when Mary's father arrests Ferintosh.</p>

							<a href="#" class="stretched-link">Continue reading</a>
						</div>
						<div class="col-auto d-none d-lg-block">
							<br> <br> <img src="images\The name of Love.jfif"
								width="250" height="250">
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div
						class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
						<div class="col p-4 d-flex flex-column position-static">
							<h3 class="mb-0">The book of Life</h3>
							<div class="mb-1 text-muted">Nov 11</div>
							<p class="mb-auto">
								LOVE IS, AND ALL THERE IS, IS LOVE. A combined edition of Joseph
								Murphys three illuminating works, Write a New Name in the Book
								of Life, Love is Freedom, and Wheels of Truth, this book
								explains how you can make your conscious and subconscious work
								harmoniously, how you can find your divine companion and ensure
								bliss in your relationships, and how you can tune yourself with
								the Infinite. <br>
							</p>
							<a href="#" class="stretched-link">Continue reading</a>
						</div>

						<div class="col-auto d-none d-lg-block">
							<br> <br> <img src="images\The book of Life.jfif"
								width="250" height="250">
						</div>
					</div>
				</div>
			</div>
		</div>
		</section>
		<section id="footer">
			<jsp:include page="Footer.jsp"/>
		</section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>