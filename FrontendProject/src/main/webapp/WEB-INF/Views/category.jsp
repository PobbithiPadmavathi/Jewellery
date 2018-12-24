<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Category Page</title>
<%@include file="header.jsp" %>
</head>
<body>
<section class="section contact" id="contact">
		<div class="container">
			<div class="section-head">
				<h2>Category</h2>
				<p>Category Details</p>
			</div>
<c:url value="/addcat" var="cat"/>
<form:form action="${cat}" method="post" modelAttribute="category">

catId:<form:input type ="text" name="catId" path="catId"/><br>
<br>
catName:<form:input type="text" name="catName" path="catName"/><br>
<br>
<input type="submit" value="Login">
<input type="reset" value="cancel">

</form:form>

</div>
</section>

<table>
<tr>
<th>CatID:</th>
<th>CatName:</th>
</tr>
<c1:forEach items="${categories}" var="cat">
<tr>
<td>${cat.getCatId()}</td>
<td>${cat.getCatName()}</td>
<td><a href="<c:url value="/editcategory/${cat.getCatId()}"/>">Edit</a></td>
<td><a href="<c:url value="/deletecategory/${cat.getCatId()}"/>">Delete</a></td>
</tr>
</c1:forEach>
</table>
</body>
</html>