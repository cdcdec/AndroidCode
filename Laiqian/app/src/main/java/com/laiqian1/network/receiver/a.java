package com.laiqian.network.receiver;

import android.content.Context;
import java.util.Timer;

public class a {
  public static a bVx;
  
  private Timer aCb;
  
  private Context mContext;
  
  private long time = 500L;
  
  static  {
  
  }
  
  public static a WR() {
    if (bVx == null)
      bVx = new a(); 
    return bVx;
  }
  
  public void c(Context paramContext, long paramLong) {
    this.mContext = paramContext;
    this.time = paramLong;
  }
  
  public void start() {
    if (this.aCb == null)
      this.aCb = new Timer(); 
    a a1 = new a(this);
    this.aCb.schedule(a1, 0L, this.time);
  }
  
  class a {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\network\receiver\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */