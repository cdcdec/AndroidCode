package com.laiqian.main.module.settlement.pay;

import android.graphics.Bitmap;

public class a {
  private d bot;
  
  private e bou;
  
  private c bov;
  
  private b bow;
  
  private a box;
  
  private boolean boy;
  
  public a OL() { return this.box; }
  
  public boolean OM() { return this.boy; }
  
  public b ON() { return this.bow; }
  
  public d OO() { return this.bot; }
  
  public e OP() { return this.bou; }
  
  public boolean OQ() { return (this.box != null || this.bow != null || this.bov != null || this.bou != null || this.bot != null || !this.boy); }
  
  public void b(long paramLong, boolean paramBoolean) { this.bot = new d(paramLong, paramBoolean); }
  
  public void dA(boolean paramBoolean) { this.boy = paramBoolean; }
  
  public void fe(String paramString) { this.box = new a(paramString); }
  
  public void ff(String paramString) { this.bow = new b(paramString); }
  
  public void fg(String paramString) { this.bov = new c(paramString); }
  
  public void p(Bitmap paramBitmap) { this.bou = new e(paramBitmap); }
  
  public static class a {
    private String boz;
    
    a(String param1String) { this.boz = param1String; }
  }
  
  public static class b {
    private String mOrderNo;
    
    b(String param1String) { this.mOrderNo = param1String; }
    
    public String xq() { return this.mOrderNo; }
  }
  
  public static class c {
    private String boA;
    
    public c(String param1String) { this.boA = param1String; }
  }
  
  public static class d {
    private long boB;
    
    private boolean boC;
    
    public d(long param1Long, boolean param1Boolean) {
      this.boB = param1Long;
      this.boC = param1Boolean;
    }
  }
  
  public static class e {
    private Bitmap boD;
    
    public e(Bitmap param1Bitmap) { this.boD = param1Bitmap; }
    
    public Bitmap OR() { return this.boD; }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\pay\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */