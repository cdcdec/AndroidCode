package com.laiqian.pos.industry.weiorder;

import android.os.Looper;
import com.laiqian.db.multidatabase.b.a;
import com.laiqian.sync.a.g;

class gd implements Runnable {
  gd(gc paramgc) {}
  
  public void run() {
    Looper.prepare();
    g g = new g(this.cwF.cwC.getActivity());
    g.apy().gW(true);
    g.b(true, "t_string", a.aOD, System.currentTimeMillis());
    Looper.loop();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\gd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */