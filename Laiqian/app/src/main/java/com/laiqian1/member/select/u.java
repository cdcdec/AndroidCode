package com.laiqian.member.select;

import com.laiqian.ui.listview.FormListView;

class u implements FormListView.a {
  u(r paramr) {}
  
  public void aX(int paramInt1, int paramInt2) {
    if (paramInt2 == 0) {
      if (paramInt1 == 0) {
        this.bAN.bvf.fC("");
        this.bAN.fF(0);
        return;
      } 
      if (paramInt1 == 1) {
        this.bAN.fF(1);
        this.bAN.bAx = 0;
        this.bAN.fG(0);
        return;
      } 
      if (paramInt1 > 1)
        this.bAN.fF(2); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\selec\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */