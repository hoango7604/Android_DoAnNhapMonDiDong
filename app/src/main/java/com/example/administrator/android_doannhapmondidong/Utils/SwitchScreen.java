package com.example.administrator.android_doannhapmondidong.Utils;

import android.content.Context;
import android.content.Intent;

import java.io.Serializable;

public class SwitchScreen {
    public static void SwitchView(Context context, Class activityClass, String extraName, String extraContent){
        Intent intent = new Intent(context, activityClass);
        if (extraContent != null){
            intent.putExtra(extraName, extraContent);
        }
        context.startActivity(intent);
    }

    public static void SwitchView(Context context, Class activityClass, String extraName, Serializable extraContent){
        Intent intent = new Intent(context, activityClass);
        if (extraContent != null){
            intent.putExtra(extraName, extraContent);
        }
        context.startActivity(intent);
    }
}