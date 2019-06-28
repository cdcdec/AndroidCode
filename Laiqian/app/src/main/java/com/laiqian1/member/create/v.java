package com.laiqian.member.create;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

class v implements TextWatcher {
  v(VipCreateDialog paramVipCreateDialog) {}
  
  public void afterTextChanged(Editable paramEditable) { Log.e("et_pay_password", paramEditable.toString()); }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */