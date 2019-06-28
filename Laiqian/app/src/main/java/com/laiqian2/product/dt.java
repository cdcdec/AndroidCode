package com.laiqian.product;

import android.view.View;

class dt implements View.OnClickListener {
  dt(ProductTaxRuleActivity paramProductTaxRuleActivity) {}
  
  public void onClick(View paramView) {
    this.cSi.setResult(-1, this.cSi.getIntent());
    this.cSi.finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */