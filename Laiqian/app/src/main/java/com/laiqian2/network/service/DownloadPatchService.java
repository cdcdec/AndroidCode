package com.laiqian.network.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import com.alipay.euler.andfix.patch.PatchManager;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.util.bb;
import com.laiqian.util.ch;
import com.laiqian.version.a;
import java.io.File;

public class DownloadPatchService extends Service {
  static String afa;
  
  static String afx;
  
  private PatchManager aMX;
  
  int afu;
  
  String bKb = "out.apatch";
  
  private boolean bVN = false;
  
  String bVO;
  
  Handler bVP;
  
  String bVT = ch.awG();
  
  String bVU;
  
  private a bVX;
  
  private a bVY;
  
  int progress;
  
  public DownloadPatchService() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.bVT);
    stringBuilder.append(this.bKb);
    this.bVO = stringBuilder.toString();
    this.afu = 1;
    this.progress = 0;
    this.bVP = new k(this);
  }
  
  private void WS() {
    if (!this.bVN)
      this.bVP.postDelayed(new l(this), 5000L); 
  }
  
  public IBinder onBind(Intent paramIntent) { return null; }
  
  public void onCreate() {
    super.onCreate();
    this.bVX = new a(this, null);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.intent.action.CloseDownloadService");
    registerReceiver(this.bVX, intentFilter);
  }
  
  public void onDestroy() {
    unregisterReceiver(this.bVX);
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
      stopSelf();
      return;
    } 
    i.c(this.bVP, afa, afx, this.bVO, this.afu, getBaseContext());
  }
  
  private class a extends BroadcastReceiver {
    private a(DownloadPatchService this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      bb.e("close", "接受到了Activity发送过来的广播");
      DownloadPatchService.a(this.bVZ, param1Intent.getBooleanExtra("bCloseService", false));
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\service\DownloadPatchService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */