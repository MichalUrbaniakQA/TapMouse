package com.example.tapmouse.gameActivity;

import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MouseRun implements Runnable {

    private ImageView mouse;
    private MouseActivity mouseActivity;
    private int screenWidth, screenHeight;
    private int defaultNormalHeightMouse, defaultNormalWidthMouse;

    private MousePosition mousePosition = new MousePosition();

    public MouseRun(ImageView mouse, MouseActivity mouseActivity, int heightPixels, int widthPixels) {
        this.mouseActivity = mouseActivity;
        this.mouse = mouse;
        this.screenHeight = heightPixels;
        this.screenWidth = widthPixels;
        this.defaultNormalHeightMouse = screenHeight / 7;
        this.defaultNormalWidthMouse = screenHeight / 5;
    }

    @Override
    public void run() {
        while (true) {

            int speedMouse = mouseActivity.getIntent().getIntExtra("speed", 30);
            int widthMouse = mouseActivity.getIntent().getIntExtra("height", defaultNormalHeightMouse);
            int heightMouse = mouseActivity.getIntent().getIntExtra("width", defaultNormalWidthMouse);

            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(widthMouse, heightMouse);
            layoutParams.setMargins(mousePosition.getMarginLeft(), mousePosition.getMarginTop(), 0, 0);

            mouseActivity.setParams(layoutParams);

            mouseSpeed(speedMouse);

            mousePosition.setCourse(10, mouse, screenHeight + defaultNormalHeightMouse, screenWidth);
        }
    }

    private void mouseSpeed(int speed) {
        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
