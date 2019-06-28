package com.laiqian.member.a;

import android.content.Context;
import com.laiqian.entity.al;
import com.laiqian.entity.h;
import com.laiqian.member.h.a;
import com.laiqian.vip.R;

class f implements a.a {
  f(a parama, Context paramContext) {}
  
  public void a(al paramal, h paramh) {
    this.bwR.a(paramh);
    this.bwR.a(paramal);
    String str = this.bwS.getString(R.string.pos_vip_charge_gift_product_none);
    if (this.bwR.bwH.bwL != null)
      str = this.bwR.bwH.bwL.aVi.name; 
    a.a(this.bwR).setText(str);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */