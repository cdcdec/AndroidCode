package com.laiqian.wallet;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

class d implements TextWatcher {
  d(BindingAlipay paramBindingAlipay) {}
  
  public void afterTextChanged(Editable paramEditable) {
    boolean bool;
    View view = BindingAlipay.h(this.dKY);
    if (BindingAlipay.f(this.dKY).length() > 0 && BindingAlipay.g(this.dKY).length() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    view.setEnabled(bool);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */