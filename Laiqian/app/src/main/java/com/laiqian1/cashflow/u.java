package com.laiqian.cashflow;

import android.view.View;
import android.widget.AdapterView;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.ui.q;
import com.laiqian.util.n;

class u implements AdapterView.OnItemClickListener {
  u(t paramt, q paramq) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    switch (paramInt) {
      case 2:
        CashFlowReport.c(this.aJU.aJQ);
        break;
      case 1:
        if (a.bo(this.aJU.aJQ.getActivity()).getPrinters().isEmpty()) {
          n.w(this.aJU.aJQ.getActivity(), 2131627438);
          return;
        } 
        CashFlowReport.b(this.aJU.aJQ);
        break;
      case 0:
        CashFlowReport.a(this.aJU.aJQ);
        break;
    } 
    this.aJT.dismiss();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflo\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */