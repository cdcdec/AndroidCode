package com.laiqian.opentable;

import android.content.Context;
import android.support.annotation.Nullable;
import com.laiqian.print.ad;
import com.laiqian.print.c;
import com.laiqian.print.h;
import com.laiqian.print.j;
import com.laiqian.print.k;
import com.laiqian.print.printtype.p;
import com.laiqian.util.k;

public class h implements j.h {
  private final Context context;
  
  public h(Context paramContext) { this.context = paramContext; }
  
  public boolean a(Class paramClass, String paramString) {
    l l = new l(this);
    return (paramClass.isAssignableFrom(b.class) && k.a(l, new i(paramString)) != null);
  }
  
  @Nullable
  public j.h.a b(Class paramClass, String paramString) { return p.cJH.contains(paramString) ? k.aer() : null; }
  
  public j.f yA() { return new k(this); }
  
  public j.k yB() { return new c(new j.k[] { ad.kU("receipt_not_specified"), ad.kU("kitchen_not_specified") }); }
  
  public j.b yy() { return new j(this); }
  
  public j.a yz() { return h.aY(this.context); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\opentable\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */