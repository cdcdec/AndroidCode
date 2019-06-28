package com.laiqian.member;

import android.view.View;
import com.laiqian.vip.R;

class l implements View.OnFocusChangeListener {
  l(MemberChangeActivity paramMemberChangeActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    if (paramBoolean) {
      if (this.btq.bsR > 0) {
        this.btq.bsA.setHint(this.btq.getString(R.string.pos_member_read_card));
      } else {
        this.btq.bsA.setHint("");
      } 
      bz bz;
      if ((bz = this.btq.aDP).aE(this.btq)) {
        this.btq.bsA.setHint(this.btq.getString(R.string.pos_member_read_card));
        this.btq.aDP = bz.Qw();
        this.btq.aDP.a(this.btq, 500L, this.btq.aDQ);
        this.btq.aDP.start();
        return;
      } 
      if (this.btq.aDP != null) {
        this.btq.aDP.stop();
        return;
      } 
    } else {
      this.btq.bsA.setHint("");
      if (this.btq.aDP != null)
        this.btq.aDP.stop(); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */