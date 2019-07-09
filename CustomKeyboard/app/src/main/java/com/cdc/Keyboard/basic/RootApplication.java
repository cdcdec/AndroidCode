package com.cdc.keyboard.basic;

import androidx.multidex.MultiDexApplication;
import com.cdc.keyboard.db.DatabaseHelper;
import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.unit.Subunits;

public class RootApplication extends MultiDexApplication {
    private static RootApplication application;

    public static RootApplication getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        AutoSizeConfig.getInstance().getUnitsManager()
                .setSupportDP(false)
                .setSupportSP(false)
                .setSupportSubunits(Subunits.PT);

        new DatabaseHelper(this);
    }
}
