package com.laiqian.pos.settings;

import android.content.Context;
import android.widget.Toast;
import com.laiqian.opentable.common.ag;
import kotlin.Metadata;

@Metadata
final class ar implements ag.a {
  ar(ShopBasicInfoFragment paramShopBasicInfoFragment) {}
  
  public final void db(boolean paramBoolean) {
    if (paramBoolean) {
      Toast.makeText((Context)this.cAE.getActivity(), 2131628397, 0).show();
      this.cAE.getActivity().finish();
      return;
    } 
    Toast.makeText((Context)this.cAE.getActivity(), 2131628396, 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */