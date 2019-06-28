package com.laiqian.setting;

import android.content.Context;
import android.view.View;
import com.laiqian.d.a;
import com.laiqian.models.at;
import com.laiqian.util.m;
import com.laiqian.util.n;

class bh extends m.b {
  bh(SettingCashierFragment paramSettingCashierFragment, Context paramContext, View paramView) { super(paramContext, paramView); }
  
  protected boolean e(View paramView1, View paramView2) {
    if (paramView2.isSelected()) {
      at at = new at(this.dlV.getActivity());
      boolean bool = at.em(false);
      at.close();
      if (bool) {
        n.eP(2131630087);
        return true;
      } 
    } 
    return false;
  }
  
  protected void f(View paramView1, View paramView2) { a.AZ().bF(paramView2.isSelected()); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */