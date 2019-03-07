package com.example.tapmouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.tapmouse.game.MouseActivity;
import com.example.tapmouse.settings.SettingsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private ActivityMainPresenter presenterGame;

    @BindView(R.id.settings)
    ImageView wheel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ButterKnife.bind(this);
        presenterGame = new ActivityMainPresenterImpl(this);

        getSupportActionBar().hide();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate_wheel);
        wheel.startAnimation(animation);
    }

    @OnClick(R.id.exitButton)
    public void clickExit(View view) {
        finish();
    }

    @OnClick(R.id.playButton)
    public void clickPlay() {
        presenterGame.startActivityGame();

//        new AlertDialog.Builder(this)
//                .setMessage("asd")
//                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                    }
//                })
//                .create()
//                .show();
    }

    @OnClick(R.id.settings)
    public void clickSettings() {
        presenterGame.startActivitySettings();
    }

    public void startActivitySettings() {
        startActivity(new Intent(this, SettingsActivity.class));
    }

    public void startActivityGame() {

        Intent intent = new Intent(this, MouseActivity.class);
        intent.putExtra("speed", 50);

        startActivity(intent);

//        startActivity(new Intent(this, MouseActivity.class));
    }
}
