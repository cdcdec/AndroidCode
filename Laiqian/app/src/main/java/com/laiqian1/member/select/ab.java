package com.laiqian.member.select;

import com.laiqian.d.a;
import com.laiqian.ui.listview.FormListView;

class ab implements FormListView.c {
  ab(y paramy) {}
  
  public void getListData(int paramInt) {
    byte b;
    y y1 = this.bAT;
    if (a.AZ().Bw()) {
      b = 4;
    } else {
      b = 2;
    } 
    y1.a(b, paramInt, this.bAT.bvf);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */