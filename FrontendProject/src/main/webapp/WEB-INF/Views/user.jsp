<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>user Page</title>
</head>
<body>
<c:url value="/adduser" var="user"/>
<form:form action="${user}" method="post" modelAttribute="user">

userId:<form:input type ="text" name="userId" path="userId"/><br>
<br>
userName:<form:input type="text" name="userName" path="userName"/><br>
<br>
address:<form:input type="text" name="address" path="address"/><br>
<br>
phoneNo:<form:input type="text" name="phoneNo" path="phoneNo"/><br>
<br>
emailId:<form:input type="email" name="emailId" path="emailId"/><br>
<br>
password:<form:input type="password" name="password" path="password"/><br>
<br>

<input type="submit" value="submit">
<input type="reset" value="cancel">

</form:form>

</body>
</html>