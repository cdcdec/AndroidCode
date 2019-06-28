package com.laiqian.takeaway;

import com.laiqian.entity.TakeOrderEntity;
import com.laiqian.ui.a.r;

class ai implements r.a {
  ai(ah paramah) {}
  
  public void xD() { this.dsi.dsf.ha(false); }
  
  public void xE() {
    TakeOrderEntity takeOrderEntity = (TakeOrderEntity)y.e(this.dsi.dsf).get(this.dsi.dse);
    y.e(this.dsi.dsf).remove(this.dsi.dse);
    y.a(this.dsi.dsf, this.dsi.bcD);
    y.a(this.dsi.dsf, takeOrderEntity);
    this.dsi.dsf.notifyDataSetChanged();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\takeaway\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */