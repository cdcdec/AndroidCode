package com.laiqian.setting;

import android.view.View;
import com.laiqian.pos.industry.setting.MainSetting;

class e implements View.OnClickListener {
  e(DateSettingActivity paramDateSettingActivity) {}
  
  public void onClick(View paramView) {
    MainSetting.sendCustomEvent(this.djT, "数据备份与删除", "com.laiqian.milestone.DeleteAllBusinessDataDescription");
    DateSettingActivity.a(this.djT, 1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */