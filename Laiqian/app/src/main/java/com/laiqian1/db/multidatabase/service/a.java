package com.laiqian.db.multidatabase.service;

import android.content.Intent;

class a implements Runnable {
  a(KillSelfService paramKillSelfService) {}
  
  public void run() {
    Intent intent = this.aOI.getPackageManager().getLaunchIntentForPackage(KillSelfService.a(this.aOI));
    this.aOI.startActivity(intent);
    this.aOI.stopSelf();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\db\multidatabase\service\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */