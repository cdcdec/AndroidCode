package com.laiqian.warehouse;

import android.text.Editable;
import android.text.TextWatcher;

class a implements TextWatcher {
  a(Warehouse paramWarehouse) {}
  
  public void afterTextChanged(Editable paramEditable) {
    String str = Warehouse.a(this.dLN).getText().toString().trim();
    Warehouse.a(this.dLN, str);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\warehouse\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */