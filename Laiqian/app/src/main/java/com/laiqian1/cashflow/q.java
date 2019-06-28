package com.laiqian.cashflow;

import android.content.Intent;
import android.view.View;

class q implements View.OnClickListener {
  q(CashFlowReport paramCashFlowReport) {}
  
  public void onClick(View paramView) {
    Intent intent = new Intent();
    intent.setClass(this.aJQ, com.laiqian.cashflow.type.CashFlowTypeListActivity.class);
    this.aJQ.startActivityForResult(intent, 111);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */