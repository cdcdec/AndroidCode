package com.laiqian.product.a;

import com.laiqian.b.a.a;
import com.laiqian.product.models.c;
import com.laiqian.product.models.f;
import com.laiqian.util.by;
import com.laiqian.util.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class b extends a<b.a, b.b> {
  f cQh;
  
  public b(f paramf) { this.cQh = paramf; }
  
  public b a(a parama) {
    ArrayList arrayList = new ArrayList();
    if (parama instanceof a.a) {
      arrayList.addAll(this.cQh.z(a.a.a((a.a)parama)));
    } else {
      if (parama instanceof a.b) {
        ArrayList arrayList1;
        a.b b1 = (a.b)parama;
        if (b1.cUf.size() > 0) {
          arrayList1 = this.cQh.mB(by.a(",", b1.cUf));
        } else {
          arrayList1 = this.cQh.akz();
        } 
        if (b1.cUg.size() > 0) {
          arrayList.addAll(k.b(arrayList1, new c(this, parama)));
        } else {
          arrayList.addAll(arrayList1);
        } 
        return new b(arrayList);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("not supported type of request");
      stringBuilder.append(parama.getClass().getName());
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    return new b(arrayList);
  }
  
  public static abstract class a implements a.a {
    public static a a(Collection<Long> param1Collection1, Collection<Long> param1Collection2) { return new b(param1Collection1, param1Collection2); }
    
    public static a akl() { return new b(Collections.emptyList(), Collections.emptyList()); }
    
    public static a w(Collection<Long> param1Collection) { return new b(param1Collection, Collections.emptyList()); }
    
    public static a x(Collection<Long> param1Collection) { return new b(Collections.emptyList(), param1Collection); }
    
    public static a y(Collection<Long> param1Collection) { return new a(param1Collection); }
    
    static class a extends a {
      private final Collection<Long> cUe;
      
      a(Collection<Long> param2Collection) { this.cUe = Collections.unmodifiableCollection(param2Collection); }
    }
    
    static class b extends a {
      final Collection<Long> cUf = new ArrayList();
      
      final Collection<Long> cUg = new ArrayList();
      
      b(Collection<Long> param2Collection1, Collection<Long> param2Collection2) {
        this.cUf.addAll(param2Collection1);
        this.cUg.addAll(param2Collection2);
      }
    }
  }
  
  static class a extends a {
    private final Collection<Long> cUe;
    
    a(Collection<Long> param1Collection) { this.cUe = Collections.unmodifiableCollection(param1Collection); }
  }
  
  static class b extends a {
    final Collection<Long> cUf = new ArrayList();
    
    final Collection<Long> cUg = new ArrayList();
    
    b(Collection<Long> param1Collection1, Collection<Long> param1Collection2) {
      this.cUf.addAll(param1Collection1);
      this.cUg.addAll(param1Collection2);
    }
  }
  
  public static class b implements a.b {
    private List<c> cUh;
    
    public b(List<c> param1List) { this.cUh = param1List; }
    
    public List<c> getAttributes() { return this.cUh; }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */