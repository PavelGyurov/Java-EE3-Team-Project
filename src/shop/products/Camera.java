package shop.products;

import shop.Product;

public class Camera extends Product {
	private double megaPixels;
	private int isoStandard;
	private int shutterSpeed;
	private double displaySize;

	public Camera(String name, String description, String model, int amount,
			double price, int warrantyMonths, double megaPixels,
			int isoStandard, int shutterSpeed, double displaySize, String image) {
		super(name, description, model, amount, price, warrantyMonths, image);
		this.megaPixels = megaPixels;
		this.isoStandard = isoStandard;
		this.shutterSpeed = shutterSpeed;
		this.displaySize = displaySize;
	}

	public double getMegaPixels() {
		return megaPixels;
	}

	public void setMegaPixels(double megaPixels) {
		this.megaPixels = megaPixels;
	}

	public int getIsoStandard() {
		return isoStandard;
	}

	public void setIsoStandard(int isoStandard) {
		this.isoStandard = isoStandard;
	}

	public int getShutterSpeed() {
		return shutterSpeed;
	}

	public void setShutterSpeed(int shutterSpeed) {
		this.shutterSpeed = shutterSpeed;
	}

	public double getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(double displaySize) {
		this.displaySize = displaySize;
	}

}
