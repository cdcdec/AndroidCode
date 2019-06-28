package com.laiqian.util;

import android.view.View;

public class ax {
  public static void a(View paramView, int[] paramArrayOfInt) { paramView.setPadding(paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2], paramArrayOfInt[3]); }
  
  public static int[] dx(View paramView) { return new int[] { paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramView.getPaddingBottom() }; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */