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
import model.shop.DBManager.DBProductDAO;

@WebServlet("/UpdateProducts")
public class UpdateProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = getServletContext();
		ConcurrentHashMap<Integer, model.shop.Product> products = null;
		try {
			products = DBProductDAO.getInstance().getAllProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		context.setAttribute("products", products);
		response.sendRedirect("uploadproduct.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		ConcurrentHashMap <Integer, model.shop.Product> products = null;
		try {
			products = DBProductDAO.getInstance().getAllProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int stock = Integer.parseInt(request.getParameter("stock"));
		System.out.println(stock);
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = null;
		try {
			product = DBProductDAO.getInstance().getProduct(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			DBProductDAO.getInstance().updateStock(id, stock);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("allproducts.jsp");
	}

}
