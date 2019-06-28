package com.laiqian.pos.hardware;

import com.laiqian.ui.ImageCheckBox;

class g implements ImageCheckBox.a {
  g(CustomerDisplaySettingActivity paramCustomerDisplaySettingActivity) {}
  
  public void a(ImageCheckBox paramImageCheckBox, boolean paramBoolean) {
    CustomerDisplaySettingActivity.b(this.ckp).setEnabled(paramBoolean);
    CustomerDisplaySettingActivity.a(this.ckp, CustomerDisplaySettingActivity.b(this.ckp));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hardware\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */