package com.laiqian.member.create;

import android.widget.CompoundButton;
import android.widget.LinearLayout;

class d implements CompoundButton.OnCheckedChangeListener {
  d(VipCreateDialog paramVipCreateDialog) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    LinearLayout linearLayout = VipCreateDialog.o(this.bxz);
    byte b2 = 8;
    if (paramBoolean) {
      b1 = 0;
    } else {
      b1 = 8;
    } 
    linearLayout.setVisibility(b1);
    linearLayout = VipCreateDialog.p(this.bxz);
    byte b1 = b2;
    if (paramBoolean)
      b1 = 0; 
    linearLayout.setVisibility(b1);
    if (paramBoolean)
      this.bxz.scanCodeHandle.post(new e(this)); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */