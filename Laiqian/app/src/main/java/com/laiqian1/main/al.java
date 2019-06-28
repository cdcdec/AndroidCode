package com.laiqian.main;

import android.view.MotionEvent;
import android.view.View;

class al implements View.OnTouchListener {
  al(PosActivity paramPosActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    if (((Boolean)(PosActivity.a(this.baU)).bee.getValue()).booleanValue())
      this.baU.baG.bba.setVisibility(0); 
    PosActivity.a(this.baU, false);
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */