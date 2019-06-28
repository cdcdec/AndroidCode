package com.laiqian.member.create;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class h implements View.OnFocusChangeListener {
  h(VipCreateDialog paramVipCreateDialog) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    if (paramBoolean) {
      VipCreateDialog.a(this.bxz, (EditText)paramView);
      this.bxz.eP(false);
      return;
    } 
    InputMethodManager inputMethodManager = (InputMethodManager)this.bxz.getContext().getSystemService("input_method");
    if (inputMethodManager.isActive())
      inputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */