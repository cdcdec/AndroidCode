package com.laiqian.opentable.a;

import com.laiqian.opentable.common.m;
import com.laiqian.opentable.common.t;
import com.laiqian.print.util.e;
import com.laiqian.util.by;

class i implements t.e {
  i(h paramh, String paramString) {}
  
  public void d(boolean paramBoolean, String paramString) throws m {
    if (paramBoolean) {
      h.a(this.bYE, by.parseLong(paramString), 1, new j(this, paramString));
      return;
    } 
    e.i(new l(this, paramString));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */