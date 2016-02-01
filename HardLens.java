package lens;

import lens.VarioLens.BlendSize;

import product.Product;

public class HardLens extends Product{
	
	private int lensSize;
	private BlendSize blendSize;

	public HardLens(String model, double price, String description, int warranty, int lensSize, BlendSize blendSize) {
		super("hard", model, price, description, warranty);
		this.lensSize = lensSize;
		this.blendSize = blendSize;
	}
	
}
