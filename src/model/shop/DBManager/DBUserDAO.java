package model.shop.DBManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.shop.Customer;

public class DBUserDAO {

	private static DBUserDAO instance;
	private DBManager manager;

	private DBUserDAO() {
		manager = DBManager.getDbManager();
		System.out.println("DB user dao initialised");
	}

	public synchronized static DBUserDAO getInstance() {
		if (instance == null)
			instance = new DBUserDAO();
		return instance;
	}

	public void addUser(Customer user) throws SQLException {
		String sql = "INSERT INTO customers (username, password, email, first_name, last_name,"
				+ "phone, town, street_name, street_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try (PreparedStatement st = manager.getConnection().prepareStatement(sql);) {
			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword());
			st.setString(3, user.getEmail());
			st.setString(4, user.getFisrtName());
			st.setString(5, user.getLastName());
			st.setString(6, user.getPhone());
			st.setString(7, user.getTown());
			st.setString(8, user.getStreetName());
			st.setInt(9, user.getStreetNumber());
			st.execute();
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	public ArrayList<Customer> getAllUsers() throws SQLException {
		ArrayList<Customer> users = new ArrayList<>();
		String sql = "SELECT username, password, email, first_name, last_name, phone,"
				+ "town, street_name, street_number FROM customers;";
		ResultSet userRS = manager.selectData(sql);
		while (userRS.next()) {
			Customer u = new Customer(userRS.getString(1), userRS.getString(2), userRS.getString(3),
					userRS.getString(4), userRS.getString(5), userRS.getString(6), userRS.getString(7),
					userRS.getString(8), userRS.getInt(9));
			users.add(u);
		}
		userRS.close();
		return users;
	}

	public boolean usernameExists(String username) throws SQLException {
		String sql = "SELECT username FROM customers WHERE username = '" + username + "';";
		PreparedStatement st = manager.getConnection().prepareStatement(sql);
		ResultSet user = st.executeQuery();
		boolean answer = user.next();
		user.close();
		return answer;
	}

	public void updateUser(Customer user) throws SQLException {
		String sql = "UPDATE customers SET password = ?, email = ?, first_name = ?, last_name = ?,"
				+ "phone = ?, town = ?, street_name = ?, street_number = ? WHERE username = ?;";
		try (PreparedStatement st = manager.getConnection().prepareStatement(sql)) {

			st.setString(1, user.getPassword());
			st.setString(2, user.getEmail());
			st.setString(3, user.getFisrtName());
			st.setString(4, user.getLastName());
			st.setString(5, user.getPhone());
			st.setString(6, user.getTown());
			st.setString(7, user.getStreetName());
			st.setInt(8, user.getStreetNumber());
			st.setString(9, user.getUsername());
			st.execute();
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	public Customer getUser(String username) throws SQLException{
		if(this.usernameExists(username)){
			String sql = "SELECT username, password, email, first_name, last_name, phone,"
					+ "town, street_name, street_number FROM customers WHERE username = '" + username + "';";
			PreparedStatement st = manager.getConnection().prepareStatement(sql);
			ResultSet userRS = st.executeQuery();
			userRS.next();
			Customer user = new Customer(userRS.getString(1), userRS.getString(2), userRS.getString(3),
					userRS.getString(4), userRS.getString(5), userRS.getString(6), userRS.getString(7),
					userRS.getString(8), userRS.getInt(9));
			userRS.close();
			return user;
		} else{
			return null;
		}
	}
	
	public boolean adminLogin(String username, String password) throws SQLException{
		String sql = "SELECT username, password FROM photoworld.product_admins WHERE username = '" + username + "';";
		PreparedStatement st = manager.getConnection().prepareStatement(sql);
		ResultSet user = st.executeQuery();
		boolean answer = user.next();
		user.close();
		return answer;
	}
}
