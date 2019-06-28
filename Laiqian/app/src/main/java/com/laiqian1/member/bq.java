package com.laiqian.member;

import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.member.create.aa;
import com.laiqian.member.create.ab;
import com.laiqian.util.n;
import com.laiqian.vip.R;

class bq implements View.OnClickListener {
  bq(MemberListActivity paramMemberListActivity) {}
  
  public void onClick(View paramView) {
    if (RootApplication.getLaiqianPreferenceManager().avs() == 1 && RootApplication.getLaiqianPreferenceManager().avr() == 1 && RootApplication.getLaiqianPreferenceManager().QV() == 1) {
      n.eP(R.string.only_headquarters_modifications_are_allowed);
      return;
    } 
    if (RootApplication.getLaiqianPreferenceManager().Wq()) {
      this.bvu.bvm = new ab(this.bvu);
    } else {
      this.bvu.bvm = new aa(this.bvu);
    } 
    this.bvu.bvm.setOnDismissListener(new br(this));
    this.bvu.bvm.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */