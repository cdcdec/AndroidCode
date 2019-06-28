package com.laiqian.ordertool.mealorder;

import android.widget.CompoundButton;
import com.laiqian.d.a;
import com.laiqian.dcb.api.server.ServerService;
import com.laiqian.opentable.common.b;
import com.laiqian.util.n;

class e implements CompoundButton.OnCheckedChangeListener {
  e(MealOrderDownloadFragment paramMealOrderDownloadFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (a.AZ().Bk() && b.XC()) {
      if (a.AZ().Bd() != paramBoolean) {
        n.eP(2131626004);
        MealOrderDownloadFragment.a(this.ceh).setChecked(true);
      } 
      return;
    } 
    if (paramBoolean) {
      MealOrderDownloadFragment.b(this.ceh);
      MealOrderDownloadFragment.a(this.ceh).setEnabled(true);
      a.AZ().bG(true);
      a.AZ().bH(true);
      a.AZ().bF(true);
      ServerService.aa(this.ceh.getActivity());
      MealOrderDownloadFragment.c(this.ceh).setText(this.ceh.getString(2131625690));
      return;
    } 
    a.AZ().bG(false);
    ServerService.ae(this.ceh.getActivity());
    MealOrderDownloadFragment.c(this.ceh).setText(this.ceh.getString(2131625690));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\mealorder\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */