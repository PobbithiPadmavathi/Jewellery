<%@taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
<c:url value="/resources/css" var="css"></c:url>
<c:url value="/resources/js" var="js"></c:url>
<c:url value="/resources/images" var="images"></c:url>
<meta charset="UTF-8">
<title>Golden Jewellery</title>


<link rel="stylesheet" href="${css}/style.css">


</head>

<body>

	<header id="home">
		<div class="container">
			<div class="brand">
				
				<img
					src="https://vignette4.wikia.nocookie.net/joke-battles/images/4/41/Infinity_Logo_Gold.png/revision/latest?cb=20151230235753"
					style="width: 40px" />
				<p>Golden Jewellery</p>
			</div>
		</div>
		<!-- / container -->

		<nav>
			<ul>
				<li><a href="#home">Home</a></li>
				<li><a href="#designer-sec">Designer Jewellery</a></li>
				<c1:if test="${pageContext.request.userPrincipal.name!=null}">
	  			 <security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="<c:url value="/Category"/>">Category</a></li>
				<li><a href="<c:url value="/Product"/>">Product</a></li>
				<li><a href="<c:url value="/Supplier"/>">Supplier</a></li>
				</security:authorize>
				</c1:if>
				
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
				<c1:if test="${pageContext.request.userPrincipal.name==null}">
	   			<li><a href="<c:url value="/login"/>">Login</a></li>
	   			<li><a href="<c:url value="/user"/>">Signup</a></li>
	   			</c1:if>
				<c1:if test="${pageContext.request.userPrincipal.name!=null}">
	   			<li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
	   			</c1:if>
			</ul>
		</nav>

		<div class="main-background">
			<div class="container">
				<div class="main-content">
					<h1>Golden Jewellery</h1>
					<h2>24 Caratage Yellow Gold Bracelet</h2>
					<p>Shope the latest designs from new brands</p>
					<a href="">- View Products</a>
				</div>
			</div>
		</div>

	</header>
	<!-- / header -->



	<!-- ========== NEW COLLECTION ========== -->

	<section class="section" id="new-sec">
		<div class="new-collection">

			<div class="left"></div>

			<div class="right"></div>

			<div class="middle">
				<div class="mid-title">
					<h2>
						New <br />Collection
					</h2>
					<a href="#home">View products</a>
				</div>
				<!-- / mid-title -->
			</div>

		</div>
	</section>

	<!-- ========== DESIGNER COLLECTION ========== -->

	<section class="section designer-collection clearfix" id="designer-sec">
		<div class="container">
			<div class="section-head"></div>
		</div>
		<!-- / container -->
	</section>


	<!-- ========== SECTION INSTAGRAM ========== -->

	<section class="section gallery cleafix">

		<div class="container">
			<div class="section-head">
				<h2>Designer Gallery</h2>
				<p>Explore Design</p>
			</div>
			<ul class="gallery-showcase">

				<li>
					<figure>
						<img
							src="https://static.pexels.com/photos/265856/pexels-photo-265856.jpeg"
							alt="" />
					</figure>
				</li>

				<li>
					<figure>
						<img
							src="https://static.pexels.com/photos/230290/pexels-photo-230290.jpeg"
							alt="" />
					</figure>
				</li>

				<li>
					<figure>
						<img
							src="https://static.pexels.com/photos/248077/pexels-photo-248077.jpeg"
							alt="" />
					</figure>
				</li>

			</ul>
		</div>

	</section>

	<!-- ========== ABOUT ========== -->

	<section class="section about" id="about">
		<div class="section-head">
			<h2>About Us</h2>
			<p>Learn more about us and quality of our products</p>
		</div>


		<div class="wrapper clearfix">

			<div class="left"></div>

			<div class="right">
				<div class="text">
					<h3>Who we are</h3>
					<br />
					<p>
						It is a long established fact that a reader will be distracted by
						the readable content of a page when looking at its layout. <br />
						<br /> The point of using Lorem Ipsum is that it has a
						more-or-less normal distribution.
					</p>
				</div>
			</div>



		</div>
		<!-- / wrapper -->

	</section>

	<!-- ========== CONTACT ========== -->

	<section class="section contact" id="contact">
		<div class="container">
			<div class="section-head">
				<h2>Contact Us</h2>
				<p>Contact Us for More Details</p>
			</div>

			<form>
				<input type="text" name="firstname" placeholder="Your First Name">

				<input type="text" name="lastname" placeholder="Your Last Name">

				<input type="text" name="phone" placeholder="Your Phone Number">

				<input type="text" name="email" placeholder="Your Email Address">

				<textarea name="message" rows="8" placeholder="Your Message"></textarea>
				<br /> <input type="button" value="Send">
			</form>

		</div>
	</section>

	<!-- ========== FOOTER ========== -->

	<div class="bottom-links">
		<div class="container">
			<ul>
				<li><a href="#home">Support</a></li>
				<li><a href="#home">FAQ</a></li>
				<li><a href="#home">Designers</a></li>
				<li><a href="#home">About</a></li>
				<li><a href="#home">Contact</a></li>
			</ul>
		</div>
	</div>

	<footer>
		<div class="container">
			<small>&copy; 2017 Golden Jewelry | Coded By Jak Ashuraliev</small>
		</div>
	</footer>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>



	<script src="${js }/index.js"></script>




</body>

</html>
