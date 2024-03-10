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
<form action="log" method="post">
email:<input type="text" name="email"><br><br>
Password:<input type="password" name="password"><br><br>
<button>Submit</button>
</form>
</body>
</html>
