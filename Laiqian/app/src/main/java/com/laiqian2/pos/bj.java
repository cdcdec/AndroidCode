package com.laiqian.pos;

import android.view.KeyEvent;
import android.view.View;
import com.laiqian.util.n;

class bj implements View.OnKeyListener {
  bj(bg parambg) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 1)
      return true; 
    if (paramInt == 4 && paramKeyEvent.getRepeatCount() == 0) {
      this.cgC.cfT.performClick();
      return false;
    } 
    if (paramInt != 160) {
      switch (paramInt) {
        default:
          return false;
        case 67:
          if (this.cgC.cgz.hasFocus()) {
            n.d(this.cgC.cgz);
            return true;
          } 
          this.cgC.cfV.performClick();
          return false;
        case 66:
          break;
      } 
      this.cgC.cfW.performClick();
      return false;
    } 
    this.cgC.cfW.performClick();
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */