package com.laiqian.print.printtype;

import android.util.Pair;
import com.laiqian.print.ac;
import com.laiqian.print.j;

class h implements j.k {
  h(g paramg) {}
  
  public boolean a(ac paramac, Class paramClass, String paramString) {
    Pair pair = new Pair(paramClass, paramString);
    return g.a(this.cJq).containsKey(pair) ? ((j.k)g.a(this.cJq).get(pair)).a(paramac, paramClass, paramString) : 0;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\printtype\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */