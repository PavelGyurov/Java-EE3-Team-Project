package model.shop.DBManager;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.catalina.tribes.group.interceptors.TwoPhaseCommitInterceptor.MapEntry;

import com.mysql.jdbc.Statement;

import model.shop.Customer;
import model.shop.Product;
import model.shop.ShoppingCart;

public class DBProductDAO {

	private static DBProductDAO instance;
	private DBManager manager;
	
	private DBProductDAO() {
		manager = DBManager.getDbManager();
		System.out.println("DB Product dao initialised");
	}

	public synchronized static DBProductDAO getInstance() {
		if (instance == null)
			instance = new DBProductDAO();
		return instance;
	}
		
	public byte[] getPicture(int id) throws SQLException{
		String sql = "SELECT image FROM products WHERE id = ?;";
		PreparedStatement st = manager.getConnection().prepareStatement(sql);
		st.setInt(1, id);
		ResultSet image = st.executeQuery();
		image.next();
		byte[] toReturn = image.getBytes(1);
		return toReturn;
	}
	
	public Product getProduct(int id) throws SQLException{
		String sql = "SELECT brand, model, description, amountInstock, price,"
				+ "warranty_months, subcategories_id, image, id FROM products WHERE id = ?;";
		PreparedStatement st = manager.getConnection().prepareStatement(sql);
		st.setInt(1, id);
		ResultSet productRS = st.executeQuery();
		productRS.next();
		String brand = productRS.getString(1);
		String model = productRS.getString(2);
		String description = productRS.getString(3);
		int amountInstock = productRS.getInt(4);
		double price = productRS.getDouble(5);
		int warranty = productRS.getInt(6);
		String subcategory = getSubcategory(productRS.getInt(7));
		byte[] image = productRS.getBytes(8);
				
		Product p = new Product(id, brand, model, description, amountInstock, price, warranty, subcategory, image);
		return p;
	}
	
	public void addProduct(String brand, String model, String description, int amountInstock, double price, int warranty_months,
			int subcategories_id, InputStream image) throws SQLException {
		String sql = "INSERT INTO photoworld.products (brand, model, description, amountInstock, price,"
				+ "warranty_months, subcategories_id, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

		try (PreparedStatement st = manager.getConnection().prepareStatement(sql);){
			st.setString(1, brand);
			st.setString(2, model);
			st.setString(3, description);
			st.setInt(4, amountInstock);
			st.setDouble(5, price);
			st.setInt(6, warranty_months);
			st.setInt(7, subcategories_id);
			st.setBlob(8, image);
			st.execute();
			
		} catch (SQLException e) {
			throw new SQLException();
		}
	}
	
	public ConcurrentHashMap <Integer, Product> getAllProducts() throws SQLException{
		ConcurrentHashMap <Integer, Product> products = new ConcurrentHashMap <Integer, Product>();
		String sql = "SELECT brand, model, description, amountInstock, price,"
				+ "warranty_months, subcategories_id, image, id FROM products;";
		ResultSet productRS = manager.getConnection().prepareStatement(sql).executeQuery();
		
		while (productRS.next()) {
			String brand = productRS.getString(1);
			String model = productRS.getString(2);
			String description = productRS.getString(3);
			int amountInstock = productRS.getInt(4);
			double price = productRS.getDouble(5);
			int warranty = productRS.getInt(6);
			String subcategory = getSubcategory(productRS.getInt(7));
			byte[] image = productRS.getBytes(8);
			int id = productRS.getInt(9);
					
			Product p = new Product(id, brand, model, description, amountInstock, price, warranty, subcategory, image);
			products.put(id, p);
		}
		
		return products;
	}
	
	private String getSubcategory(int subcategoryID) throws SQLException{
		String subcatQuery = "SELECT subcategory FROM photoworld.subcategories WHERE id = ?;";
		PreparedStatement st = manager.getConnection().prepareStatement(subcatQuery);
		st.setInt(1, subcategoryID);
		ResultSet subcatRS = st.executeQuery();
		subcatRS.next();
		String subcategory = subcatRS.getString(1);
		return subcategory;
	}
	
	public ArrayList<String> getAllSubcategories(String category) throws SQLException{
		ArrayList<String> subcategories = new ArrayList<String>();
		String catIDsql = "SELECT id FROM categories WHERE category_name = '" + category +"';";
		ResultSet categoryId = manager.getConnection().createStatement().executeQuery(catIDsql);
		categoryId.next();
		int id = categoryId.getInt(1);
		String subcatsSQL = "SELECT subcategory FROM subcategories WHERE categories_id = "+ id + ";";
		ResultSet subcatsRS = manager.getConnection().createStatement().executeQuery(subcatsSQL);
		while(subcatsRS.next()){
			subcategories.add(subcatsRS.getString(1));
		}
		return subcategories;
	}
	
	public String saveOrder(ShoppingCart cart) throws SQLException{
		StringBuilder order = new StringBuilder(cart.getCustomer().getOrderInfo());
		order.append(System.lineSeparator());
		String utf = "Марка - модел - брой - цена(лв)";
		byte[] bytes = utf.getBytes(Charset.forName("UTF-8"));
		String converted = new String(bytes, (Charset.forName("UTF-8")));
		order.append(converted);
		for(Entry<Product, Integer>  e: cart.getProducts().entrySet()){
			order.append(System.lineSeparator());
			order.append(e.getKey().getBrand() + " " + e.getKey().getModel() + " " + e.getValue() + " " +(e.getKey().getPrice()*e.getValue()));
		}
		order.append(System.lineSeparator());
		String finalprice = "Крайна цена(лв): ";
		order.append(new String(finalprice.getBytes(Charset.forName("UTF-8")), Charset.forName("UTF-8")) + cart.getPriceForAll());
		LocalDate date = LocalDate.now();
		Date sqldate = Date.valueOf(date);;
		String username = cart.getCustomer().getUsername();
		
		String sql = "INSERT INTO orders (customers_username, date_time, details) VALUES (?, ?, ?)";
		PreparedStatement st = manager.getConnection().prepareStatement(sql);
		st.setString(1, username);
		st.setDate(2, sqldate);
		st.setString(3, order.toString());
		st.execute();
		cart.removeAllProducts();
		return order.toString();
	}
	
	public void updateStock(int id, int stock) throws SQLException{
		String sql = "UPDATE products SET amountInstock=? WHERE id=?;";
		PreparedStatement st = manager.getConnection().prepareStatement(sql);
		st.setInt(1, stock);
		st.setInt(2, id);
		st.execute();
	}
}
