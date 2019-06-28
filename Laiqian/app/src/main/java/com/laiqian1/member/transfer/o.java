package com.laiqian.member.transfer;

import com.laiqian.ui.a.w;
import com.laiqian.ui.a.z;
import com.laiqian.vip.R;
import java.util.HashMap;

class o implements w.a {
  o(d paramd) {}
  
  public void bA(boolean paramBoolean) { z.a(this, paramBoolean); }
  
  public void dL(int paramInt) {
    if (paramInt > -1) {
      this.bHx.bHn = String.valueOf(((HashMap)this.bHx.bHo.get(paramInt)).get("path"));
      d.b(this.bHx, paramInt);
      d.a(this.bHx).gl(this.bHx.bHn);
      return;
    } 
    d.a(this.bHx).gk(d.d(this.bHx).getString(R.string.pos_please_manual_search));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\transfer\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */