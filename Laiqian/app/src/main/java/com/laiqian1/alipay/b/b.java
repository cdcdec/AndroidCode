package com.laiqian.alipay.b;

import android.content.Context;
import com.laiqian.alipay.a;
import com.laiqian.alipay.b;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class b extends b {
  private HashMap<String, String> aBZ;
  
  private a aCa;
  
  private Timer aCb;
  
  private Context mContext;
  
  private long time = 5000L;
  
  private String url;
  
  static  {
  
  }
  
  public static b xA() { // Byte code:
    //   0: getstatic com/laiqian/alipay/b/b.aCc : Lcom/laiqian/alipay/b/b;
    //   3: ifnonnull -> 64
    //   6: ldc com/laiqian/alipay/b/b
    //   8: monitorenter
    //   9: getstatic com/laiqian/alipay/b/b.aCc : Lcom/laiqian/alipay/b/b;
    //   12: ifnonnull -> 52
    //   15: invokestatic awP : ()Lcom/laiqian/util/logger/h;
    //   18: pop
    //   19: new com/laiqian/util/logger/d
    //   22: dup
    //   23: ldc com/laiqian/alipay/b/b
    //   25: invokevirtual getName : ()Ljava/lang/String;
    //   28: ldc 'getInstance'
    //   30: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   33: getstatic com/laiqian/util/logger/h$a.dHx : Lcom/laiqian/util/logger/h$a;
    //   36: getstatic com/laiqian/util/logger/h$b.dHz : Lcom/laiqian/util/logger/h$b;
    //   39: invokestatic a : (Lcom/laiqian/util/logger/d;Lcom/laiqian/util/logger/h$a;Lcom/laiqian/util/logger/h$b;)V
    //   42: new com/laiqian/alipay/b/b
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: putstatic com/laiqian/alipay/b/b.aCc : Lcom/laiqian/alipay/b/b;
    //   52: ldc com/laiqian/alipay/b/b
    //   54: monitorexit
    //   55: goto -> 64
    //   58: astore_0
    //   59: ldc com/laiqian/alipay/b/b
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    //   64: getstatic com/laiqian/alipay/b/b.aCc : Lcom/laiqian/alipay/b/b;
    //   67: areturn
    // Exception table:
    //   from	to	target	type
    //   9	52	58	finally
    //   52	55	58	finally
    //   59	62	58	finally }
  
  public void a(Context paramContext, HashMap<String, String> paramHashMap, a parama, String paramString) {
    this.mContext = paramContext;
    this.aBZ = paramHashMap;
    this.aCa = parama;
    this.url = paramString;
  }
  
  public void b(Context paramContext, HashMap<String, String> paramHashMap, String paramString, a parama) { a(paramContext, paramHashMap, paramString, parama); }
  
  public void start() {
    if (this.aCb == null)
      this.aCb = new Timer(); 
    a a1 = new a(this);
    this.aCb.schedule(a1, 0L, this.time);
  }
  
  public void stop() {
    if (this.aCb != null) {
      this.aCb.cancel();
      this.aCb = null;
    } 
  }
  
  class a extends TimerTask {
    a(b this$0) {}
    
    public void run() { this.aCd.b(b.a(this.aCd), b.b(this.aCd), b.c(this.aCd), b.d(this.aCd)); }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\alipay\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */