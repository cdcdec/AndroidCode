package com.laiqian.network.service;

import com.laiqian.util.ch;
import java.io.File;

class d implements Runnable {
  d(DownloadApkService paramDownloadApkService) {}
  
  public void run() {
    File file = new File(ch.awE());
    if (file.exists())
      file.delete(); 
    DownloadApkService.a(this.bVQ).notify(0, DownloadApkService.d(this.bVQ));
    this.bVQ.onStart(null, 0);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\service\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */