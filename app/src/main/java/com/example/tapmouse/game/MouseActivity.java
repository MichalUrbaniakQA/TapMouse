package com.example.tapmouse.game;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.tapmouse.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MouseActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView mouseImageView;

    private Thread mouseThread;
    private MouseRun mouseRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);

        System.out.println("sdfgdfghjhfgjkjhghjkiu6tr: " + getIntent().getIntExtra("speed", 10));


        getSupportActionBar().hide();

        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        mouseRunnable = new MouseRun(mouseImageView, this, outMetrics.heightPixels, outMetrics.widthPixels);
        mouseThread = new Thread(mouseRunnable, "mouseThread");
        mouseThread.start();
    }

    @OnClick(R.id.imageView)
    public void clickPet(View view) {
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.pisk1mp3);
        mp.start();
    }

    public void setParams(final RelativeLayout.LayoutParams layoutParams) {
        runOnUiThread(new Runnable() {
            public void run() {
                mouseImageView.setLayoutParams(layoutParams);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  mouseRunnable = null;
//
//        try {
//            mouseThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
      //  mouseThread = null;
    }
}
