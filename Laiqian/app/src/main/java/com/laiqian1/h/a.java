package com.laiqian.h;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import com.alibaba.a.a.b.b;
import com.alibaba.a.a.b.c;
import com.laiqian.pos.hardware.RootUrlParameter;

public class a {
  private static final String[] aXb = { RootUrlParameter.ckV, RootUrlParameter.ckS };
  
  private static c aXc;
  
  public static c Js() { return aXc; }
  
  public static boolean ah(Context paramContext) {
    String str;
    int i = Build.VERSION.SDK_INT;
    byte b = 0;
    if (i >= 14) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i != 0) {
      String str1 = System.getProperty("http.proxyHost");
      str = System.getProperty("http.proxyPort");
      if (str == null)
        str = "-1"; 
      i = Integer.parseInt(str);
      str = str1;
    } else {
      String str1 = Proxy.getHost(str);
      i = Proxy.getPort(str);
      str = str1;
    } 
    int j = b;
    if (str != null) {
      j = b;
      if (i != -1)
        j = 1; 
    } 
    return j;
  }
  
  public static void init(Context paramContext) {
    aXc = b.e(paramContext, "105349", "ec66dc96bb248477c8d347e14604fa92");
    aXc.aT(true);
    aXc.aQ(true);
    b b = new b(paramContext);
    aXc.a(b);
    aXc.b(RootUrlParameter.clm);
    aXc.aR(true);
    aXc.aS(true);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */