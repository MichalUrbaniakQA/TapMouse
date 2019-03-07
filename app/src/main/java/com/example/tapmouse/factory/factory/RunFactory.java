package com.example.tapmouse.factory.factory;

import android.widget.ImageView;

public class RunFactory {

    private boolean isMoveRight = true;
    private boolean isMoveLeft = false;
    private boolean isMoveDown = true;
    private boolean isMoveTop = false;

    private int marginTop;
    private int marginLeft;

    public void test(int distance, ImageView mouse, int height, int width) {
        checkRunSide(mouse, height, width);

        if (isMoveRight) {
            this.marginLeft += distance;
        }
        if (isMoveLeft) {
            this.marginLeft -= distance;
        }
        if (isMoveTop) {
            this.marginTop -= distance;
        }
        if (isMoveDown) {
            this.marginTop += distance;
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

    private Course course;

    public Course setPosition(ImageView mouse, int height, int width) {
        checkRunSide(mouse, height, width);

        //   if (isMoveRight && isMoveDown)
      //  Pair<Course, Course> p = new Pair<Course, Course>(new RunDown(), new RunLeft());
        //        return p;

        if (isMoveRight) {
   //         course = new RunRight();
            return new RunRight();
        }
        else if (isMoveLeft) {
   //         course = new RunLeft();
            return new RunLeft();
        }
        else if (isMoveTop) {
     //       course = new RunTop();
            return new RunTop();
        }
        else if (isMoveDown) {
   //         course = new RunDown();
            return new RunDown();
        }

        return null;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public int getMarginLeft() {
        return marginLeft;
    }
}
