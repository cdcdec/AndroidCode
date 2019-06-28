package com.laiqian.pos;

import android.os.Handler;
import android.os.Message;
import com.laiqian.util.bd;

class bf extends Handler {
  bf(PosDownloaderAfterLogin paramPosDownloaderAfterLogin) {}
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    if (PosDownloaderAfterLogin.b(this.cgy))
      return; 
    if (bd.bH(this.cgy)) {
      PosDownloaderAfterLogin.c(this.cgy);
      return;
    } 
    PosDownloaderAfterLogin.a(this.cgy);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */