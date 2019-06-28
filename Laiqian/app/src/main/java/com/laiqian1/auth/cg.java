package com.laiqian.auth;

import com.laiqian.ui.ImageCheckBox;

class cg implements ImageCheckBox.a {
  cg(UserManagement.c paramc, int paramInt) {}
  
  public void a(ImageCheckBox paramImageCheckBox, boolean paramBoolean) {
    if (this.qI == 0) {
      if (paramBoolean) {
        ((UserManagement.d)UserManagement.c.a(this.aGt).get(0)).aGu = true;
        ((UserManagement.d)UserManagement.c.a(this.aGt).get(1)).aGu = true;
      } else {
        ((UserManagement.d)UserManagement.c.a(this.aGt).get(0)).aGu = false;
      } 
      this.aGt.notifyDataSetChanged();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */