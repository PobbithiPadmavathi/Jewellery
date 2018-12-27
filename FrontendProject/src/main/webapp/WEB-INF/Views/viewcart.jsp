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
<table border="1px solid black" width="100%">
<tr>
<th>prodImage</th>
<th>prodID</th>
<th>prodName</th>
<th>price</th>
<th>Actions</th>
</tr>

<c1:forEach items="${cartItems}" var="cit">
<tr>
<td><img width="150px" height="150px" src="<c:url value="/resources/images/${cit.getProduct().getProdId()}.jpg"/>"></td>
<td>${cit.getProduct().getProdId()}</td>
<td>${cit.getProduct().getProdName()}</td>
<td>${cit.getPrice()}</td>
<td><a href="<c:url value="/Buy/${cit.getProduct().getProdId()}/${cit.getCartItemId()}"/>">Buy</a><a href="<c:url value="/Remove/${cit.getCartItemId()}"/>">Remove</a></td>
</tr>
</c1:forEach>
</table>
<a href="<c:url value="/Buyall"/>">Buyall</a>
<a href="<c:url value="/Removeall"/>">RemoveAll</a>
</body>
</html>