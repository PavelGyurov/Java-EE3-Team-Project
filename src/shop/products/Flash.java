package shop.products;

import shop.Product;

public class Flash extends Product {
	private int mainNumber;
	private boolean isWirelessControlled;

	public Flash(String name, String description, String model, int amount,
			double price, int warrantyMonths, int mainNumber,
			boolean isWirelessControlled) {
		super(name, description, model, amount, price, warrantyMonths);
		this.mainNumber = mainNumber;
		this.isWirelessControlled = isWirelessControlled;
	}

	public int getMainNumber() {
		return mainNumber;
	}

	public void setMainNumber(int mainNumber) {
		this.mainNumber = mainNumber;
	}

	public boolean isWirelessControlled() {
		return isWirelessControlled;
	}

	public void setWirelessControlled(boolean isWirelessControlled) {
		this.isWirelessControlled = isWirelessControlled;
	}

}
