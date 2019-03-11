package com.example.tapmouse.settingsActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.tapmouse.R;
import com.example.tapmouse.gameActivity.MouseActivity;
import com.example.tapmouse.mainActivity.MainActivity;
import com.example.tapmouse.settingsActivity.size.factory.SetSize;
import com.example.tapmouse.settingsActivity.size.factory.SizeEnum;
import com.example.tapmouse.settingsActivity.speed.factory.SetSpeed;
import com.example.tapmouse.settingsActivity.speed.factory.SpeedEnum;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class SettingsActivity extends AppCompatActivity {

    private SpeedValue speedValue;
    private SetSpeed setSpeed;

    private SizeValue sizeValue;
    private SetSize setSize;

    @BindView(R.id.feedbackTextEditor)
    EditText feedbackEditText;

    @BindView(R.id.slowSwitch)
    Switch slow;
    @BindView(R.id.normalSwitch)
    Switch normal;
    @BindView(R.id.fastSwitch)
    Switch fast;

    @BindView(R.id.smallSwitch)
    Switch small;
    @BindView(R.id.mediumSwitch)
    Switch medium;
    @BindView(R.id.largeSwitch)
    Switch large;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ButterKnife.bind(this);

        speedValue = new SpeedValue();
        sizeValue = new SizeValue();

        getSupportActionBar().hide();

        normal.setChecked(true);
        medium.setChecked(true);
    }

    @OnClick(R.id.backButton)
    public void clickBack() {
        finish();
    }

    @OnClick(R.id.playButtonSettingView)
    public void startActivityGame() {
        Intent intent = new Intent(this, MouseActivity.class);

        intent.putExtra("speed", setSpeed.speed());
        intent.putExtra("width", setSize.mouseWidth(MainActivity.widthWindow));
        intent.putExtra("height", setSize.mouseHeight(MainActivity.heightWindow));

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

    @OnCheckedChanged({R.id.slowSwitch, R.id.normalSwitch, R.id.fastSwitch})
    public void setMouseSpeed(Switch switchButton, boolean isChecked) {
        if (isChecked)
            switch (switchButton.getId()) {
                case R.id.slowSwitch:
                    setSlowSpeed();
                    break;

                case R.id.normalSwitch:
                    setNormalSpeed();
                    break;

                case R.id.fastSwitch:
                    setFastSpeed();
                    break;
            }
    }

    @OnCheckedChanged({R.id.smallSwitch, R.id.mediumSwitch, R.id.largeSwitch})
    public void setMouseSize(Switch switchButton, boolean isChecked) {
        if (isChecked)
            switch (switchButton.getId()) {
                case R.id.smallSwitch:
                    setSmallSize();
                    break;

                case R.id.mediumSwitch:
                    setMediumSize();
                    break;

                case R.id.largeSwitch:
                    setLargeSize();
                    break;
            }
    }

    private void setSlowSpeed() {
        normal.setChecked(false);
        fast.setChecked(false);
        this.setSpeed = speedValue.mouseSpeed(SpeedEnum.SLOW);
    }

    private void setNormalSpeed() {
        slow.setChecked(false);
        fast.setChecked(false);
        this.setSpeed = speedValue.mouseSpeed(SpeedEnum.NORMAL);
    }

    private void setFastSpeed() {
        slow.setChecked(false);
        normal.setChecked(false);
        this.setSpeed = speedValue.mouseSpeed(SpeedEnum.FAST);
    }

    private void setSmallSize() {
        medium.setChecked(false);
        large.setChecked(false);
        this.setSize = sizeValue.mouseSize(SizeEnum.SMALL);
    }

    private void setMediumSize() {
        small.setChecked(false);
        large.setChecked(false);
        this.setSize = sizeValue.mouseSize(SizeEnum.MEDIUM);
    }

    private void setLargeSize() {
        small.setChecked(false);
        medium.setChecked(false);
        this.setSize = sizeValue.mouseSize(SizeEnum.LARGE);
    }

    private Intent prepareDataToSendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        String[] TO = {"urbaniak.michal@yahoo.com"};

        emailIntent.setDataAndType(Uri.parse("mailto:"), "text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from app :)");
        emailIntent.putExtra(Intent.EXTRA_TEXT, feedbackEditText.getText());

        return emailIntent;
    }
}
