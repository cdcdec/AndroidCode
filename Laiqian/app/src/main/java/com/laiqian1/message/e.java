package com.laiqian.message;

import java.util.concurrent.TimeUnit;

public class e implements i {
  private final long bIp;
  
  private final TimeUnit bIq;
  
  private e(a parama) {
    this.bIp = a.a(parama);
    this.bIq = a.b(parama);
  }
  
  public i.a gp(String paramString) { return new f(this, paramString); }
  
  public static class a {
    private long bIp = 2L;
    
    private TimeUnit bIs = TimeUnit.SECONDS;
    
    public e To() { return new e(this, null); }
    
    public a b(long param1Long, TimeUnit param1TimeUnit) {
      this.bIp = param1Long;
      this.bIs = param1TimeUnit;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\message\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */