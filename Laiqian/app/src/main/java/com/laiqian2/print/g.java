package com.laiqian.print;

import com.laiqian.util.bd;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class g {
  LinkedHashSet<Long> cCt;
  
  Iterator<Long> cCu;
  
  public g(LinkedHashSet<Long> paramLinkedHashSet) {
    this.cCt = paramLinkedHashSet;
    this.cCu = paramLinkedHashSet.iterator();
  }
  
  public Long aen() {
    while (this.cCu.hasNext()) {
      Long long = (Long)this.cCu.next();
      if (!bd.F(bd.cC(long.longValue()), 10))
        return long; 
    } 
    return null;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */