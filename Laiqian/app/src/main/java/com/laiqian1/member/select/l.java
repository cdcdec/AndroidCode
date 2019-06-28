package com.laiqian.member.select;

import android.util.Log;
import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.member.create.aa;
import com.laiqian.member.create.ab;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class l implements View.OnClickListener {
  l(PosSelectVipDialog paramPosSelectVipDialog) {}
  
  public void onClick(View paramView) {
    aa aa = new StringBuilder();
    aa.append(RootApplication.getLaiqianPreferenceManager().avr());
    aa.append("");
    Log.e("getPaySubMode", aa.toString());
    if (RootApplication.getLaiqianPreferenceManager().avs() == 1 && RootApplication.getLaiqianPreferenceManager().avr() == 1 && RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.eP(R.string.only_headquarters_modifications_are_allowed);
      return;
    } 
    PosSelectVipDialog.a(this.bAG, true);
    if (RootApplication.getLaiqianPreferenceManager().Wq()) {
      ab ab = new ab(PosSelectVipDialog.a(this.bAG));
    } else {
      aa = new aa(PosSelectVipDialog.a(this.bAG));
    } 
    aa.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */