package com.laiqian.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.laiqian.util.av;
import com.laiqian.util.bb;
import com.laiqian.util.z;
import java.util.concurrent.TimeUnit;

public class PushService extends Service {
  public static String bXG = "AutoMethod";
  
  private AlarmManager bXB;
  
  private PendingIntent bXC;
  
  private PendingIntent bXD;
  
  private PendingIntent bXE;
  
  private PendingIntent bXF;
  
  static  {
  
  }
  
  public static void r(Context paramContext, int paramInt) {
    Intent intent = new Intent(paramContext, PushService.class);
    intent.putExtra(bXG, paramInt);
    paramContext.startService(intent);
    bb.e("laiqiankuai_network", "the push service start");
  }
  
  public void gt(int paramInt) {
    this.bXB = (AlarmManager)getSystemService("alarm");
    av av = new av(this);
    if (av.atv() && (paramInt == 1 || paramInt == 3)) {
      bb.e("已经开启自动上传", "已经开启自动上传");
      Intent intent = new Intent(this, PushReceiver.class);
      intent.putExtra("auto_upload", true);
      if (this.bXC != null && this.bXB != null) {
        this.bXB.cancel(this.bXC);
        this.bXC = null;
      } 
      this.bXC = PendingIntent.getBroadcast(this, 0, intent, 1073741824);
      long l = av.atJ();
      l = System.currentTimeMillis() + l * 60L * 60L * 1000L;
      this.bXB.set(0, l, this.bXC);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("下一次自动上传时间:");
      stringBuilder.append(z.b(l, "yyyy-MM-dd-HH-mm-ss"));
      bb.e("自动上传时间", stringBuilder.toString());
    } 
    if (av.atw() && (paramInt == 2 || paramInt == 3)) {
      bb.e("已经开启自动备份", "已经开启自动备份");
      Intent intent = new Intent(this, PushReceiver.class);
      intent.putExtra("auto_backup", true);
      if (this.bXE != null && this.bXB != null) {
        this.bXB.cancel(this.bXE);
        this.bXE = null;
      } 
      this.bXE = PendingIntent.getBroadcast(this, 1, intent, 1073741824);
      long l = TimeUnit.HOURS.toMillis(1L);
      l = System.currentTimeMillis() + l;
      this.bXB.set(0, l, this.bXE);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("下一次自动备份时间:");
      stringBuilder.append(z.b(l, "yyyy-MM-dd-HH-mm-ss"));
      bb.e("自动备份时间", stringBuilder.toString());
    } 
    if (paramInt == 5 || paramInt == 3) {
      bb.e("已经开启微信订单数查询", "已经开启微信订单数查询");
      Intent intent = new Intent(this, PushReceiver.class);
      intent.putExtra("auto_TakeOut", true);
      if (this.bXF != null && this.bXB != null) {
        this.bXB.cancel(this.bXF);
        this.bXF = null;
      } 
      this.bXF = PendingIntent.getBroadcast(this, 2, intent, 1073741824);
      long l = av.auf();
      l = System.currentTimeMillis() + l * 1000L;
      this.bXB.set(0, l, this.bXF);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("下一次微信订单数查询时间:");
      stringBuilder.append(z.b(l, "yyyy-MM-dd-HH-mm-ss"));
      bb.e("微信订单数查询时间", stringBuilder.toString());
    } 
    av.close();
  }
  
  public IBinder onBind(Intent paramIntent) { return null; }
  
  public void onCreate() { super.onCreate(); }
  
  public void onDestroy() {
    if (this.bXC != null && this.bXB != null) {
      this.bXB.cancel(this.bXC);
      this.bXC = null;
    } 
    if (this.bXF != null && this.bXB != null) {
      this.bXB.cancel(this.bXF);
      this.bXF = null;
    } 
    if (this.bXE != null && this.bXB != null) {
      this.bXB.cancel(this.bXE);
      this.bXE = null;
    } 
    if (this.bXD != null && this.bXB != null) {
      this.bXB.cancel(this.bXD);
      this.bXD = null;
    } 
    if (this.bXB != null)
      this.bXB = null; 
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt) {
    int i = 3;
    try {
      int j = paramIntent.getIntExtra(bXG, 3);
      i = j;
    } catch (Exception exception) {}
    gt(i);
    super.onStart(paramIntent, paramInt);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\notification\PushService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */