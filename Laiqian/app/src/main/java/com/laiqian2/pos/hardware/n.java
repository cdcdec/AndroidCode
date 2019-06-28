package com.laiqian.pos.hardware;

import android.widget.TextView;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class n implements w.a {
  n(m paramm, String[] paramArrayOfString) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    ((TextView)(CustomerDisplaySettingActivity.d(this.ckt.ckp)).cky.cAP.getView()).setText(this.ckr[paramInt]);
    CustomerDisplaySettingActivity.b(this.ckt.ckp).setBaudrate(Integer.parseInt(this.ckr[paramInt]));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hardware\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */