package com.cdc.okhttp;
import android.app.Application;
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        MLog.init(this);

        //崩溃日志保存
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(getApplicationContext());

    }
}
