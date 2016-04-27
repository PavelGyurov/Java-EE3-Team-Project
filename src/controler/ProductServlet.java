package controler;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.ImageIcon;

import com.mysql.jdbc.Blob;
import com.sun.prism.Image;

import jdk.nashorn.internal.ir.BlockLexicalContext;
import model.shop.Product;
import model.shop.DBManager.DBProductDAO;


@WebServlet("/ProductServlet")
@MultipartConfig 
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		super.init();
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
		
		String subcategory = request.getParameter("subcategory");
		String category = request.getParameter("category");
		ConcurrentHashMap <Integer, Product> search = (ConcurrentHashMap<Integer, Product>) context.getAttribute("products");
		 
		HashSet<Product> found = new HashSet<>();
		
		if(subcategory != null){
			for(Product p : search.values()){
				if(subcategory.equals(p.getSubcategory())){
					found.add(p);
				}
			}
		}
		
		if(category != null){
			ArrayList<String> subcategories = new ArrayList<String>();
			try {
				subcategories = DBProductDAO.getInstance().getAllSubcategories(category);
				for(Product p : search.values()){
					for(String subcat : subcategories){
						if(subcat.equals(p.getSubcategory())){
							found.add(p);
						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		request.setAttribute("foundproduct", found);
		request.setAttribute("servlet", "ProductServlet");
		request.getRequestDispatcher("/products-list.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String description = request.getParameter("description");
		int amountInstock = Integer.parseInt(request.getParameter("amountInstock"));
		double price = Double.parseDouble(request.getParameter("price"));
		int warranty_months = Integer.parseInt(request.getParameter("warranty_months"));
		int subcategories_id = Integer.parseInt(request.getParameter("subcategory"));
		Part image = request.getPart("image");
		String fileName = image.getSubmittedFileName();
		InputStream input = image.getInputStream();
		System.out.println(brand);
		response.sendRedirect("uploadproduct.html");
		
		try {
			DBProductDAO.getInstance().addProduct(brand, model, description, amountInstock, price, warranty_months, subcategories_id, input);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
