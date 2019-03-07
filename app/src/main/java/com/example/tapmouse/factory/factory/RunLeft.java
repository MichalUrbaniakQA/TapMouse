package com.example.tapmouse.factory.factory;

public class RunLeft implements Course {

    @Override
    public int setCourse(int marginLeft, int distance) {
        marginLeft -= distance;
        return marginLeft;
    }
}
