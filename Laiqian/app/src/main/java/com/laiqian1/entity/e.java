package com.laiqian.entity;

import java.io.Serializable;
import java.util.HashMap;

public class e implements Serializable {
  private long aRI;
  
  private String aRJ;
  
  private int aRK;
  
  private long aRL;
  
  private HashMap<String, e> aRM;
  
  public e(long paramLong1, int paramInt, long paramLong2) {
    this.aRI = paramLong1;
    this.aRK = paramInt;
    this.aRL = paramLong2;
    this.aRM = new HashMap();
  }
  
  public int EF() { return this.aRK; }
  
  public long EG() { return this.aRI; }
  
  public String EH() { return this.aRJ; }
  
  public HashMap<String, e> EI() { return this.aRM; }
  
  public e cV(String paramString) {
    this.aRJ = paramString;
    return this;
  }
  
  public void eq(int paramInt) { this.aRK = paramInt; }
  
  public e k(HashMap<String, e> paramHashMap) {
    this.aRM = paramHashMap;
    return this;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */