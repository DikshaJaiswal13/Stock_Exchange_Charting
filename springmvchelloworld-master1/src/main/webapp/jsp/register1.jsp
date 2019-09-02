<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Register</title>
 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"> 
<link rel="shortcut icon"
	href="http://www.brianshim.com/webtricks/wp-content/uploads/2012/11/stars_favicon.png"
	type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="./css/userRegisterStyle.css">
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- <script type="text/javascript" src="./script/registration.js"></script>  -->

	<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/jquery-migrate-1.4.1.min.js"></script>
<script src="./js/jquery-ui-1.10.3.custom.min.js"></script>

<script>
function avail() {
	$.ajax({
		url : "checkAdminid",
		data : {
			admin : $("#AsID6").val()
		},
		success : function(data) {
			var m = data;
			if (m == "Username is Available") {
				/*alert("In avail");*/
				alert("Username available");
			}
			if (m == "Username is taken") {
				alert("Username already associated with another account");
				$("#AsID6").val("");
			}
		},
		error : function() {
			alert("Error");
		}
	});
}

function avail1() {
	$.ajax({
		url : "checkAdminid",
		data : {
			admin : $("#AsID7").val()
		},
		success : function(data) {
			var m = data;
			if (m == "Username is Available") {
				/*alert("In avail");*/
				//alert("In avail");
			}
			if (m == "Username is taken") {
				alert("Username already associated with another account");
				$("#AsID7").val("");
			}
		},
		error : function() {
			alert("Error");
		}
	});
}

</script>










	<!-- <script>
	function myFunction() {
		var username = $("#username").val();

		var password = $("#password").val();
		var email = $("#email").val();
		var mobilenumber = $("#mobilenumber").val();
		if (username == '' || password == '' || email == '' || mobilenumber == '') {
		alert("Please fill all fields...!!!!!!");
		} else if ((password.length) < 8) {
		alert("Password should atleast 8 character in length...!!!!!!");
		}
		else if ((mobilenumber.length) < 8) {
			alert("Mobilenumber should be 10 digits...!!!!!!");
			}
		else{
			alert("You have Successfully Registered.....");
		}
		};
		

	</script>
 -->
</head>
<body>
	<div class=" container login-container">
 <div class="row d-flex justify-content-center align-items-center">
  <div class="col-md-2"></div>
   <div class="col-md-8 login-form-1 ">
    <h2 class="display-3">Register Form</h2>
    
    <hr>
   <div class="row">
   <div class="col-md-3"></div>
  <div class="col-md-6">
  <ul class="nav nav-pills">
    <li class="active"><a data-toggle="pill" href="#home">Register as Admin</a></li>
    <li><a data-toggle="pill" href="#menu1">Register as User</a></li>
   
  </ul>
  </div>
  <div class="col-md-3"></div>
 </div>
  
  <div class="tab-content">
					<div id="home" class="tab-pane fade in active">

						<!-- Form1 goes here -->
						<div class="space"></div>
						<form:form method="POST" action="/register1" modelAttribute="r1"
							class="form" role="form" autocomplete="off">
							<div class="form-group">
								<div class="col-md-10" style="padding-left: 0%;">
									<form:input placeholder="Username" type="text"
										class="form-control" path="username" id="AsID6"
										required="true" />

								</div>
								<div class="col-md-2" style="padding-right: 0%;">
									<button type="button" class="btn btn-primary" onclick="avail()">Check</button>

									<div class="space1"></div>
								</div>
							</div>


							<%-- 	<div class="col-lg-6">
											<form:input class="form-control" type="text" path="username"
												required="required" id="AsID6" />
										</div>
										<div class="col-lg-2">
											<button type="button" class="btn btn-success"
												onclick="avail()">Check</button>
										</div> --%>



							<div class="form-group">
								<form:input placeholder="Password" type="password"
									class="form-control" path="password" id="password1"
									required="true" />
							</div>
							<div class="form-group">
								<form:input placeholder="Email" type="email"
									class="form-control" path="email" id="email1" required="true" />
							</div>


							<div class="form-group">
								<form:input type="number" placeholder="Mobile Number"
									class="form-control" path="mobilenumber" id="mobilenumber1"
									required="true" />
							</div>
							

							<div class="row">
							

								<div class="col-md-6">
									<div class="form-group" id="f33">
										<button type="submit" class="btn btn-primary" id="submit1">Create
											Account</button>

									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group" id="f22">
										<button type="reset" class="btn btn-primary" id="f2">Reset</button>
									</div>
								</div>
							</div>
						</form:form>

					</div>
    <div id="menu1" class="tab-pane fade">
      
       <div class="space"></div>
       <!-- Form 2 starts here -->
      <form:form method="POST" action="/register2" modelAttribute="r1" class="form" role="form" autocomplete="off"> <!-- onsubmit="myFunction()"> -->
     <div class="form-group">
     <div class="col-md-8" style="padding-left:0%;"> 
     	<form:input  placeholder="Username" type="text" class="form-control" path="username" id="AsID7" required="true"/>
     </div>
     <div class="col-md-2" style="padding-right:0%;">
     	<button type="button" class="btn btn-primary" onclick="avail1()">Check</button>
     </div>
												
			<div class="space1"></div>
     </div>
     <div class="form-group">
      <form:input  placeholder="Password" type="password" class="form-control" path="password" id="password" required="true"/>
     </div>
     <div class="form-group">
      <form:input  placeholder="Email"  type="email" class="form-control" path="email" id="email" required="true"/>
     </div>
   
     <div class="form-group">
      <form:input type="number" placeholder="Mobile Number" class="form-control" path="mobilenumber" id="mobilenumber" required="true"/>
     </div>
     <%-- <div class="form-group">
      <form:input type="text" class="form-control" path="confirmed" placeholder="Enter OTP" />
     </div> --%>
    
    <!--  <div class="form-group">
      <button type="submit" class="btn btn-primary btn-block">Create Account</button>
     </div> -->
     
     <div class="row">
						

						<div class="col-md-6">
							<div class="form-group" id="f33">
								<button type="submit" class="btn btn-primary" id="submit1">Create
									Account</button>

							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group" id="f22">
								<button type="reset" class="btn btn-primary" id="f2">Reset</button>
							</div>
						</div>
					</div>
    </form:form>
     
    </div>
    
  </div>

    <!-- -->
   </div>
  <div class="col-md-2"></div>
 </div>
 </div>
</body>
</html> 



