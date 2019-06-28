package com.laiqian.message;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.laiqian.basic.RootApplication;
import com.laiqian.message.redis.a;
import io.reactivex.a.a;

public class RequestMessageService2 extends Service {
  private final a bgv = new a();
  
  @Nullable
  public IBinder onBind(Intent paramIntent) { return null; }
  
  public void onCreate() {
    super.onCreate();
    k k = RootApplication.zv().zB();
    i.a a1 = k.Tr().gp("redis message");
    k.a(a1);
    this.bgv.b(a1.Tn().b(new n(this, k, a1)));
  }
  
  public void onDestroy() {
    this.bgv.clear();
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) { return super.onStartCommand(paramIntent, paramInt1, paramInt2); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\RequestMessageService2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */