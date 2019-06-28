package com.laiqian.main.module.settlement;

import android.util.Log;
import io.reactivex.c.g;

class cl extends Object implements g<Double> {
  cl(PosActivitySettlementDialogSubmitOrderFragment paramPosActivitySettlementDialogSubmitOrderFragment) {}
  
  public void g(Double paramDouble) throws Exception {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("------ 团购券金额=");
    stringBuilder.append(paramDouble);
    Log.i("orderFragment", stringBuilder.toString());
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */