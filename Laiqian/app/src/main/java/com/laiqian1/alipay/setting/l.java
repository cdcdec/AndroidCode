package com.laiqian.alipay.setting;

import android.view.View;

class l implements View.OnClickListener {
  l(OtherPaySettingActivity paramOtherPaySettingActivity) {}
  
  public void onClick(View paramView) {
    if ((OtherPaySettingActivity.a(this.aCC)).aCm) {
      OtherPaySettingActivity.a(this.aCC).by(false);
      return;
    } 
    OtherPaySettingActivity.a(this.aCC).by(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\alipay\setting\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */