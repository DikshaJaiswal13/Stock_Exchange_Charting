 <%@ page language="java" contentType="text/html; charset=UTF-8" import="com.example.stockspring.model.User" 
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html lang="en">
<head>

<title>Reset Password</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="importStockPageStyle.css" />
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="shortcut icon"
	href="http://www.brianshim.com/webtricks/wp-content/uploads/2012/11/stars_favicon.png"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="./css/addCompanyStyle.css">

<!-- <script src="./js/password.js"></script>
<link rel="stylesheet" type="text/css" href="./css/password.css"> -->



<script type="text/javascript">

function myFunction() {
	  var x = document.getElementById("password-field");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}








function Validate() {
var password = document.getElementById("password").value;
var confirmPassword = document.getElementById("confirmPassword").value;
if (password != confirmPassword) {
 alert("Password and Confirm Password do not match.");
 return false;
}
return true;
}

$(".toggle-password").click(function() {

	  $(this).toggleClass("fa-eye fa-eye-slash");
	  var input = $($(this).attr("toggle"));
	  if (input.attr("type") == "password") {
	    input.attr("type", "text");
	  } else {
	    input.attr("type", "password");
	  }
	});






</script>
</head>
<body style="background-image: linear-gradient(to right, white, cyan);">

<div class=" container login-container">
 <div class="row d-flex justify-content-center align-items-center">
  <div class="col-md-8 login-form-1 ">
   <h3 class="display-3">Reset password</h3>
   <form:form action="/changepassword" modelAttribute="pass" method="post">
   <br>Email<br>
   <form:input type="type" path="email" value="${b}"
    class="form-control" readonly="true"/>
    <!-- style="background-color: #BDBDBD;" /> -->
   <br>New Password<br>
   
   <!--  <div class="col-md-6">
              <input id="password-field" type="password" class="form-control" name="password" value="secret">
              <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
            </div> -->
   
   
   
   
   
   
   
   
   
   
   
   
   
   
    <form:input id="password-field" type="password" path="password" class="form-control"
    required="required" />
     <!-- <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span> -->
    
    <input type="checkbox" onclick="myFunction()">Show Password
    
    <br>
  <!--  <div class="form-group">
    <label><font size="4">Confirm Password</font></label> <input
     id="confirmPassword" name="confirmPassword" type="password" class="form-control"
       />
   </div> -->
   <br>
   <div class="form-group">
    <input type="submit" class="btn btn-primary btn-lg" value="Login" />	
    
   <!--  onClick="Validate()"  -->
   </div>
  </form:form>
 </div>
 </div>
</div>
</body>
</html>