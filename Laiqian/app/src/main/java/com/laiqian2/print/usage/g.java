package com.laiqian.print.usage;

import com.laiqian.print.bm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class g {
  public static e.c aic() {
    e.c c = new e.c();
    c.u("settle_receipt", 1);
    c.u("pre", 1);
    c.u("dish", 1);
    c.u("shift", 1);
    c.u("takeout", 1);
    return c;
  }
  
  public static e.b aid() {
    e.b b = new e.b();
    b.u("kitchen_port", 0);
    b.u("kitchen_total", 1);
    return b;
  }
  
  public static e.d aie() {
    e.d d = new e.d();
    d.u("tag_not_specified", 1);
    return d;
  }
  
  public static e.a aif() {
    e.a a = new e.a();
    a.u("delivery_not_specified", 1);
    return a;
  }
  
  public static e h(bm parambm) {
    StringBuilder stringBuilder;
    switch (h.bgg[parambm.ordinal()]) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("no such usage ");
        stringBuilder.append(parambm);
        throw new IllegalArgumentException(stringBuilder.toString());
      case 4:
        return aif();
      case 3:
        return aid();
      case 2:
        return aie();
      case 1:
        break;
    } 
    return aic();
  }
  
  public static Collection<e> v(Collection<bm> paramCollection) {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext())
      arrayList.add(h((bm)iterator.next())); 
    return arrayList;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */