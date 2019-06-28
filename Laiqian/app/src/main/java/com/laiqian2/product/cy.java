package com.laiqian.product;

import android.view.View;

class cy implements View.OnClickListener {
  cy(ProductList paramProductList) {}
  
  public void onClick(View paramView) {
    ProductList.a(this.cRN, true, ProductList.d(this.cRN));
    ProductList.c(this.cRN).notifyDataSetChanged();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */