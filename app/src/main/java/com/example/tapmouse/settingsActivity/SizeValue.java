package com.example.tapmouse.settingsActivity;

import com.example.tapmouse.settingsActivity.size.factory.SizeEnum;
import com.example.tapmouse.settingsActivity.size.factory.SizeSize;
import com.example.tapmouse.settingsActivity.size.factory.MediumSize;
import com.example.tapmouse.settingsActivity.size.factory.SetSize;
import com.example.tapmouse.settingsActivity.size.factory.SmallSize;

public class SizeValue {

    SetSize mouseLarge(SizeEnum sizeEnum){

        SetSize setSize = null;

        switch (sizeEnum){
            case SMALL:
                setSize = new SmallSize();
                break;

            case MEDIUM:
                setSize = new MediumSize();
                break;

            case LARGE:
                setSize = new SizeSize();
                break;
        }

        return setSize;
    }
}
