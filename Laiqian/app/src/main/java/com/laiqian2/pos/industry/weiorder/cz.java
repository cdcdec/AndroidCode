package com.laiqian.pos.industry.weiorder;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class cz implements w.a {
  cz(cy paramcy) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    switch (paramInt) {
      case 1:
        this.cuR.cuP.cuL.ctH.eH(2);
        this.cuR.cuP.cuL.ctH.setUrl("");
        break;
      case 0:
        this.cuR.cuP.cuL.ctH.eH(1);
        this.cuR.cuP.cuL.ctH.setUrl("");
        break;
    } 
    WeiOrderSettingFragment.b(this.cuR.cuP, this.cuR.cuP.cuL);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */