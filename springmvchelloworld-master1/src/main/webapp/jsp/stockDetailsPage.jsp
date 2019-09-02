
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
  <%@ page language="java" contentType="text/html; charset=UTF-8" 
 import="com.example.stockspring.model.User,java.util.*,com.example.stockspring.model.Stock"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Stock Details</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/companyListStyle.css" />
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="shortcut icon"
	href="http://www.brianshim.com/webtricks/wp-content/uploads/2012/11/stars_favicon.png"
	type="image/x-icon" />
	
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

<%
List stockList=(List)request.getAttribute("stockList");
System.out.println(stockList);//will print the list on the console
%>
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
 <!-- Code starts from here -->
	<h3>Table of Stock Exchange</h3>
<br>
<br>

<table>
<thead>
 <tr>
  <th>Stock Exchange Id</th>
  <th>Stock Exchange Name</th>
  <th>Brief</th>
  <th>Contact Address</th>
    <th>Remarks</th>
 </tr>
</thead>
<tbody id="myTable">
<% for(int i=0;i<stockList.size();i++){
	Stock e=(Stock)stockList.get(i);
	%>
<tr>
<td><%= e.getStockExchangeId() %></td>
<td><%= e.getStockExchangeName() %></td>
<td><%= e.getBrief() %></td>
<td><%= e.getContactAddress() %></td>
<td><%= e.getRemarks() %></td>
</tr>
<% }%>

</tbody>
</table>
 
 
 <!-- Code ends here -->
</div>
<div class="footer">
 <p>Copyright © 2019 Stock Exchange Chart-All Rights Reserved</p>
</div>
	

</body>
</html>