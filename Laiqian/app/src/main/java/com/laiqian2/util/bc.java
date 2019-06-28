package com.laiqian.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class bc<T> extends ArrayList<T> {
  private final List<Integer> dGf = new ArrayList();
  
  public bc() {}
  
  public bc(Collection<T> paramCollection) { super(paramCollection); }
  
  public bc(Collection<T> paramCollection1, Collection<Integer> paramCollection2) {
    this(paramCollection1);
    this.dGf.addAll(paramCollection2);
  }
  
  public static <T> bc<T> b(Collection<T> paramCollection1, Collection<T> paramCollection2) {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = paramCollection1.iterator();
    for (byte b = 0; iterator.hasNext(); b++) {
      if (paramCollection2.contains(iterator.next()))
        arrayList.add(Integer.valueOf(b)); 
    } 
    return new bc(paramCollection1, arrayList);
  }
  
  public List<Integer> awm() { return Collections.unmodifiableList(this.dGf); }
  
  public List<T> awn() {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = this.dGf.iterator();
    while (iterator.hasNext())
      arrayList.add(get(((Integer)iterator.next()).intValue())); 
    return Collections.unmodifiableList(arrayList);
  }
  
  public boolean mg(int paramInt) { return this.dGf.remove(Integer.valueOf(paramInt)); }
  
  public boolean mh(int paramInt) {
    if (!this.dGf.contains(Integer.valueOf(paramInt))) {
      this.dGf.add(Integer.valueOf(paramInt));
      return true;
    } 
    return false;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */