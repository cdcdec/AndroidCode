package com.laiqian.product;

import android.view.View;

class dd implements View.OnClickListener {
  dd(ProductList paramProductList) {}
  
  public void onClick(View paramView) {
    if (ProductList.k(this.cRN)) {
      ProductList.c(this.cRN).ajK();
      ProductList.c(this.cRN).notifyDataSetChanged();
      return;
    } 
    ProductList.m(this.cRN);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */