package com.laiqian.member;

import android.view.View;

class ay implements View.OnClickListener {
  ay(MemberListActivity paramMemberListActivity) {}
  
  public void onClick(View paramView) {
    View[] arrayOfView = (View[])paramView.getTag();
    if (arrayOfView[1].isSelected()) {
      MemberListActivity.b(this.bvu, arrayOfView[0]);
      return;
    } 
    MemberListActivity.c(this.bvu, arrayOfView[1]);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */