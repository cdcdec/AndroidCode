package com.laiqian.cashflow.type;

import android.view.View;
import android.widget.AdapterView;

class l implements AdapterView.OnItemClickListener {
  l(CashFlowTypeListActivity paramCashFlowTypeListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    CashFlowTypeListActivity.c(this.aKt).setSelection(paramInt);
    CashFlowTypeListActivity.c(this.aKt).setItemChecked(paramInt, true);
    CashFlowTypeListActivity.a(this.aKt, CashFlowTypeListActivity.d(this.aKt).dS(paramInt).getID());
    CashFlowTypeListActivity.a(this.aKt, CashFlowTypeListActivity.d(this.aKt).dS(paramInt).getName());
    CashFlowTypeListActivity.b(this.aKt, CashFlowTypeListActivity.a(this.aKt));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\type\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */