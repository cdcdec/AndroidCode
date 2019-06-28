package com.laiqian.cashflow.type;

class o implements f.a {
  o(CashFlowTypeListActivity paramCashFlowTypeListActivity) {}
  
  public void bH(String paramString) {}
  
  public void c(long paramLong1, String paramString, long paramLong2) {
    if (paramLong2 == 300001L) {
      CashFlowTypeListActivity.e(this.aKt).setSelection(0);
      CashFlowTypeListActivity.e(this.aKt).setItemChecked(0, true);
    } else {
      CashFlowTypeListActivity.e(this.aKt).setSelection(1);
      CashFlowTypeListActivity.e(this.aKt).setItemChecked(1, true);
    } 
    CashFlowTypeListActivity.b(this.aKt, paramLong2);
    this.aKt.setResult(-1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\type\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */