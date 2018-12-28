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
				<h2></h2>
				<p></p>
			</div>
		</div>
</section>
<div class="span11">

	<div class="col-md-12  col-sm-12  col-xs-8 "
	style="background: #fff; padding: 30px;">

	<div class="col-md-6 col-sm-6 col-xs-12">
		<h3 class="text-center">Billing Address</h3>

		<hr>
			<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" path="user.emailIid" name="email" class="form-control input-sm"					
				placeholder="Emailid" disabled="true"/> 
			</div>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="mono" path="user.phoneNo" disabled="true"
			class="form-control input-sm" placeholder="Mobile no"/>
			</div>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" path="user.userName" name="name" class="form-control input-sm"					
				placeholder="Name" disabled="true"/> 
			</div>
		</div>

		

		<div class="col-xs-12 col-sm-4 col-md-4">
			<div class="form-group">
				<form:input type="text" name="country" disabled="true"
					class="form-control input-sm" placeholder="country" path="user.billing.country" />
			</div>
		</div>
		
		
		<input class="coupon_question" type="checkbox" name="coupon_question"
			value="1"> <span class="item-text">Check Shipping
			address</span>
			
	</div>


	<div class="col-md-6 shipping col-sm-6 col-xs-12">
		<h3 class="text-center">shipping Address</h3>

		<hr>
	<c:url value="/orderConfirm" var="a"/>
		<form:form action="${a}" method="post" modelAttribute="shippingAddress">

		<div class="col-xs-6 col-sm-6 col-md-6">
			<div class="form-group">
				<form:input type="text" name="name" 
					class="form-control input-sm" placeholder="Name" path="shipName"/>
			</div>
		</div>

		<div class="col-xs-12 col-sm-12 col-md-12">
			<div class="form-group">
				<form:input type="text" class="form-control" placeholder="Address" path="address"/>                                                
                                           
			</div>
		</div>

		<div class="col-xs-12 col-sm-4 col-md-4">
			<div class="form-group">
				<form:input type="text"
					class="form-control input-sm" placeholder="PhoneNo" path="phno"/>
			</div>
		</div>
		
		
		<div class="col-md-12">
		<input type="submit" class="btn btn-primary pull-right" value="Continue">
	</div>
	
</form:form>   
</div>
</div></div>

</body>
</html>