<%@page import="org.te.springmvc.beans.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
String msg = (String) request.getAttribute("msg");
%>
<%
String errmsg = (String) request.getAttribute("errmsg");
%>
<%@ include file="header.jsp"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<h1>
		<%= msg%></h1>
	<%
	}
	%>

	<%
	if (errmsg != null && !errmsg.isEmpty()) {
	%>
	<h2>
		<%= errmsg%></h2>
	<%
	}
	%>

	<fieldset>
		<legend>Delete Form</legend>

		<form action="./delete" method="get">
			<table>
				<tr>
					<td>Enter user ID to delete</td>
					<td>:</td>
					<td><input type="number" name="id"></td>
				</tr>

				<tr>
					<td><input type="submit" value="delete"></td>
				</tr>

			</table>
		</form>
	</fieldset>


</body>
</html>