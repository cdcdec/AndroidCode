package com.laiqian.member.setting.credit;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.laiqian.util.n;

class c implements TextWatcher {
  c(VipCreditSettingFragment paramVipCreditSettingFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (TextUtils.isEmpty(paramEditable)) {
      this.bDa.bCZ.ao(-1.0D);
      return;
    } 
    this.bDa.bCZ.ao(n.u(paramEditable.toString()));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\credit\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */