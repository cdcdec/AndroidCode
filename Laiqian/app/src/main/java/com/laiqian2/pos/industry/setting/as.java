package com.laiqian.pos.industry.setting;

import android.view.View;
import com.laiqian.auth.ModifyUserPasswordDialog;
import com.laiqian.crash.model.CrashApplication;

class as implements View.OnClickListener {
  as(MainSetting paramMainSetting) {}
  
  public void onClick(View paramView) {
    if (!MainSetting.access$600(this.csj))
      return; 
    if (MainSetting.access$700(this.csj) == null) {
      MainSetting.access$702(this.csj, new ModifyUserPasswordDialog(this.csj));
      MainSetting.access$700(this.csj).a(this.csj);
    } 
    MainSetting.access$700(this.csj).w(this.csj.nUserID, CrashApplication.getLaiqianPreferenceManager().atr());
    MainSetting.access$700(this.csj).show();
    MainSetting.access$500(this.csj).dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\setting\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */