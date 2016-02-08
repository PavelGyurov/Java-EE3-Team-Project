package shop.products;

import shop.Product;

public class VarioLens extends Product {

	private LensSize lensSize;
	private BlendSize blendSize;

	public VarioLens(String name, String description, String model,
			double amount, double price, int warrantyMonths, LensSize lensSize,
			BlendSize blendSize) {
		super(name, description, model, amount, price, warrantyMonths);
		this.lensSize = lensSize;
		this.blendSize = blendSize;
	}

	public LensSize getLensSize() {
		return lensSize;
	}

	public void setLensSize(LensSize lensSize) {
		this.lensSize = lensSize;
	}

	public BlendSize getBlendSize() {
		return blendSize;
	}

	public void setBlendSize(BlendSize blendSize) {
		this.blendSize = blendSize;
	}
	
	class LensSize {
		int min;
		int max;

		LensSize(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

	class BlendSize {
		double min;
		double max;

		BlendSize(double min, double max) {
			this.min = min;
			this.max = max;
		}
	}

}
