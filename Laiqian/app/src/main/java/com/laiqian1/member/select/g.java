package com.laiqian.member.select;

import android.text.Editable;
import android.text.TextWatcher;

class g implements TextWatcher {
  g(PosSelectVipDialog paramPosSelectVipDialog) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (this.bAG.bvb.getText().toString().trim().length() > 0) {
      this.bAG.bAr.setVisibility(0);
      return;
    } 
    this.bAG.bAr.setVisibility(8);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */