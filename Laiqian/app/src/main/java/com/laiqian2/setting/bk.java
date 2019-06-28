package com.laiqian.setting;

import android.content.Intent;
import com.laiqian.d.a;
import com.laiqian.ui.a.aq;
import com.laiqian.util.n;

class bk extends Object implements aq.a<CharSequence> {
  bk(bj parambj) {}
  
  public void a(aq paramaq, int paramInt, CharSequence paramCharSequence) {
    a.AZ().dU(n.parseInt(paramCharSequence.toString()));
    if (this.dlW.dlV.getActivity() != null) {
      this.dlW.dlV.getActivity().sendBroadcast(new Intent("pos_activity_change_data_producttype"));
      if (a.AZ().Bk())
        this.dlW.dlV.getActivity().sendBroadcast(new Intent("pos_activity_change_data_area")); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */