package com.laiqian.member;

import android.view.View;

class aw implements View.OnFocusChangeListener {
  aw(MemberListActivity paramMemberListActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean) {
    if (paramBoolean) {
      bz bz;
      if ((bz = this.bvu.aDP).aE(this.bvu)) {
        this.bvu.aDP = bz.Qw();
        this.bvu.aDP.a(this.bvu, 500L, this.bvu.aDQ);
        this.bvu.aDP.start();
        return;
      } 
      if (this.bvu.aDP != null) {
        this.bvu.aDP.stop();
        return;
      } 
    } else if (this.bvu.aDP != null) {
      this.bvu.aDP.stop();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */