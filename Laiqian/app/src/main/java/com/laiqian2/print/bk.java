package com.laiqian.print;

import com.laiqian.print.model.g;
import com.laiqian.print.model.s;

class bk implements Runnable {
  bk(be parambe) {}
  
  public void run() {
    be.c(this.cDX).aem();
    if (be.g(this.cDX) != null)
      for (ac ac : be.g(this.cDX)) {
        s s = ac.aew();
        if (s.getType() == 1)
          s.setConnected(be.h(this.cDX).isConnected(s)); 
        be.c(this.cDX).a(g.cGS.f(s), ac.aex());
      }  
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */