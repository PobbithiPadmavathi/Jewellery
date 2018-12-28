<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Payment</title>
 
 <body  ng-app="myApp" ng-controller="myCtrl">
 <%@ include file="header.jsp" %>
 <br> 
 <div class="container">
  <div class="panel-group" id="accordion">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">OTP</a>
        </h4>
      </div>
<div id="collapse1" class="panel-collapse collapse in">
  <div class="panel-body">
  <c:url value="/payment" var="pa"/>
<form:form action="${pa}" method="post" id="myForm">
 <h4>Enter a OTP:</h4><br>
 <input type="text" class="form-control" name="otp" >
 <br>
 <button class="button1" >PAY</button>
 </form:form>
   </div>
 </div>
</div>
	
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">CARD PAYMENT</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body">
		<form>
 <img src="${img}/card2.png" class="img-rounded" alt="almond" width="75px">
  <img src="${img}/card3.jpg" class="img-rounded" alt="almond" width="75px">
  <br>
   <img src="${img}/card4.jpg" class="img-rounded" alt="almond" width="75px">  
   <img src="${img}/card5.png" class="img-rounded" alt="almond" width="75px">  
 <br>  
  Card Holder Name:<br>
 <input type="text" class="form-control">
 <br>
 Credit Card Number:<br>
 <input type="text" class="form-control">
 <br>
 CVV Code:<br>
 <input type="password" class="form-control" id="password">  
 <br>
 <button class="button1" >PAY</button>  
 </form>
 </div>
      </div>
    </div>
	
	
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">NETBANKING</a>
        </h4>
      </div>
      <div id="collapse3" class="panel-collapse collapse">
        <div class="panel-body">
		<form>
 Account Number:<br>
 <input type="text" class="form-control">
 <br>
 Bank Name:<br>
 <input type="text" class="form-control">
 <br>
 Password:<br>
 <input type="password" class="form-control" id="password"> 
 <br>
 <button class="button1" >PAY</button>.</div>
      </div>
    </div>
  </div> 
</div>
    
	
</body>
</html>
 
 
 
 

