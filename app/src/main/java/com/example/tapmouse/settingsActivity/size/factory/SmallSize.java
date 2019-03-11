package com.example.tapmouse.settingsActivity.size.factory;

public class SmallSize implements SetSize {

    @Override
    public int mouseWidth(int width) {
        return width / 8;
    }

    @Override
    public int mouseHeight(int height) {
        return height / 13;
    }
}
