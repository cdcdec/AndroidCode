package com.laiqian.main.module.opentable;

import com.laiqian.main.dl;
import io.reactivex.c.j;

class ac extends Object implements j<dl.b, Boolean, Boolean, Boolean, Boolean> {
  ac(PosActivityOpenTableFragment paramPosActivityOpenTableFragment) {}
  
  public Boolean a(dl.b paramb, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3) throws Exception {
    boolean bool;
    if (paramBoolean1.booleanValue() && paramb == dl.b.beF && !paramBoolean2.booleanValue() && !paramBoolean3.booleanValue()) {
      bool = true;
    } else {
      bool = false;
    } 
    return Boolean.valueOf(bool);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\opentable\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */