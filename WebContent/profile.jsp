<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Профил на потребител</title>
<link rel="stylesheet" href="registrationstyle.css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="registrationJS.js"></script>
</head>
<body>
<% pageContext.setAttribute("forward", "index.jsp");%>
<div><%@ include file="header.jsp"%></div>

	<c:set var="id" scope="page" value="${param.id + 0 }" ></c:set>
	<c:set var="user" scope="page" value="${sessionScope.user }"></c:set>
	
	<font color="red" size="18">
		<% if(request.getParameter("reg") != null){
			if(request.getParameter("reg").equalsIgnoreCase("nameeexist")){
				out.append("Потребителското име е заето, моля изберете друго!");
			} else if(request.getParameter("reg").equalsIgnoreCase("empty")){
				out.append("Попълнете всички полета!");
			} else if(request.getParameter("reg").equalsIgnoreCase("negativenumber")){
				out.append("Въведете валиден уличен номер!");
			} else if(request.getParameter("reg").equalsIgnoreCase("invalidemail")){
				out.append("Въведете валиден имейл адрес!");
			}
		}%>
		
<div class="container">
<div class="main">
<form name="regform" class="form" method="post" onsubmit="return validateForm()" action="Registration">
<h2>Профил на потребител</h2>
<label id="reglabel">Потребителско име :</label>
<input id="reginput" readonly="readonly type="text" name="name" id="name" value="${user.getUsername() }">
<label id="reglabel">Email :</label>
<input id="reginput" type="text" name="email" id="email" value="${user.getEmail()}" >
<label id="reglabel">Нова парола :</label>
<input id="reginput" type="password" name="password" id="password">
<label id="reglabel">Потвърдете паролата :</label>
<input id="reginput" type="password" name="cpassword" id="cpassword">
<label id="reglabel">Име :</label>
<input id="reginput" type="text" name="firstname" id="firstname" value="${user.getFisrtName()}" >
<label id="reglabel">Фамилия:</label>
<input id="reginput" type="text" name="lastname" id="lastname" value="${user.getLastName()}" >
<label id="reglabel">Телефон:</label>
<input id="reginput" type="text" name="phone" id="phone" value="${user.getPhone()}">
<label id="reglabel">Град:</label>
<input id="reginput" type="text" name="town" id="town" value="${user.getTown()}">
<label id="reglabel">Улица:</label>
<input id="reginput" type="text" name="street" id="street" value="${user.getStreetName()}">
<label id="reglabel">Номер:</label>
<input id="reginput" type="text" name="streetnumber" id="streetnumber" value="${user.getStreetNumber()}">
<input type="hidden" name="regOrUpdate" value="update">
<input type="submit" name="register" id="register" value="Обнови профила" >
</form>
</div>
</body>
</html>