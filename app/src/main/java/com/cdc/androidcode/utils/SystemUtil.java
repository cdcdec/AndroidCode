package com.cdc.androidcode.utils;

public class SystemUtil {
    /**
     * 获取当前手机系统版本号
     *
     * @return  系统版本号
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取当前手机系统API level
     *
     * @return  API level
     */
    public static int getSystemLevel(){
        return android.os.Build.VERSION.SDK_INT;
    }


}
