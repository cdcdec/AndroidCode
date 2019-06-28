package com.laiqian.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public abstract class e<T> extends Object {
  a dEL;
  
  public int dEM = 1;
  
  public int dEN = 0;
  
  ScheduledThreadPoolExecutor dEO;
  
  int dEP = 2;
  
  public T dEQ;
  
  String dER;
  
  Handler handler;
  
  public e(a parama) {
    this.dEL = parama;
    this.dEO = new ScheduledThreadPoolExecutor(this.dEP);
    this.handler = new f(this, Looper.getMainLooper());
  }
  
  public e(a parama, String paramString) {
    this.dEL = parama;
    this.dER = paramString;
    this.dEO = new ScheduledThreadPoolExecutor(this.dEP);
    this.handler = new g(this, Looper.getMainLooper());
  }
  
  public abstract void a(e parame, String paramString);
  
  public void asz() {
    h h = new h(this);
    this.dEO.execute(h);
    this.dEO.shutdown();
  }
  
  public void lr(int paramInt) { this.handler.sendEmptyMessage(paramInt); }
  
  public static interface a<T> {
    void aJ(T param1T);
    
    void aK(T param1T);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */