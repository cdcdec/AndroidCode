package com.laiqian.network;

import android.util.Log;
import com.google.a.a.a.a.a.a;
import java.util.concurrent.FutureTask;

class p implements Runnable {
  p(o paramo) {}
  
  public void run() {
    while (true) {
      try {
        null = o.Ou();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("当前等待队列:");
        stringBuilder.append(o.a(this.bUt).size());
        Log.i(null, stringBuilder.toString());
        FutureTask futureTask = (FutureTask)o.a(this.bUt).take();
        if (futureTask != null)
          o.b(this.bUt).execute(futureTask); 
        String str = o.Ou();
        stringBuilder = new StringBuilder();
        stringBuilder.append("线程池大小:");
        stringBuilder.append(o.b(this.bUt).getPoolSize());
        Log.i(str, stringBuilder.toString());
      } catch (InterruptedException interruptedException) {
        a.e(interruptedException);
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\network\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */