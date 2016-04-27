package controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import model.shop.Customer;
import model.shop.DBManager.DBProductDAO;
import model.shop.DBManager.DBUserDAO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		DBUserDAO.getInstance();
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
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			if(DBUserDAO.getInstance().usernameExists(username)){
				Customer user = DBUserDAO.getInstance().getUser(username); 
				if(user.getPassword().equals(password)){
					request.getSession().setAttribute("logged", "true");
					request.getSession().setAttribute("user", user);
					request.getSession().setAttribute("cart", user.getShoppingCart());
					request.getSession().setAttribute("cartproducts", user.getShoppingCart().getProducts());
				}else{
					request.getSession().setAttribute("wrongpassword", "yes");
				}
			}else{
				request.getSession().setAttribute("doesnotexist", "yes");
			}
		} catch (SQLException e) {
			request.getSession().setAttribute("logged", "failed");
			e.printStackTrace();
		}
		response.sendRedirect(request.getParameter("forwardTo"));
	}

}
