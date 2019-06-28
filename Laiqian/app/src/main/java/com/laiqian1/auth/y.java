package com.laiqian.auth;

import android.text.Editable;
import android.text.TextWatcher;

class y implements TextWatcher {
  y(CreateEmployeeDialog paramCreateEmployeeDialog) {}
  
  public void afterTextChanged(Editable paramEditable) { CreateEmployeeDialog.d(this.aDT).setText(""); }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */