package com.laiqian.member.transfer;

import com.laiqian.basic.RootApplication;
import com.laiqian.vip.R;

class i implements Runnable {
  i(d paramd, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run() {
    if (this.bHy) {
      if (this.bHz) {
        d.a(this.bHx).gm(RootApplication.zv().getString(R.string.pos_product_import_success));
        return;
      } 
    } else {
      if (!d.b(this.bHx)) {
        d.b(this.bHx, true);
        d.c(this.bHx);
        return;
      } 
      if (this.bHz)
        d.a(this.bHx).gn(RootApplication.zv().getString(R.string.sync_failed)); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\transfer\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */