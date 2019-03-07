package com.example.tapmouse.game;

import android.widget.ImageView;

public class MousePosition {

    private boolean isMoveRight = true;
    private boolean isMoveLeft = false;
    private boolean isMoveDown = true;
    private boolean isMoveTop = false;

    private int marginTop;
    private int marginLeft;

    public void setCourse(int distance, ImageView mouse, int height, int width) {
        checkRunSide(mouse, height, width);

        if (isMoveRight && isMoveDown) {
            this.marginLeft += distance;
            this.marginTop += distance;
            mouse.setRotation(315);
        }
        if (isMoveLeft && isMoveDown) {
            this.marginLeft -= distance;
            this.marginTop += distance;
            mouse.setRotation(45);
        }
        if (isMoveLeft && isMoveTop) {
            this.marginLeft -= distance;
            this.marginTop -= distance;
            mouse.setRotation(135);
        }
        if (isMoveTop && isMoveRight) {
            this.marginLeft += distance;
            this.marginTop -= distance;
            mouse.setRotation(225);
        }
    }

    private void checkRunSide(ImageView mouse, int height, int width) {
        if (mouse.getBottom() <= mouse.getHeight()) {
            isMoveDown = true;
            isMoveTop = false;
        }
        if (mouse.getBottom() + mouse.getHeight() > height) {
            isMoveDown = false;
            isMoveTop = true;
        }
        if (mouse.getRight() <= mouse.getWidth()) {
            isMoveRight = true;
            isMoveLeft = false;
        }
        if (mouse.getRight() == width) {
            isMoveRight = false;
            isMoveLeft = true;
        }
    }

    public int getMarginTop() {
        return marginTop;
    }

    public int getMarginLeft() {
        return marginLeft;
    }
}
