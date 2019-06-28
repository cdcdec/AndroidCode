package com.laiqian.print.model;

class n implements Runnable {
  n(g paramg, c paramc, s params) {}
  
  public void run() {
    boolean bool = this.cHg.connect(this.cHh);
    this.cHh.setConnected(bool);
    if (g.a(this.cHe) != null)
      g.a(this.cHe).g(this.cHh.getIdentifier(), bool); 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */