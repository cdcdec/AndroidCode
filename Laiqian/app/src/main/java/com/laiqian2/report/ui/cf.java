package com.laiqian.report.ui;

import android.view.View;
import com.laiqian.ui.a.r;

class cf implements View.OnClickListener {
  cf(TransactionDetails paramTransactionDetails) {}
  
  public void onClick(View paramView) {
    r r = new r(this.dhn, true, new cg(this));
    r.setTitle(this.dhn.getString(2131625963));
    r.s(this.dhn.getString(2131629404));
    r.t(this.dhn.getString(2131625975));
    r.oZ(this.dhn.getString(2131625967));
    r.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */