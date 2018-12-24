<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
<title></title>
</head>
<body>
<%@include file="header.jsp"%>
<section class="section contact" id="contact">
	<div class="container">
		<div class="section-head">
			
	</div> 
<form:form>
    billId:<form:input type ="text" name="billId" path="billId"/><br>
    <br>
    billName:<form:input type="text" name="billName" path="billName"/><br>
    <br>
    address:<form:input type="text" name="address" path="address"/><br>
    <br>
    phoneNo:<form:input type="text" name="phNo" path="phNo"/><br>
    <br>


    <input type="submit" value="buy">
    <input type="reset" value="cancel">
	</div>
</section>
</form:form>
</body>
</html>
