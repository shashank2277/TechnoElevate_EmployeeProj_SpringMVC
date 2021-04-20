<%@page import="org.te.springmvc.beans.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<% String msg = (String) request.getAttribute("msg");
 EmployeeBean bean =(EmployeeBean) request.getAttribute("data"); %>
 

<%@ include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% if (msg != null && !msg.isEmpty()){ %>
	<h1 ><%= msg %></h1>
	<% }  %>


	<fieldset>
		<legend>Search</legend>

		<form action="./search" method="get">
			<table>
				<tr>
					<td>Enter user ID</td>
					<td>:</td>
					<td><input type="number" name="id"></td>
				</tr>
				<tr>
					<td><input type="submit" value="search"></td>
				</tr>

			</table>
		</form>
	</fieldset>
	<%if(bean != null)  {%>
	<h4>
		Name :
		<%= bean.getId()  %></h4>
	<h4>
		Name :
		<%= bean.getName()  %></h4>
	<h4>
		Name :
		<%= bean.getDateofbirth()  %></h4>
	<% } %>

</body>
</html>