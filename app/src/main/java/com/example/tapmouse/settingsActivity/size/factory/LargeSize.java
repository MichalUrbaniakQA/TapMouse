package com.example.tapmouse.settingsActivity.size.factory;

public class LargeSize implements SetSize {

    @Override
    public int mouseWidth(int width) {
        return width / 3;
    }

    @Override
    public int mouseHeight(int height) {
        return height / 5;
    }
}
