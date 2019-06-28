package com.laiqian.wallet;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

class c implements TextWatcher {
  c(BindingAlipay paramBindingAlipay) {}
  
  public void afterTextChanged(Editable paramEditable) {
    boolean bool;
    View view = BindingAlipay.e(this.dKY);
    if (paramEditable.length() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    view.setEnabled(bool);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */