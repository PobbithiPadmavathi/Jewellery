<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en" >
<head>
  
  <%@include file="header.jsp" %>
  
</head>


<body>
<section class="section contact" id="contact">
		<div class="container">
			<div class="section-head">
				<h2>Category</h2>
				<p>Category Details</p>
			</div>
<h4>BILLING</h4>
<table border=1px solid grey>
<tr>
<th>BillID</th>
<th>BillName</th>
<th>Address</th>
<th>PhoneNo</th>
</tr>

<tr>
<td>${billing.getBillId()}</td>
<td>${billing.getBillName()}</td>
<td>${billing.getAddress()}</td>
<td>${billing.getPhNo()}</td>
</tr>
</table>
<br>
<br>

<h4>SHIPPING</h4>
<table border=1px solid grey>
<tr>
<th>Shipping-ID</th>
<th>ShipName</th>
<th>Address</th>
<th>PhoneNo</th>
</tr>

<tr>
<td>${shippingAddress.getShipId()}</td>
<td>${shippingAddress.getShipName()}</td>
<td>${shippingAddress.getAddress()}</td>
<td>${shippingAddress.getPhno()}</td>
</tr>
</table>
<br>
<br>

<h4>PRODUCT</h4>
<table border=1px solid grey>
<tr>
<th>ProductImage</th>
<th>ProductId</th>
<th>ProductName</th>
<th>ProductDesc</th>
<th>ProductPrice</th>
<th>ProductQuantity</th>
</tr>

<c1:if test="${prot!=null}">
<tr>
<td><img src="<c:url value="/resources/images/${prot.getProdId()}.jpg"/>" width=150px height=200px></td>
<td>${prot.getProdId()}</td>
<td>${prot.getProdName()}</td>
<td>${prot.getDescription()}</td>
<td>${prot.getPrice()}</td>
<td>${prot.getQuantity()}</td>
</tr>
</c1:if>

<c1:if test="${prot==null}">
 <c1:forEach items="${cartItems}" var="c">
 <tr>
  <td> <img src="<c:url value="/resources/images/${c.getProduct().getProdId()}.jpg"/>" width="100px" height="100px">
  <td> ${c.getProduct().getProdId()}</td>
  <td> ${c.getProduct().getProdName()}</td>
  <td> ${c.getProduct().getDescription()}</td>
   <td>${c.getProduct().getPrice()}</td>
   <td>${c.getProduct().getQuantity()}</td>
  <td> ${c.getProduct().getCategory().getCatName()}</td>
  <td> ${c.getProduct().getSupplier().getSupName()}</td>
 </tr>
 </c1:forEach>
</c1:if>
</table>
<button class="btn submits sign-up" ><a href="<c:url value='/previous'/>">PREVIOUS</a></button>
 <button class="btn submits sign-up"><a href="<c:url value="/pay"/>">PAY</a></button>
</div>
</body>
</html>