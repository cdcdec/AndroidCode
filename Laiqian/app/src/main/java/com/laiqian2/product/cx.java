package com.laiqian.product;

import android.text.Editable;
import android.text.TextWatcher;

class cx implements TextWatcher {
  cx(ProductList paramProductList) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (ProductList.i(this.cRN))
      ProductList.c(this.cRN).YQ(); 
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */