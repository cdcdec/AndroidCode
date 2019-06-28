package com.laiqian.cashflow;

import android.view.View;
import com.laiqian.ui.ActivityRoot;
import com.laiqian.ui.q;
import com.laiqian.util.ae;

class t implements View.OnClickListener {
  t(CashFlowReport paramCashFlowReport, View paramView) {}
  
  public void onClick(View paramView) {
    ActivityRoot activityRoot = this.aJQ.getActivity();
    int i = ae.b(this.aJQ.getActivity(), 150.0F);
    q q = new q(activityRoot, new String[] { "Sync", "Print", "Export" }, i, -2);
    q.setAnchorView(this.aJS.findViewById(2131299251));
    q.setModal(true);
    q.setOnItemClickListener(new u(this, q));
    q.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */