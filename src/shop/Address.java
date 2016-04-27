package shop;

import shop.enums.AddressType;

public class Address {
	private String country;
	private String province;
	private String city;
	private String county;
	private String street;
	private int number;
	private int building;
	private String entrance;
	private int floor;
	private int apartment;
	private AddressType addressType;
	
	// constructors
	public Address(String country, String province, String city, String county, String street, int number,
			int building, String entrance, int floor, int apartment, AddressType addressType) {
		this.country = country;
		this.province = province;
		this.city = city;
		this.county = county;
		this.street = street;
		this.number = number;
		this.building = building;
		this.entrance = entrance;
		this.floor = floor;
		this.apartment = apartment;
		this.addressType = addressType;
	}

	// getters/setters
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getBuilding() {
		return building;
	}

	public void setBuilding(int building) {
		this.building = building;
	}

	public String getEntrance() {
		return entrance;
	}

	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getApartment() {
		return apartment;
	}

	public void setApartment(int apartment) {
		this.apartment = apartment;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	// behavior
	public String getFullAddress() {
		// TODO
		return "construct full address";
	}

}
