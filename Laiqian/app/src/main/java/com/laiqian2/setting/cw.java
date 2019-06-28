package com.laiqian.setting;

import android.util.Log;
import com.laiqian.sync.a.g;
import com.laiqian.sync.c.a;
import com.laiqian.sync.model.SyncProgessMessage;

class cw implements Runnable {
  cw(UnitWeightActivity paramUnitWeightActivity) {}
  
  public void run() {
    g g = new g(this.dnz.getActivity());
    SyncProgessMessage syncProgessMessage = g.apy();
    boolean bool1 = true;
    syncProgessMessage.gW(true);
    boolean bool2 = g.b(false, a.dpw, 0L, System.currentTimeMillis());
    boolean bool3 = g.b(true, a.dpv, 0L, System.currentTimeMillis());
    String str = UnitWeightActivity.Ui();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" 重量转数量服务器更新数据 success=");
    if (!bool2 || !bool3)
      bool1 = false; 
    stringBuilder.append(bool1);
    Log.i(str, stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */