package com.laiqian.product;

import com.laiqian.ui.a.r;
import com.laiqian.util.n;

class ec implements r.a {
  ec(ProductTaxRuleEditActivity paramProductTaxRuleEditActivity, int paramInt) {}
  
  public void xD() {
    if (this.cSI == 3)
      this.cSG.finish(); 
  }
  
  public void xE() {
    if (this.cSI == 3) {
      this.cSG.i(ProductTaxRuleEditActivity.h(this.cSG));
      return;
    } 
    if (this.cSI == 4) {
      if (ProductTaxRuleEditActivity.d(this.cSG).bP(ProductTaxRuleEditActivity.g(this.cSG))) {
        n.o(this.cSG.getApplication().getResources().getString(2131630124));
      } else {
        n.o(this.cSG.getApplication().getResources().getString(2131630195));
      } 
      this.cSG.setResult(-1, this.cSG.getIntent());
      this.cSG.finish();
    } 
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */