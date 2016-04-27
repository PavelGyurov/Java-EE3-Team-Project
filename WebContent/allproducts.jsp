<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
 import="java.util.concurrent.ConcurrentHashMap" 
 import="java.util.Map.Entry"
 import="model.shop.Product"
 import="model.shop.DBManager.DBProductDAO"
 import="java.sql.SQLException"
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Всички продукти</title>
</head>
<body>
<table>
<tr>
<td>ID</td>
<td>Марка</td>
<td>Модел</td><td>Наличност</td>
<td>Обнови наличност</td>
</tr>
<%ServletContext context = getServletContext();
ConcurrentHashMap <Integer, model.shop.Product> products = null;
try {
	products = DBProductDAO.getInstance().getAllProducts();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
for(Entry<Integer, Product>  e: products.entrySet()){%>
<tr>
<td><%=e.getKey() %></td>
<td><%=e.getValue().getBrand() %></td>
<td><%=e.getValue().getModel() %></td>
<form action="UpdateProducts" method="post">
<td><input id="stock" type="text" name="stock" id="stock" value="<%=e.getValue().getAmountInstock() %>" ></td>
<td><input type="submit" value="Обнови количество" >
<input type="hidden" name="id" value="<%=e.getKey() %>" ></td>
</form>
</tr>
<%} %>
</table>
<br><br><br>
<a href="uploadproduct.html">Добвяне на продукт</a>
</body>
</html>