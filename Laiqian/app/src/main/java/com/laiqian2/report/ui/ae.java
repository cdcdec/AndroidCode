package com.laiqian.report.ui;

import android.text.TextUtils;
import com.laiqian.network.i;
import com.laiqian.util.n;

class ae implements Runnable {
  ae(ab paramab, int paramInt, i parami) {}
  
  public void run() {
    if (this.deY >= 9) {
      this.deW.deU.stop();
      this.deW.deV.deR.gD(false);
      OrderDetailsByReturn.a.d(this.deW.deV.deR).show();
    } 
    if (!TextUtils.isEmpty(this.deX.message))
      n.o(this.deX.message); 
    this.deW.deV.deR.deB.dez = false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\repor\\ui\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */