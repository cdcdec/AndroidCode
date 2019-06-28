package com.laiqian.opentable.b;

import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.t;
import com.laiqian.print.util.e;

class g implements t.f {
  g(b paramb, TableEntity paramTableEntity) {}
  
  public void dp(boolean paramBoolean) throws m {
    if (paramBoolean) {
      b.a(this.ccI, this.bMz.getID(), 2, new h(this));
      return;
    } 
    e.i(new j(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */