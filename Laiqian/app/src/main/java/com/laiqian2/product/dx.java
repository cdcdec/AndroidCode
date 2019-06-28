package com.laiqian.product;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;

class dx implements w.a {
  dx(dw paramdw, String[] paramArrayOfString) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    String str = this.cwD[paramInt];
    ProductTaxRuleEditActivity.a(this.cSH.cSG, paramInt);
    ProductTaxRuleEditActivity.a.b(this.cSH.cSG.cSx).setText(str);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */