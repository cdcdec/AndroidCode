package com.laiqian.mobileopentable;

import android.content.Context;
import android.util.DisplayMetrics;
import com.laiqian.dcb.api.client.k;

public class t {
  public static boolean Uz() { return (k.aPi == 1); }
  
  public static void aL(Context paramContext) {
    int i;
    DisplayMetrics displayMetrics = paramContext.getResources().getDisplayMetrics();
    if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
      i = displayMetrics.widthPixels;
    } else {
      i = displayMetrics.heightPixels;
    } 
    float f = i / 360.0F;
    displayMetrics.density = f;
    displayMetrics.scaledDensity = f;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\mobileopentable\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */