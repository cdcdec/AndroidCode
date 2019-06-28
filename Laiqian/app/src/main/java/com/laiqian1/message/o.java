package com.laiqian.message;

import com.laiqian.entity.m;
import com.laiqian.message.redis.a;
import hugo.weaving.DebugLog;

class o implements a.a {
  o(RequestMessageService2 paramRequestMessageService2, k paramk, i.a parama) {}
  
  @DebugLog
  public boolean W(String paramString1, String paramString2) {
    for (k.b b : this.bIY.getCallbacks()) {
      if (b.ci(paramString1))
        b.cj(paramString2); 
    } 
    this.bIZ.aL(new Object());
    return true;
  }
  
  public void a(m paramm) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */