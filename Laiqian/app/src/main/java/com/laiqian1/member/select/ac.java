package com.laiqian.member.select;

import com.laiqian.ui.listview.FormListView;

class ac implements FormListView.a {
  ac(y paramy) {}
  
  public void aX(int paramInt1, int paramInt2) {
    if (paramInt2 == 0)
      if (paramInt1 == 0) {
        this.bAT.bvf.fC("");
        this.bAT.fF(0);
      } else if (paramInt1 == 1) {
        this.bAT.fF(1);
        this.bAT.bAx = 0;
        this.bAT.fG(0);
      } else if (paramInt1 > 1) {
        this.bAT.fF(2);
      }  
    this.bAT.dK(false);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */