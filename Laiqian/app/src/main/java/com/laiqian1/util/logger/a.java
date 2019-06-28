package com.laiqian.util.logger;

public final class a {
  private k dGV = new g();
  
  public a() { awL(); }
  
  public a(String paramString) { si(paramString); }
  
  private l awL() { return si("PRETTYLOGGER"); }
  
  private l si(String paramString) {
    this.dGV = new g();
    return this.dGV.si(paramString);
  }
  
  public void b(String paramString, Object... paramVarArgs) { this.dGV.b(paramString, paramVarArgs); }
  
  public void c(String paramString, Object... paramVarArgs) { this.dGV.a(null, paramString, paramVarArgs); }
  
  public void d(String paramString, Object... paramVarArgs) { this.dGV.d(paramString, paramVarArgs); }
  
  public void e(String paramString, Object... paramVarArgs) { this.dGV.e(paramString, paramVarArgs); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqia\\util\logger\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */