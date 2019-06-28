package com.laiqian.opentable.b;

import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.n;
import com.laiqian.opentable.common.t;

class k implements t.f {
  k(b paramb, t.f paramf) {}
  
  public void dp(boolean paramBoolean) throws m {
    if (b.XB()) {
      if (paramBoolean) {
        n.a(true, this.bYP);
        return;
      } 
      this.bYP.dp(false);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\b\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */