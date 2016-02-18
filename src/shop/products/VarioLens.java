package shop.products;

import shop.Product;

public class VarioLens extends Product {

//
//	private LensSize lensSize;
//	private BlendSize blendSize;

    private int lensSizeMin;
    private int lensSizeMax;
    private double blendSizeMin;
    private double blendSizeMax;

//	public VarioLens(String name, String description, String model,
//			int amount, double price, int warrantyMonths, LensSize lensSize,
//			BlendSize blendSize) {
//		super(name, description, model, amount, price, warrantyMonths);
//		this.lensSize = lensSize;
//		this.blendSize = blendSize;
//	}

    public VarioLens(String name, String description, String model, int amountInstock,
                     double price, int warrantyMonths, int lensSizeMin,
                     int lensSizeMax, double blendSizeMin, double blendSizeMax) {
        super(name, description, model, amountInstock, price, warrantyMonths);
        this.lensSizeMin = lensSizeMin;
        this.lensSizeMax = lensSizeMax;
        this.blendSizeMin = blendSizeMin;
        this.blendSizeMax = blendSizeMax;
    }

    public int getLensSizeMin() {
        return lensSizeMin;
    }

    public int getLensSizeMax() {
        return lensSizeMax;
    }

    public double getBlendSizeMin() {
        return blendSizeMin;
    }

    public double getBlendSizeMax() {
        return blendSizeMax;
    }

//	public LensSize getLensSize() {
//		return lensSize;
//	}
//
//	public void setLensSize(LensSize lensSize) {
//		this.lensSize = lensSize;
//	}
//
//	public BlendSize getBlendSize() {
//		return blendSize;
//	}
//
//	public void setBlendSize(BlendSize blendSize) {
//		this.blendSize = blendSize;
//	}
	
//	public class LensSize {
//		int min;
//		int max;
//
//		LensSize(int min, int max) {
//			this.min = min;
//			this.max = max;
//		}
//	}
//
//	public class BlendSize {
//		double min;
//		double max;
//
//		BlendSize(double min, double max) {
//			this.min = min;
//			this.max = max;
//		}
//	}

}
