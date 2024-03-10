<%@page import="jsp_employee.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Log in Successfully</h1>
<%String value=(String)request.getAttribute("tracking"); 
if(value!=null){
%>
<h3>Changed by
<%=value %>
</h3>
<%} %>

<%
List<Employee> list=(List)request.getAttribute("list");
%>
<table border="2px solid">
<tr>
<th>Id</th>
<th>Name</th>
<th>Phone</th>
<th>Address</th>
<th>Email</th>
<th>Password</th>
</tr>

<%
for(Employee employee:list){
%>
<tr>
<td> <%=employee.getId() %></td>
<td> <%=employee.getName()%></td>
<td> <%=employee.getPhone()%></td>
<td> <%=employee.getAddress() %></td>
<td> <%=employee.getEmail()%></td>
<td> <%=employee.getPassword()%></td>
<td><a href="delete?id=<%=employee.getId() %>"><button>delete</button></a></td>
<td><a href="update?id=<%=employee.getId() %>"><button>update</button></a></td>

</tr>

<%} %>
</table>
<br><br>
<a href="logout"> <button>Log Out</button></a>
</body>
</html>
