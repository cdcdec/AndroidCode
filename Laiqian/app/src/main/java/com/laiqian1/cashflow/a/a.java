package com.laiqian.cashflow.a;

public class a {
  private String aJV;
  
  private double aJW;
  
  private String aJX;
  
  private long aJx = 0L;
  
  private long aJy = 0L;
  
  private a(a parama) {
    this.aJx = a.a(parama);
    this.aJy = a.b(parama);
    this.aJV = a.c(parama);
    this.aJW = a.d(parama);
    this.aJX = a.e(parama);
  }
  
  public long AL() { return this.aJx; }
  
  public long AM() { return this.aJy; }
  
  public String AN() { return this.aJV; }
  
  public double AO() { return this.aJW; }
  
  public String AP() { return this.aJX; }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("typeID:");
    stringBuilder.append(this.aJx);
    stringBuilder.append(";subTypeID");
    stringBuilder.append(this.aJy);
    stringBuilder.append(";subTypename");
    stringBuilder.append(this.aJV);
    stringBuilder.append(";amount");
    stringBuilder.append(this.aJW);
    stringBuilder.append(";remark");
    stringBuilder.append(this.aJX);
    return stringBuilder.toString();
  }
  
  public static class a {
    private String aJV;
    
    private double aJW = 0.0D;
    
    private String aJX;
    
    private long aJx;
    
    private long aJy;
    
    public a AQ() { return new a(this, null); }
    
    public a I(long param1Long) {
      this.aJx = param1Long;
      return this;
    }
    
    public a J(long param1Long) {
      this.aJy = param1Long;
      return this;
    }
    
    public a bI(String param1String) {
      this.aJV = param1String;
      return this;
    }
    
    public a bJ(String param1String) {
      this.aJX = param1String;
      return this;
    }
    
    public a c(double param1Double) {
      this.aJW = param1Double;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\cashflow\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */