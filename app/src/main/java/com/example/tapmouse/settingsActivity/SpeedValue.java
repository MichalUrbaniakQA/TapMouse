package com.example.tapmouse.settingsActivity;

import com.example.tapmouse.settingsActivity.speed.factory.FastSpeed;
import com.example.tapmouse.settingsActivity.speed.factory.NormalSpeed;
import com.example.tapmouse.settingsActivity.speed.factory.SetSpeed;
import com.example.tapmouse.settingsActivity.speed.factory.SlowSpeed;
import com.example.tapmouse.settingsActivity.speed.factory.SpeedEnum;

public class SpeedValue {

    SetSpeed mouseSpeed(SpeedEnum speedEnum) {

        SetSpeed setSpeed = null;

        switch (speedEnum) {
            case SLOW:
                setSpeed = new SlowSpeed();
                break;

            case NORMAL:
                setSpeed = new NormalSpeed();
                break;

            case FAST:
                setSpeed = new FastSpeed();
                break;
        }

        return setSpeed;
    }
}
