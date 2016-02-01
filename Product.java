package product;

public abstract class Product {
	private String type;
	private String model;
	private double price;
	private int amount;
	private String description;
	private int warranty; //in months
	
	
	
	public Product(String type, String model, double price, String description, int warranty) {
		this.type = type;
		this.model = model;
		this.price = price;
		this.amount = 0;
		this.description = description;
		this.warranty = warranty;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
