package com.laiqian.member.select;

import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class p implements View.OnClickListener {
  p(PosSelectVipDialog paramPosSelectVipDialog) {}
  
  public void onClick(View paramView) {
    if (RootApplication.getLaiqianPreferenceManager().avs() == 1 && RootApplication.getLaiqianPreferenceManager().avr() == 1 && RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.eP(R.string.only_headquarters_modifications_are_allowed);
      return;
    } 
    this.bAG.fH(this.bAG.bAx);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */