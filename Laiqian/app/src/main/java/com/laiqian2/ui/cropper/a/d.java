package com.laiqian.ui.cropper.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;

public class d {
  public static Rect a(Bitmap paramBitmap, View paramView) { return p(paramBitmap.getWidth(), paramBitmap.getHeight(), paramView.getWidth(), paramView.getHeight()); }
  
  public static Rect o(int paramInt1, int paramInt2, int paramInt3, int paramInt4) { return p(paramInt1, paramInt2, paramInt3, paramInt4); }
  
  private static Rect p(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    double d2;
    double d1;
    if (paramInt3 < paramInt1) {
      d1 = paramInt3 / paramInt1;
    } else {
      d1 = Double.POSITIVE_INFINITY;
    } 
    if (paramInt4 < paramInt2) {
      d2 = paramInt4 / paramInt2;
    } else {
      d2 = Double.POSITIVE_INFINITY;
    } 
    if (d1 != Double.POSITIVE_INFINITY || d2 != Double.POSITIVE_INFINITY) {
      if (d1 <= d2) {
        d2 = paramInt3;
        d1 = paramInt2 * d2 / paramInt1;
      } else {
        d1 = paramInt4;
        d2 = paramInt1 * d1 / paramInt2;
      } 
    } else {
      d1 = paramInt2;
      d2 = paramInt1;
    } 
    double d3 = paramInt3;
    paramInt1 = 0;
    if (d2 == d3) {
      paramInt2 = (int)Math.round((paramInt4 - d1) / 2.0D);
    } else {
      double d4 = paramInt4;
      if (d1 == d4) {
        paramInt1 = (int)Math.round((d3 - d2) / 2.0D);
        paramInt2 = 0;
      } else {
        paramInt1 = (int)Math.round((d3 - d2) / 2.0D);
        paramInt2 = (int)Math.round((d4 - d1) / 2.0D);
      } 
    } 
    return new Rect(paramInt1, paramInt2, (int)Math.ceil(d2) + paramInt1, (int)Math.ceil(d1) + paramInt2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\cropper\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */