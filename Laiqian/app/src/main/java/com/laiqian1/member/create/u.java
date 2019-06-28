package com.laiqian.member.create;

import android.view.View;
import android.widget.EditText;

class u implements View.OnClickListener {
  u(VipCreateDialog paramVipCreateDialog) {}
  
  public void onClick(View paramView) { ((EditText)paramView.getTag()).requestFocus(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\creat\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */