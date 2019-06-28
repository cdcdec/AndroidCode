package com.laiqian.alipay.setting;

import android.view.View;
import com.laiqian.util.av;

class j implements View.OnClickListener {
  j(OtherPaySettingActivity paramOtherPaySettingActivity) {}
  
  public void onClick(View paramView) {
    av av = new av(this.aCC);
    av.auK();
    av.close();
    if ((OtherPaySettingActivity.a(this.aCC)).aCk) {
      OtherPaySettingActivity.a(this.aCC).bw(false);
      return;
    } 
    OtherPaySettingActivity.a(this.aCC).bw(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\alipay\setting\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */