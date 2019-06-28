package com.laiqian.report.ui;

import android.view.View;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.util.n;
import io.reactivex.g.a;

class cc implements View.OnClickListener {
  cc(ShiftDetails paramShiftDetails) {}
  
  public void onClick(View paramView) {
    if (a.bo(this.dhh).getPrinters().isEmpty()) {
      n.w(this.dhh, 2131627438);
      return;
    } 
    ShiftDetails.a(this.dhh).setVisibility(4);
    ShiftDetails.b(this.dhh).setVisibility(0);
    a.aKh().r(new cd(this));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */