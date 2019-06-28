package com.laiqian.setting;

import android.view.View;
import com.laiqian.crash.model.CrashApplication;
import com.laiqian.ui.a.w;

class bp implements View.OnClickListener {
  bp(SettingCashierFragment paramSettingCashierFragment) {}
  
  public void onClick(View paramView) {
    w w = new w(this.dlV.getActivity(), SettingCashierFragment.f(this.dlV), new bq(this));
    w.gn(CrashApplication.getLaiqianPreferenceManager().avy());
    w.show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\setting\bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */