package com.laiqian.member.setting.marketing;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

class n implements View.OnTouchListener {
  n(DiscountMarketActivity paramDiscountMarketActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    Log.i(DiscountMarketActivity.St(), "onTouch ");
    ((EditText)(DiscountMarketActivity.a(this.bED)).bEG.dwQ.getView()).setCursorVisible(true);
    ((EditText)(DiscountMarketActivity.a(this.bED)).bEG.dwQ.getView()).setSelected(true);
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\marketing\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */