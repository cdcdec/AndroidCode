package com.laiqian.i;

import com.squareup.moshi.aa;
import com.squareup.moshi.af;
import com.squareup.moshi.am;
import com.squareup.moshi.ay;
import com.squareup.moshi.t;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public abstract class a<C extends Collection<T>, T> extends t<C> {
  public static final t.a aXC = new b();
  
  private final t<T> aXD;
  
  private a(t<T> paramt) { this.aXD = paramt; }
  
  static <T> t<Collection<T>> a(Type paramType, am paramam) { return new c(paramam.u(ay.e(paramType, Collection.class))); }
  
  abstract C Jw();
  
  public C a(aa paramaa) throws IOException {
    Collection collection = Jw();
    paramaa.beginArray();
    while (paramaa.hasNext())
      collection.add(this.aXD.b(paramaa)); 
    paramaa.endArray();
    return (C)collection;
  }
  
  public void a(af paramaf, C paramC) throws IOException {
    paramaf.azQ();
    paramC = (C)paramC.iterator();
    while (paramC.hasNext()) {
      Object object = paramC.next();
      this.aXD.a(paramaf, object);
    } 
    paramaf.azR();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.aXD);
    stringBuilder.append(".collection()");
    return stringBuilder.toString();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */