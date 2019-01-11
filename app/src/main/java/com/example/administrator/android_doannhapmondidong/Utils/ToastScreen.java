package com.example.administrator.android_doannhapmondidong.Utils;

import android.content.Context;
import android.widget.Toast;

public class ToastScreen {
    public static void ShowToast_Short(Context context, String thongbao){
        Toast.makeText(context, thongbao, Toast.LENGTH_SHORT).show();
    }
}
