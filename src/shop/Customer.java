package shop;

import java.util.List;

import shop.enums.CustomerOnlineStatus;

public class Customer {
	private String username;
	private String password;
	private String fullname;
	private List<Address> addresses;

	private CustomerOnlineStatus status;
	private ShoppingCart shoppingCart;

	// constructor
	public Customer(String username, String password, String fullname) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;

		this.shoppingCart = new ShoppingCart(this);
	}

	public Customer(String username, String password, String fullname, List<Address> addresses) {
		this(username, password, fullname);
		this.addresses = addresses;
	}

	// getters/setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public List<Address> getAddress() {
		return addresses;
	}

	public void setAddress(List<Address> addresses) {
		this.addresses = addresses;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public CustomerOnlineStatus getStatus() {
		return status;
	}

	public void setStatus(CustomerOnlineStatus status) {
		this.status = status;
	}

	// behavior

}
