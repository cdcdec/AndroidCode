package com.laiqian.member.select;

import android.view.View;

class h implements View.OnClickListener {
  h(PosSelectVipDialog paramPosSelectVipDialog) {}
  
  public void onClick(View paramView) {
    if (this.bAG.bvf.Qy().replaceAll("\\%", "").equals(this.bAG.bvb.getText().toString().trim()) || "".equals(this.bAG.bvb.getText().toString().trim())) {
      this.bAG.bAw = false;
    } else {
      this.bAG.bAw = true;
    } 
    if (this.bAG.bAw) {
      this.bAG.Ej();
      return;
    } 
    if (this.bAG.bAq.getList().size() > 0 && this.bAG.bAh != 3)
      this.bAG.fE(PosSelectVipDialog.e(this.bAG)); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */