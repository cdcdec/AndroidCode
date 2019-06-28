package com.laiqian.rx.b;

import android.util.Log;
import io.reactivex.a.a;
import io.reactivex.annotations.NonNull;
import io.reactivex.c.g;
import java.util.Iterator;

class d extends Object implements g<E> {
  d(a parama, a.a parama1) {}
  
  public void accept(@NonNull E paramE) throws Exception {
    null = a.Ou();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("accept: removing disposable for removed item: ");
    stringBuilder.append(paramE);
    Log.d(null, stringBuilder.toString());
    Iterator iterator = a.a(this.dhQ).aR(Long.valueOf(this.dhP.aP(paramE))).iterator();
    while (iterator.hasNext())
      ((a)iterator.next()).clear(); 
    a.a(this.dhQ).remove(Long.valueOf(this.dhP.aP(paramE)));
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\rx\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */