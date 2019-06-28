package com.laiqian.member.setting.marketing;

import android.widget.AbsListView;

class y implements AbsListView.OnScrollListener {
  boolean bDk;
  
  y(SMSDetailStaticsActivity paramSMSDetailStaticsActivity, SMSDetailStaticsActivity.c paramc) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
    boolean bool;
    if (paramInt1 + paramInt2 == paramInt3) {
      bool = true;
    } else {
      bool = false;
    } 
    this.bDk = bool;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    if (this.bDk && paramInt == 0 && SMSDetailStaticsActivity.a(this.bFc).size() >= 20)
      SMSDetailStaticsActivity.a(this.bFc, this.bFb); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\setting\marketing\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */