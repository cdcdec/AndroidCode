package com.laiqian.pos.industry.weiorder;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class cv implements w.a {
  cv(cu paramcu) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 1:
        WeiOrderSettingFragment.b(this.cuQ.cuP);
        return;
      case 0:
        break;
    } 
    WeiOrderSettingFragment.b(this.cuQ.cuP, this.cuQ.cuP.cuN);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */