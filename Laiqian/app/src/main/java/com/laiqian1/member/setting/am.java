package com.laiqian.member.setting;

import android.util.Log;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.sync.a.g;

class am implements Runnable {
  am(VipModeSettingActivity paramVipModeSettingActivity, g paramg) {}
  
  public void run() {
    this.bCI.apy().gW(true);
    this.bCI.a(true, "t_bpartner", a.aOD, System.currentTimeMillis());
    this.bCI.a(false, "t_bpartner_chargedoc", a.aOD, System.currentTimeMillis());
    boolean bool = this.bCI.execute();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" 离线会员改在线会员后数据上传 success=");
    stringBuilder.append(bool);
    Log.i("VipModeSettingActivity", stringBuilder.toString());
    if (bool) {
      VipModeSettingActivity.b(this.bCH).obtainMessage(0, Boolean.valueOf(bool)).sendToTarget();
      return;
    } 
    VipModeSettingActivity.b(this.bCH).obtainMessage(1, Boolean.valueOf(bool)).sendToTarget();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */