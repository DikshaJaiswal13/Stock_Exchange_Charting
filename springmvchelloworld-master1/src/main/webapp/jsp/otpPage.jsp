   <%@ page language="java" contentType="text/html; charset=UTF-8" import="com.example.stockspring.model.User" 
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html lang="en">
<head>

<title>OTP Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="shortcut icon"
	href="http://www.brianshim.com/webtricks/wp-content/uploads/2012/11/stars_favicon.png"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="./css/userLoginStyle.css">

<!-- <meta charset="ISO-8859-1"> -->

</head>
<body>

<div class="container">
	<div class="row" style="padding-top:25%;">
	<div class="col-md-3"></div>
	<div class="col-md-6">

 <form:form method="POST" action="/otpController" modelAttribute="c1" class="form" role="form" autocomplete="off">

	<%-- Enter otp: <form:input class="form-control" type="text" path="otpVerification" placeholder="Enter OTP"/>&nbsp;&nbsp;
	<input type="submit" class="btn btn-primary" value="Verify">
	 --%>
	 <div class="form-group row">
        <h2><label class="col-lg-5 col-form-label form-control-label">Enter otp:</label></h2>
        <div class="col-lg-7">
        <form:input class="form-control" type="text" path="otpVerification" placeholder="Enter OTP"/><br><br>
	<input type="submit" class="btn btn-primary" value="Verify">
        </div>
       </div>
       
	
	</form:form>
	</div>
	<div class="col-md-3"></div>
	</div>
	</div>
	
</body>
</html>