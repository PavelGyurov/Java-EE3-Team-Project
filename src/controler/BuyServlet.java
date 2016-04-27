package controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.shop.Product;
import model.shop.ShoppingCart;
import model.shop.DBManager.DBProductDAO;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("user") == null) {
			response.sendRedirect("loginfirst.jsp");
		} else {
			ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
			int id = Integer.parseInt(request.getParameter("id"));
			ServletContext context = getServletContext();
			ConcurrentHashMap<Integer, model.shop.Product> products = (ConcurrentHashMap<Integer, Product>) context
					.getAttribute("products");

			Product product = products.get(id);
			cart.addProduct(product);
			request.setAttribute("add", "succsess");
			response.sendRedirect("product.jsp?id=" + id + "&added=true");
			//request.getRequestDispatcher("product.jsp?id=" + id + "&added=true").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		ConcurrentHashMap<Integer, model.shop.Product> products = (ConcurrentHashMap<Integer, Product>) context
				.getAttribute("products");
		if (request.getParameter("remove") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			Product p = products.get(id);
			ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
			cart.removeProduct(p);
			response.sendRedirect("cart.jsp");
		} else {
			ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
			
			for(Entry<Product, Integer>  e: cart.getProducts().entrySet()){
				if(products.containsValue(e.getKey())){
					e.getKey().setAmountInstock(e.getKey().getAmountInstock() - e.getValue());
				}
			}
			
			String order = "";
			try {
				order = DBProductDAO.getInstance().saveOrder(cart);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("order", order);
			request.getRequestDispatcher("successfulorder.jsp").forward(request, response);
		}
	}

}
