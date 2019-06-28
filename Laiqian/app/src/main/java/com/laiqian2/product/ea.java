package com.laiqian.product;

import android.view.View;

class ea implements View.OnClickListener {
  ea(ProductTaxRuleEditActivity paramProductTaxRuleEditActivity) {}
  
  public void onClick(View paramView) {
    if (ProductTaxRuleEditActivity.e(this.cSG) == null || ProductTaxRuleEditActivity.f(this.cSG) == null) {
      ProductTaxRuleEditActivity.a(this.cSG, ProductTaxRuleEditActivity.d(this.cSG).bQ(ProductTaxRuleEditActivity.g(this.cSG)));
      ProductTaxRuleEditActivity.a(this.cSG, 2, ProductTaxRuleEditActivity.e(this.cSG));
      return;
    } 
    ProductTaxRuleEditActivity.a(this.cSG, 2, ProductTaxRuleEditActivity.f(this.cSG));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\ea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */