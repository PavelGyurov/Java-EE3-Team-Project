<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1" />
<title>PhotoWolrd</title>
<link href="style1.css" rel="stylesheet">
</head>
<body>
	<header>
	<div class="flexsearch">
		<div class="flexsearch--wrapper">
			<form class="flexsearch--form" action="SearchServlet" method="get">
				<div class="flexsearch--input-wrapper">
					<input class="flexsearch--input" type="search" name="keyword" placeholder="Търсене">
				</div>
				<input class="flexsearch--submit" type="submit" value="&#10140;" />
			</form>
		</div>
	</div>
	<%
		if (session.getAttribute("logged") == null || !session.getAttribute("logged").equals("true")) {
	%>

	<div id="login_form">	
		<form name="f1" method="post" action="LoginServlet" id="f1">
			<table>
				<tbody>
					<tr>
						<td class="f1_label">Потребител:</td>
						<td>
							<input type="text" name="username" value=""> 
							<input type="hidden" name="forwardTo" value="<%=pageContext.getAttribute("forward")%>">
						</td>
					</tr>
					<tr>
						<td class="f1_label">Парола:</td>
						<td><input type="password" name="password" value="">
						</td>
					</tr>
					<tr>
						<td><input type="submit" name="login" value="Вход"
							style="font-size: 18px;"></td>
							</form>
						<td><form action="register.jsp"><input type="submit" value="Регистрация"
							style="font-size: 18px;">
						</form></td>
						<td>
					</tr>
					<tr>
					<%if(session.getAttribute("doesnotexist") != null){ %>
						<td colspan="3"><font color="red">
						Несъществуващ потребител!
						</font>
						</td>
					<%} %> 
					<% if(session.getAttribute("wrongpassword") != null){ %>
						<td colspan="3"><font color="red">
						Грешна парола или потребител!
						</font>
						</td>
					<% }%>
					</tr>
				</tbody>
			</table>
	</div>
	
	<%
	} else if (session.getAttribute("logged").equals("true")) {
	%>
	<div id="profile">
		<table>
			<tr>
				<td><a href=profile.jsp>Профил</a> <br> 
				<br>
				<a href=cart.jsp>Количка</a>
				<br> <br>
					<form name="logout" method="post" action="LogoutServlet">
						<input type="submit" name="logout" value="Изход" style="font-size:18px;" />
						<input type="hidden" name="forwardTo" value="<%=request.getRequestURI()%>" />
					</form>
				</td>
			</tr>
		</table>
	</div>
	<%
		}
	
	 	if(session.getAttribute("doesnotexist") != null || session.getAttribute("wrongpassword") != null){
			session.setAttribute("doesnotexist", null);
			session.setAttribute("wrongpassword", null);
		}
	%> <a href="index.jsp"><img id="logo-container"
		src="camera-eye-logo.jpg" width="180" height="100"></a> <nav
		class="nav-main">
	<ul>
		<li><input type="radio" name="nav-group" id="camera"
			class="nav-option"> <label for="camera" class="nav-item">Фотоапарати</label>
			<label for="nav-close" class="nav-close"></label>
			<div class="nav-content">
				<div class="nav-sub">
					<ul>
						<form action="ProductServlet" method="get">
						<li><a href="ProductServlet?subcategory=DSLR">Огледално рефлексни фотоапарати</a></li>
						<li><a href="ProductServlet?subcategory=Compapt">Компактни фотоапарати</a></li>
						<li><a href="ProductServlet?category=Camera">Всички</a></li>
						</form>
					</ul>
				</div>
			</div></li>
		<li><input type="radio" name="nav-group" id="lenses"
			class="nav-option"> <label for="lenses" class="nav-item">Обективи</label>
			<label for="nav-close" class="nav-close"></label>
			<div class="nav-content">
				<div class="nav-sub">
					<ul>
						<li><a href="products-list.jsp">За огледално рефлексни фотоапарати</a></li>
						<li><a href="#">За компактни фотоапарати</a></li>
						<li><a href="#">Всички</a></li>
					</ul>
				</div>
			</div></li>
		<li><input type="radio" name="nav-group" id="bag"
			class="nav-option"> <label for="bag" class="nav-item">Чанти</label>
			<label for="nav-close" class="nav-close"></label>
			<div class="nav-content">
				<div class="nav-sub">
					<ul>
						<li><a href="#">За огледално рефлексни фотоапарати</a></li>
						<li><a href="#">За компактни фотоапарати</a></li>
						<li><a href="#">За кръста</a></li>
						<li><a href="#">За китката</a></li>
						<li><a href="#">Всички</a></li>
					</ul>
				</div>
			</div></li>
		<li><input type="radio" name="nav-group" id="lighter"
			class="nav-option"> <label for="lighter" class="nav-item">Светкавици
		</label> <label for="nav-close" class="nav-close"></label>

			<div class="nav-content">
				<div class="nav-sub">
					<ul>
						<li><a href="#">За Canon</a></li>
						<li><a href="#">За Nikon</a></li>
						<li><a href="#">Всички</a></li>
					</ul>
				</div>
			</div></li>
		<li><input type="radio" name="nav-group" id="tripod"
			class="nav-option"> <label for="tripod" class="nav-item">Стативи
		</label> <label for="nav-close" class="nav-close"></label>

			<div class="nav-content">
				<div class="nav-sub">
					<ul>
						<li><a href="#">Компактни</a></li>
						<li><a href="#">Стандартни</a></li>
						<li><a href="#">Моноподи</a></li>
						<li><a href="#">Всички</a>
						<li>
					</ul>
				</div>
			</div></li>
		<li><input type="radio" name="nav-group" id="memory"
			class="nav-option"> <label for="memory" class="nav-item">Памет</label>
			<label for="nav-close" class="nav-close"></label>
			<div class="nav-content">
				<div class="nav-sub">
					<ul>
						<li><a href="#">Micro SD</a>
						<li>
						<li><a href="#">Secure Digital</a>
						<li>
						<li><a href="#">Compact Flash</a>
						<li>
						<li><a href="#">XD</a>
						<li>
						<li><a href="#">Всички</a>
						<li>
					</ul>
				</div>
			</div></li>
		<li><input type="radio" name="nav-group" id="filters"
			class="nav-option"> <label for="filters" class="nav-item">Филтри</label>
			<label for="nav-close" class="nav-close"></label>

			<div class="nav-content">
				<div class="nav-sub">
					<ul>
						<li><a href="#">Ултравиолетови</a>
						<li>
						<li><a href="#">Поляризационни</a>
						<li>
						<li><a href="#">Неутрални</a>
						<li>
						<li><a href="#">Всички</a>
						<li>
					</ul>
				</div>
			</div></li>
		<li><input type="radio" name="nav-group" id="batery"
			class="nav-option"> <label for="batery" class="nav-item">Батерии
		</label> <label for="nav-close" class="nav-close"></label>

			<div class="nav-content">
				<div class="nav-sub">
					<ul>
						<li><a href="#">Литево-йонни</a>
						<li>
						<li><a href="#">Алкални АА</a>
						<li>
						<li><a href="#">Алкални ААА</a>
						<li>
						<li><a href="#">Акумулаторни АА</a>
						<li>
						<li><a href="#">Всички</a>
						<li>
					</ul>
				</div>
			</div></li>
	</ul>
	</nav> </header>
</head>
<body>

</body>
</html>