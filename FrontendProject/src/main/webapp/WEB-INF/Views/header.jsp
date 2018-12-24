<%@taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				<li><a href="<c:url value="/Category"/>">Category</a></li>
				<li><a href="<c:url value="/Product"/>">Product</a></li>
				<li><a href="<c:url value="/Supplier"/>">Supplier</a></li>
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
			</ul>
		</nav>
</header>
</body>
</html>