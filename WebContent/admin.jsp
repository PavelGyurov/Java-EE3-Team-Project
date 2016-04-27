<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Влизане като администратор</title>
</head>
<body>
		<font color="red">
			<% if(request.getAttribute("login") != null){
				if(request.getAttribute("login").equals("failed")){
					out.append("Грешна парола или потребителско име.");
				}
			} %>
		</font>
		<form method="post" action="AdminLogin">
			<table>
					<tr>
						<td>Администратор:</td>
						<td><input type="text" name="username" value=""></td>
					</tr>
					<tr>
						<td>Парола:</td>
						<td><input type="password" name="password" value="">
						</td>
					</tr>
					<tr>
						<td><input type="submit" value="Вход"
							style="font-size: 18px;"></td>
			</table>
		</form>
							
					
</body>
</html>