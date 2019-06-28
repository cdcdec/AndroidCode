package com.laiqian.pos;

import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.product.models.g;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class cl implements w.a {
  cl(ProductPictureManagementActivity.c paramc, boolean paramBoolean) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    if (paramInt == 0) {
      String str;
      g g = new g(this.chW.chz);
      long l = Long.parseLong(this.chW.chS);
      if (this.chV) {
        str = "1";
      } else {
        str = "0";
      } 
      boolean bool = g.z(l, str);
      g.close();
      if (bool) {
        ProductPictureManagementActivity.m(this.chW.chz);
        return;
      } 
    } else if (paramInt == 1) {
      bn = new bn(this.chW.chz, new cm(this));
      g g = new g(this.chW.chz);
      try {
        boolean bool = g.cN(Long.parseLong(this.chW.chS));
        bn.d(this.chW.chT, this.chW.chU, bool);
      } catch (RuntimeException bn) {
        a.e(bn);
        Toast.makeText(this.chW.chz, "error fetching data", 0).show();
      } finally {}
      g.close();
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */