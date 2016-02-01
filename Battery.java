package com.company;

public class Battery extends Product{

    private double voltage;
    private int amperage;
    private String size; //TO DO: make field enum

    //TO DO: factory method
    public Battery(double voltage, int amperage, String size) {
        if (voltage > 0){
            this.voltage = voltage;
        }
        if (amperage > 0){
            this.amperage = amperage;
        }
        if (size.equals("AA") || size.equals("AAA") || size.equals("Li-Ion")){
            this.size = size;
        }
    }

    public String getSize() {
        return size;
    }

    public double getVoltage() {
        return voltage;
    }

    public int getAmperage() {
        return amperage;
    }
}
