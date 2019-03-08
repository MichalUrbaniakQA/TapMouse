package com.example.tapmouse.settingsActivity.size.factory;

public class MediumSize implements SetSize {

    @Override
    public double mouseWidth(double width) {
        return width/5.20;
    }

    @Override
    public double mouseHeight(double height) {
        return height/7.50;
    }
}
