package com.laiqian.auth;

import com.laiqian.ui.ImageCheckBox;

class ch implements ImageCheckBox.a {
  ch(UserManagement.c paramc, int paramInt) {}
  
  public void a(ImageCheckBox paramImageCheckBox, boolean paramBoolean) {
    if (this.qI == 1) {
      if (!paramBoolean) {
        ((UserManagement.d)UserManagement.c.a(this.aGt).get(0)).aGu = false;
        ((UserManagement.d)UserManagement.c.a(this.aGt).get(1)).aGu = false;
      } else {
        ((UserManagement.d)UserManagement.c.a(this.aGt).get(1)).aGu = true;
      } 
      this.aGt.notifyDataSetChanged();
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\auth\ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */