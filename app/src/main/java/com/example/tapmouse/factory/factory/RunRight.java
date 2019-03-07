package com.example.tapmouse.factory.factory;

public class RunRight implements Course {

    @Override
    public int setCourse(int marginLeft, int distance) {
        marginLeft += distance;
        return marginLeft;
    }
}
