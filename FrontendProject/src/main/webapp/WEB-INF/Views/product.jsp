<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Product Page</title>
</head>
<body>
<%@include file="header.jsp" %>
<section class="section contact" id="contact">
		<div class="container">
			<div class="section-head">
				<h2>Product</h2>
				<p>Products Details</p>
			</div>
<c:url value="/addproduct" var="prod"/>
<form:form action="${prod}" method="post" modelAttribute="product" enctype="multipart/form-data">

prodId:<form:input type ="text" name="prodId" path="prodId"/><br>
<br>
prodName:<form:input type="text" name="prodName" path="prodName"/><br>
<br>
price:<form:input type="text" name="price" path="price"/><br>
<br>
quantity:<form:input type="text" name="quantity" path="quantity"/><br>
<br>
description:<form:input type="text" name="description" path="description"/><br>
<br>

<form:input type="file" value="uploadfile" path="pimg"/>

<input type="submit" value="AddProduct">
<input type="reset" value="cancel">

</form:form>

</div>
</section>

<table>
<tr>
<th>prodImage</th>
<th>prodID</th>
<th>prodName</th>
<th>price</th>
<th>quantity</th>
<th>description</th>
</tr>

<c1:forEach items="${products}" var="prod">
<tr>
<td><img width="150px" height="150px" src="<c:url value="/resources/images/${prod.getProdId()}.jpg"/>"></td>
<td>${prod.getProdId()}</td>
<td>${prod.getProdName()}</td>
<td>${prod.getPrice()}</td>
<td>${prod.getQuantity()}</td>
<td>${prod.getDescription()}</td>
<td><a href="<c:url value="/editproduct/${prod.getProdId()}"/>">Edit</a></td>
<td><a href="<c:url value="/deleteproduct/${prod.getProdId()}"/>">Delete</a></td>
</tr>
</c1:forEach>
</table>
</body>
</html>