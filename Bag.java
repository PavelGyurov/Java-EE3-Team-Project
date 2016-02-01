package bag;

import product.Product;

public class Bag extends Product{
	
	private boolean forWaist;
	private boolean forArm;
	private boolean placeForLaptop;
	private boolean placeForTablet;
	
	private boolean forDSLR;
	private boolean forCompactCamera;
	
	public Bag(String model, double price, String description, int warranty, 
			boolean forWaist, boolean forArm, boolean placeForLaptop, boolean placeForTablet,
			boolean forDSLR, boolean forCompactCamera) {
		super(null, model, price, description, warranty);
		if(this.forDSLR){
			super.setType("forDSLR");
		}
		else{
			super.setType("forCompactCamera");
		}
		this.forArm = forArm;
		this.forWaist = forWaist;
		this.placeForLaptop = placeForLaptop;
		this.placeForTablet = placeForTablet;
	}
	
}
