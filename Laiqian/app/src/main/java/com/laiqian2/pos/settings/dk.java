package com.laiqian.pos.settings;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.laiqian.pos.hardware.q;
import com.laiqian.util.aq;
import kotlin.Metadata;
import kotlin.jvm.b.f;
import org.jetbrains.annotations.NotNull;

@Metadata
public final class dk extends Handler {
  dk(ShopMoreInfoSettingsFragment paramShopMoreInfoSettingsFragment) {}
  
  public void handleMessage(@NotNull Message paramMessage) {
    f.m(paramMessage, "msg");
    int i = paramMessage.what;
    if (i != -1) {
      if (i != 1) {
        Toast.makeText((Context)this.cBV.getActivity(), (CharSequence)this.cBV.getString(2131630490), 0).show();
        ShopMoreInfoSettingsFragment.i(this.cBV).aea().setVisibility(8);
        ShopMoreInfoSettingsFragment.i(this.cBV).adZ().setVisibility(8);
        ShopMoreInfoSettingsFragment.i(this.cBV).aeb().setVisibility(0);
      } else if (ShopMoreInfoSettingsFragment.d(this.cBV) != null) {
        ShopMoreInfoSettingsFragment.i(this.cBV).aea().setVisibility(8);
        ShopMoreInfoSettingsFragment.i(this.cBV).adZ().setVisibility(0);
        ShopMoreInfoSettingsFragment.i(this.cBV).aeb().setVisibility(8);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(q.cll);
        stringBuilder1.append(ShopMoreInfoSettingsFragment.b(this.cBV));
        aq.qz(stringBuilder1.toString());
        ShopMoreInfoSettingsFragment shopMoreInfoSettingsFragment = this.cBV;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(q.cll);
        stringBuilder2.append(ShopMoreInfoSettingsFragment.b(this.cBV));
        ShopMoreInfoSettingsFragment.b(shopMoreInfoSettingsFragment, stringBuilder2.toString());
        ShopMoreInfoSettingsFragment.a(this.cBV, true);
        ShopMoreInfoSettingsFragment.e(this.cBV).jZ(ShopMoreInfoSettingsFragment.k(this.cBV));
        ShopMoreInfoSettingsFragment.a(this.cBV, ShopMoreInfoSettingsFragment.k(this.cBV), ShopMoreInfoSettingsFragment.j(this.cBV));
      } else {
        ShopMoreInfoSettingsFragment.i(this.cBV).aea().setVisibility(8);
        ShopMoreInfoSettingsFragment.i(this.cBV).adZ().setVisibility(8);
        ShopMoreInfoSettingsFragment.i(this.cBV).aeb().setVisibility(0);
      } 
    } else {
      ShopMoreInfoSettingsFragment.e(this.cBV).Jx();
      ShopMoreInfoSettingsFragment.i(this.cBV).aea().setVisibility(8);
      ShopMoreInfoSettingsFragment.i(this.cBV).aeb().setVisibility(0);
      ShopMoreInfoSettingsFragment.i(this.cBV).adZ().setVisibility(8);
    } 
    super.handleMessage(paramMessage);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */