<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  
	<link href="style2.css" rel="stylesheet">
    <title>Списък с продукти</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<% String forward = request.getAttribute("servlet").toString() + "?" + request.getQueryString(); 
pageContext.setAttribute("forward", forward);%>
	<%@include file="header.jsp"%>
<table id="product" padding-bottom: 50px;>
 
	<c:forEach var="item" items="${requestScope.foundproduct }">
	<c:set var="stock" scope="page" value="${item.getAmountInstock()}"/>
	<c:if test="${stock > 0}">
		   <tr>
            <td rowspan="5">
                <table>
                    <tr id="rowproduct">
                        <td>	
                                <table>
                                    <tr>
                                        <td id="image" rowspan="2">
                                    
                                            <img id="product_picture" src="ImageServlet?id=${item.getId()}"  />
                                        </td>
                                    </tr>
										<td id ="description">
											<div id="product-title">
											<a href="product.jsp?id=${item.getId()}"><c:out value="${item.getBrand()} "></c:out> <c:out value="${item.getModel()} "></c:out></a>
										</div>
											
											<textarea rows="10" cols="50" readonly>
												<c:out value="${item.getDescription() }"></c:out>
											</textarea>
										</td>
                                 
                                </table>
                        </td>
                        <td>
                            <div id="availability">
                                  Наличност: <c:out value="${item.getAmountInstock()} "></c:out>
                            </div>
                            <fieldset id="price">
                               Цена: <c:out value="${item.getPrice()} "></c:out> лв.
                            </fieldset>
							<div id="buy-button">
							<a href="product.jsp?id=${item.getId()}" >
								<input type="submit" class="myButton" value="Купи" form="buyform">
							</a>
							</div>
                        </td>
                    </tr>
                    </c:if>
  	</c:forEach>
</table>

		
</body>
</html>