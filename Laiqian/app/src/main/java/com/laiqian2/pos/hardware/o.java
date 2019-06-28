package com.laiqian.pos.hardware;

import android.support.v4.util.Pair;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class o implements w.a {
  o(CustomerDisplaySettingActivity paramCustomerDisplaySettingActivity) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    if (paramInt < CustomerDisplaySettingActivity.e(this.ckp).size()) {
      CustomerDisplaySettingActivity.b(this.ckp).a((Pair)CustomerDisplaySettingActivity.e(this.ckp).get(paramInt));
      CustomerDisplaySettingActivity.a(this.ckp, CustomerDisplaySettingActivity.b(this.ckp));
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hardware\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */