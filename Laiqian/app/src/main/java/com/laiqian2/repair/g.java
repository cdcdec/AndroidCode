package com.laiqian.repair;

import com.laiqian.infrastructure.R;
import com.laiqian.ui.a.r;
import com.laiqian.util.n;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;

class g implements r.a {
  g(f paramf) {}
  
  public void xD() { f.b(this.cYd).cancel(); }
  
  public void xE() {
    HashMap hashMap = new HashMap();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append((f.a(this.cYd)).id);
    hashMap.put("code", stringBuilder.toString());
    MobclickAgent.onEvent(this.cYd.mActivity, "repair_code", hashMap);
    if (!this.cYd.b(f.a(this.cYd))) {
      f.b(this.cYd).cancel();
      return;
    } 
    if (f.c(this.cYd)) {
      n.w(this.cYd.mActivity, R.string.pos_repair_self_repairing_again);
      return;
    } 
    f.a(this.cYd, true);
    f.d(this.cYd).show();
    (new h(this)).start();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repair\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */