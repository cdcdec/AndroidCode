package com.laiqian.dcb.api.client;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.laiqian.util.logger.a;

public class HeartBeatService extends Service {
  private a aOV = new a(HeartBeatService.class.getName());
  
  private AlarmManager aOW;
  
  private PendingIntent aOX;
  
  private long aOY = 0L;
  
  private void DA() {
    Intent intent = new Intent(this, HeartbeatReceiver.class);
    intent.putExtra(HeartbeatReceiver.KEY, 1);
    sendBroadcast(intent);
  }
  
  private void DB() {
    a a1 = this.aOV;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("设置心跳闹钟，周期: ");
    stringBuilder.append(this.aOY / 1000L);
    stringBuilder.append("s");
    a1.b(stringBuilder.toString(), new Object[0]);
    if (this.aOX != null)
      this.aOW.cancel(this.aOX); 
    this.aOX = PendingIntent.getService(this, 0, new Intent(this, HeartBeatService.class), 268435456);
    long l1 = System.currentTimeMillis();
    long l2 = this.aOY;
    this.aOW.setRepeating(0, l1 + l2, this.aOY, this.aOX);
  }
  
  private boolean DC() {
    long l = this.aOY;
    int i = ((WifiManager)getApplicationContext().getSystemService("wifi")).getConnectionInfo().getRssi();
    a a1 = this.aOV;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("当前 RSSI 为: ");
    stringBuilder.append(i);
    String str = stringBuilder.toString();
    boolean bool = false;
    a1.b(str, new Object[0]);
    if (i > -50) {
      this.aOY = 70000L;
    } else if (i <= -50) {
      this.aOY = 80000L;
    } 
    if (l != this.aOY)
      bool = true; 
    return bool;
  }
  
  private void Dz() { this.aOW = (AlarmManager)getSystemService("alarm"); }
  
  public static void aa(Context paramContext) { paramContext.startService(new Intent(paramContext, HeartBeatService.class)); }
  
  @Nullable
  public IBinder onBind(Intent paramIntent) { return null; }
  
  public void onCreate() {
    super.onCreate();
    this.aOV.b("开启心跳服务", new Object[0]);
    Dz();
  }
  
  public void onDestroy() {
    this.aOV.b("关闭心跳服务", new Object[0]);
    if (this.aOX != null && this.aOW != null) {
      this.aOW.cancel(this.aOX);
      this.aOX = null;
      this.aOW = null;
    } 
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    DA();
    if (DC())
      DB(); 
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\client\HeartBeatService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */