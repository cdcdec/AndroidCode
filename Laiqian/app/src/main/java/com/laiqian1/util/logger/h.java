package com.laiqian.util.logger;

import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.av;
import io.reactivex.g.a;
import java.util.Map;

public class h {
  private static final String TAG = "h";
  
  private static h dHr;
  
  static  {
  
  }
  
  public static void L(String paramString1, String paramString2, String paramString3) { b(paramString1, paramString2, paramString3, false); }
  
  public static void a(d paramd, a parama, b paramb) { L(paramd.toString(), parama.getValue(), paramb.getValue()); }
  
  public static void a(d paramd, a parama, b paramb, String paramString) {
    if (RootApplication.getLaiqianPreferenceManager().awc())
      a.aKh().r(new i(paramd, parama, paramString, paramb)); 
  }
  
  public static h awP() { // Byte code:
    //   0: getstatic com/laiqian/util/logger/h.dHr : Lcom/laiqian/util/logger/h;
    //   3: ifnonnull -> 37
    //   6: ldc com/laiqian/util/logger/h
    //   8: monitorenter
    //   9: getstatic com/laiqian/util/logger/h.dHr : Lcom/laiqian/util/logger/h;
    //   12: ifnonnull -> 25
    //   15: new com/laiqian/util/logger/h
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/laiqian/util/logger/h.dHr : Lcom/laiqian/util/logger/h;
    //   25: ldc com/laiqian/util/logger/h
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/laiqian/util/logger/h
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/laiqian/util/logger/h.dHr : Lcom/laiqian/util/logger/h;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally }
  
  public static void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    if (paramBoolean || RootApplication.getLaiqianPreferenceManager().awc())
      a.aKh().r(new j(paramString1, paramString2, paramString3)); 
  }
  
  public static void bD(String paramString1, String paramString2) { b(paramString1, "", paramString2, false); }
  
  public static void h(String paramString1, String paramString2, boolean paramBoolean) { b(paramString1, "", paramString2, paramBoolean); }
  
  class h {}
  
  class h {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqia\\util\logger\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */