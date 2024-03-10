<%@page import="jsp_employee.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Update Data</h3>
<%Employee e=(Employee)request.getAttribute("emp"); %>
<form action="up" method="post">
Id:<input type="number" name="id" readonly value="<%=e.getId() %>"><br><br>
Name:<input type="text" name="name" value="<%=e.getName()%>"><br><br>
Phone:<input type="tel" name="phone" value="<%=e.getPhone()%>"><br><br>
Address:<input type="text" name="address" value="<%=e.getAddress()%>"><br><br>
email:<input type="email" name="email" value="<%=e.getEmail() %>"><br><br>
Password:<input type="password" name="password" value="<%=e.getPassword() %>"><br><br>
<button>Update</button>
</form>
</body>
</html>