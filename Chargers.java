package com.company;

import java.util.ArrayList;

public class Chargers extends Product{

    private int batterySlots;
    private ArrayList<String> types; //TO DO: make enum
    private ArrayList<String> extras;
    private double voltage;
    private int amperage;

    public Chargers(int batterySlots, double voltage, int amperage) {

        if (voltage > 0 && amperage > 0 && batterySlots > 0 && batterySlots < 8){
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

    public ArrayList<String> getTypes() {
        return types;
    }

    public ArrayList<String> getExtras() {
        return extras;
    }

    public double getVoltage() {
        return voltage;
    }

    public int getAmperage() {
        return amperage;
    }
}
