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
				<li><a href="<c:url value="/"/>">Home</a></li>
				<li><a href="<c:url value="/"/>">Designer Jewellery</a></li>
				<c1:if test="${pageContext.request.userPrincipal.name!=null}">
	  			 <security:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="<c:url value="/Category"/>">Category</a></li>
				<li><a href="<c:url value="/Product"/>">Product</a></li>
				<li><a href="<c:url value="/Supplier"/>">Supplier</a></li>
				</security:authorize>
				</c1:if>
				
				<li><a href="<c:url value="/"/>">About</a></li>
				<li><a href="<c:url value="/"/>">Contact</a></li>
				<c1:if test="${pageContext.request.userPrincipal.name==null}">
	   			<li><a href="<c:url value="/login"/>">Login</a></li>
	   			<li><a href="<c:url value="/user"/>">Signup</a></li>
	   			</c1:if>
				<c1:if test="${pageContext.request.userPrincipal.name!=null}">
	   			<li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>
	   			</c1:if>
	   			<li><a href="<c:url value="/viewcart"/>"><i class="fa fa-shopping-cart"></i></a></li>
			
			</ul>
		</nav>
</header>
</body>
</html>