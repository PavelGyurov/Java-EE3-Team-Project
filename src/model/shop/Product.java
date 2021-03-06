package model.shop;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.swing.ImageIcon;

import org.apache.tomcat.util.codec.binary.Base64;

public class Product implements Serializable{
	private int id; //auto generated by database
	private String brand;
	private String description;
	private String model;
	private int amountInstock;
	private double price;
	private int warrantyMonths;
	private byte[] image;
	private String subcategory;
	

	// constructors
	public Product(int id, String brand, String model, String description, int amountInstock, double price, int warrantyMonths, String subcategory, byte[] image) {
		this.id = id;
		this.brand = brand;
		this.description = description;
		this.model = model;
		this.amountInstock = amountInstock;
		this.price = price;
		this.warrantyMonths = warrantyMonths;
        this.image = image;
        this.subcategory = subcategory;
	}

	// getters/setters


	// behaviour
	public double increaseAmount(double increase) {
		return amountInstock += increase;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public String getDescription() {
		return description;
	}

	public String getModel() {
		return model;
	}

	public int getAmountInstock() {
		return amountInstock;
	}

	public double getPrice() {
		return price;
	}

	public int getWarrantyMonths() {
		return warrantyMonths;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public double decreaseAmount(double decrease) {
		return amountInstock -= decrease;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setAmountInstock(int amountInstock) {
		this.amountInstock = amountInstock;
	}
	
	
}
