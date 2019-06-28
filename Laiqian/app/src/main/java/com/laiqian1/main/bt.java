package com.laiqian.main;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;

class bt implements View.OnClickListener {
  bt(PosActivitySettlementDialog paramPosActivitySettlementDialog, ArrayList paramArrayList) {}
  
  public void onClick(View paramView) {
    Context context = PosActivitySettlementDialog.access$3300(this.bcy);
    int j = this.bcz.size();
    int i = 5;
    if (j <= 5)
      i = this.bcz.size(); 
    b b = new b(context, paramView, '', i * 43);
    b.aF(this.bcz);
    b.a(this.bcz, new bu(this, b));
    b.KF();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */