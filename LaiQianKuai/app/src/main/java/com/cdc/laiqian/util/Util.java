package com.cdc.laiqian.util;

import android.content.res.Resources;
import android.util.TypedValue;

public class Util {
    public static int b(float paramFloat, Resources paramResources) {
        return (int) TypedValue.applyDimension(1, paramFloat, paramResources.getDisplayMetrics());
    }

    public static boolean mk(int paramInt) {
        return ((paramInt == 0));
    }

    public static boolean ml(int paramInt) {
        return ((paramInt!= 0));
    }
}
