package com.laiqian.alipay.setting;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

class i implements View.OnClickListener {
  i(OtherPaySettingActivity paramOtherPaySettingActivity) {}
  
  public void onClick(View paramView) {
    if (((TextView)(OtherPaySettingActivity.b(this.aCC)).aCK.getView()).getVisibility() == 0) {
      OtherPaySettingActivity.d(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCK.getView());
      OtherPaySettingActivity.e(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCH.getView());
      OtherPaySettingActivity.f(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCL.getView());
    } 
    if (((LinearLayout)(OtherPaySettingActivity.b(this.aCC)).aCI.getView()).getVisibility() == 0) {
      OtherPaySettingActivity.d(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCI.getView());
      OtherPaySettingActivity.e(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCu.getView());
      OtherPaySettingActivity.e(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCH.getView());
      OtherPaySettingActivity.f(this.aCC, (OtherPaySettingActivity.b(this.aCC)).aCL.getView());
    } 
    OtherPaySettingActivity.a(this.aCC).bz(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\alipay\setting\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */