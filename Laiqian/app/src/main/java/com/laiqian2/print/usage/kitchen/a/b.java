package com.laiqian.print.usage.kitchen.a;

import android.content.Context;
import com.laiqian.print.model.g;
import com.laiqian.print.usage.c;
import com.laiqian.print.usage.d;

public final class b {
  private static b cNe;
  
  private g cDD;
  
  private c cDE;
  
  private Context mContext;
  
  static  {
  
  }
  
  private b(Context paramContext) {
    this.mContext = paramContext;
    this.cDD = g.cGS;
    this.cDE = c.bi(this.mContext);
  }
  
  public static b bn(Context paramContext) { // Byte code:
    //   0: getstatic com/laiqian/print/usage/kitchen/a/b.cNe : Lcom/laiqian/print/usage/kitchen/a/b;
    //   3: ifnonnull -> 41
    //   6: ldc com/laiqian/print/usage/kitchen/a/b
    //   8: monitorenter
    //   9: getstatic com/laiqian/print/usage/kitchen/a/b.cNe : Lcom/laiqian/print/usage/kitchen/a/b;
    //   12: ifnonnull -> 29
    //   15: new com/laiqian/print/usage/kitchen/a/b
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   23: invokespecial <init> : (Landroid/content/Context;)V
    //   26: putstatic com/laiqian/print/usage/kitchen/a/b.cNe : Lcom/laiqian/print/usage/kitchen/a/b;
    //   29: ldc com/laiqian/print/usage/kitchen/a/b
    //   31: monitorexit
    //   32: goto -> 41
    //   35: astore_0
    //   36: ldc com/laiqian/print/usage/kitchen/a/b
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    //   41: getstatic com/laiqian/print/usage/kitchen/a/b.cNe : Lcom/laiqian/print/usage/kitchen/a/b;
    //   44: areturn
    // Exception table:
    //   from	to	target	type
    //   9	29	35	finally
    //   29	32	35	finally
    //   36	39	35	finally }
  
  public c aiC() { return d.bj(this.mContext).aeg(); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\kitchen\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */