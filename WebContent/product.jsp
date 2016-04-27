<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="style2.css" rel="stylesheet">
    <title>Продукт</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
	<body> 
	<% pageContext.setAttribute("forward", "product.jsp?"+request.getQueryString());%>
		<%@include file="header.jsp"%>
		<%if(request.getParameter("added") != null){ %>
			<font color="purple" size="5">
				Продуктът беше добавел успешно в <a href="cart.jsp">количката Ви</a>
			</font>
				<% } %>
		<c:set var="id" scope="page" value="${param.id + 0 }" ></c:set>
		<c:set var="item" scope="page" value="${applicationScope.products[id.intValue()] }"></c:set>
		<table>
			<tr>
				<div  id="product-title">

					Продукт: <c:out value="${item.getBrand() }"></c:out><c:out value="${item.getModel()} "></c:out>
				</div>	
			</tr>
			
			<tr id="rowproduct">
				<td>
					<img id="image400" src="ImageServlet?id=${item.getId()}"/>
				</td>
				<td id="description">
					<div id="product-title">
						Подробни характерисики: </br>
					</div> <c:out value="${item.getDescription() }"></c:out>
				</td>
				 <td>
                            <div id="availability">
                               Наличност: <c:out value="${item.getAmountInstock()} "></c:out> 
                            </div>
                            <fieldset id="price">
                               Цена: <c:out value="${item.getPrice()} "></c:out> лв. 
                            </fieldset>
							<div id="buy-button">
							<a href="BuyServlet?id=${id }" class="myButton" >Купи</a>
							</div>
                        </td>
			</tr>
			
			
		</table>
	</body>
</html>