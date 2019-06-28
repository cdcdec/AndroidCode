package com.laiqian.news;

import android.content.Context;
import com.laiqian.util.bq;
import java.util.Timer;

public class aa {
  public static aa bXo;
  
  public static String bXp = "SCAN_ORDER_RECEIVE";
  
  public static String bXq = "SCAN_ORDER_NUMS";
  
  public static String bXr = "SCAN_ORDER_NUMS_CHANGE";
  
  private Timer aCb;
  
  private y bWQ = new y();
  
  private bq bpc;
  
  private Context mContext;
  
  private long time = 5000L;
  
  static  {
  
  }
  
  public static aa Xb() {
    if (bXo == null)
      bXo = new aa(); 
    return bXo;
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
  
  public void stop() {
    if (this.aCb != null) {
      this.aCb.cancel();
      this.aCb = null;
    } 
    bXo = null;
  }
  
  class aa {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\news\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */