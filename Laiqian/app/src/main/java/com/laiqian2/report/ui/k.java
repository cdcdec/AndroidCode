package com.laiqian.report.ui;

import android.view.View;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.util.n;
import io.reactivex.g.a;

class k implements View.OnClickListener {
  k(DeliveryReport paramDeliveryReport) {}
  
  public void onClick(View paramView) {
    if (!this.det.anQ())
      return; 
    if (a.bo(this.det).getPrinters().isEmpty()) {
      n.w(this.det, 2131627438);
      return;
    } 
    this.det.dgi.setVisibility(4);
    this.det.dgj.setVisibility(0);
    a.aKh().r(new l(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */