<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style2.css" rel="stylesheet">
<meta charset="utf-8">
<title>Влезте или се регистрирайте</title>
</head>
<body>

<%
pageContext.setAttribute("forward", "loginfirst.jsp");%>
<%@include file="header.jsp"%>
<font color="red" size="5">
За да пазарувате първо влезте с вашето потребителско име и парола или се регистрирайте.<br>
Натиснете бутона "Назад", за да се върнете на предишната страница.<br>
<button onclick="window.history.back()" class="myButton">Назад</button>
</font>
</body>
</html>