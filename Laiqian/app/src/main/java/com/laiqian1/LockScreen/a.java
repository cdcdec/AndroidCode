package com.laiqian.LockScreen;

import android.widget.CompoundButton;

class a implements CompoundButton.OnCheckedChangeListener {
  a(LockScreenManage paramLockScreenManage, String paramString) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (paramBoolean) {
      LockScreenManage.a(this.azR).setBackgroundResource(2130772056);
      LockScreenManage.b(this.azR).setVisibility(0);
      LockScreenManage.c(this.azR).setText(this.azQ);
      return;
    } 
    LockScreenManage.b(this.azR).setVisibility(8);
    LockScreenManage.a(this.azR).setBackgroundResource(2130772048);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\LockScreen\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */