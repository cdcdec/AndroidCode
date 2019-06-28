package com.laiqian.pos.industry.weiorder;

import android.os.Looper;
import android.util.Log;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.sync.a.g;

class gb implements Runnable {
  gb(WeshopMarketingFragment paramWeshopMarketingFragment) {}
  
  public void run() {
    Looper.prepare();
    g g = new g(this.cwC.getActivity());
    g.apy().gW(true);
    g.a(true, "t_bpartner", a.aOD, System.currentTimeMillis());
    g.a(false, "t_bpartner_chargedoc", a.aOD, System.currentTimeMillis());
    boolean bool = g.execute();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" 离线会员改在线会员后数据上传 success=");
    stringBuilder.append(bool);
    Log.i("WeshopMarketingFragment", stringBuilder.toString());
    if (bool) {
      WeshopMarketingFragment.f(this.cwC).obtainMessage(0, Boolean.valueOf(bool)).sendToTarget();
    } else {
      WeshopMarketingFragment.f(this.cwC).obtainMessage(1, Boolean.valueOf(bool)).sendToTarget();
    } 
    Looper.loop();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\gb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */