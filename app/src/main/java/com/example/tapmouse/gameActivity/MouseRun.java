package com.example.tapmouse.gameActivity;

import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MouseRun implements Runnable {

    private ImageView mouse;
    private MouseActivity mouseActivity;
    private int screenWidth, screenHeight;

    private MousePosition mousePosition = new MousePosition();

    public MouseRun(ImageView mouse, MouseActivity mouseActivity, int heightPixels, int widthPixels) {
        this.mouseActivity = mouseActivity;
        this.mouse = mouse;
        this.screenHeight = heightPixels;
        this.screenWidth = widthPixels;
    }

    @Override
    public void run() {
        while (true) {

//            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(90, 135);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(328, 367);
            layoutParams.setMargins(mousePosition.getMarginLeft(), mousePosition.getMarginTop(), 0, 0);

            mouseActivity.setParams(layoutParams);

            mouseSpeed();

            mousePosition.setCourse(10, mouse, screenHeight, screenWidth);
        }
    }

    private void mouseSpeed() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
