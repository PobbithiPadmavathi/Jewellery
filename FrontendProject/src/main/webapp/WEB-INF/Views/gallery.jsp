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
<%@include file="header.jsp" %>

<body>
<section class="section gallery cleafix">

		<div class="container">
			<div class="section-head">
				<h2>Designer Gallery</h2>
				<p>Explore Design</p>
			</div>
			<ul class="gallery-showcase">
				<c1:forEach items="${products}" var="prod">
				<li>
					<figure>
						<img width="150px" height="150px" src="<c:url value="/resources/images/${prod.getProdId()}.jpg"/>">
						
					</figure>
					<p>${prod.getProdName() }</p>
					<a href="<c:url value="/addtocart/${prod.getProdId()}"/>">Add to cart</a>
				</li>
				
				</c1:forEach>

<!-- 				<li> -->
<!-- 					<figure> -->
<!-- 						<img -->
<!-- 							src="https://static.pexels.com/photos/230290/pexels-photo-230290.jpeg" -->
<!-- 							alt="" /> -->
<!-- 					</figure> -->
<!-- 				</li> -->

<!-- 				<li> -->
<!-- 					<figure> -->
<!-- 						<img -->
<!-- 							src="https://static.pexels.com/photos/248077/pexels-photo-248077.jpeg" -->
<!-- 							alt="" /> -->
<!-- 					</figure> -->
<!-- 				</li> -->

			</ul>
		</div>

	</section>
	<%@include file="footer.jsp" %>
	</body>
	</html>
