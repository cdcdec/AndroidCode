package com.laiqian.main;

import com.laiqian.product.models.c;
import io.reactivex.annotations.NonNull;
import io.reactivex.c.h;
import java.util.HashMap;
import java.util.List;

class eu extends Object implements h<List<c>, List<c>> {
  eu(dl.e parame, HashMap paramHashMap) {}
  
  public List<c> q(@NonNull List<c> paramList) throws Exception {
    for (c c : paramList)
      c.qty = ((Integer)this.bfg.get(Long.valueOf(c.id))).intValue(); 
    return paramList;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\eu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */