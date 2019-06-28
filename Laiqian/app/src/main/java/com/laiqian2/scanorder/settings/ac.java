package com.laiqian.scanorder.settings;

import android.util.Log;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.sync.a.g;

class ac implements Runnable {
  ac(PayAndFeeFragment paramPayAndFeeFragment, g paramg) {}
  
  public void run() {
    this.bCI.apy().gW(true);
    this.bCI.a(true, "t_bpartner", a.aOD, System.currentTimeMillis());
    this.bCI.a(false, "t_bpartner_chargedoc", a.aOD, System.currentTimeMillis());
    boolean bool = this.bCI.execute();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" 离线会员改在线会员后数据上传 success=");
    stringBuilder.append(bool);
    Log.i("ContentValues", stringBuilder.toString());
    if (bool) {
      PayAndFeeFragment.c(this.djj).obtainMessage(0, Boolean.valueOf(bool)).sendToTarget();
      return;
    } 
    PayAndFeeFragment.c(this.djj).obtainMessage(1, Boolean.valueOf(bool)).sendToTarget();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scanorder\settings\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */