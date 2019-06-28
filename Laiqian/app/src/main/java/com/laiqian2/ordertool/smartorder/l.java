package com.laiqian.ordertool.smartorder;

import android.widget.CompoundButton;
import com.laiqian.d.a;
import com.laiqian.dcb.api.server.ServerService;
import com.laiqian.opentable.common.b;
import com.laiqian.util.n;

class l implements CompoundButton.OnCheckedChangeListener {
  l(SmartOrderSettingsFragment paramSmartOrderSettingsFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean) {
    if (a.AZ().Bk() && b.XC()) {
      if (a.AZ().Bd() != paramBoolean) {
        n.eP(2131626004);
        SmartOrderSettingsFragment.a(this.ceO).setChecked(true);
      } 
      return;
    } 
    if (paramBoolean) {
      SmartOrderSettingsFragment.b(this.ceO);
      SmartOrderSettingsFragment.a(this.ceO).setEnabled(true);
      a.AZ().bG(true);
      a.AZ().bH(true);
      a.AZ().bF(true);
      ServerService.aa(this.ceO.getActivity());
      SmartOrderSettingsFragment.c(this.ceO).setText(this.ceO.getString(2131625690));
      return;
    } 
    a.AZ().bG(false);
    ServerService.ae(this.ceO.getActivity());
    SmartOrderSettingsFragment.c(this.ceO).setText(this.ceO.getString(2131625690));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\smartorder\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */