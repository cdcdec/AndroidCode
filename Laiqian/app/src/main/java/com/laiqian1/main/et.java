package com.laiqian.main;

import com.laiqian.entity.aa;
import com.laiqian.main.module.productcart.am;
import io.reactivex.annotations.NonNull;
import io.reactivex.c.h;
import java.util.ArrayList;
import java.util.List;

class et extends Object implements h<List<am.a>, List<aa>> {
  et(dl.e parame, dl paramdl) {}
  
  public List<aa> q(@NonNull List<am.a> paramList) throws Exception {
    ArrayList arrayList = new ArrayList();
    for (am.a a : paramList) {
      if (a instanceof am.a.a)
        arrayList.add(((am.a.a)a).bjo); 
    } 
    return arrayList;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\et.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */