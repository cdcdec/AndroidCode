package com.laiqian.alipay.setting;

import android.view.View;
import android.widget.TextView;

class g implements View.OnClickListener {
  g(OtherPaySettingActivity paramOtherPaySettingActivity) {}
  
  public void onClick(View paramView) {
    if (((TextView)(OtherPaySettingActivity.b(this.aCC)).aCK.getView()).getVisibility() == 0) {
      OtherPaySettingActivity.a(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCK.getView());
      OtherPaySettingActivity.b(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCu.getView());
      OtherPaySettingActivity.c(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCI.getView());
    } 
    if (((TextView)(OtherPaySettingActivity.b(this.aCC)).aCL.getView()).getVisibility() == 0) {
      OtherPaySettingActivity.a(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCL.getView());
      OtherPaySettingActivity.b(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCu.getView());
      OtherPaySettingActivity.b(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCH.getView());
      OtherPaySettingActivity.c(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCI.getView());
    } 
    OtherPaySettingActivity.a(this.aCC).bu(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\alipay\setting\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */