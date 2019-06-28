package com.laiqian.pos.industry.weiorder;

import android.os.Looper;
import android.util.Log;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.sync.a.g;

class s implements Runnable {
  s(QrorderMarketingFragment paramQrorderMarketingFragment) {}
  
  public void run() {
    Looper.prepare();
    g g = new g(this.csM.getActivity());
    g.apy().gW(true);
    g.a(true, "t_bpartner", a.aOD, System.currentTimeMillis());
    g.a(false, "t_bpartner_chargedoc", a.aOD, System.currentTimeMillis());
    boolean bool = g.execute();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" 离线会员改在线会员后数据上传 success=");
    stringBuilder.append(bool);
    Log.i("ContentValues", stringBuilder.toString());
    if (bool) {
      QrorderMarketingFragment.c(this.csM).obtainMessage(0, Boolean.valueOf(bool)).sendToTarget();
    } else {
      QrorderMarketingFragment.c(this.csM).obtainMessage(1, Boolean.valueOf(bool)).sendToTarget();
    } 
    Looper.loop();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */