package com.example.tapmouse.settingsActivity;

import android.view.View;

public class ActivitySettingPresenterImpl implements ActivitySettingPresenter {

    private SettingsActivity settingsActivity;

    public ActivitySettingPresenterImpl(SettingsActivity settingsActivity) {
        this.settingsActivity = settingsActivity;
    }

    @Override
    public void startActivityGame(View view) {
        settingsActivity.startActivityGame(view);
    }

    @Override
    public void sendFeedback(View view) {
        settingsActivity.sendFeedback(view);
    }
}
