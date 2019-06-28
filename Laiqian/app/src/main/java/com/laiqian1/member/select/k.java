package com.laiqian.member.select;

import android.view.View;
import java.util.Map;

class k implements View.OnClickListener {
  k(PosSelectVipDialog paramPosSelectVipDialog) {}
  
  public void onClick(View paramView) {
    if (this.bAG.bAq.getList().size() > 0) {
      this.bAG.bAy = (String)((Map)this.bAG.bAq.getList().get(this.bAG.bAx)).get("_id");
      String str = (String)((Map)this.bAG.bAq.getList().get(this.bAG.bAx)).get("nUpdateFlag");
      (new PosSelectVipDialog.a(this.bAG, null)).execute(new String[] { this.bAG.bAy, str });
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */