package com.laiqian.setting;

import android.content.Intent;
import com.laiqian.d.a;
import com.laiqian.ui.a.aq;

class bn extends Object implements aq.a<CharSequence> {
  bn(bm parambm) {}
  
  public void a(aq paramaq, int paramInt, CharSequence paramCharSequence) {
    a.AZ().dV(paramInt);
    this.dlX.dlV.getActivity().sendBroadcast(new Intent("pos_activity_change_data_product"));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */