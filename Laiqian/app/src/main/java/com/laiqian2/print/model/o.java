package com.laiqian.print.model;

class o implements Runnable {
  o(g paramg, e parame, c paramc) {}
  
  public void run() {
    this.bYk.onStart();
    boolean bool = this.cHg.connect(this.bYk.aew());
    this.bYk.aew().setConnected(bool);
    if (bool) {
      this.bYk.xx();
      return;
    } 
    this.bYk.afv();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */