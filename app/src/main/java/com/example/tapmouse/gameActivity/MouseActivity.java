package com.example.tapmouse.gameActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
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

        getSupportActionBar().hide();

        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        mouseRunnable = new MouseRun(mouseImageView, this, outMetrics.heightPixels, outMetrics.widthPixels);
        mouseThread = new Thread(mouseRunnable, "mouseThread");
        mouseThread.start();

    //    System.out.println("sdfgdfghjhfgjkjhghjkiu6tr: " + getIntent().getIntExtra("width", 10));
//        System.out.println("sdfgdfghjhfgjkjhghjkiu6tr: " + getIntent().getIntExtra("height", 10));
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
    }
}
