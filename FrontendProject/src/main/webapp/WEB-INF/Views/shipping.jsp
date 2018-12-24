<%@taglib prefix="c" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
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
    shipId:<form:input type ="text" name="shipId" path="shipId"/><br>
    <br>
    shipName:<form:input type="text" name="shipName" path="shipName"/><br>
    <br>
    address:<form:input type="text" name="address" path="address"/><br>
    <br>
    phoneNo:<form:input type="text" name="phNo" path="phno"/><br>
    <br>


    <input type="submit" value="submit">
    <input type="reset" value="cancel">
    </form:form>
	</div>
</section>
  </body>
  </html>
