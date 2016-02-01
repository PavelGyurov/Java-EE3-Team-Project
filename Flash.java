package flash;

import product.Product;

public class Flash extends Product{
	
	private int mainNumber;
	private boolean wirelessControlFlashes;
	
	

	public Flash(String model, double price, String description, int warranty, int mainNumber,
			boolean wirelessControlFlashes) {
		super("flash", model, price, description, warranty);
		this.mainNumber = mainNumber;
		this.wirelessControlFlashes = wirelessControlFlashes;
	}
	
}
