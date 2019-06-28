package com.laiqian.print.usage.tag;

import android.text.Editable;
import android.text.TextWatcher;

class o implements TextWatcher {
  o(TagPreviewActivity paramTagPreviewActivity) {}
  
  public void afterTextChanged(Editable paramEditable) { TagPreviewActivity.f(this.cNN).lS(paramEditable.toString()); }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\tag\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */