package com.laiqian.cashflow.a;

import com.laiqian.ui.a.g;

public class c implements g.b {
  private long aJx;
  
  private long id;
  
  private String name;
  
  private c(a parama) {
    this.name = a.a(parama);
    this.id = a.b(parama);
    this.aJx = a.c(parama);
  }
  
  public long AL() { return this.aJx; }
  
  public long AR() { return this.id; }
  
  public CharSequence AS() { return this.name; }
  
  public CharSequence AT() { return this.name; }
  
  public long getID() { return this.id; }
  
  public String getName() { return this.name; }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("子类型名称：");
    stringBuilder.append(this.name);
    stringBuilder.append(",id为：");
    stringBuilder.append(this.id);
    return stringBuilder.toString();
  }
  
  public static class a {
    private long aJx;
    
    private long id = 0L;
    
    private String name;
    
    public a(long param1Long) { this.id = param1Long; }
    
    public c AU() { return new c(this, null); }
    
    public a K(long param1Long) {
      this.aJx = param1Long;
      return this;
    }
    
    public a bK(String param1String) {
      this.name = param1String;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */