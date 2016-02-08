package shop.products;

import shop.Product;
import shop.products.VarioLens.BlendSize;

public class HardLens extends Product {

	private int lensSize;
	private BlendSize blendSize;

	public HardLens(String name, String description, String model,
			double amount, double price, int warrantyMonths, int lensSize,
			BlendSize blendSize) {
		super(name, description, model, amount, price, warrantyMonths);
		this.lensSize = lensSize;
		this.blendSize = blendSize;
	}

	public int getLensSize() {
		return lensSize;
	}

	public void setLensSize(int lensSize) {
		this.lensSize = lensSize;
	}

	public BlendSize getBlendSize() {
		return blendSize;
	}

	public void setBlendSize(BlendSize blendSize) {
		this.blendSize = blendSize;
	}

}
