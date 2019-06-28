package com.laiqian.mobileopentable;

import android.view.View;
import com.laiqian.dcb.api.client.a;
import com.laiqian.opentable.common.b;

class e implements View.OnClickListener {
  e(OrderResultActivity paramOrderResultActivity) {}
  
  public void onClick(View paramView) {
    if (b.XC()) {
      new a(this.bMm);
      OrderResultActivity.b(this.bMm);
      OrderResultActivity.c(this.bMm);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\mobileopentable\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */