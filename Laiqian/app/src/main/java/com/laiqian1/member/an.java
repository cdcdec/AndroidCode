package com.laiqian.member;

import android.view.View;
import com.laiqian.basic.RootApplication;
import com.laiqian.ui.a.be;
import com.laiqian.vip.R;

class an implements View.OnClickListener {
  an(MemberInfoActivity paramMemberInfoActivity) {}
  
  public void onClick(View paramView) {
    MemberInfoActivity.a(this.buu, false);
    if (this.buu.buc == null) {
      String str = RootApplication.zv().getResources().getString(R.string.pos_pos_SimpleYearAndMonth);
      this.buu.buc = new be(this.buu, str);
      this.buu.buc.a(new ao(this));
    } 
    this.buu.buc.g(MemberInfoActivity.h(this.buu));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */