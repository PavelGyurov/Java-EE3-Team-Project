package camera;

import product.Product;

public abstract class Camera extends Product{
	private double mp;
	private int iso;
	private int shutterSpeed;
	private double displaySize;
	
	
	
	
	public Camera(String type, String model, double price, String description, int warranty, double mp, int iso, int shutterSpeed, double displaySize) {
		super(type, model, price, description, warranty);
		this.mp = mp;
		this.iso = iso;
		this.shutterSpeed = shutterSpeed;
		this.displaySize = displaySize;
	}
		
	
	public double getMp() {
		return mp;
	}
	public void setMp(double mp) {
		this.mp = mp;
	}
	public int getIso() {
		return iso;
	}
	public void setIso(int iso) {
		this.iso = iso;
	}
	public int getShutterSpeed() {
		return shutterSpeed;
	}
	public void setShutterSpeed(int shutterSpeed) {
		this.shutterSpeed = shutterSpeed;
	}
	public double getDisplaySize() {
		return displaySize;
	}
	public void setDisplaySize(double displaySize) {
		this.displaySize = displaySize;
	}
	
	
}
