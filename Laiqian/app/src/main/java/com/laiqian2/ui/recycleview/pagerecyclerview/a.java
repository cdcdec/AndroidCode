package com.laiqian.ui.recycleview.pagerecyclerview;

import android.view.animation.Interpolator;

final class a implements Interpolator {
  public float getInterpolation(float paramFloat) {
    paramFloat--;
    return paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\recycleview\pagerecyclerview\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */