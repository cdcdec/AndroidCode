package com.laiqian.network.service;

import com.laiqian.util.ch;
import java.io.File;

class h implements Runnable {
  h(DownloadOtaService paramDownloadOtaService) {}
  
  public void run() {
    null = new StringBuilder();
    null.append(ch.awH());
    null.append("update.zip");
    File file = new File(null.toString());
    if (file.exists())
      file.delete(); 
    DownloadOtaService.b(this.bVV).notify(0, DownloadOtaService.d(this.bVV));
    this.bVV.onStart(null, 0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\service\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */