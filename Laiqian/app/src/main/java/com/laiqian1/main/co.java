package com.laiqian.main;

import android.view.View;
import com.laiqian.util.n;

class co implements View.OnClickListener {
  co(PosActivitySettlementDialog paramPosActivitySettlementDialog) {}
  
  public void onClick(View paramView) {
    if (PosActivitySettlementDialog.access$800(this.bcy))
      return; 
    PosActivitySettlementDialog.access$900(this.bcy, 10001, true);
    PosActivitySettlementDialog.access$1000(this.bcy).OC();
    double d = PosActivitySettlementDialog.access$1100(this.bcy);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("这里是删除会员按钮时的折扣：");
    stringBuilder.append(d);
    n.println(stringBuilder.toString());
    if (n.aU(PosActivitySettlementDialog.access$600(this.bcy).getText()) != d) {
      PosActivitySettlementDialog.access$600(this.bcy).requestFocus();
      PosActivitySettlementDialog.access$1200(this.bcy, d);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */