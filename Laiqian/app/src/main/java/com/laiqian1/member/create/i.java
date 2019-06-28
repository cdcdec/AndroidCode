package com.laiqian.member.create;

import android.view.View;
import android.widget.EditText;

class i implements View.OnFocusChangeListener {
  i(VipCreateDialog paramVipCreateDialog) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    if (paramBoolean) {
      VipCreateDialog.b(this.bxz, (EditText)paramView);
      this.bxz.eP(true);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */