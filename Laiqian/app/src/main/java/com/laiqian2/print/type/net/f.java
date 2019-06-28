package com.laiqian.print.type.net;

import android.view.View;
import com.laiqian.util.bd;

class f implements View.OnClickListener {
  f(ChangeNetPrinterIpActivity paramChangeNetPrinterIpActivity) {}
  
  public void onClick(View paramView) {
    if (!bd.bH(this.cKX.getActivity())) {
      this.cKX.ahI();
      return;
    } 
    this.cKX.cKS.ahT();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\net\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */