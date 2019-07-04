package com.cdc.keyboard.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import java.lang.reflect.InvocationTargetException;

public class DensityUtil {
    public static int pxToDp(Context paramContext, float paramFloat) {
        return (int) (paramFloat * (paramContext.getResources().getDisplayMetrics()).density + 0.5F);
    }

    public static int[] getResolution(Context paramContext){
        int i;
        int k = Build.VERSION.SDK_INT;
        DisplayMetrics displayMetrics = new DisplayMetrics();
       @SuppressLint("WrongConstant") Display display = ((WindowManager) paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay();
        display.getMetrics(displayMetrics);
        int m = displayMetrics.widthPixels;
        int j = displayMetrics.heightPixels;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Run1 first get resolution:");
        stringBuilder2.append(displayMetrics.widthPixels);
        stringBuilder2.append(" * ");
        stringBuilder2.append(displayMetrics.heightPixels);
        stringBuilder2.append(", ver ");
        stringBuilder2.append(k);
        Log.e("TAG", stringBuilder2.toString());
        if (k < 13) {
            i = displayMetrics.heightPixels;
        } else if (k == 13) {
            try {
                k = ((Integer) display.getClass().getMethod("getRealHeight", new Class[0]).invoke(display, new Object[0])).intValue();
                i = j;
                if (k > 0)
                    i = k;
            } catch (Exception e) {
                i = j;
            }
        } else {
            i = j;
            if (k > 13) {
                try {
                    k = ((Integer) display.getClass().getMethod("getRawHeight", new Class[0]).invoke(display, new Object[0])).intValue();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                i = j;
                if (k > 0)
                    i = k;
            }
        }
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Run2 Calibration  resolution:");
        stringBuilder1.append(m);
        stringBuilder1.append(" * ");
        stringBuilder1.append(i);
        Log.e("TAG", stringBuilder1.toString());
        return new int[]{m, i};
    }

    public static int dpToPx(Context paramContext, float paramFloat) {
        return (int) (paramFloat * (paramContext.getResources().getDisplayMetrics()).scaledDensity + 0.5F);
    }
}
