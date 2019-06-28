package com.laiqian.member;

import com.laiqian.ui.listview.FormListView;

class ak implements FormListView.a {
  ak(MemberInfoActivity paramMemberInfoActivity) {}
  
  public void aX(int paramInt1, int paramInt2) {
    if (paramInt2 == 0) {
      if (paramInt1 == 0) {
        this.buu.btT.setVisibility(0);
        MemberInfoActivity.e(this.buu).hideFooterView();
        return;
      } 
      if (paramInt1 > 0 && paramInt1 < 7) {
        MemberInfoActivity.e(this.buu).hideFooterView();
        MemberInfoActivity.e(this.buu).setVisibility(0);
        this.buu.btT.setVisibility(8);
        return;
      } 
      if (paramInt1 >= 7) {
        MemberInfoActivity.e(this.buu).showFooterView();
        MemberInfoActivity.e(this.buu).setVisibility(0);
        this.buu.btT.setVisibility(8);
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */