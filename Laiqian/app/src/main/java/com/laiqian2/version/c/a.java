package com.laiqian.version.c;

import android.support.annotation.Nullable;
import com.laiqian.basic.RootApplication;
import com.laiqian.f.b;
import com.laiqian.i.d;
import com.laiqian.network.b;
import com.laiqian.network.g;
import com.laiqian.network.h;
import com.laiqian.network.n;
import com.laiqian.pos.hardware.RootUrlParameter;
import com.laiqian.util.n;
import com.laiqian.version.a.a.a;
import com.laiqian.version.a.b.b;
import com.laiqian.version.a.c.b;
import com.laiqian.version.a.d.a;
import com.laiqian.version.a.e.a;
import com.laiqian.version.a.f.c;
import retrofit2.d;

public class a {
  public <T> void a(@Nullable T paramT, @Nullable String paramString, d<h> paramd) {
    String str1 = d.ac(paramT);
    paramT = (T)(b)n.bUo.af(b.class);
    g g = new g(str1);
    String str2 = String.valueOf(System.currentTimeMillis() / 1000L);
    String str3 = b.c(n.parseLong(str2), n.parseInt(RootApplication.getLaiqianPreferenceManager().Tx()));
    paramT.a(paramString, g, RootApplication.getLaiqianPreferenceManager().Tx(), str2, str3).a(paramd);
  }
  
  public void a(d<h> paramd, String paramString) { a(new a(paramString), RootUrlParameter.clj, paramd); }
  
  public void a(d<h> paramd, String paramString1, String paramString2) { a(new a(paramString1, paramString2), RootUrlParameter.cli, paramd); }
  
  public void a(d<h> paramd, String paramString1, String paramString2, String paramString3) { a(new a(paramString3, paramString1, paramString2), RootUrlParameter.clh, paramd); }
  
  public void b(d<h> paramd, String paramString1, String paramString2) { a(new c(paramString1, paramString2), RootUrlParameter.cle, paramd); }
  
  public void b(d<h> paramd, String paramString1, String paramString2, String paramString3) { a(new b(paramString3, paramString1, paramString2), RootUrlParameter.clg, paramd); }
  
  public void c(d<h> paramd, String paramString1, String paramString2) { a(new b(paramString2, paramString1), RootUrlParameter.clf, paramd); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\version\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */