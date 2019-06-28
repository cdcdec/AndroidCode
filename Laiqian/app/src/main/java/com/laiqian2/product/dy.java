package com.laiqian.product;

import android.view.View;

class dy implements View.OnClickListener {
  dy(ProductTaxRuleEditActivity paramProductTaxRuleEditActivity) {}
  
  public void onClick(View paramView) {
    long[] arrayOfLong = ProductTaxRuleEditActivity.d(this.cSG).mv(ProductTaxRuleEditActivity.c(this.cSG));
    ProductTaxRuleEditActivity.b(this.cSG).l(arrayOfLong);
    ProductTaxRuleEditActivity.b(this.cSG).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */