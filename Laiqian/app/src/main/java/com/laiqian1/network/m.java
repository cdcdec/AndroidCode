package com.laiqian.network;

import android.content.Context;
import com.laiqian.opentable.common.b;
import java.util.Timer;

public class m {
  public static m bUm;
  
  private Timer aCb;
  
  private Context mContext;
  
  private long time = 3600000L;
  
  static  {
  
  }
  
  private m() { b.Xw(); }
  
  public static m WP() {
    if (bUm == null)
      bUm = new m(); 
    return bUm;
  }
  
  public void c(Context paramContext, long paramLong) {
    this.mContext = paramContext;
    this.time = paramLong;
  }
  
  public void start() {
    if (this.aCb == null)
      this.aCb = new Timer(); 
    a a = new a(this);
    this.aCb.schedule(a, 0L, this.time);
  }
  
  class m {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\network\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */