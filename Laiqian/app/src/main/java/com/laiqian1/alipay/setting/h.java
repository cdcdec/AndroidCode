package com.laiqian.alipay.setting;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

class h implements View.OnClickListener {
  h(OtherPaySettingActivity paramOtherPaySettingActivity) {}
  
  public void onClick(View paramView) {
    if (((LinearLayout)(OtherPaySettingActivity.b(this.aCC)).aCI.getView()).getVisibility() == 0) {
      OtherPaySettingActivity.d(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCI.getView());
      OtherPaySettingActivity.e(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCu.getView());
      OtherPaySettingActivity.f(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCK.getView());
    } 
    if (((TextView)(OtherPaySettingActivity.b(this.aCC)).aCL.getView()).getVisibility() == 0) {
      OtherPaySettingActivity.a(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCL.getView());
      OtherPaySettingActivity.b(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCH.getView());
      OtherPaySettingActivity.c(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCK.getView());
    } 
    OtherPaySettingActivity.a(this.aCC).bv(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\alipay\setting\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */