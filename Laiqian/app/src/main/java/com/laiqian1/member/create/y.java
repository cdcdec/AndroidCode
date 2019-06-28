package com.laiqian.member.create;

import android.view.View;
import com.laiqian.ui.a.w;

class y implements View.OnClickListener {
  y(VipCreateDialog paramVipCreateDialog) {}
  
  public void onClick(View paramView) {
    if (VipCreateDialog.g(this.bxz) == null) {
      VipCreateDialog.a(this.bxz, new w(VipCreateDialog.h(this.bxz), VipCreateDialog.i(this.bxz), new z(this)));
      VipCreateDialog.g(this.bxz).gn(0);
    } 
    VipCreateDialog.g(this.bxz).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */