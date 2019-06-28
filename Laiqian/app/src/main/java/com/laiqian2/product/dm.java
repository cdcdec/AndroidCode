package com.laiqian.product;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

class dm implements TextWatcher {
  dm(ProductList paramProductList, View paramView) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (ProductList.f(this.cRN).getText().toString().length() == 0) {
      this.chA.setVisibility(8);
      return;
    } 
    this.chA.setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */