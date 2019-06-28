package com.laiqian.opentable.common;

import io.netty.channel.s;
import io.netty.channel.t;
import io.netty.e.b.v;

final class j implements t {
  j(t.f paramf) {}
  
  public void a(s params) throws Exception {
    if (this.bYP != null) {
      boolean bool;
      t.f f1 = this.bYP;
      if (params.aEG() && params.isDone()) {
        bool = true;
      } else {
        bool = false;
      } 
      f1.dp(bool);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */