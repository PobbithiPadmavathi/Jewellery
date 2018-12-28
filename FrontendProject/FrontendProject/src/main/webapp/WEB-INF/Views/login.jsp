<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Login Page</title>
</head>
<body>
<%@include file="header.jsp" %>
<section class="section contact" id="contact">
		<div class="container">
			<div class="section-head">
				
			</div> 
<c:url value="/j_spring_security_check" var="login"/>
<form:form action="${login}" method="post" target="_blank">

emailId:<input type ="text" name="j_username"/><br>
<br>
Password:<input type="password" name="j_password"/><br>
<br>
<input type="submit" value="Login">
<input type="reset" value="cancel">

</form:form>

</div>
</section>

</body>
</html>