package com.laiqian.sync.view;

import android.view.ViewTreeObserver;
import com.laiqian.util.bb;

class d implements ViewTreeObserver.OnGlobalLayoutListener {
  d(SealData paramSealData, int paramInt) {}
  
  public void onGlobalLayout() {
    SealData.b(this.dpZ).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    SealData.b(this.dpZ).setProgress(this.dqa);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("seekBar.getWidth()");
    stringBuilder.append(SealData.b(this.dpZ).getWidth());
    bb.e("_Seal", stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sync\view\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */