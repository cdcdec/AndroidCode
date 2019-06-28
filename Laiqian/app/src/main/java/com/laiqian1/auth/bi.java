package com.laiqian.auth;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class bi implements w.a {
  bi(bh parambh) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    ShopInfo.c(this.aFt.aFs).setText(this.aFt.aFs.aFk[paramInt]);
    ShopInfo.c(this.aFt.aFs).setTag(ShopInfo.d(this.aFt.aFs).get(paramInt));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */