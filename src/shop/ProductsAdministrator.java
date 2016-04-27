package shop;

import shop.enums.*;

public class ProductsAdministrator {

    private String username;
    private String password;

    public ProductsAdministrator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password){
        // if username and password match database
        if (username == username) {
            ProductsAdministrator admin = new ProductsAdministrator(username, password);
            return true;
        }
        return false;
    }

    public void addBag(String name, String description, String model, int amount,
                       double price, int warrantyMonths, WearPlaceType wearPlaceType,
                       DevicePlaceType devicePlaceType, CameraType cameraType){
        //insert query
    }

    public void addBattery(String name, String description, String model,
                           int	 amount, double price, int warrantyMonths, double voltage,
                           int amperage, BatterySizeType sizeType, BatteryTechnologyType technologyType){
        //insert query
    }

    public void addCamera(String name, String description, String model, int amount,
                          double price, int warrantyMonths, double megaPixels,
                          int isoStandard, int shutterSpeed, double displaySiz){
        //insert query
    }

    public void addCharger(String name, String description, String model,
                           int amount, double price, int warrantyMonths, int batterySlots,
                           double voltage, double amperage){
        //insert query
    }

    public void addFilter(String name, String description, String model,
                          int amount, double price, int warrantyMonths, double diameter,
                          double thickness){
        //insert query
    }

    public void addFlash(String name, String description, String model, int amount,
                         double price, int warrantyMonths, int mainNumber,
                         boolean isWirelessControlled){
        //insert query
    }

    public void addHardLens(String name, String description, String model, int amountInstock, double price,
                            int warrantyMonths, int lensSize, double blendSizeMin, double blendSizeMax){
        //insert query
    }

    public void addMemory(String name, String description, String model, int amount,
                          double price, int warrantyMonths, int memoryCapacity,
                          MemoryClass memoryClass, MemoryType memoryType, int readingSpeed, int writingSpeed){
        //insert query
    }

    public void addTripod(String name, String description, String model, int amount,
                          double price, int warrantyMonths, int loadCapacity,
                          double minHeight, double maxHeight, double weight){
        //insert query
    }

    public void addVarioLens(String name, String description, String model, int amountInstock,
                             double price, int warrantyMonths, int lensSizeMin,
                             int lensSizeMax, double blendSizeMin, double blendSizeMax){
        //insert query
    }
}
