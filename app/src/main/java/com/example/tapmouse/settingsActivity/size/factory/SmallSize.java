package com.example.tapmouse.settingsActivity.size.factory;

public class SmallSize implements SetSize {

    @Override
    public double mouseWidth(double width) {
        return width/12;
    }

    @Override
    public double mouseHeight(double height) {
        return height/13;
    }
}
