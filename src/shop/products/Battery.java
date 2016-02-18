package shop.products;

import shop.Product;
import shop.enums.BatterySizeType;
import shop.enums.BatteryTechnologyType;

public class Battery extends Product {

	private double voltage;
	private int amperage;
	private BatterySizeType sizeType;
	private BatteryTechnologyType technologyType;

	public Battery(String name, String description, String model,
			int	 amount, double price, int warrantyMonths, double voltage,
			int amperage, BatterySizeType sizeType, BatteryTechnologyType technologyType) {
		super(name, description, model, amount, price, warrantyMonths);
		this.voltage = voltage;
		this.amperage = amperage;
		this.sizeType = sizeType;
		this.technologyType = technologyType;

	}

	public BatterySizeType getSizeType() {
		return sizeType;
	}

	public double getVoltage() {
		return voltage;
	}

	public int getAmperage() {
		return amperage;
	}

	public BatteryTechnologyType getTechnologyType() {
		return technologyType;
	}

	public void setVoltage(double voltage) {
		this.voltage = voltage;
	}

	public void setAmperage(int amperage) {
		this.amperage = amperage;
	}

	public void setSizeType(BatterySizeType sizeType) {
		this.sizeType = sizeType;
	}

	public void setTechnologyType(BatteryTechnologyType technologyType) {
		this.technologyType = technologyType;
	}

}
