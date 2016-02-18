package shop.products;

import shop.Product;

public class Filters extends Product {
	private double diameter;
	private double thickness;

	public Filters(String name, String description, String model,
			int amount, double price, int warrantyMonths, double diameter,
			double thickness) {
		super(name, description, model, amount, price, warrantyMonths);
		this.diameter = diameter;
		this.thickness = thickness;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public double getThickness() {
		return thickness;
	}

	public void setThickness(double thickness) {
		this.thickness = thickness;
	}

}
