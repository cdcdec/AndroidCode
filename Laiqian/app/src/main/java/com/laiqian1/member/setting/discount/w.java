package com.laiqian.member.setting.discount;

import android.util.Log;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.sync.a.g;

class w implements Runnable {
  w(VipSettingFragment paramVipSettingFragment, g paramg) {}
  
  public void run() {
    this.bCI.apy().gW(true);
    this.bCI.a(true, "t_bpartner", a.aOD, System.currentTimeMillis());
    this.bCI.a(false, "t_bpartner_chargedoc", a.aOD, System.currentTimeMillis());
    boolean bool = this.bCI.execute();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" 离线会员改在线会员后数据上传 success=");
    stringBuilder.append(bool);
    Log.i("VipSettingFragment", stringBuilder.toString());
    if (bool) {
      VipSettingFragment.a(this.bDZ).obtainMessage(0, Boolean.valueOf(bool)).sendToTarget();
      return;
    } 
    VipSettingFragment.a(this.bDZ).obtainMessage(1, Boolean.valueOf(bool)).sendToTarget();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\discount\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */