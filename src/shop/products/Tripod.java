package shop.products;

import shop.Product;

public class Tripod extends Product {
	private double loadCapacity;
	private double minHeight;
	private double maxHeight;
	private double weight;

	public Tripod(String name, String description, String model, int amount,
			double price, int warrantyMonths, int loadCapacity,
			double minHeight, double maxHeight, double weight, String image) {
		super(name, description, model, amount, price, warrantyMonths, image);
		this.loadCapacity = loadCapacity;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.weight = weight;
	}

	public double getLoadCapacity() {
		return loadCapacity;
	}

	public double getMinHeight() {
		return minHeight;
	}

	public double getMaxHeight() {
		return maxHeight;
	}

	public double getWeight() {
		return weight;
	}

	public void setLoadCapacity(double loadCapacity) {
		this.loadCapacity = loadCapacity;
	}

	public void setMinHeight(double minHeight) {
		this.minHeight = minHeight;
	}

	public void setMaxHeight(double maxHeight) {
		this.maxHeight = maxHeight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
