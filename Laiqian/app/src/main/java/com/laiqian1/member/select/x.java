package com.laiqian.member.select;

import android.view.View;

class x implements View.OnClickListener {
  x(v paramv) {}
  
  public void onClick(View paramView) {
    int i = ((Integer)paramView.getTag()).intValue();
    this.bAP.bAN.bAx = i - this.bAP.bAN.bAq.getHeaderViewsCount();
    this.bAP.bAN.fI(i - this.bAP.bAN.bAq.getHeaderViewsCount());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */