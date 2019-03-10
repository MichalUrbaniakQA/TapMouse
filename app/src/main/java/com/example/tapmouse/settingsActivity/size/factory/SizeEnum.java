package com.example.tapmouse.settingsActivity.size.factory;

public enum SizeEnum {

    SMALL(12,13),
    MEDIUM(5,7),
    LARGE(3,5);

    private int width;
    private int height;

    SizeEnum(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
