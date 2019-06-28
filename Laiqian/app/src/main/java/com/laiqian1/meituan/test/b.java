package com.laiqian.meituan.test;

import android.view.View;
import com.laiqian.util.n;

class b implements View.OnClickListener {
  b(MeituanTestActivity paramMeituanTestActivity) {}
  
  public void onClick(View paramView) {
    int i = n.parseInt(this.bsc.brQ.getText().toString());
    this.bsc.time = n.parseInt(this.bsc.brW.getText().toString()) * 1000;
    this.bsc.brU.fg(i);
    this.bsc.handler.postDelayed(this.bsc.bsa, this.bsc.time);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\meituan\test\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */