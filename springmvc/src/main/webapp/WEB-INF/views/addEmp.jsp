<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String msg = (String) request.getAttribute("msg"); 
	String errMsg = (String) request.getAttribute("errMsg");
%>

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
	if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h1>
		<%= errMsg%></h1>
	<%
	}
	%>

<fieldset>
		<legend>addEmpForm</legend>
		
		<form action="./add" method="post">
			<table>
				<tr>
					<td>Enter UserID</td>
					<td>:</td>
					<td><input type="number" name="id"></td>
				</tr>
				<tr>
					<td>Enter UserName</td>
					<td>:</td>
					<td><input type="text" name="name"></td>
				</tr>
			
				<tr>
					<td>Enter Password</td>
					<td>:</td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<td>Enter Dob</td>
					<td>:</td>
					<td><input type="date" name="dateofbrth"></td>
				</tr>
			
				<tr>
					<td><input type="submit" value="add"></td>
				</tr>

			</table>
		</form>
	</fieldset>


</body>
</html>