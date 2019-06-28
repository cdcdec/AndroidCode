package com.laiqian.report.models;

import com.laiqian.entity.v;

public class t {
  private String aEO;
  
  private String bci;
  
  private long[] cPh = new long[0];
  
  private long cZw;
  
  private long dbs;
  
  private v dbt;
  
  private String dbu;
  
  private String dbv;
  
  private int dbw;
  
  private int dbx;
  
  private final long end;
  
  private final long start;
  
  public t(long paramLong1, long paramLong2) {
    this.start = paramLong1;
    this.end = paramLong2;
  }
  
  public int anc() { return this.dbw; }
  
  public int and() { return this.dbx; }
  
  public long ane() { return this.start; }
  
  public long anf() { return this.end; }
  
  public long ang() { return this.cZw; }
  
  public long[] anh() { return this.cPh; }
  
  public String ani() { return this.dbu; }
  
  public String anj() { return this.bci; }
  
  public v ank() { return this.dbt; }
  
  public String yq() { return this.aEO; }
  
  public static class a {
    private String aEO;
    
    private String bci;
    
    private long[] cPh = new long[0];
    
    private long cZw;
    
    private long dbs;
    
    private v dbt;
    
    private String dbu;
    
    private String dbv;
    
    private int dbw;
    
    private int dbx;
    
    private final long end;
    
    private final long start;
    
    public a(long param1Long1, long param1Long2) {
      this.start = param1Long1;
      this.end = param1Long2;
    }
    
    public t anl() {
      t t = new t(this.start, this.end);
      e(t);
      return t;
    }
    
    public a d(v param1v) {
      this.dbt = param1v;
      return this;
    }
    
    public a dh(long param1Long) {
      this.cZw = param1Long;
      return this;
    }
    
    void e(t param1t) {
      t.a(param1t, this.cZw);
      t.a(param1t, this.cPh);
      t.a(param1t, this.dbt);
      t.a(param1t, this.dbu);
      t.b(param1t, this.bci);
      t.c(param1t, this.dbv);
      t.d(param1t, this.aEO);
      t.b(param1t, this.dbs);
      t.a(param1t, this.dbx);
      t.b(param1t, this.dbw);
    }
    
    public a jJ(int param1Int) {
      this.dbx = param1Int;
      return this;
    }
    
    public a jK(int param1Int) {
      this.dbw = param1Int;
      return this;
    }
    
    public a k(long[] param1ArrayOfLong) {
      this.cPh = param1ArrayOfLong;
      return this;
    }
    
    public a nn(String param1String) {
      this.dbu = param1String;
      return this;
    }
    
    public a no(String param1String) {
      this.bci = param1String;
      return this;
    }
    
    public a np(String param1String) {
      this.aEO = param1String;
      return this;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */