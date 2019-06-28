package com.laiqian.member;

import android.util.Log;
import android.view.Display;
import com.laiqian.ui.listview.FormListView;

class bl implements FormListView.a {
  bl(MemberListActivity paramMemberListActivity) {}
  
  public void aX(int paramInt1, int paramInt2) {
    if (paramInt2 == 0) {
      this.bvu.aNv.setVisibility(8);
      Display display = this.bvu.getWindowManager().getDefaultDisplay();
      display.getHeight();
      paramInt2 = display.getWidth();
      int i = paramInt2 / paramInt2;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt2);
      stringBuilder.append("");
      Log.e("screenHeight", stringBuilder.toString());
      MemberListActivity.d(this.bvu).setVisibility(0);
      if (paramInt1 == 0) {
        MemberListActivity.d(this.bvu).setVisibility(8);
        this.bvu.buS.setVisibility(8);
        MemberListActivity.e(this.bvu).setVisibility(0);
      } else if (paramInt1 > 0 && paramInt1 < 10) {
        this.bvu.buS.hideFooterView();
        this.bvu.buS.setVisibility(0);
        MemberListActivity.e(this.bvu).setVisibility(8);
      } else if (paramInt1 >= 10 && paramInt2 <= 760) {
        this.bvu.buS.showFooterView();
        this.bvu.buS.setVisibility(0);
        MemberListActivity.e(this.bvu).setVisibility(8);
      } else if (paramInt1 >= 10 && paramInt2 > 760) {
        this.bvu.buS.showFooterView();
        this.bvu.buS.setVisibility(0);
        MemberListActivity.e(this.bvu).setVisibility(8);
      } 
      this.bvu.aDQ.postDelayed(new bm(this), 100L);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */