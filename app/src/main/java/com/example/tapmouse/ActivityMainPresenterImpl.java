package com.example.tapmouse;

public class ActivityMainPresenterImpl implements ActivityMainPresenter {

    private MainActivity mainActivity;

    public ActivityMainPresenterImpl(MainActivity mainActivity) {
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
