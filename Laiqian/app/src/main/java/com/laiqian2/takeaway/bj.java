package com.laiqian.takeaway;

import com.laiqian.basic.RootApplication;
import com.laiqian.pos.industry.a;
import com.laiqian.print.model.PrintContent;
import com.laiqian.util.bh;
import java.util.HashMap;

class bj implements Runnable {
  bj(bi parambi) {}
  
  public void run() {
    HashMap hashMap = new HashMap();
    hashMap.put("type", "meituan");
    hashMap.put("shopid", RootApplication.getLaiqianPreferenceManager().Tx());
    hashMap.put("orders", ((PrintContent)this.dtX.bYk.ags().get(0)).lm("print_orders"));
    bh.a(a.cro, this.dtX.dtS.context, hashMap);
    RootApplication.getLaiqianPreferenceManager().rI("[]");
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */