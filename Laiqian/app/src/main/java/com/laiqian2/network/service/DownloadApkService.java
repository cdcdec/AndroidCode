package com.laiqian.network.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.widget.RemoteViews;
import com.laiqian.infrastructure.R;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.util.bb;
import com.laiqian.util.ch;
import hugo.weaving.DebugLog;
import java.io.File;

public class DownloadApkService extends Service {
  static String afa;
  
  static String afx;
  
  public static String bVG = "laiqian.apk.zip";
  
  public static String bVH = "laiqian.apk";
  
  private static String bVI = "APK";
  
  public static String bVJ = "apk";
  
  int afu = 1;
  
  private NotificationManager bVK;
  
  private a bVL;
  
  private boolean bVM = false;
  
  private boolean bVN = false;
  
  String bVO = ch.awE();
  
  Handler bVP = new c(this);
  
  private Notification notif;
  
  int progress = 0;
  
  static  {
  
  }
  
  private void WS() {
    if (!this.bVN)
      this.bVP.postDelayed(new d(this), 5000L); 
  }
  
  @DebugLog
  public IBinder onBind(Intent paramIntent) { return null; }
  
  @DebugLog
  public void onCreate() {
    super.onCreate();
    this.bVL = new a(this, null);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.intent.action.CloseDownloadService");
    registerReceiver(this.bVL, intentFilter);
    this.bVK = (NotificationManager)getSystemService("notification");
    this.notif = new Notification();
    this.notif.icon = R.drawable.pos_logo;
    this.notif.tickerText = getString(R.string.pos_laiqian_start_download);
    this.notif.contentView = new RemoteViews(getPackageName(), R.layout.content_view);
    this.bVK.notify(0, this.notif);
  }
  
  @DebugLog
  public void onDestroy() {
    unregisterReceiver(this.bVL);
    super.onDestroy();
  }
  
  @DebugLog
  public void onStart(Intent paramIntent, int paramInt) {
    bb.e("start", "onStart开启");
    if (paramIntent != null) {
      afx = paramIntent.getStringExtra("sApkFileName");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootUrlParameter.clt);
      stringBuilder.append("/");
      stringBuilder.append(paramIntent.getStringExtra("sApkDir"));
      afa = stringBuilder.toString();
      bb.ao(afa);
      bb.ao(afx);
      this.bVN = paramIntent.getBooleanExtra("bCloseService", false);
    } 
    if (afa == null || afx == null) {
      File file = new File(this.bVO);
      if (file.exists())
        file.delete(); 
      this.bVK.cancel(0);
      stopSelf();
      return;
    } 
    a.a(this.bVP, afa, afx, this.bVO, this.afu, getBaseContext());
  }
  
  private class a extends BroadcastReceiver {
    private a(DownloadApkService this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      bb.e("close", "接受到了Activity发送过来的广播");
      DownloadApkService.a(this.bVQ, param1Intent.getBooleanExtra("bCloseService", false));
      if (DownloadApkService.b(this.bVQ))
        DownloadApkService.a(this.bVQ).cancel(0); 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\service\DownloadApkService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */