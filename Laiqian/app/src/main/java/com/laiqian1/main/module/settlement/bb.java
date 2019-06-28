package com.laiqian.main.module.settlement;

import com.laiqian.main.b.c;
import io.reactivex.c.g;

class bb extends Object implements g<c> {
  bb(ag paramag) {}
  
  public void c(c paramc) throws Exception {
    if (((Double)this.bnl.beU.getValue()).doubleValue() > ((Double)this.bnl.bmz.getValue()).doubleValue()) {
      if (!((Boolean)this.bnl.bmF.getValue()).booleanValue()) {
        this.bnl.bmz.accept(this.bnl.beU.getValue());
        return;
      } 
      if (((c)this.bnl.bmT.bnn.getValue()).aTv != ((c)this.bnl.bmT.bnm.getValue()).aTv)
        this.bnl.bmz.accept(this.bnl.bmG.getValue()); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */