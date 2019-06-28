package com.laiqian.message;

import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.util.av;

public class m {
  public static void Tv() {
    if (q.gE(RequestMessageService.class.getName()))
      q.A(RequestMessageService.class); 
  }
  
  public static String Tw() {
    telephonyManager = (TelephonyManager)RootApplication.zv().getSystemService("phone");
    try {
      String str = telephonyManager.getDeviceId();
    } catch (Exception telephonyManager) {
      a.e(telephonyManager);
      telephonyManager = null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(telephonyManager);
    stringBuilder.append(",");
    stringBuilder.append(Build.SERIAL);
    return stringBuilder.toString();
  }
  
  protected static String Tx() {
    av av = new av(RootApplication.zv());
    String str = av.Tx();
    av.close();
    return str;
  }
  
  public static void V(String paramString1, String paramString2) { p.a(h.aH(RootApplication.zv())).execute(new String[] { paramString1, paramString2 }); }
  
  public static void a(a parama) { c(j.bIw.bIx, parama); }
  
  public static void b(a parama) { c(j.bIw.bIy, parama); }
  
  public static void c(a parama) { c(j.bIw.bIC, parama); }
  
  private static void c(String paramString, a parama) {
    if (parama != null)
      a.aG(RootApplication.zv()).a(paramString, parama); 
  }
  
  public static void d(a parama) { c(j.bIw.bIz, parama); }
  
  private static void d(String paramString, a parama) {
    if (parama != null)
      a.aG(RootApplication.zv()).b(paramString, parama); 
  }
  
  public static void e(a parama) { d(j.bIw.bIx, parama); }
  
  public static void f(a parama) { d(j.bIw.bIy, parama); }
  
  public static void g(a parama) { d(j.bIw.bIC, parama); }
  
  public static void gC(String paramString) { V(paramString, j.bIw.bIx); }
  
  public static void gD(String paramString) { V(paramString, j.bIw.bIC); }
  
  public static int getDeviceType() {
    int i = RootApplication.getLaiqianPreferenceManager().avL();
    return (i != 1 && i != 2) ? 1 : ((i != 1) ? 2 : ((i != 2) ? 3 : 0));
  }
  
  protected static String getPrefix(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Tx());
    stringBuilder.append("-");
    stringBuilder.append(paramString);
    stringBuilder.append("-");
    stringBuilder.append(Tw());
    stringBuilder.append("-");
    return stringBuilder.toString();
  }
  
  protected static String getVersion() { return "3"; }
  
  public static void h(a parama) { d(j.bIw.bIz, parama); }
  
  public static interface a {
    void H(String param1String1, String param1String2);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */