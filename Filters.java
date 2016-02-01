package com.company;

public class Filters extends Product{

    private int diameter;
    private int thickness;

    public Filters(int diameter, int thickness) {
        if (diameter > 0 && thickness > 0){
            this.diameter = diameter;
            this.thickness = thickness;
        }
    }

    public int getDiameter() {
        return diameter;
    }

    public int getThickness() {
        return thickness;
    }
}
