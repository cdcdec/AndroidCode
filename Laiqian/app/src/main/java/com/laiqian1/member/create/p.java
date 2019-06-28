package com.laiqian.member.create;

import android.content.DialogInterface;

class p implements DialogInterface.OnDismissListener {
  p(VipCreateDialog paramVipCreateDialog) {}
  
  public void onDismiss(DialogInterface paramDialogInterface) {
    VipCreateDialog.a(this.bxz, false);
    this.bxz.bwy.setEnabled(true);
    this.bxz.bwy.setFocusable(true);
    this.bxz.bwy.setClickable(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */