package com.laiqian.util;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class ae {
  public static int b(Context paramContext, float paramFloat) { return (int)(paramFloat * (paramContext.getResources().getDisplayMetrics()).density + 0.5F); }
  
  public static int[] bS(Context paramContext) {
    int i;
    int k = Build.VERSION.SDK_INT;
    DisplayMetrics displayMetrics = new DisplayMetrics();
    display = ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay();
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
    bb.f("TAG", stringBuilder2.toString());
    if (k < 13) {
      i = displayMetrics.heightPixels;
    } else if (k == 13) {
      try {
        k = ((Integer)display.getClass().getMethod("getRealHeight", new Class[0]).invoke(display, new Object[0])).intValue();
        i = j;
        if (k > 0)
          i = k; 
      } catch (Exception display) {
        i = j;
      } 
    } else {
      i = j;
      if (k > 13) {
        k = ((Integer)display.getClass().getMethod("getRawHeight", new Class[0]).invoke(display, new Object[0])).intValue();
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
    bb.f("TAG", stringBuilder1.toString());
    return new int[] { m, i };
  }
  
  public static int c(Context paramContext, float paramFloat) { return (int)(paramFloat * (paramContext.getResources().getDisplayMetrics()).scaledDensity + 0.5F); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqia\\util\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */