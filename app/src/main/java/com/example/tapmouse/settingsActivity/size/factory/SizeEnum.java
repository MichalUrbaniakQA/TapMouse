package com.example.tapmouse.settingsActivity.size.factory;

public enum SizeEnum {

    SMALL(12,13),
    MEDIUM(5.20,7.50),
    LARGE(3.30,5);

    private double width;
    private double height;

    SizeEnum(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
