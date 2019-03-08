package com.example.tapmouse.gameActivity;

import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MouseRun implements Runnable {

    private ImageView mouse;
    private MouseActivity mouseActivity;
    private int screenWidth, screenHeight;
    private int speed;

    private MousePosition mousePosition = new MousePosition();

    public MouseRun(ImageView mouse, MouseActivity mouseActivity, int heightPixels, int widthPixels) {
        this.mouseActivity = mouseActivity;
        this.mouse = mouse;
        this.screenHeight = heightPixels;
        this.screenWidth = widthPixels;
       // this.speed = mouseActivity.getIntent().getIntExtra("speed", 10);
     //   System.out.println(heightPixels + " " + widthPixels);

    }

    @Override
    public void run() {
        while (true) {

//            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(90, 135);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(90, 135);
            layoutParams.setMargins(mousePosition.getMarginLeft(), mousePosition.getMarginTop(), 0, 0);

            mouseActivity.setParams(layoutParams);

            speed = mouseActivity.getIntent().getIntExtra("speed", 1);
            System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb " + speed);

            mouseSpeed(speed);

            mousePosition.setCourse(10, mouse, screenHeight, screenWidth);


        //    System.out.println(mouse.getWidth() + " " + mouse.getHeight());
       //     System.out.println(mouseActivity.getIntent().toString());
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
