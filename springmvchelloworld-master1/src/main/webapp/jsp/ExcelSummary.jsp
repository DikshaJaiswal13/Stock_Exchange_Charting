<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.example.stockspring.model.ImportData, com.example.stockspring.model.User"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>File Upload Eg</title>
</head>
<body>
 
	Filename:
	<b>${fileName}</b>- Uploaded successfully
</body>
</html> --%>

 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html lang="en">
<head>

<title>Summary of Upload</title>
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

 	<%ImportData data=(ImportData)request.getAttribute("import");%> <!-- import is the model attribute name in ImportDataControllerImpl -->
 	<%SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");%>  

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
				<spring:url value="/importData" var="link1" htmlEscape="true" />
				<li><a href="${link1}">Import Data</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Manage Company<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<spring:url value="/addCompany" var="link2" htmlEscape="true" />
						<li><a href="${link2 }" style="color: white;">Add Company</a></li>
						<spring:url value="/updateCompany" var="link3" htmlEscape="true" />
						<li><a href="${link3 }" style="color: white;">Update
								Company</a></li>
						<spring:url value="/companyList" var="link4" htmlEscape="true" />
						<li><a href="${link4}" style="color: white;">List of all
								Companies</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Manage Exchange<span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<spring:url value="/importStock" var="link5" htmlEscape="true" />
						<li><a href="${link5 }" style="color: lightblue;">Register
								New Stock Exchange</a></li>
						<spring:url value="/stockList" var="link6" htmlEscape="true" />
						<li><a href="${link6 }" style="color: white;">List Stock
								Exchange</a></li>
					</ul></li>
				<spring:url value="/ipoRegistration" var="link7" htmlEscape="true" />
				<li><a href="${link7 }">Update IPO details</a></li>

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
      <h3 class="card-title text-center" align="center">Summary of Upload
       </h3>
      <hr>
     <%--  <form:form method="POST" action="/addCompany" modelAttribute="c1" class="form" role="form" autocomplete="off"> --%>
       <div class="form-group row">
        <label class="col-lg-5 col-form-label form-control-label">Company Name:</label>
        <div class="col-lg-7">
         <%-- <form:input class="form-control" type="text"
          path="companyName" placeholder="Company Name"/> --%>
          <%=data.getCompanyName() %>
        </div>
       </div>
       <div class="form-group row">
        <label class="col-lg-5 col-form-label form-control-label">Stock Exchange:</label>
        <div class="col-lg-7">
         <%-- <form:input class="form-control" type="text" path="ceo"
          placeholder="CEO"/> --%>
           <%=data.getStockExchange() %>
        </div>
       </div>
       <div class="form-group row">
        <label class="col-lg-5 col-form-label form-control-label">Total no of records
         :</label>
        <div class="col-lg-7">
        <%--  <form:input class="form-control" type="text" path="turnover"
          placeholder="Turnover"/> --%>
           <%=data.getRecords() %>
        </div>
       </div>
       <div class="form-group row">
        <label class="col-lg-5 col-form-label form-control-label">From Date:</label>
        <div class="col-lg-7">
        <%--  <form:input class="form-control" type="text" path="boardOfDirectors"
          placeholder="Board of Directors"/> --%>
           <%=sdf.format(data.getFromDate()) %>
        </div>
       </div>
       
        
       
       <div class="form-group row">
        <label class="col-lg-5 col-form-label form-control-label">To Date:</label>
        <div class="col-lg-7">
        <%--  <form:input class="form-control" type="text" path="brief"
          placeholder="Brief"/> --%>
           <%=sdf.format(data.getToDate()) %>
        </div>
       </div>
       
      <%--   <div class="form-group row">
        <label class="col-lg-5 col-form-label form-control-label">Stock Code:</label>
        <div class="col-lg-7">
         <form:input class="form-control" type="text" path="stockCode"
          placeholder="Stock Code"/>
        </div>
       </div>
       
       
       
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
								</div> --%>
    <%--   </form:form> --%>
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


