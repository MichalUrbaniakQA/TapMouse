package com.example.tapmouse.mainActivity;

public class ActivityMainPresenterImpl implements ActivityMainPresenter {

    private MainActivity mainActivity;

    ActivityMainPresenterImpl(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void startActivityGame() {
        mainActivity.startActivityGame();
    }

    @Override
    public void startActivitySettings() {
        mainActivity.startActivitySettings();
    }
}
