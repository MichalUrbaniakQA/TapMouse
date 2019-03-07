package com.example.tapmouse.settings;

public class ActivitySettingPresenterImpl implements ActivitySettingPresenter {

    private SettingsActivity settingsActivity;

    public ActivitySettingPresenterImpl(SettingsActivity settingsActivity) {
        this.settingsActivity = settingsActivity;
    }

    @Override
    public void startActivityGame() {
        settingsActivity.startActivityGame();
    }
}
