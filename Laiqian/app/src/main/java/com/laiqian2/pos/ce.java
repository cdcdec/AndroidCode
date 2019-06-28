package com.laiqian.pos;

import android.text.Editable;
import android.text.TextWatcher;

class ce implements TextWatcher {
  ce(ProductPictureManagementActivity paramProductPictureManagementActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (ProductPictureManagementActivity.g(this.chz))
      ProductPictureManagementActivity.c(this.chz).YQ(); 
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */