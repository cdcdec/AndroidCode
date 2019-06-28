package com.laiqian.takeaway;

import com.laiqian.basic.RootApplication;
import com.laiqian.pos.industry.a;
import com.laiqian.util.bh;
import java.util.HashMap;

class bf implements Runnable {
  bf(be parambe) {}
  
  public void run() {
    HashMap hashMap = new HashMap();
    hashMap.put("type", "meituan");
    hashMap.put("shopid", RootApplication.getLaiqianPreferenceManager().Tx());
    hashMap.put("number", this.dtU.dtT);
    bh.a(a.crn, this.dtU.dtS.context, hashMap);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */