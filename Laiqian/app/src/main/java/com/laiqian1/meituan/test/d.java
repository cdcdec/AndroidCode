package com.laiqian.meituan.test;

import android.view.View;

class d implements View.OnClickListener {
  d(MeituanTestActivity paramMeituanTestActivity) {}
  
  public void onClick(View paramView) {
    this.bsc.handler.removeCallbacks(this.bsc.brZ);
    this.bsc.handler.removeCallbacks(this.bsc.bsa);
    this.bsc.handler.removeCallbacks(this.bsc.bsb);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\test\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */