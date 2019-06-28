package com.laiqian.pos.settings;

import android.widget.Toast;
import com.laiqian.ui.a.r;
import com.laiqian.util.bd;

class cc implements r.a {
  cc(ShopInfoActivity paramShopInfoActivity) {}
  
  public void xD() { this.cBl.finish(); }
  
  public void xE() {
    if (!bd.bH(this.cBl) && !this.cBl.getResources().getBoolean(2131034123)) {
      Toast.makeText(this.cBl, 2131626280, 0).show();
      return;
    } 
    ShopInfoActivity.g(this.cBl);
    this.cBl.finish();
  }
  
  public void xF() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\settings\cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */