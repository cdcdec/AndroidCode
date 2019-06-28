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
import java.io.File;

public class DownloadOtaService extends Service {
  static String afa;
  
  static String afx;
  
  int afu;
  
  String bKb = "update.zip";
  
  private NotificationManager bVK;
  
  private boolean bVM = false;
  
  private boolean bVN = false;
  
  String bVO;
  
  Handler bVP;
  
  private a bVS;
  
  String bVT = ch.awH();
  
  String bVU;
  
  private Notification notif;
  
  int progress;
  
  public DownloadOtaService() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bVT);
    stringBuilder.append(this.bKb);
    this.bVO = stringBuilder.toString();
    this.afu = 1;
    this.progress = 0;
    this.bVP = new g(this);
  }
  
  private void WS() {
    if (!this.bVN)
      this.bVP.postDelayed(new h(this), 5000L); 
  }
  
  public IBinder onBind(Intent paramIntent) { return null; }
  
  public void onCreate() {
    super.onCreate();
    this.bVS = new a(this, null);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.intent.action.CloseDownloadService");
    registerReceiver(this.bVS, intentFilter);
    this.bVK = (NotificationManager)getSystemService("notification");
    this.notif = new Notification();
    this.notif.icon = R.drawable.pos_logo;
    this.notif.tickerText = getString(R.string.pos_laiqian_start_download);
    this.notif.contentView = new RemoteViews(getPackageName(), R.layout.content_view);
    this.bVK.notify(1, this.notif);
  }
  
  public void onDestroy() {
    unregisterReceiver(this.bVS);
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt) {
    bb.e("start", "onStart开启");
    if (paramIntent != null) {
      afx = paramIntent.getStringExtra("sFileName");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RootUrlParameter.clt);
      stringBuilder.append("/");
      stringBuilder.append(paramIntent.getStringExtra("sFileDir"));
      afa = stringBuilder.toString();
      this.bVU = paramIntent.getStringExtra("sVersion");
      bb.ao(afa);
      bb.ao(afx);
      this.bVN = paramIntent.getBooleanExtra("bCloseService", false);
    } 
    if (afa == null || afx == null) {
      File file = new File(this.bVO);
      if (file.exists())
        file.delete(); 
      this.bVK.cancel(1);
      stopSelf();
      return;
    } 
    e.b(this.bVP, afa, afx, this.bVO, this.afu, getBaseContext());
  }
  
  private class a extends BroadcastReceiver {
    private a(DownloadOtaService this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      bb.e("close", "接受到了Activity发送过来的广播");
      DownloadOtaService.a(this.bVV, param1Intent.getBooleanExtra("bCloseService", false));
      if (DownloadOtaService.a(this.bVV))
        DownloadOtaService.b(this.bVV).cancel(0); 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\service\DownloadOtaService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */