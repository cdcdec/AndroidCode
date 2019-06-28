package com.laiqian.util;

import android.support.annotation.AnyThread;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.LQKVersion;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.logger.AliLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class b {
  private static String dEv;
  
  private static String dEw;
  
  private static ExecutorService dEx;
  
  private static Map<AliLog.b, AliLog> dEy;
  
  public static AliLog a(AliLog.b paramb) {
    if (dEy == null)
      dEy = new HashMap(); 
    AliLog aliLog = (AliLog)dEy.get(paramb);
    if (aliLog == null)
      try {
        return (new AliLog.a()).awM().b(paramb).awN();
      } catch (Exception paramb) {
        a.e(paramb);
      }  
    return aliLog;
  }
  
  public static Map<String, String> a(AliLog paramAliLog, int paramInt, String paramString1, String paramString2) {
    byte b1;
    if (LQKVersion.zg()) {
      b1 = 2;
    } else {
      b1 = 3;
    } 
    return paramAliLog.a(b1, paramInt, dEv, dEw, paramString1, paramString2);
  }
  
  public static void a(AliLog.b paramb, a parama, String paramString) {
    AliLog aliLog = a(paramb);
    a(parama.value, aliLog, a(aliLog, 1, paramString, ""));
  }
  
  public static void a(AliLog.b paramb, a parama, String paramString1, String paramString2) {
    AliLog aliLog = a(paramb);
    a(parama.value, aliLog, a(aliLog, 1, paramString1, paramString2));
  }
  
  @AnyThread
  public static void a(String paramString, AliLog paramAliLog, Map<String, String> paramMap) {
    if (dEx == null)
      dEx = Executors.newCachedThreadPool(); 
    c c = new c(paramAliLog, paramString, Collections.unmodifiableMap(new HashMap(paramMap)));
    dEx.submit(c);
  }
  
  public static void b(AliLog.b paramb, a parama, String paramString) {
    AliLog aliLog = a(paramb);
    a(parama.value, aliLog, a(aliLog, 3, paramString, ""));
  }
  
  public static void c(AliLog.b paramb, a parama, String paramString) {
    AliLog aliLog = a(paramb);
    a(parama.value, aliLog, a(aliLog, 0, paramString, ""));
  }
  
  public static void init() {
    av av = new av(RootApplication.zv());
    dEv = av.Tx();
    dEw = av.Ea();
    av.close();
  }
  
  public enum a {
    dEC("Pos - On Submit"),
    dED("Smart Order - Local Connection"),
    dEE("Smart Order - Login"),
    dEF("pos - crash"),
    dEG("OpenTable - submit"),
    dEH("abnormal - log"),
    dEI("pos - product merge"),
    dEJ("Block Canary");
    
    public final String value;
    
    a(String param1String1) { this.value = param1String1; }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */