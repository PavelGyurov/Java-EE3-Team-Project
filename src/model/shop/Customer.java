package model.shop;

public class Customer {
	private String username;
	private String password;
	private String fisrtName;
	private String lastName;
	private String email;
	private String phone;
	private String town;
	private String streetName;
	private int streetNumber;
	private ShoppingCart shoppingCart;

	// constructor
	public Customer(String username, String password, String email, String fisrtName, String lastName, String phone,
			String town, String streetName, int streetNumber) {
		super();
		this.username = username;
		this.password = password;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.town = town;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.shoppingCart = new ShoppingCart(this);
	}

	// getters/setters
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getTown() {
		return town;
	}

	public String getStreetName() {
		return streetName;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	
	public String getOrderInfo(){
		String orderInfo = fisrtName + " " + lastName + " " + town + " " + streetName + " " + streetNumber;
		return orderInfo;
	}
}
