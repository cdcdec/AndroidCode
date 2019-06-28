package com.laiqian.pos;

import android.view.View;

class cq implements View.OnClickListener {
  cq(ReprintActivity paramReprintActivity) {}
  
  public void onClick(View paramView) {
    if (ReprintActivity.a(this.cik).getCount() > 0)
      ReprintActivity.a(this.cik, ReprintActivity.a(this.cik).gS(0)); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */