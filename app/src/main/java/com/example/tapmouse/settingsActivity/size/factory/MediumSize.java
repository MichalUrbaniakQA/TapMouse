package com.example.tapmouse.settingsActivity.size.factory;

public class MediumSize implements SetSize {

    @Override
    public int mouseWidth(int width) {
        return width / 5;
    }

    @Override
    public int mouseHeight(int height) {
        return height / 7;
    }
}
