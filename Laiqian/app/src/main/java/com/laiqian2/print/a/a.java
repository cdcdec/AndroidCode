package com.laiqian.print.a;

public abstract class a {
  c cET = new c();
  
  StringBuilder cEU = new StringBuilder();
  
  private a cEV;
  
  public a(String paramString) {
    this.cET.title = paramString;
    this.cET.state = 1;
  }
  
  private void afw() {
    if (this.cEV != null)
      this.cEV.a(aft()); 
  }
  
  public void a(a parama) { this.cEV = parama; }
  
  public c aft() {
    this.cET.cFc = this.cEU.toString();
    return new c(this.cET);
  }
  
  protected void afu() {
    this.cET.state = 4;
    afw();
  }
  
  protected void afv() {
    this.cET.state = 3;
    afw();
  }
  
  protected void la(String paramString) {
    StringBuilder stringBuilder1 = this.cEU;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramString);
    stringBuilder2.append("\n");
    stringBuilder1.append(stringBuilder2.toString());
  }
  
  protected void onError() {
    this.cET.state = 100;
    afw();
  }
  
  protected void onStart() {
    this.cET.state = 2;
    afw();
  }
  
  public abstract void run();
  
  public static interface a {
    void a(c param1c);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */