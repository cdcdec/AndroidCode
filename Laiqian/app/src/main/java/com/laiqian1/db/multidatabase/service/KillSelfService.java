package com.laiqian.db.multidatabase.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

public class KillSelfService extends Service {
  private static long aOG = 2000L;
  
  private String aOH;
  
  private Handler handler = new Handler();
  
  static  {
  
  }
  
  public IBinder onBind(Intent paramIntent) { return null; }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    aOG = paramIntent.getLongExtra("Delayed", 2000L);
    this.aOH = paramIntent.getStringExtra("PackageName");
    this.handler.postDelayed(new a(this), aOG);
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\db\multidatabase\service\KillSelfService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */