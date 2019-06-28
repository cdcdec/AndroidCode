package com.laiqian.member.create;

import android.view.View;
import android.widget.EditText;

class j implements View.OnFocusChangeListener {
  j(VipCreateDialog paramVipCreateDialog) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    if (paramBoolean) {
      VipCreateDialog.c(this.bxz, (EditText)paramView);
      this.bxz.eP(false);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */