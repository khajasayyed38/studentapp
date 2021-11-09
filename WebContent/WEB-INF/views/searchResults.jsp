<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<%@ page import = "java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>result</title>
</head>
<body>
	<h2>Search Results</h2>
	<table border='1'>
	<tr>
		<th>name</th>
		<th>city</th>
		<th>email id</th>
		<th>mobile number</th>
		<th>delete</th>
		<th>update</th>
	</tr>
	<%
		ResultSet result =(ResultSet)request.getAttribute("result");
		while(result.next()){
	%>	
		<tr>
			<td><%=result.getString(1) %></td>
			<td><%=result.getString(2) %></td>
			<td><%=result.getString(3) %></td>
			<td><%=result.getString(4) %></td>
			<td><a href="deleteReg?email=<%=result.getString(3) %>">delete</a></td>
			<td><a href="updateReg?email=<%=result.getString(3) %>&mobile=<%=result.getString(4)%>">update</a></td>
		</tr>
		<%
		}
		 %>
	

	
	
	
	
	</table>
</body>
</html>