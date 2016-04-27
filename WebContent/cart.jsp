<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
</style>

<link href="style2.css" rel="stylesheet">
<title>Количка</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

	<div><%@ include file="header.jsp"%></div>

	<div id="product-title">
		<h2>Поръчка</h2>
	</div>
	<table>
		<tr>

		</tr>

		<tr>
			<td id="cart">Продукти в количката</td>
			<td class="spacer"><img src="arrow.jpg"></td>
			<td id="cart">Доставка и плащане</td>
			<td class="spacer"><img src="arrow.jpg"></td>
			<td id="cart">Завършване на доставката</td>
		</tr>
		<c:set var="cart" value="${sessionScope.cart }"></c:set>
		<tr class="spacer">
			<td></td>
		</tr>
	</table>
	<table>
		<tr id="cart">
			<td width="500">ПРОДУКТ</td>
			<td>ЕД. ЦЕНА</td>
			<td>КОЛИЧЕСТВО</td>
			<td>КРАЙНА ЦЕНА</td>
			<td>ИЗТРИЙ</td>
		</tr>
		<c:forEach var="item" items="${cart.getProducts() }">
			<tr>
				<td><c:out value="${item.key.getBrand() }"></c:out> <c:out value="${item.key.getModel() }"></c:out></td>
				<td><c:out value="${item.key.getPrice()}"/></td>
				<td><c:out value="${item.value}"/></td>
				<td><c:out value="${item.value * item.key.getPrice()}"/></td>
				<td><form action="BuyServlet" method="post">
				<input type="hidden" name="id" value="${item.key.getId() }">
    <input type="submit" name="remove" class="myButton" value="Изтрий" />
</form></td>
			</tr>
		</c:forEach>
	</table>
	<br><br><br>
	<div id="container">
		<form method="post" action="BuyServlet"><input type="radio" name="delivery_type"
				value="cash on delivery">Наложен платеж <input type="radio"
				name="delivery_type" value="card">Плащане по банков път <br>
			Сума: <span class="simpleCart_total"></span><span
				class="taxCost"></span> <br /> Цена на доставката: Безплатна<span
				class="shippingCost"></span> <br /> -----------------------------<br />
			Крайна сума: <span class="simpleCart_finalTotal"><c:out value="${cart.getPriceForAll() }"></c:out></span> <br />
		
		<input type="submit" class="myButton" value="Поръчай">
		</form>
		<br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>