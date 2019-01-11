package com.example.administrator.android_doannhapmondidong.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CheckConnection {
    public static boolean isOnline(Context ctx) {

        NetworkInfo info = (NetworkInfo) ((ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info == null && !info.isConnected() ) {
            return false;
        }
        if (info.isRoaming()) {
            return false;
        }
        return true;
    }
}