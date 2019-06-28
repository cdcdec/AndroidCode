package com.laiqian.pos;

import android.widget.Toast;
import com.google.a.a.a.a.a.a;
import com.laiqian.infrastructure.R;
import com.laiqian.product.models.g;

class cm implements bn.a {
  cm(cl paramcl) {}
  
  public void p(String paramString, boolean paramBoolean) {
    g2 = new g(this.chX.chW.chz);
    boolean bool = g2.A(Long.parseLong(this.chX.chW.chS), paramString);
    g2.close();
    g g1 = new g(this.chX.chW.chz);
    try {
      g1.f(Long.parseLong(this.chX.chW.chS), paramBoolean);
      g1.close();
      paramBoolean = bool;
    } catch (RuntimeException g2) {
      a.e(g2);
      g1.close();
      paramBoolean = false;
    } finally {}
    if (paramBoolean) {
      Toast.makeText(this.chX.chW.chz, this.chX.chW.chz.getString(R.string.wechat_product_detail_success), 0).show();
      ProductPictureManagementActivity.m(this.chX.chW.chz);
      return;
    } 
    Toast.makeText(this.chX.chW.chz, this.chX.chW.chz.getString(R.string.wechat_product_detail_fail), 0).show();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */