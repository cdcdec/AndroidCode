package com.laiqian.online;

import android.text.TextUtils;

public class b {
  public static b bXI;
  
  public boolean debug = false;
  
  public final String url;
  
  static  {
  
  }
  
  public b(a parama) {
    if (TextUtils.isEmpty(a.a(parama)))
      throw new IllegalArgumentException("url is not set"); 
    this.url = a.a(parama);
  }
  
  public static class a {
    private boolean debug = false;
    
    private String url;
    
    public b Xe() {
      b b = new b(this);
      b.debug = this.debug;
      return b;
    }
    
    public a ev(boolean param1Boolean) {
      this.debug = param1Boolean;
      return this;
    }
    
    public a iK(String param1String) {
      this.url = param1String;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\online\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */