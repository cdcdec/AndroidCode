package com.laiqian.member;

import android.text.Editable;
import android.text.TextWatcher;

class at implements TextWatcher {
  at(MemberListActivity paramMemberListActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {
    if (paramEditable.length() > 0) {
      MemberListActivity.k(this.bvu).setVisibility(0);
    } else {
      MemberListActivity.k(this.bvu).setVisibility(8);
    } 
    MemberListActivity.c(this.bvu).fC(String.format("%%%s%%", new Object[] { paramEditable.toString() }));
    this.bvu.buS.clearList();
    this.bvu.Pz();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */