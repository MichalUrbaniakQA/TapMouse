package com.example.tapmouse.factory.factory;

public class RunTop implements Course {

    @Override
    public int setCourse(int marginTop, int distance) {
        marginTop -= distance;
        return marginTop;
    }
}
