package com.laiqian.network;

import com.google.a.a.a.a.a.a;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class o {
  private static final String TAG = "o";
  
  private static o bUp = new o();
  
  private LinkedBlockingDeque<Future<?>> bUq = new LinkedBlockingDeque();
  
  private ThreadPoolExecutor bUr = new ThreadPoolExecutor(8, 16, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue(4), new a(this));
  
  private Runnable bUs = new p(this);
  
  private o() { this.bUr.execute(this.bUs); }
  
  public static o WQ() { return bUp; }
  
  public <T> void a(FutureTask<T> paramFutureTask) throws InterruptedException { this.bUq.put(paramFutureTask); }
  
  class a implements RejectedExecutionHandler {
    a(o this$0) {}
    
    public void rejectedExecution(Runnable param1Runnable, ThreadPoolExecutor param1ThreadPoolExecutor) {
      try {
        o.a(this.bUt).put(new q(this, param1Runnable, null));
        return;
      } catch (InterruptedException param1Runnable) {
        a.e(param1Runnable);
        return;
      } 
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */