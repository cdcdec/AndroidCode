package com.laiqian.report.ui;

import android.os.Bundle;
import android.view.View;
import com.laiqian.util.n;

class ah implements View.OnClickListener {
  ah(OrderDetailsRoot paramOrderDetailsRoot) {}
  
  public void onClick(View paramView) {
    Bundle bundle = new Bundle();
    bundle.putString("orderNo", OrderDetailsRoot.access$000(this.dfa));
    bundle.putString("ORDERTIME", OrderDetailsRoot.access$100(this.dfa));
    n.a(this.dfa, OrderDetailsByReturnDetails.class, bundle);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */