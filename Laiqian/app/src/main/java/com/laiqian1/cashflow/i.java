package com.laiqian.cashflow;

import android.view.View;
import com.laiqian.ui.a.g;

class i implements View.OnClickListener {
  i(CashFlowDetailActivity paramCashFlowDetailActivity) {}
  
  public void onClick(View paramView) {
    CashFlowDetailActivity.a(this.aJH, new g(this.aJH, CashFlowDetailActivity.b(this.aJH), new j(this)));
    CashFlowDetailActivity.g(this.aJH).b(CashFlowDetailActivity.d(this.aJH), -1);
    CashFlowDetailActivity.g(this.aJH).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */