package com.cdc.keyboard.util;

import android.content.res.Resources;
import android.util.TypedValue;

public class Utils {
    public static int sizeConversion(float paramFloat, Resources paramResources) {
        //把非标准尺寸转换成标准尺寸  TypedValue.applyDimension
        return (int) TypedValue.applyDimension(1, paramFloat, paramResources.getDisplayMetrics());
    }

   /* public static boolean mk(int paramInt) {

        return ((paramInt & true) == 0);
    }

    public static boolean ml(int paramInt) {
        return ((paramInt & true) != 0);
    }*/
}
