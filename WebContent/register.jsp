<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Регистрация на потребител</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Регистрация на потебител</title>
<link rel="stylesheet" href="registrationstyle.css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="registrationJS.js"></script>
</head>
<body>
<% pageContext.setAttribute("forward", "index.jsp");%>
<div><%@ include file="header.jsp"%></div>

<div >
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
	</font>
</div>

<div class="container">
<div class="main">
<form name="regform" class="form" method="post" onsubmit="return validateForm()"	 action="Registration">
<h2>Регистриране на нов потребител</h2>
<label id="reglabel">Потребителско име :</label>
<input id="reginput" type="text" name="name" id="name">
<label id="reglabel">Email :</label>
<input id="reginput" type="text" name="email" id="email">
<label id="reglabel">Парола :</label>
<input id="reginput"  type="password" name="password" id="password">
<label id="reglabel">Потвърдете паролата :</label>
<input id="reginput"  type="password" name="cpassword" id="cpassword">
<label id="reglabel">Име :</label>
<input id="reginput" type="text" name="firstname" id="firstname">
<label id="reglabel">Фамилия:</label>
<input id="reginput" type="text" name="lastname" id="lastname">
<label id="reglabel">Телефон:</label>
<input id="reginput" type="text" name="phone" id="phone">
<label id="reglabel">Град:</label>
<input id="reginput" type="text" name="town" id="town">
<label id="reglabel">Улица:</label>
<input id="reginput" type="text" name="street" id="street">
<label id="reglabel">Номер:</label>
<input id="reginput" type="text" name="streetnumber" id="streetnumber">
<input type="hidden" name="regOrUpdate" value="reg">
<input type="submit" name="register" id="register" value="Регистрирай">
</form>
</div>
</body>
</html>