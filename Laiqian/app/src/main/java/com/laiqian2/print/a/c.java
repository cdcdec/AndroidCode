package com.laiqian.print.a;

public class c {
  public String cFc;
  
  public int state = 0;
  
  public String title;
  
  public c() {}
  
  public c(c paramc) {
    this.title = paramc.title;
    this.state = paramc.state;
    this.cFc = paramc.cFc;
  }
  
  public boolean isStopped() { return (this.state == 4 || this.state == 3 || this.state == 100); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */