package com.laiqian.print.model;

import android.support.annotation.Nullable;
import com.laiqian.print.model.type.usb.g;

class j {
  j(g paramg) {}
  
  @Nullable
  public q a(g paramg, s params) {
    if (params.getType() == 1 && params instanceof g) {
      q q;
      g g1 = (g)params;
      if (g1.getVendorId() == 10473 && g1.getProductId() == 649) {
        q = new q(paramg, params);
        q.a(new k(this));
        return q;
      } 
      if (g1.getVendorId() == 1305 && g1.getProductId() == 8211) {
        q = new q(q, params);
        q.a(new l(this));
        return q;
      } 
      if (g1.getVendorId() == 1305 && g1.getProductId() == 8213) {
        q = new q(q, params);
        q.a(new m(this));
        return q;
      } 
    } 
    return null;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */