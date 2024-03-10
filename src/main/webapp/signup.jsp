<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String message=(String)request.getAttribute("message");
if(message!=null){
%>
<%=message %>
<%
}
%>
<form action="reg" method="post">
Id:<input type="number" name="id"><br><br>
Name:<input type="text" name="name"><br><br>
Phone:<input type="tel" name="phone"><br><br>
Address:<input type="text" name="address"><br><br>
email:<input type="email" name="email"><br><br>
Password:<input type="password" name="password"><br><br>
<button>Submit</button>
</form>
</body>
</html>