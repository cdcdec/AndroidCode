package com.laiqian.dcb.api.client;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class g extends Handler {
  g(HeartbeatReceiver paramHeartbeatReceiver, Looper paramLooper) { super(paramLooper); }
  
  public void handleMessage(Message paramMessage) {
    if (HeartbeatReceiver.DE().get() && HeartbeatReceiver.DF() <= 3) {
      HeartbeatReceiver.DG();
      if (HeartbeatReceiver.DH().get()) {
        HeartbeatReceiver.a(this.aPc);
        return;
      } 
      if (HeartbeatReceiver.DF() <= 3) {
        HeartbeatReceiver.a(this.aPc, context);
        return;
      } 
      HeartbeatReceiver.b(this.aPc, context);
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\client\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */