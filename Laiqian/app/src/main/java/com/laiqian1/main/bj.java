package com.laiqian.main;

import android.text.Editable;
import android.text.TextWatcher;

class bj implements TextWatcher {
  bj(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void afterTextChanged(Editable paramEditable) { this.bcy.showAfterPaidChanged(paramEditable.toString()); }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */