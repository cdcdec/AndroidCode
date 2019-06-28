package com.laiqian.report.ui;

import android.text.Editable;
import android.text.TextWatcher;

class cb implements TextWatcher {
  cb(ReturnModeReport paramReturnModeReport) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (paramEditable.length() == 0) {
      ReturnModeReport.b(this.dhg).setVisibility(8);
    } else {
      ReturnModeReport.b(this.dhg).setVisibility(0);
    } 
    this.dhg.AJ();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */