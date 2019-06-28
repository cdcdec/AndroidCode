package com.laiqian.pos.industry.weiorder;

import android.view.View;
import com.laiqian.ui.a.w;

class l implements View.OnClickListener {
  l(QRCodeSetting paramQRCodeSetting) {}
  
  public void onClick(View paramView) {
    if (QRCodeSetting.a(this.csI) == null) {
      QRCodeSetting.a(this.csI, new w(this.csI.getActivity(), QRCodeSetting.b(this.csI), new m(this)));
      QRCodeSetting.a(this.csI).setTitle(this.csI.getString(2131630524));
      QRCodeSetting.a(this.csI).pb(QRCodeSetting.c(this.csI).getText().toString().trim());
    } 
    QRCodeSetting.a(this.csI).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\industry\weiorder\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */