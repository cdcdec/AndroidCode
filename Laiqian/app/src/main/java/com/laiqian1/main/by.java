package com.laiqian.main;

import android.graphics.Rect;
import android.view.View;

class by implements View.OnClickListener {
  by(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void onClick(View paramView) {
    Rect rect = new Rect();
    paramView.getGlobalVisibleRect(rect);
    int i = rect.right;
    int j = rect.top;
    PosActivitySettlementDialog.access$4300(this.bcy).showAtLocation(paramView, 0, i + 5, j - 11);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */