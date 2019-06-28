package com.laiqian.pos.industry.weiorder;

import android.os.Looper;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.sync.a.g;

class u implements Runnable {
  u(t paramt) {}
  
  public void run() {
    Looper.prepare();
    g g = new g(this.csN.csM.getActivity());
    g.apy().gW(true);
    g.a(true, "t_string", a.aOD, System.currentTimeMillis());
    g.execute();
    Looper.loop();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorde\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */