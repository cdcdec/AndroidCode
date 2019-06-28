package com.laiqian.alipay.setting;

import android.view.View;
import com.laiqian.util.av;

class k implements View.OnClickListener {
  k(OtherPaySettingActivity paramOtherPaySettingActivity) {}
  
  public void onClick(View paramView) {
    av av = new av(this.aCC);
    av.auL();
    av.close();
    if ((OtherPaySettingActivity.a(this.aCC)).aCl) {
      OtherPaySettingActivity.a(this.aCC).bx(false);
      return;
    } 
    OtherPaySettingActivity.a(this.aCC).bx(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\alipay\setting\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */