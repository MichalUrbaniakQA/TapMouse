package com.example.tapmouse.settingsActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tapmouse.R;
import com.example.tapmouse.gameActivity.MouseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends AppCompatActivity {

    private ActivitySettingPresenter presenterGame;

    @BindView(R.id.feedbackTextEditor)
    EditText feedbackEditText;

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
    public void startActivityGame(View view) {
        Intent intent = new Intent(this, MouseActivity.class);
        intent.putExtra("speed", 50);

        startActivity(intent);
    }

    @OnClick(R.id.feedbackLayout)
    public void sendFeedback(View view) {
        try {
            startActivity(Intent.createChooser(prepareDataToSendEmail(), "Send mail..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(SettingsActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private Intent prepareDataToSendEmail(){
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        String[] TO = {"urbaniak.michal@yahoo.com"};

        emailIntent.setDataAndType(Uri.parse("mailto:"), "text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from app :)");
        emailIntent.putExtra(Intent.EXTRA_TEXT, feedbackEditText.getText());

        return emailIntent;
    }
}
