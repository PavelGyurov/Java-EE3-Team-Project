package shop.products;

import shop.Product;

public class HardLens extends Product {

	private int lensSize;
	private double blendSizeMin;
	private double blendSizeMax;

	public HardLens(String name, String description, String model, int amountInstock, double price,
					int warrantyMonths, int lensSize, double blendSizeMin, double blendSizeMax, String image) {
		super(name, description, model, amountInstock, price, warrantyMonths, image);
		this.lensSize = lensSize;
		this.blendSizeMin = blendSizeMin;
		this.blendSizeMax = blendSizeMax;
	}

	public int getLensSize() {
		return lensSize;
	}

	public void setLensSize(int lensSize) {
		this.lensSize = lensSize;
	}

	public double getBlendSizeMin() {
		return blendSizeMin;
	}

	public double getBlendSizeMax() {
		return blendSizeMax;
	}
}
