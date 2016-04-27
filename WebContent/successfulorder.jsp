<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style2.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Успешна поръчка</title>
</head>
<body>
<%@include file="header.jsp"%>

<font color="purple" size="5">
Вашате поръчка беше изпълнена успешно. Очаквайте обаждане за дата и час на доставката.<br>
Подробности: <br>
Име - Фамилия - Град - Улица - Номер<br>
<c:out value="${requestScope.order }"></c:out>
</font>

</body>
</html>