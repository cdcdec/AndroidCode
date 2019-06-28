package com.laiqian.ui;

import com.c.c.a;

class g implements Runnable {
  g(FloatButton paramFloatButton) {}
  
  public void run() {
    this.dvY.showPosition = a.getY(this.dvY);
    this.dvY.hidePosition = a.getY(this.dvY) + (this.dvY.getHeight() * 3);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\ui\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */