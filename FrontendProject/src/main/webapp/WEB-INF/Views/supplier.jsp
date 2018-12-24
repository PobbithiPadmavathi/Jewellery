<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Supplier Page</title>
</head>
<body>
<%@include file="header.jsp" %>
<section class="section contact" id="contact">
		<div class="container">
			<div class="section-head">
				<h2>Supplier</h2>
				<p>Suppliers Details</p>
			</div>
<c:url value="/addsupplier" var="sup"/>
<form:form action="${sup}" method="post" modelAttribute="supplier">

supId:<form:input type ="text" name="supId" path="supId"/><br>
<br>
supName:<form:input type="text" name="supName" path="supName"/><br>
<br>
address:<form:input type="text" name="address" path="address"/><br>
<br>
phoneNo:<form:input type="text" name="phoneNo" path="phoneNo"/><br>
<br>


<input type="submit" value="submit">
<input type="reset" value="cancel">

</form:form>

</div>
</section>

<table>
<tr>
<th>supId</th>
<th>supName</th>
<th>address</th>
<th>phoneNo</th>
</tr>
<c1:forEach items="${suppliers}" var="sup">
<tr>
<td>${sup.getSupId() }</td>
<td>${sup.getSupName() }</td>
<td>${sup.getAddress() }</td>
<td>${sup.getPhoneNo() }</td>
<td><a href="<c:url value="/editsupplier/${sup.getSupId() }"/>">Edit</a></td>
<td><a href="<c:url value="/deletesupplier/${sup.getSupId() }"/>">Delete</a></td>
</tr>
</c1:forEach>

</table>
</body>
</html>