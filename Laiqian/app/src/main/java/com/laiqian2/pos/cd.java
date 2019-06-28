package com.laiqian.pos;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

class cd implements TextWatcher {
  cd(ProductPictureManagementActivity paramProductPictureManagementActivity, View paramView) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (TextUtils.isEmpty(ProductPictureManagementActivity.f(this.chz).getText().toString())) {
      this.chA.setVisibility(8);
      return;
    } 
    this.chA.setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */