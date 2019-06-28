package com.laiqian.pos.settings;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

class cg implements TextWatcher {
  cg(ShopInfoActivity paramShopInfoActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    if (paramCharSequence.toString().contains(".")) {
      paramCharSequence = paramCharSequence.toString().trim().replace(".", "");
      ((EditText)this.cBl.cBh.cBm.cAJ.dwQ.getView()).setText(paramCharSequence);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */