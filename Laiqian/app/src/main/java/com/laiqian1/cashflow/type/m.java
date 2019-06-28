package com.laiqian.cashflow.type;

import android.view.View;
import android.widget.AdapterView;

class m implements AdapterView.OnItemClickListener {
  m(CashFlowTypeListActivity paramCashFlowTypeListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    CashFlowTypeListActivity.e(this.aKt).setSelection(paramInt);
    CashFlowTypeListActivity.e(this.aKt).setItemChecked(paramInt, true);
    f f = new f(this.aKt, CashFlowTypeListActivity.f(this.aKt).dR(paramInt));
    f.a(this.aKt.aKs);
    f.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\type\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */