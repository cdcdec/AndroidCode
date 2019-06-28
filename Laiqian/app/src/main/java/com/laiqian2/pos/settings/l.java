package com.laiqian.pos.settings;

import android.util.Log;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.sync.a.g;

class l implements Runnable {
  l(InitialSettingsActivity paramInitialSettingsActivity, g paramg) {}
  
  public void run() {
    this.bCI.apy().gW(true);
    this.bCI.a(true, "t_string", a.aOD, System.currentTimeMillis());
    boolean bool = this.bCI.execute();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" 离线会员改在线会员后数据上传 success=");
    stringBuilder.append(bool);
    Log.i("InitialSettingsActivity", stringBuilder.toString());
    if (bool) {
      InitialSettingsActivity.k(this.czu).obtainMessage(0, Boolean.valueOf(bool)).sendToTarget();
      return;
    } 
    InitialSettingsActivity.k(this.czu).obtainMessage(1, Boolean.valueOf(bool)).sendToTarget();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */