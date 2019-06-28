package com.laiqian.member.create;

import com.laiqian.entity.al;
import com.laiqian.entity.h;
import com.laiqian.member.h.a;
import com.laiqian.vip.R;

class r implements a.a {
  r(VipCreateDialog paramVipCreateDialog) {}
  
  public void a(al paramal, h paramh) {
    VipCreateDialog.a(this.bxz, paramh);
    VipCreateDialog.a(this.bxz, paramal);
    String str = VipCreateDialog.b(this.bxz).getString(R.string.pos_vip_charge_gift_product_none);
    if (this.bxz.bwH.bwL != null)
      str = this.bxz.bwH.bwL.aVi.name; 
    VipCreateDialog.c(this.bxz).setText(str);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */