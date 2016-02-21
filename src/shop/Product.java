package shop;

//import category.Category;

public abstract class Product {
	private String name;
	private String description;
	private String model;
	private int amountInstock;
	private double price;
	private int warrantyMonths;
	private String image;
	// private Category category;

	// constructors
	// public Product(String name, String description, double amountInstock, double price, Category category) {
	public Product(String name, String description, String model, int amountInstock, double price, int warrantyMonths, String image) {
		this.name = name;
		this.description = description;
		this.model = model;
		this.amountInstock = amountInstock;
		this.price = price;
		this.warrantyMonths = warrantyMonths;
        this.image = image;
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

	public int getAmountInstock() {
		return amountInstock;
	}

	public void setAmountInstock(int amountInstock) {
		this.amountInstock = amountInstock;
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
		return amountInstock += increase;
	}

	public double decreaseAmount(double decrease) {
		return amountInstock -= decrease;
	}

}
