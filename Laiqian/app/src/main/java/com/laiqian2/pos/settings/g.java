package com.laiqian.pos.settings;

import com.laiqian.models.h;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class g implements w.a {
  g(InitialSettingsActivity paramInitialSettingsActivity, String[] paramArrayOfString, h.b paramb) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    null = this.czv[paramInt];
    h.e e = (h.e)this.czy.UM().get(null);
    this.czu.d(e);
    if (this.czu.czs != null)
      this.czu.czs.d(e); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */