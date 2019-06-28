package com.laiqian.auth;

import com.laiqian.ui.ImageCheckBox;

class ap implements ImageCheckBox.a {
  ap(PrivilegeLimitActivity paramPrivilegeLimitActivity) {}
  
  public void a(ImageCheckBox paramImageCheckBox, boolean paramBoolean) {
    if (paramBoolean) {
      this.aEm.findViewById(2131297746).setVisibility(0);
      this.aEm.findViewById(2131297747).setVisibility(0);
      PrivilegeLimitActivity.g(this.aEm).setVisibility(0);
      PrivilegeLimitActivity.h(this.aEm).setVisibility(0);
      PrivilegeLimitActivity.i(this.aEm);
      return;
    } 
    this.aEm.findViewById(2131297746).setVisibility(8);
    this.aEm.findViewById(2131297747).setVisibility(8);
    PrivilegeLimitActivity.g(this.aEm).setVisibility(8);
    PrivilegeLimitActivity.h(this.aEm).setVisibility(8);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */