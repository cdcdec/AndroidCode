package com.laiqian.dcb.api.client;

import android.support.annotation.NonNull;
import com.laiqian.basic.RootApplication;
import com.laiqian.dcb.api.a.a;
import com.laiqian.dcb.api.b.g;
import com.laiqian.dcb.api.b.j;
import com.laiqian.dcb.api.client.c.a;
import hugo.weaving.DebugLog;
import io.netty.channel.n;
import io.reactivex.g.a;

public class h {
  private a aOR;
  
  public n aPd;
  
  public static h DI() { return a.DK(); }
  
  public static void DJ() {
    g g = new g(RootApplication.zv());
    String str = g.oC();
    if (str != null) {
      e(str, j.Y(g.Eb()));
      return;
    } 
    k.aPi = 0;
    a.a(RootApplication.zv().getApplicationContext(), new int[] { 2001, 2004 }, 1005, 0, "");
  }
  
  private static void connect(String paramString, int paramInt) {
    i i = new i(paramString, paramInt);
    a.aKh().r(i);
  }
  
  @DebugLog
  public static void e(@NonNull String paramString, int paramInt) {
    if ((DI()).aPd != null && (DI()).aPd.isActive()) {
      (DI()).aOR.aPo = true;
      (DI()).aPd.Zb();
    } 
    (DI()).aOR = new a(RootApplication.zv().getApplicationContext());
    connect(paramString, paramInt);
  }
  
  public static boolean isActive() {
    if ((DI()).aPd != null) {
      n n1 = (DI()).aPd;
      if (n1 != null && n1.isActive())
        return true; 
    } 
    return false;
  }
  
  private static class a {
    private static final h aPh = new h();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\dcb\api\client\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */