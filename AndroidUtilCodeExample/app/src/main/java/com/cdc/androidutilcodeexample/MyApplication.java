package com.cdc.androidutilcodeexample;

import android.app.Application;
import android.content.Context;

import com.log.MLog;

public class MyApplication extends Application{
    private static Context context;

    @Override
    public void onCreate() {
       super.onCreate();
        context = getApplicationContext();
        MLog.init(this);

    }

    public static Context getContext() {
        return context;
    }
}
