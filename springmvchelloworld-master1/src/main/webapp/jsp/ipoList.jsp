<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
 import="com.example.stockspring.model.User,java.util.*,com.example.stockspring.model.IpoPlanned"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Company</title>

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
List ipoList=(List)request.getAttribute("ipoList");
System.out.println(ipoList);//will print the list on the console
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
				<spring:url value="/ipoList" var="url1" htmlEscape="true" />
				<li><a href="${url1}">IPO's</a></li>
				
					
					<spring:url value="/comparecompany" var="url2" htmlEscape="true" />
				<li><a href="${url2}">Compare Company</a></li>
				
			<%-- 	<spring:url value="/comparesectors" var="url3" htmlEscape="true" />
				<li><a href="${url3}">Compare Sectors</a></li>
					
					
					
					
					
					
				<spring:url value="/other" var="url4" htmlEscape="true" />
				<li><a href="${url4 }">Other</a></li> --%>

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
	<h3>IPO Details</h3>
<br>
<br>

<table>
<thead>
 <tr>
  <th>Company Code</th>
  <th>Stock Exchange</th>
  <th>Price Per Share(INR)</th>
  <th>Total shares</th>
  <th>Open Date Time</th>
  <th>Remarks</th>
 
 </tr>
</thead>

<tbody id="myTable">
<% for(int i=0;i<ipoList.size();i++){
	IpoPlanned e=(IpoPlanned)ipoList.get(i);
	%>
<tr>
<td><%= e.getCompanyCode() %></td>
<td><%= e.getStockExchange() %></td>
<td><%= e.getPricePerShare() %></td>
<td><%= e.getNoOfShares() %></td>
<td><%= e.getOpenDateTime() %></td>
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
 