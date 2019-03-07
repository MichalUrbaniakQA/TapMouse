package com.example.tapmouse.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.tapmouse.R;
import com.example.tapmouse.game.MouseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends AppCompatActivity {

    private ActivitySettingPresenter presenterGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ButterKnife.bind(this);

        presenterGame = new ActivitySettingPresenterImpl(this);

        getSupportActionBar().hide();
    }

    @OnClick(R.id.backButton)
    public void clickBack(View view) {
        finish();
    }

    @OnClick(R.id.playButtonSettingView)
    public void startActivityGame() {
        Intent intent = new Intent(this, MouseActivity.class);
        intent.putExtra("speed", 50);

        startActivity(intent);
    }


}
