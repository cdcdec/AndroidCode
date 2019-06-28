package com.laiqian.ordertool.smartorder;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.laiqian.pos.hardware.RootUrlParameter;

class j implements View.OnClickListener {
  j(SmartOrderDownloadFragment paramSmartOrderDownloadFragment) {}
  
  public void onClick(View paramView) {
    FragmentActivity fragmentActivity = this.ceK.getActivity();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RootUrlParameter.ckY);
    stringBuilder.append("/interface/check-apk");
    (new a(fragmentActivity, stringBuilder.toString(), 0.4D)).Zj();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\smartorder\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */