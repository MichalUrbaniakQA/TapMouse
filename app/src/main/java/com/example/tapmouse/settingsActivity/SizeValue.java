package com.example.tapmouse.settingsActivity;

import com.example.tapmouse.settingsActivity.size.factory.LargeSize;
import com.example.tapmouse.settingsActivity.size.factory.MediumSize;
import com.example.tapmouse.settingsActivity.size.factory.SetSize;
import com.example.tapmouse.settingsActivity.size.factory.SizeEnum;
import com.example.tapmouse.settingsActivity.size.factory.SmallSize;

public class SizeValue {

    SetSize mouseSize(SizeEnum sizeEnum) {

        SetSize setSize = null;

        switch (sizeEnum) {
            case SMALL:
                setSize = new SmallSize();
                break;

            case MEDIUM:
                setSize = new MediumSize();
                break;

            case LARGE:
                setSize = new LargeSize();
                break;
        }

        return setSize;
    }
}
