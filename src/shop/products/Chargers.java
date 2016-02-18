package shop.products;

import java.util.ArrayList;
import java.util.List;

import shop.Product;

public class Chargers extends Product {
	private static final int MAX_BATTERY_SLOTS = 8;

	private int batterySlots;
	private double voltage;
	private double amperage;

	private List<String> types; // TO DO: make enum
	private List<String> extras;

	public Chargers(String name, String description, String model,
			int amount, double price, int warrantyMonths, int batterySlots,
			double voltage, double amperage) {
		super(name, description, model, amount, price, warrantyMonths);
		if (voltage > 0 && amperage > 0 && batterySlots > 0
				&& batterySlots <= MAX_BATTERY_SLOTS) {
			this.batterySlots = batterySlots;
			this.voltage = voltage;
			this.amperage = amperage;
		}
		this.types = new ArrayList<String>();
		this.extras = new ArrayList<String>();
	}

	public int getBatterySlots() {
		return batterySlots;
	}

	public List<String> getTypes() {
		return types;
	}

	public List<String> getExtras() {
		return extras;
	}

	public double getVoltage() {
		return voltage;
	}

	public double getAmperage() {
		return amperage;
	}

	public void setBatterySlots(int batterySlots) {
		this.batterySlots = batterySlots;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public void setExtras(List<String> extras) {
		this.extras = extras;
	}

	public void setVoltage(double voltage) {
		this.voltage = voltage;
	}

	public void setAmperage(double amperage) {
		this.amperage = amperage;
	}
}
