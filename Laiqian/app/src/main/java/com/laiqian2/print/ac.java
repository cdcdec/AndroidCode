package com.laiqian.print;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.laiqian.print.model.s;
import com.laiqian.print.printtype.j;
import com.laiqian.print.usage.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class ac implements Serializable {
  @NonNull
  private s cCV;
  
  private final Map<bm, e> cCW = new LinkedHashMap();
  
  public ac(ac paramac) {
    this.cCV = paramac.aew();
    Iterator iterator = paramac.cCW.values().iterator();
    while (iterator.hasNext()) {
      e e;
      this.cCW.put(e.ahZ(), (e = (e)iterator.next()).b(e));
    } 
  }
  
  public ac(@NonNull s params, e parame) { this(params, Collections.singleton(parame)); }
  
  public ac(@NonNull s params, Collection<e> paramCollection) {
    this.cCV = params;
    for (e e : paramCollection)
      this.cCW.put(e.ahZ(), e); 
  }
  
  public e a(bm parambm) { return (e)this.cCW.get(parambm); }
  
  public void a(e parame) { this.cCW.put(parame.ahZ(), parame); }
  
  public Collection<j> aeA() {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = this.cCW.values().iterator();
    while (iterator.hasNext())
      arrayList.addAll(((e)iterator.next()).aia()); 
    return arrayList;
  }
  
  public s aew() { return this.cCV; }
  
  public Set<bm> aex() { return Collections.unmodifiableSet(this.cCW.keySet()); }
  
  public Collection<e> aey() { return Collections.unmodifiableCollection(this.cCW.values()); }
  
  public void aez() { this.cCW.clear(); }
  
  public boolean b(bm parambm) { return this.cCW.containsKey(parambm); }
  
  public void c(s params) { this.cCV = params; }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = (ac)paramObject;
      return !this.cCV.equals(paramObject.cCV) ? false : (!!this.cCW.equals(paramObject.cCW));
    } 
    return false;
  }
  
  public int hashCode() { return this.cCV.hashCode() * 31 + this.cCW.hashCode(); }
  
  @Nullable
  public j kS(String paramString) {
    Iterator iterator = this.cCW.values().iterator();
    while (iterator.hasNext()) {
      j j = ((e)iterator.next()).lP(paramString);
      if (j != null)
        return j; 
    } 
    return null;
  }
  
  public void n(Collection<e> paramCollection) {
    Iterator iterator = paramCollection.iterator();
    while (iterator.hasNext())
      a((e)iterator.next()); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */