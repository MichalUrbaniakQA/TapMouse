package com.example.tapmouse.settingsActivity.size.factory;

public class SizeSize implements SetSize {

    @Override
    public double mouseWidth(double width) {
        return width/3.30;
    }

    @Override
    public double mouseHeight(double height) {
        return height/5;
    }
}
