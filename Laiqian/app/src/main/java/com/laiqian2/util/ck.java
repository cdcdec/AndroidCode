package com.laiqian.util;

import android.content.res.Resources;
import android.util.TypedValue;

public class ck {
  public static int b(float paramFloat, Resources paramResources) { return (int)TypedValue.applyDimension(1, paramFloat, paramResources.getDisplayMetrics()); }
  
  public static boolean mk(int paramInt) { return ((paramInt & true) == 0); }
  
  public static boolean ml(int paramInt) { return ((paramInt & true) != 0); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */