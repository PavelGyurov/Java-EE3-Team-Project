package shop;

import java.util.List;

import shop.enums.CustomerOnlineStatus;

public class Customer {
	private String username;
	private String password;
	private String fullname;
	private Address address;

	private CustomerOnlineStatus status;
	private ShoppingCart shoppingCart;

	// constructor
	public Customer(String username, String password, String fullname) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;

		this.shoppingCart = new ShoppingCart(this);
	}

	public Customer(String username, String password, String fullname, Address address) {
		this(username, password, fullname);
		this.address = address;
	}

	// getters/setters
	public String getUsername() {
		return username;
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

    public Address getAddress() {
        return address;
    }

    public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}


	public CustomerOnlineStatus getStatus() {
		return status;
	}

	public void setStatus(CustomerOnlineStatus status) {
		this.status = status;
	}

	// behavior

}
