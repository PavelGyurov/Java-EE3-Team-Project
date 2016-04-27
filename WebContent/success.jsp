<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Great Success</title>
<link href="style2.css" rel="stylesheet">
</head>
<body>
<% pageContext.setAttribute("forward", "index.jsp");%>
<div><%@ include file="header.jsp"%></div>
<div class="success" style="width: 500px;">Успешна регистрация! Можете да влезете с потребителското име и паролата си.</div>
</body>
</html>