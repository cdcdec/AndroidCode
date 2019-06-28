package com.laiqian.member.select;

import android.text.TextUtils;
import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.entity.as;
import com.laiqian.member.e.a;
import com.laiqian.pos.do;
import com.laiqian.util.n;
import java.util.Map;

class b implements View.OnClickListener {
  b(PosSelectVipDialog paramPosSelectVipDialog) {}
  
  public void onClick(View paramView) {
    String str1 = (String)((Map)this.bAG.bAq.getList().get(this.bAG.bAx)).get("sSpareField3");
    if (!"null".equals(str1) && !TextUtils.isEmpty(str1) && !RootApplication.getLaiqianPreferenceManager().avM()) {
      (new do(PosSelectVipDialog.b(this.bAG), new c(this))).show();
      return;
    } 
    a a = new a(PosSelectVipDialog.d(this.bAG));
    as as = new as((String)((Map)this.bAG.bAq.getList().get(this.bAG.bAx)).get("sSpareField3"));
    long l = n.parseLong((String)((Map)this.bAG.bAq.getList().get(this.bAG.bAx)).get("_id"));
    String str2 = (String)((Map)this.bAG.bAq.getList().get(this.bAG.bAx)).get("sNumber");
    String str3 = (String)((Map)this.bAG.bAq.getList().get(this.bAG.bAx)).get("sContactMobilePhone");
    if (((Map)this.bAG.bAq.getList().get(this.bAG.bAx)).containsKey("nBelongShopID")) {
      str1 = (String)((Map)this.bAG.bAq.getList().get(this.bAG.bAx)).get("nBelongShopID");
    } else {
      str1 = RootApplication.getLaiqianPreferenceManager().Tx();
    } 
    int i = n.parseInt(str1);
    a.a(as, l, str2, str3, i, new e(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */