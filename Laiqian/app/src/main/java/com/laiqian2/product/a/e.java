package com.laiqian.product.a;

import com.jakewharton.b.b;
import com.laiqian.i.d;
import com.laiqian.product.models.c;
import java.util.ArrayList;

public class e {
  private final c cUk;
  
  public final b<String> cUl;
  
  public final b<Double> cUm;
  
  public final b<ArrayList<Long>> cUn;
  
  public final b<Long> cUo;
  
  public final b<Integer> cUp = (this.cUo = (this.cUn = (this.cUm = (this.cUl = b.wJ()).wJ()).wJ()).wJ()).wJ();
  
  public e(c paramc) {
    this.cUk = paramc;
    this.cUl.accept(paramc.name);
    this.cUm.accept(Double.valueOf(paramc.value));
    ArrayList arrayList = new ArrayList();
    if (paramc.cUy != null)
      for (String str : paramc.cUy.split(",")) {
        if (str.trim().length() > 0)
          arrayList.add(Long.valueOf(Long.parseLong(str))); 
      }  
    this.cUn.accept(arrayList);
    this.cUo.accept(Long.valueOf(paramc.aUH));
    this.cUp.accept(Integer.valueOf(paramc.qty));
    this.cUl.b(new f(this));
    this.cUp.b(new g(this));
    this.cUm.b(new h(this));
  }
  
  public c akn() { return this.cUk; }
  
  public void js(int paramInt) {
    if (((Integer)this.cUp.getValue()).intValue() != paramInt)
      this.cUp.accept(Integer.valueOf(paramInt)); 
  }
  
  public String toString() { return d.ac(akn()); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */