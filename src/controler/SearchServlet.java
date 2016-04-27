package controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.shop.Product;
import model.shop.DBManager.DBProductDAO;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		if(context.getAttribute("products") == null){
			ConcurrentHashMap <Integer, model.shop.Product> products = null;
			try {
				products = DBProductDAO.getInstance().getAllProducts();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			context.setAttribute("products", products);
		}
		
		String keyword = request.getParameter("keyword");
		
		ConcurrentHashMap <Integer, Product> search = (ConcurrentHashMap<Integer, Product>) context.getAttribute("products");
		HashSet<Product> found = new HashSet<>();
		for (Product product : search.values()) {
			if(product.getBrand().toLowerCase().contains(keyword.toLowerCase()) || product.getModel().toLowerCase().contains(keyword.toLowerCase())
					|| product.getDescription().toLowerCase().contains(keyword.toLowerCase())){
				found.add(product);
			}
		}
		request.setAttribute("servlet", "SearchServlet");
		request.setAttribute("foundproduct", found);
		request.getRequestDispatcher("/products-list.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
