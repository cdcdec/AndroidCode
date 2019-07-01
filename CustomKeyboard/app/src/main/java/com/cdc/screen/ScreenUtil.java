package com.cdc.screen;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

public class ScreenUtil{
    private final  String TAG="dpi";
    public  ScreenInfo screen(Activity activity){
        DisplayMetrics displayMetrics=new DisplayMetrics();
        WindowManager windowManager=activity.getWindowManager();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        ScreenInfo screenInfo=new ScreenInfo();
        float density=displayMetrics.density;
        int dpi=displayMetrics.densityDpi;
        screenInfo.setDensity(density);
        screenInfo.setDensityDpi(dpi);
        int widthPix= displayMetrics.widthPixels;
        int heightPix=displayMetrics.heightPixels;
        screenInfo.setWidthPixels(widthPix);
        screenInfo.setHeightPixels(heightPix);
        float xDpi=displayMetrics.xdpi;
        float yDpi=displayMetrics.ydpi;
        Log.e(TAG,"xDpi="+xDpi+",yDpi="+yDpi);//268.941  268.694
        float widthDpi=widthPix/density+0.5f;
        float heightDpi=heightPix/density+0.5f;
        screenInfo.setWidthDpi(widthDpi);
        screenInfo.setHeightDpi(heightDpi);
        if(activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            screenInfo.setOrientation("横屏");
        } else if (activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            screenInfo.setOrientation("竖屏");
        }
        screenInfo.setDeviceBrand(android.os.Build.BRAND);
        screenInfo.setSdkLevel(android.os.Build.VERSION.SDK_INT);
        screenInfo.setSystemModel(android.os.Build.MODEL);
        screenInfo.setFacturer(android.os.Build.MANUFACTURER);
        screenInfo.setProduct(android.os.Build.PRODUCT);
        screenInfo.setSystemVersion(android.os.Build.VERSION.RELEASE);
        int statusHeight=getStatusHeight(activity);
        statusHeight=getStausHeightBy(activity);
        screenInfo.setStstusHeightPix(statusHeight);
        screenInfo.setStatusHeightDp((int)(statusHeight/density+0.5f));
        Log.e(TAG, screenInfo.toString());
        return screenInfo;
    }

    private int getStatusHeight(Activity activity){
        /**
         * 获取状态栏高度——方法1
         * */
        int statusBarHeight1 = -1;
        //获取status_bar_height资源的ID
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight1 = activity.getResources().getDimensionPixelSize(resourceId);
        }
        Log.e("123", "状态栏-方法1:" + statusBarHeight1);
        return statusBarHeight1;
    }

    private int getStausHeightBy(Activity activity){
        /**
         * 获取状态栏高度——方法2
         * */
        int statusBarHeight2 = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusBarHeight2 = activity.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.e("123", "状态栏-方法2:" + statusBarHeight2);
        return statusBarHeight2;
    }
}
