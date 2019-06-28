package com.laiqian.product;

import android.view.View;

class dc implements View.OnClickListener {
  dc(ProductList paramProductList) {}
  
  public void onClick(View paramView) {
    if (ProductList.k(this.cRN)) {
      ProductList.c(this.cRN).ajL();
      ProductList.c(this.cRN).notifyDataSetChanged();
      return;
    } 
    ProductList.l(this.cRN);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */