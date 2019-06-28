package com.laiqian.print.usage.receipt;

import android.text.Editable;
import android.text.TextWatcher;

class g implements TextWatcher {
  g(ReceiptPreviewActivity paramReceiptPreviewActivity) {}
  
  public void afterTextChanged(Editable paramEditable) { ReceiptPreviewActivity.f(this.cNl).lS(paramEditable.toString()); }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\receipt\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */