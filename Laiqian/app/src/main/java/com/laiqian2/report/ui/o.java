package com.laiqian.report.ui;

import com.laiqian.entity.ap;
import com.laiqian.ui.a.aq;

class o extends Object implements aq.a<ap> {
  o(DeliveryReport paramDeliveryReport) {}
  
  public void a(aq paramaq, int paramInt, ap paramap) {
    DeliveryReport.c(this.det).setText(paramap.getName());
    this.det.des.daw = paramap.getID();
    this.det.AJ();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */