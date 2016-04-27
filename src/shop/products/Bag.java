package shop.products;

import shop.Product;
import shop.enums.CameraType;
import shop.enums.DevicePlaceType;
import shop.enums.WearPlaceType;

public class Bag extends Product {
	private WearPlaceType wearPlaceType;
	private DevicePlaceType devicePlaceType;
	private CameraType cameraType;

	public Bag(String name, String description, String model, int amount,
			double price, int warrantyMonths, WearPlaceType wearPlaceType,
			DevicePlaceType devicePlaceType, CameraType cameraType, String image) {
		super(name, description, model, amount, price, warrantyMonths, image);
		this.wearPlaceType = wearPlaceType;
		this.devicePlaceType = devicePlaceType;
		this.cameraType = cameraType;
	}

	public WearPlaceType getWearPlaceType() {
		return wearPlaceType;
	}

	public void setWearPlaceType(WearPlaceType wearPlaceType) {
		this.wearPlaceType = wearPlaceType;
	}

	public DevicePlaceType getDevicePlaceType() {
		return devicePlaceType;
	}

	public void setDevicePlaceType(DevicePlaceType devicePlaceType) {
		this.devicePlaceType = devicePlaceType;
	}

	public CameraType getCameraType() {
		return cameraType;
	}

	public void setCameraType(CameraType cameraType) {
		this.cameraType = cameraType;
	}

}
