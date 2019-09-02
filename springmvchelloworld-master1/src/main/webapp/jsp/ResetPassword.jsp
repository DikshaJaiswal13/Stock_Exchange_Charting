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

<script src="./js/jquery-3.3.1.min.js"></script>
<script src="./js/jquery-migrate-1.4.1.min.js"></script>
<script src="./js/jquery-ui-1.10.3.custom.min.js"></script>
<script>
function validate() {
	$.ajax({
		url : "checkValidation",
		data : {
			uname : $("#uname").val(),
			pass : $("#pass").val()
		},
		success : function(data) {
			var m = data;
			if (m == "Right") {
				/*alert("In avail");*/
				//alert("In avail");
			}
			if (m == "Wrong") {
				alert("Wrong username or password! Please try again ");
				$("#uname").val("");
				$("#pass").val("");
				$("#uname").focus();
			}
		},
		error : function() {
			alert("Error");
		}
	});
}
</script>
</head>



<body>

	<div class="container">
		<!-- Code starts from here -->
		<div class="row">
			<div class="col-sm-3"></div>
			<div>
				<div class="col-sm-6">
					<div class="card">
						<div class="card-body">
							<h3 class="card-title text-center" align="center">Reset Password</h3>
							<hr>
							<form:form class="form" role="form" autocomplete="off" action="/reset" modelAttribute="e1">
								<div class="form-group row">
									<label class="col-lg-4 col-form-label form-control-label">Username:</label>
									<div class="col-lg-8">
										<form:input type="password" class="form-control"  path="uname" required="required" id="uname"/>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-lg-4 col-form-label form-control-label">Original Password:</label>
									<div class="col-lg-8">
										<form:input type="password" class="form-control"  path="oldpass" required="required" id="pass"/>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-lg-4 col-form-label form-control-label">New Password:</label>
									<div class="col-lg-8">
										<form:input class="form-control" type="password" path="newpass" required="required" onfocus="validate()"/>
									</div>
								</div>
								<div class="form-group row">
									<label class="col-lg-4 col-form-label form-control-label"></label>
									<div class="col-lg-8">
										<div class="col-lg-2">
							
										</div>
										<div class="col-lg-3">
											<input type="submit" class="btn btn-primary"
												value="Reset"/>
										</div>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
				<div class="col-sm-3"></div>
			</div>
		</div>
		</div>



</body>
</html>