package com.laiqian.pos.industry.weiorder;

import android.text.Editable;
import android.text.TextWatcher;

class gt implements TextWatcher {
  gt(WeshopPaymentSettingsFragment paramWeshopPaymentSettingsFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {
    try {
      double d = Double.parseDouble(paramEditable.toString());
      this.cxj.cxi.az(d);
      return;
    } catch (Exception paramEditable) {
      return;
    } 
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\gt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */