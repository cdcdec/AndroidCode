package com.laiqian.report;

import android.content.Context;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class k {
  private static long cZa = TimeUnit.SECONDS.toMillis(0L);
  
  private static long cZb = TimeUnit.SECONDS.toMillis(5L);
  
  private static long cZd = TimeUnit.HOURS.toMillis(1L);
  
  private Timer bxH = new Timer();
  
  private long cZc = 0L;
  
  private Context mContext;
  
  public k(Context paramContext) { this.mContext = paramContext; }
  
  public void a(TimerTask paramTimerTask) { this.bxH.schedule(paramTimerTask, cZa, cZb); }
  
  public void df(long paramLong) { cZb = paramLong; }
  
  public void stop() { this.bxH.cancel(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */