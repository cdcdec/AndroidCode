package com.laiqian.pos.settings;

import com.laiqian.models.h;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import kotlin.Metadata;
import kotlin.jvm.b.f;

@Metadata
final class ao implements w.a {
  ao(ShopBasicInfoFragment paramShopBasicInfoFragment, String[] paramArrayOfString, h.e parame) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public final void dL(int paramInt) {
    null = this.cAF[paramInt];
    h.a a1 = (h.a)this.cAG.UO().get(null);
    ShopBasicInfoFragment shopBasicInfoFragment = this.cAE;
    if (a1 == null)
      f.aQI(); 
    f.l(a1, "c!!");
    shopBasicInfoFragment.d(a1);
    if (ShopBasicInfoFragment.b(this.cAE) != null)
      ShopBasicInfoFragment.b(this.cAE).e(a1); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */