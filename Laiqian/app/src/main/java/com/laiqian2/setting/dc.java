package com.laiqian.setting;

import android.view.View;
import com.laiqian.util.m;

class dc implements m.b.a {
  dc(WeighSettingActivity paramWeighSettingActivity) {}
  
  public void i(View paramView, boolean paramBoolean) {
    if (paramBoolean) {
      WeighSettingActivity.c(this.dnL).setVisibility(0);
      return;
    } 
    WeighSettingActivity.c(this.dnL).setVisibility(8);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */