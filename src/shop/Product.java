package shop;

//import category.Category;

public abstract class Product {
	private String name;
	private String description;
	private String model;
	private double amount;
	private double price;
	private int warrantyMonths;
	// private Category category;

	// constructors
	// public Product(String name, String description, double amount, double price, Category category) {
	public Product(String name, String description, String model, double amount, double price, int warrantyMonths) {
		this.name = name;
		this.description = description;
		this.model = model;
		this.amount = amount;
		this.price = price;
		this.warrantyMonths = warrantyMonths;
		// this.category = category;
	}

	// getters/setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	/*
	 * public Category getCategory() { return category; }
	 * 
	 * public void setCategory(Category category) { this.category = category; }
	 */

	public int getWarrantyMonths() {
		return warrantyMonths;
	}

	public void setWarrantyMonths(int warrantyMonths) {
		this.warrantyMonths = warrantyMonths;
	}

	// behavior
	public double increaseAmount(double increase) {
		return amount += increase;
	}

	public double decreaseAmount(double decrease) {
		return amount -= decrease;
	}

}
