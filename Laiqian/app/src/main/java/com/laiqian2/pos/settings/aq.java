package com.laiqian.pos.settings;

import com.laiqian.models.h;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import kotlin.Metadata;
import kotlin.jvm.b.f;

@Metadata
final class aq implements w.a {
  aq(ShopBasicInfoFragment paramShopBasicInfoFragment, String[] paramArrayOfString, h.b paramb) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public final void dL(int paramInt) {
    null = this.cAF[paramInt];
    h.b b1 = this.cAI;
    f.l(b1, "china");
    h.e e = (h.e)b1.UM().get(null);
    ShopBasicInfoFragment shopBasicInfoFragment = this.cAE;
    if (e == null)
      f.aQI(); 
    f.l(e, "p!!");
    shopBasicInfoFragment.d(e);
    if (ShopBasicInfoFragment.b(this.cAE) != null)
      ShopBasicInfoFragment.b(this.cAE).e(e); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */