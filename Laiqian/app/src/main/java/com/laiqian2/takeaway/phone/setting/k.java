package com.laiqian.takeaway.phone.setting;

import android.util.Log;
import android.view.Display;
import com.laiqian.ui.listview.FormListView;

class k implements FormListView.a {
  k(PhoneListActivity paramPhoneListActivity) {}
  
  public void aX(int paramInt1, int paramInt2) {
    if (paramInt2 == 0) {
      this.duU.aNv.setVisibility(8);
      Display display = this.duU.getWindowManager().getDefaultDisplay();
      display.getHeight();
      paramInt2 = display.getWidth();
      int i = paramInt2 / paramInt2;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt2);
      stringBuilder.append("");
      Log.e("screenHeight", stringBuilder.toString());
      PhoneListActivity.a(this.duU).setVisibility(0);
      if (paramInt1 == 0) {
        PhoneListActivity.a(this.duU).setVisibility(8);
        this.duU.duR.setVisibility(8);
        PhoneListActivity.b(this.duU).setVisibility(0);
        return;
      } 
      if (paramInt1 > 0 && paramInt1 < 10) {
        this.duU.duR.hideFooterView();
        this.duU.duR.setVisibility(0);
        PhoneListActivity.b(this.duU).setVisibility(8);
        return;
      } 
      if (paramInt1 >= 10 && paramInt2 <= 760) {
        this.duU.duR.showFooterView();
        this.duU.duR.setVisibility(0);
        PhoneListActivity.b(this.duU).setVisibility(8);
        return;
      } 
      if (paramInt1 >= 10 && paramInt2 > 760) {
        this.duU.duR.showFooterView();
        this.duU.duR.setVisibility(0);
        PhoneListActivity.b(this.duU).setVisibility(8);
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\phone\setting\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */