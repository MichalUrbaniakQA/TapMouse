package com.example.tapmouse.factory.factory;

public class RunDown implements Course {

    @Override
    public int setCourse(int marginTop, int distance) {
        marginTop += distance;
        return marginTop;
    }
}
