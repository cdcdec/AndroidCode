package com.laiqian.member.select;

import android.view.View;

class af implements View.OnClickListener {
  af(ad paramad) {}
  
  public void onClick(View paramView) {
    int i = ((Integer)paramView.getTag()).intValue();
    this.bAV.bAT.bAx = i - this.bAV.bAT.bAq.getHeaderViewsCount();
    this.bAV.bAT.fI(i - this.bAV.bAT.bAq.getHeaderViewsCount());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\member\select\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */