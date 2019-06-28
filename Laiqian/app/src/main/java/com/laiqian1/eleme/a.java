package com.laiqian.eleme;

import android.os.Handler;
import android.os.Message;
import com.laiqian.pos.dn;

class a extends Handler {
  a(ElemeActivity paramElemeActivity) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    this.aQF.Eo();
    (new dn(this.aQF)).start();
    this.aQF.aQA.init();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\eleme\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */