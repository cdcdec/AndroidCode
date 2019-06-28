package com.laiqian.main.module.productcart;

import android.view.KeyEvent;
import com.laiqian.entity.aa;
import io.reactivex.c.g;

class w extends Object implements g<KeyEvent> {
  w(PosActivityProductCartFragment paramPosActivityProductCartFragment) {}
  
  public void d(KeyEvent paramKeyEvent) throws Exception {
    if (paramKeyEvent.getAction() != 0)
      return; 
    aa aa = this.bje.bfr.bea.Me();
    switch (paramKeyEvent.getKeyCode()) {
      default:
        return;
      case 132:
        if (aa != null) {
          PosActivityProductCartFragment.a(this.bje, aa, ((Integer)this.bje.bfr.bea.beW.getValue()).intValue(), 2);
          return;
        } 
        return;
      case 131:
        break;
    } 
    if (aa != null)
      PosActivityProductCartFragment.a(this.bje, aa, ((Integer)this.bje.bfr.bea.beW.getValue()).intValue(), 1); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\productcart\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */