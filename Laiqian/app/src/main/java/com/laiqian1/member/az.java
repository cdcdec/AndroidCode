package com.laiqian.member;

import android.view.View;

class az implements View.OnClickListener {
  az(MemberListActivity paramMemberListActivity) {}
  
  public void onClick(View paramView) {
    MemberListActivity.a(this.bvu, 0);
    for (byte b = 0; b < MemberListActivity.l(this.bvu).length; b++) {
      boolean bool;
      View view = MemberListActivity.l(this.bvu)[b];
      if (MemberListActivity.l(this.bvu)[b] == paramView) {
        bool = true;
      } else {
        bool = false;
      } 
      view.setSelected(bool);
    } 
    this.bvu.buS.clearList();
    MemberListActivity.c(this.bvu).fD((String)paramView.getTag());
    this.bvu.Pz();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */