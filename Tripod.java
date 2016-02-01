package com.company;

public class Tripod extends Product{

    private int loadCapacity;
    private double minHeight;
    private double maxHeight;
    private double weight;

    public Tripod(int loadCapacity, double minHeight, double maxHeight, double weight) {
       if (loadCapacity > 0 && minHeight > 0 && maxHeight > 0 && weight > 0){
           this.loadCapacity = loadCapacity;
           this.minHeight = minHeight;
           this.maxHeight = maxHeight;
           this.weight = weight;
       }
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public double getMinHeight() {
        return minHeight;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public double getWeight() {
        return weight;
    }
}
