package com.laiqian.pos.settings;

import com.laiqian.models.h;
import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import kotlin.Metadata;
import kotlin.jvm.b.f;

@Metadata
final class ap implements w.a {
  ap(ShopBasicInfoFragment paramShopBasicInfoFragment, String[] paramArrayOfString, h.a parama) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public final void dL(int paramInt) {
    null = this.cAF[paramInt];
    h.c c = (h.c)this.cAH.UK().get(null);
    ShopBasicInfoFragment shopBasicInfoFragment = this.cAE;
    if (c == null)
      f.aQI(); 
    f.l(c, "d!!");
    shopBasicInfoFragment.b(c);
    if (ShopBasicInfoFragment.b(this.cAE) != null)
      ShopBasicInfoFragment.b(this.cAE).c(c); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */