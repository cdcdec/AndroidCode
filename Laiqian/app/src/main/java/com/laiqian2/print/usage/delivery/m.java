package com.laiqian.print.usage.delivery;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class m implements w.a {
  m(DeliveryPreviewActivity paramDeliveryPreviewActivity) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 3:
        DeliveryPreviewActivity.b(this.cMu, 4);
        return;
      case 2:
        DeliveryPreviewActivity.a(this.cMu, 2);
        return;
      case 1:
        DeliveryPreviewActivity.i(this.cMu).o(1, null);
        return;
      case 0:
        break;
    } 
    DeliveryPreviewActivity.i(this.cMu).o(0, null);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\delivery\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */