package com.laiqian.main.module.settlement;

import android.util.Log;
import android.widget.TextView;
import io.reactivex.c.g;
import java.util.List;

class ac extends Object implements g<List<Integer>> {
  ac(PosActivitySettlementDialogFragment paramPosActivitySettlementDialogFragment) {}
  
  public void r(List<Integer> paramList) throws Exception {
    Log.i("@emery dialogFragment", "给快速金额赋值");
    TextView[] arrayOfTextView = PosActivitySettlementDialogFragment.a(this.blV).Or();
    for (byte b = 0; b < arrayOfTextView.length; b++) {
      TextView textView = arrayOfTextView[b];
      if (b < paramList.size()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramList.get(b));
        stringBuilder.append("");
        textView.setText(stringBuilder.toString());
      } else {
        textView.setText("");
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */