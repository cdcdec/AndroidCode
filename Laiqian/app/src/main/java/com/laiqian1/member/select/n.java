package com.laiqian.member.select;

import android.view.KeyEvent;
import android.view.View;

class n implements View.OnKeyListener {
  n(PosSelectVipDialog paramPosSelectVipDialog) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 1 && paramKeyEvent.getKeyCode() == 66) {
      this.bAG.bvb.selectAll();
      this.bAG.bwy.performClick();
      return true;
    } 
    if (paramInt == 4 && paramKeyEvent.getRepeatCount() == 0) {
      this.bAG.bwx.performClick();
      return false;
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */