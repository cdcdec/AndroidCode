package com.laiqian.member.select;

import com.laiqian.basic.RootApplication;
import com.laiqian.entity.as;
import com.laiqian.member.e.a;
import com.laiqian.pos.do;
import com.laiqian.util.n;
import java.util.Map;

class c implements do.a {
  c(b paramb) {}
  
  public void dj(boolean paramBoolean) {
    if (paramBoolean) {
      String str1;
      a a1 = new a(PosSelectVipDialog.c(this.bAH.bAG));
      as as = new as((String)((Map)this.bAH.bAG.bAq.getList().get(this.bAH.bAG.bAx)).get("sSpareField3"));
      long l = n.parseLong((String)((Map)this.bAH.bAG.bAq.getList().get(this.bAH.bAG.bAx)).get("_id"));
      String str2 = (String)((Map)this.bAH.bAG.bAq.getList().get(this.bAH.bAG.bAx)).get("sNumber");
      String str3 = (String)((Map)this.bAH.bAG.bAq.getList().get(this.bAH.bAG.bAx)).get("sContactMobilePhone");
      if (((Map)this.bAH.bAG.bAq.getList().get(this.bAH.bAG.bAx)).containsKey("nBelongShopID")) {
        str1 = (String)((Map)this.bAH.bAG.bAq.getList().get(this.bAH.bAG.bAx)).get("nBelongShopID");
      } else {
        str1 = RootApplication.getLaiqianPreferenceManager().Tx();
      } 
      int i = n.parseInt(str1);
      a1.a(as, l, str2, str3, i, new d(this));
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */