package com.laiqian.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class k {
  public static <T> double a(Collection<T> paramCollection, b<T, Double> paramb) {
    Iterator iterator = paramCollection.iterator();
    double d;
    for (d = 0.0D; iterator.hasNext(); d += ((Double)paramb.aN(iterator.next())).doubleValue());
    return d;
  }
  
  @Nullable
  public static <T> T a(Collection<T> paramCollection, a<T> parama) {
    for (Object object : paramCollection) {
      if (parama.accept(object))
        return (T)object; 
    } 
    return null;
  }
  
  @Nullable
  public static <T> T a(Collection<T> paramCollection, T paramT, Comparator<T> paramComparator) {
    for (Object object : paramCollection) {
      if (paramComparator.compare(object, paramT) == 0)
        return (T)object; 
    } 
    return null;
  }
  
  public static <K, V> LinkedHashMap<K, ArrayList<V>> a(Collection<V> paramCollection, c<K, V> paramc) {
    LinkedHashMap linkedHashMap = new LinkedHashMap();
    for (Object object1 : paramCollection) {
      Object object2 = paramc.aO(object1);
      if (!linkedHashMap.containsKey(object2))
        linkedHashMap.put(object2, new ArrayList()); 
      ((ArrayList)linkedHashMap.get(object2)).add(object1);
    } 
    return linkedHashMap;
  }
  
  public static <T> void a(Collection<T> paramCollection, List<T> paramList, a<T> parama) {
    for (Object object : paramCollection) {
      if (parama.accept(object))
        paramList.add(object); 
    } 
  }
  
  @NonNull
  public static <T> ArrayList<T> b(Collection<T> paramCollection, a<T> parama) {
    ArrayList arrayList = new ArrayList();
    for (Object object : paramCollection) {
      if (parama.accept(object))
        arrayList.add(object); 
    } 
    return arrayList;
  }
  
  public static <T> List<T> b(T[] paramArrayOfT1, T[] paramArrayOfT2) {
    paramArrayOfT1 = (T[])Arrays.asList(paramArrayOfT1);
    ArrayList arrayList = new ArrayList();
    int i = paramArrayOfT2.length;
    for (byte b = 0; b < i; b++) {
      T t = paramArrayOfT2[b];
      if (!paramArrayOfT1.contains(t))
        arrayList.add(t); 
    } 
    return arrayList;
  }
  
  public static interface a<T> {
    boolean accept(T param1T);
  }
  
  public static interface b<P, R> {
    R aN(P param1P);
  }
  
  public static interface c<K, V> {
    K aO(V param1V);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */