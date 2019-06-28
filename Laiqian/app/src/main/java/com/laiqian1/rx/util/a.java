package com.laiqian.rx.util;

import com.jakewharton.b.b;
import com.jakewharton.b.c;
import com.jakewharton.b.d;
import io.reactivex.c.g;
import io.reactivex.h;
import io.reactivex.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class a<E> extends d<List<E>> {
  private final d<E> dhW = c.wO();
  
  private final d<E> dhX = c.wO();
  
  private final g<E> dhY = new b(this);
  
  private final g<E> dhZ = new c(this);
  
  private final b<List<E>> dia = b.wJ();
  
  private a() {}
  
  private a(List<E> paramList) {}
  
  public static <E> a<E> R(List<E> paramList) { return new a(paramList); }
  
  public static <E> a<E> aoI() { return new a(); }
  
  public boolean add(E paramE) {
    List list2 = (List)this.dia.getValue();
    List list1 = list2;
    if (list2 == null)
      list1 = new ArrayList(); 
    boolean bool = list1.add(paramE);
    if (bool) {
      this.dia.accept(new ArrayList(list1));
      this.dhW.accept(paramE);
    } 
    return bool;
  }
  
  public h<E> aoJ() { return this.dhW; }
  
  public h<E> aoK() { return this.dhX; }
  
  public List<E> aoL() { return (List)this.dia.getValue(); }
  
  protected void b(l<? super List<E>> paraml) { this.dia.c(paraml); }
  
  public void clear() {
    List list = (List)this.dia.getValue();
    null = list;
    if (list == null)
      null = new ArrayList(); 
    list = new ArrayList(null);
    null.clear();
    this.dia.accept(new ArrayList());
    for (Object object : list)
      this.dhX.accept(object); 
  }
  
  public void r(List<E> paramList) {
    if (this.dia.getValue() != null) {
      arrayList = new ArrayList((Collection)this.dia.getValue());
    } else {
      ArrayList arrayList;
      arrayList = new ArrayList();
    } 
    this.dia.accept(paramList);
    for (Object object : arrayList) {
      if (object != null)
        this.dhX.accept(object); 
    } 
    for (Object object : paramList)
      this.dhW.accept(object); 
  }
  
  public boolean remove(E paramE) {
    List list2 = (List)this.dia.getValue();
    List list1 = list2;
    if (list2 == null)
      list1 = new ArrayList(); 
    boolean bool = list1.remove(paramE);
    if (bool) {
      this.dia.accept(new ArrayList(list1));
      this.dhX.accept(paramE);
    } 
    return bool;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\r\\util\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */