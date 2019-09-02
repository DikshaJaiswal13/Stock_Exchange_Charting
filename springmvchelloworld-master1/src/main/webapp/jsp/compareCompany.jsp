 <%@ page language="java" contentType="text/html; charset=UTF-8" import="com.example.stockspring.model.User" 
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html lang="en">
<head>

<title>Add Company</title>
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
<link rel="stylesheet" type="text/css" href="./css/addCompanyStyle.css">

<script type="text/javascript">
	function confirm_alert(node){
		return confirm("Are you sure you want to logout?")
	}
	
	</script>

</head>
<body>

 <%response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader("Expires", 0);
%>

<% User user=(User)request.getAttribute("user"); %>

<c:if test="${sessionScope.user.id==null }">
<%response.sendRedirect("/login"); %>
</c:if>

 
	<div class="header">
		<nav class="navbar navbar-inverse">
		<div class="container-fluid" style="background: black">
			<div class="navbar-header">
				<!--  <img alt="logo" src="logo.png"> -->
			</div>
			<div class="navbar-header">
				<a class="navbar-brand" href="#" style="color: white"><b>&nbsp;Stock
						Exchange Chart</b></a>
			</div>
			<ul class="nav navbar-nav">
				<spring:url value="/ipoList" var="url1" htmlEscape="true" />
				<li><a href="${url1}">IPO's</a></li>
				
					
					<spring:url value="/comparecompany" var="url2" htmlEscape="true" />
				<li><a href="${url2}">Compare Company</a></li>
				
				</ul>
			
			
			
			<div class="nav navbar-nav navbar-right" id="logout">
			
			
				
					<form action="/logout" method="get">
					<button type="submit" class="btn navbar-btn btn-default" onclick="return confirm_alert(this);">
					<span class="glyphicon glyphicon-log-out"></span> Logout</button>
					</form>
			</div>
		</div>
		</nav>
	</div>
	
	<div class="container">
	<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
	 <div id="login-box">
	<div class="card">
     <div class="card-body">
      <h3 class="card-title text-center" align="center">Create New Company
       </h3>
      <hr>
      <form:form method="POST" action="/showgraph" modelAttribute="c1" class="form" role="form" autocomplete="off">
      
      	  <div class="form-group row">
        <label class="col-lg-5 col-form-label form-control-label">Select Company1:</label>
       <div class="col-lg-7">
        <form:select class="form-control" path="companyCode" id="companyCode" required="true">
                        <option value="" disabled selected style="display: none;">Select Company1</option>
                        <c:forEach items="${companyList}" var="sl">
                        <form:option value="${sl.companyId}">${sl.companyId}-${sl.companyName}</form:option>
                        </c:forEach>
    					</form:select> 
    					
        </div>
       </div>
       
       
       
       <div class="form-group row">
        <label class="col-lg-5 col-form-label form-control-label">Select Company2:</label>
        <div class="col-lg-7">
        <form:select class="form-control" path="companyCode" id="companyCode" required="true">
                        <option value="" disabled selected style="display: none;">Select Company2</option>
                        <c:forEach items="${companyList}" var="sl">
                        <form:option value="${sl.companyId}">${sl.companyId}-${sl.companyName}</form:option>
                        </c:forEach>
    					</form:select> 
    					
        </div>
       </div>
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       <div class="space1"></div>
        <div class="form-group row">
									<!-- <label class="col-lg-4 col-form-label form-control-label"></label> -->
									<!--   <div class="col-lg-8"> -->
									<div class="col-lg-6">
										<input type="reset" class="btn btn-secondary" value="Cancel"
											id="cancel">
									</div>
									<div class="col-lg-6">
										<input type="submit" class="btn btn-primary"
											value="Save Changes">
									</div>
									<!--  </div> -->
								</div>
      </form:form>
     </div>
     </div>
    </div>
    </div>
    <div class="col-md-3"></div>
    </div>
    </div>
    <div class="footer">
 <p>Copyright © 2019 Stock Exchange Chart-All Rights Reserved</p>
</div>

</body>
</html>

       
      
      