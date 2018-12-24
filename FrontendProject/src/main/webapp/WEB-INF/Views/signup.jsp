<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
<title></title>
</head>
<body>
<%@include file="header.jsp"%>
<style>
input[type=email],[type=password]{
  width: 50%;
  padding: 10px;
  border: 1px solid #985d8d;
  border-radius: 4px;
  margin: 6px;
  resize: vertical;
}
</style>
<section class="section contact" id="contact">
	<div class="container">
		<div class="section-head">
			
		</div> 
    <c:url value="/adduser" var="add"/>
<form:form action="${add}" method="post" modelAttribute="user">
userId:<form:input type ="text" name="userId" path="userId"/><br>
<br>
userName:<form:input type="text" name="userName" path="userName"/><br>
<br>
address:<form:input type="text" name="address" path="address"/><br>
<br> 
phoneNo:<form:input type="text" name="phNo" path="phoneNo"/><br>
<br>
emailId:<form:input type="email" name="emailId" path="emailIid"/><br>
<br>
password:<form:input type="password" name="password" path="password"/></br>
<br>
<input type="submit" value="submit">
<input type="reset" value="cancel">
</form:form>
</div>
</section>
</body>
</html>

