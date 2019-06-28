package com.laiqian.pos.hardware;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class i implements w.a {
  i(h paramh) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    switch (paramInt) {
      default:
        CustomerDisplaySettingActivity.b(this.ckq.ckp).setType(1);
        break;
      case 1:
        CustomerDisplaySettingActivity.b(this.ckq.ckp).setType(2);
        break;
      case 0:
        CustomerDisplaySettingActivity.b(this.ckq.ckp).setType(1);
        break;
    } 
    CustomerDisplaySettingActivity.a(this.ckq.ckp, CustomerDisplaySettingActivity.b(this.ckq.ckp));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hardware\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */