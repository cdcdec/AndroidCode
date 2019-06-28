package com.laiqian.member.create;

import android.view.View;
import android.widget.EditText;
import com.laiqian.d.a;
import com.laiqian.member.bz;
import com.laiqian.vip.R;

class k implements View.OnFocusChangeListener {
  k(VipCreateDialog paramVipCreateDialog) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    if (paramBoolean) {
      VipCreateDialog.d(this.bxz, (EditText)paramView);
      this.bxz.eP(false);
      if (VipCreateDialog.q(this.bxz)) {
        this.bxz.bxa.setHint(VipCreateDialog.r(this.bxz).getString(R.string.pos_member_read_card));
      } else {
        this.bxz.bxa.setHint("");
      } 
      this.bxz.eO(a.AZ().Bw() ^ true);
      bz bz;
      if ((bz = this.bxz.aDP).aE(VipCreateDialog.s(this.bxz))) {
        this.bxz.aDP = bz.Qw();
        this.bxz.aDP.a(VipCreateDialog.t(this.bxz), 500L, this.bxz.aDQ);
        this.bxz.aDP.start();
        return;
      } 
      if (this.bxz.aDP != null) {
        this.bxz.aDP.stop();
        return;
      } 
    } else {
      this.bxz.eO(true);
      if (this.bxz.aDP != null)
        this.bxz.aDP.stop(); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\create\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */