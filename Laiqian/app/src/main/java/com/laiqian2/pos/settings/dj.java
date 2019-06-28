package com.laiqian.pos.settings;

import android.content.Context;
import android.widget.Toast;
import com.laiqian.pos.hardware.q;
import com.laiqian.ui.a.r;
import com.laiqian.util.aq;
import kotlin.Metadata;
import kotlin.jvm.b.f;

@Metadata
public final class dj implements r.a {
  dj(ShopMoreInfoSettingsFragment paramShopMoreInfoSettingsFragment) {}
  
  public void xD() {}
  
  public void xE() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(q.cll);
    stringBuilder.append(ShopMoreInfoSettingsFragment.b(this.cBV));
    if (aq.qz(stringBuilder.toString())) {
      Toast.makeText((Context)this.cBV.getActivity(), (CharSequence)this.cBV.getString(2131630485), 0).show();
      ShopMoreInfoSettingsFragment.a(this.cBV, false);
      ShopMoreInfoSettingsFragment.b(this.cBV, "");
      cs cs = ShopMoreInfoSettingsFragment.e(this.cBV);
      if (cs == null)
        f.aQI(); 
      cs.jZ(ShopMoreInfoSettingsFragment.k(this.cBV));
      ShopMoreInfoSettingsFragment.a(this.cBV, ShopMoreInfoSettingsFragment.k(this.cBV), ShopMoreInfoSettingsFragment.j(this.cBV));
      return;
    } 
    Toast.makeText((Context)this.cBV.getActivity(), (CharSequence)this.cBV.getString(2131630484), 0).show();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */