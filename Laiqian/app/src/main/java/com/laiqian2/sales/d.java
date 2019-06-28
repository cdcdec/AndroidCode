package com.laiqian.sales;

import android.text.Editable;
import android.text.TextWatcher;

class d implements TextWatcher {
  d(Sales paramSales) {}
  
  public void afterTextChanged(Editable paramEditable) {
    String str = Sales.a(this.div).getText().toString().trim();
    this.div.nA(str);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\sales\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */