package com.laiqian.util;

import android.content.Context;
import android.speech.tts.TextToSpeech;

public class cc {
  private static Context context;
  
  private TextToSpeech dGD;
  
  private boolean dGE;
  
  private cc(Context paramContext) {
    context = paramContext;
    this.dGD = new TextToSpeech(paramContext, new cd(this));
  }
  
  public static cc ca(Context paramContext) { // Byte code:
    //   0: getstatic com/laiqian/util/cc.dGC : Lcom/laiqian/util/cc;
    //   3: ifnonnull -> 41
    //   6: ldc com/laiqian/util/cc
    //   8: monitorenter
    //   9: getstatic com/laiqian/util/cc.dGC : Lcom/laiqian/util/cc;
    //   12: ifnonnull -> 29
    //   15: new com/laiqian/util/cc
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   23: invokespecial <init> : (Landroid/content/Context;)V
    //   26: putstatic com/laiqian/util/cc.dGC : Lcom/laiqian/util/cc;
    //   29: ldc com/laiqian/util/cc
    //   31: monitorexit
    //   32: goto -> 41
    //   35: astore_0
    //   36: ldc com/laiqian/util/cc
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    //   41: getstatic com/laiqian/util/cc.dGC : Lcom/laiqian/util/cc;
    //   44: areturn
    // Exception table:
    //   from	to	target	type
    //   9	29	35	finally
    //   29	32	35	finally
    //   36	39	35	finally }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */