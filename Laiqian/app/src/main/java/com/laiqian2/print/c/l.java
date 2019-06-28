package com.laiqian.print.c;

import com.laiqian.print.model.e;
import java.util.Collection;
import java.util.Iterator;

public class l {
  private static l cJk;
  
  private a cJl;
  
  public static l ahn() {
    if (cJk == null)
      cJk = new l(); 
    return cJk;
  }
  
  public void a(a parama) { this.cJl = parama; }
  
  public void b(e parame) {
    if (this.cJl != null)
      this.cJl.b(parame); 
  }
  
  public void e(e parame) { parame.a(new m(this, parame)); }
  
  public void p(Collection<e> paramCollection) {
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext())
      e((e)iterator.next()); 
  }
  
  public static interface a {
    void b(e param1e);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\c\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */