package com.laiqian.dcb.api.client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.laiqian.basic.RootApplication;
import com.laiqian.dcb.api.a.a;
import com.laiqian.dcb.api.b.b;
import com.laiqian.dcb.api.b.h;
import com.laiqian.ordertool.a;
import com.laiqian.util.logger.a;
import java.util.concurrent.atomic.AtomicBoolean;

public class HeartbeatReceiver extends BroadcastReceiver {
  public static final String KEY = HeartbeatReceiver.class.getCanonicalName();
  
  private static a aOV = new a(HeartbeatReceiver.class.getName());
  
  private static AtomicBoolean aOZ = new AtomicBoolean(false);
  
  private static AtomicBoolean aPa = new AtomicBoolean(false);
  
  private static int aPb;
  
  private static Handler handler;
  
  private void DD() {
    RootApplication rootApplication = RootApplication.zv();
    if (h.DI().isActive() && k.aPi == 1) {
      if (!aOZ.get()) {
        aOV.b("心跳连接测试开始: %s", new Object[] { b.b(System.currentTimeMillis(), "HH-mm-ss") });
        aOZ.set(true);
        aPa.set(false);
        aPb = 1;
        ab(rootApplication);
        ac(rootApplication);
        return;
      } 
      aOV.e("正在测试中...", new Object[0]);
      return;
    } 
    ad(rootApplication);
  }
  
  private void ab(Context paramContext) {
    if (handler == null)
      handler = new g(this, paramContext.getMainLooper(), paramContext); 
  }
  
  private void ac(Context paramContext) {
    if (aOZ.get()) {
      aOV.b("发送测试消息，次数:$d，时间：%s", new Object[] { Integer.valueOf(aPb), b.b(System.currentTimeMillis(), "HH-mm-ss") });
      a.cz(a.a(paramContext, 3000, "", -1));
      handler.sendEmptyMessageDelayed(0, 20000L);
    } 
  }
  
  private void ad(Context paramContext) {
    if (aOZ.get()) {
      aOV.e("连接断开，停止测试，消息时间：%s", new Object[] { b.b(System.currentTimeMillis(), "HH-mm-ss") });
      h.cF(String.format("##连接断开##\n连接断开，停止测试，消息时间：%s", new Object[] { b.b(System.currentTimeMillis(), "yyyy-MM-dd HH-mm-ss") }));
      aPa.set(false);
      aOZ.set(false);
      handler.removeMessages(0);
      k.aPi = 0;
      a.a(paramContext, 2001, 1004, 0, "");
    } 
  }
  
  private void onConnected() {
    if (aOZ.get()) {
      aOV.b("连接正常，消息时间：%s", new Object[] { b.b(System.currentTimeMillis(), "HH-mm-ss") });
      aPa.set(true);
      aOZ.set(false);
      handler.removeMessages(0);
    } 
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    switch (paramIntent.getIntExtra(KEY, 0)) {
      default:
        return;
      case 2:
        onConnected();
        return;
      case 1:
        DD();
        return;
      case 0:
        break;
    } 
    aOV.e("异常的入口", new Object[0]);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\client\HeartbeatReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */