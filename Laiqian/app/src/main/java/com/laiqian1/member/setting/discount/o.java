package com.laiqian.member.setting.discount;

import android.view.View;
import com.laiqian.basic.LQKVersion;
import com.laiqian.c.a;

class o implements View.OnClickListener {
  o(VipDiscountFragment paramVipDiscountFragment) {}
  
  public void onClick(View paramView) {
    boolean bool;
    if (LQKVersion.zl() && a.zR().Ad()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool)
      VipDiscountFragment.a(this.bDQ); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\discount\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */