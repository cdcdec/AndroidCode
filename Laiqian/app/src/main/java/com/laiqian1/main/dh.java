package com.laiqian.main;

import android.view.View;

class dh implements View.OnClickListener {
  dh(cs.c paramc) {}
  
  public void onClick(View paramView) {
    cs.e e = (cs.e)paramView.getTag();
    cs.h(this.bdi.bde).setVisibility(0);
    cs.x(this.bdi.bde).setText(cs.e.d(e));
    cs.y(this.bdi.bde).setTag(e);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */