package com.cdc.keyboard.basic;

import androidx.multidex.MultiDexApplication;

public class RootApplication extends MultiDexApplication {
    private static RootApplication application;

    public static RootApplication getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
    }
}
