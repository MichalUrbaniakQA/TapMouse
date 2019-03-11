package com.example.tapmouse.gameActivity;

import android.widget.ImageView;

class MousePosition {

    private boolean isMoveRight = true;
    private boolean isMoveLeft = false;
    private boolean isMoveDown = true;
    private boolean isMoveTop = false;

    private int marginTop, marginLeft;

    private MouseActivity mouseActivity;

    void setCourse(MouseActivity mouseActivity, ImageView mouse, int screenHeight, int screenWidth) {
        this.mouseActivity = mouseActivity;

        checkRunSide(mouse, screenHeight, screenWidth);

        int corner = 0;

        int distance = 10;

        if (isMoveRight && isMoveDown) {
            this.marginLeft += distance;
            this.marginTop += distance;
            corner = 315;
        }
        if (isMoveLeft && isMoveDown) {
            this.marginLeft -= distance;
            this.marginTop += distance;
            corner = 45;
        }
        if (isMoveLeft && isMoveTop) {
            this.marginLeft -= distance;
            this.marginTop -= distance;
            corner = 135;
        }
        if (isMoveTop && isMoveRight) {
            this.marginLeft += distance;
            this.marginTop -= distance;
            corner = 225;
        }

        setRotation(mouse, corner);
    }

    private void setRotation(final ImageView imageView, final int corner) {
        mouseActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                imageView.setRotation(corner);
            }
        });
    }

    private void checkRunSide(ImageView mouse, int screenHeight, int screenWidth) {
        if (mouse.getBottom() <= mouse.getHeight()) {
            isMoveDown = true;
            isMoveTop = false;
        }
        if (mouse.getBottom() + mouse.getHeight() > screenHeight) {
            isMoveDown = false;
            isMoveTop = true;
        }
        if (mouse.getRight() <= mouse.getWidth()) {
            isMoveRight = true;
            isMoveLeft = false;
        }
        if (mouse.getRight() == screenWidth) {
            isMoveRight = false;
            isMoveLeft = true;
        }
    }

    int getMarginTop() {
        return marginTop;
    }

    int getMarginLeft() {
        return marginLeft;
    }
}
