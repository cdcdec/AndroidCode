package com.laiqian.wallet;

import android.os.Handler;
import java.util.Timer;

public class i {
  boolean bMf = false;
  
  Timer bxH = null;
  
  public void XV() {
    if (this.bxH != null) {
      this.bxH.cancel();
      this.bxH = null;
    } 
  }
  
  public void a(Handler paramHandler, int paramInt) { a(paramHandler, paramInt, null); }
  
  public void a(Handler paramHandler, int paramInt, a parama) {
    this.bMf = false;
    XV();
    this.bxH = new Timer();
    this.bxH.schedule(new j(this, paramHandler, parama), paramInt);
  }
  
  public static interface a {
    void XW();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\wallet\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */