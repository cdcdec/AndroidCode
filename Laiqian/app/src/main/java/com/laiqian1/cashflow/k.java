package com.laiqian.cashflow;

import android.view.View;
import com.laiqian.ui.a.g;

class k implements View.OnClickListener {
  k(CashFlowDetailActivity paramCashFlowDetailActivity) {}
  
  public void onClick(View paramView) {
    CashFlowDetailActivity.b(this.aJH, new g(this.aJH, CashFlowDetailActivity.e(this.aJH), new l(this)));
    CashFlowDetailActivity.i(this.aJH).b(CashFlowDetailActivity.f(this.aJH), -1);
    CashFlowDetailActivity.i(this.aJH).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */