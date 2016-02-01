package lens;
import product.Product;

public class VarioLens extends Product {


	private class LensSize{
		int min;
		int max;
		
		LensSize(int min, int max){
			this.min = min;
			this.max = max;
		}
	}
	
	 class BlendSize{
		double min;
		double max;
		
		BlendSize(double min, double max){
			this.min = min;
			this.max = max;
		}
	}
	
	private LensSize lensSize;
	private BlendSize blendSize;
	
	
	
	public VarioLens(String model, double price, String description, int warranty, LensSize lensSize, BlendSize blendSize) {
		super("vario", model, price, description, warranty);
		this.lensSize = lensSize;
		this.blendSize = blendSize;
	}
	

}
