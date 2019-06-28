package com.laiqian.product;

import android.view.View;

class db implements View.OnClickListener {
  db(ProductList paramProductList) {}
  
  public void onClick(View paramView) {
    if (ProductList.c(this.cRN).ajR()) {
      ProductList.c(this.cRN).O(null);
    } else {
      ProductList.c(this.cRN).P(null);
    } 
    ProductList.c(this.cRN).ajQ();
    ProductList.c(this.cRN).notifyDataSetChanged();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */