package com.laiqian.print.usage.delivery;

import android.text.Editable;
import android.text.TextWatcher;

class s implements TextWatcher {
  s(DeliveryPreviewActivity paramDeliveryPreviewActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (DeliveryPreviewActivity.e(this.cMu))
      return; 
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\delivery\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */