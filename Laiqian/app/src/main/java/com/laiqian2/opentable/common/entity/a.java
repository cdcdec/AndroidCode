package com.laiqian.opentable.common.entity;

import java.io.Serializable;

public class a implements Serializable, Cloneable {
  private String bZc;
  
  private final long id;
  
  public a(long paramLong, String paramString) {
    this.id = paramLong;
    this.bZc = paramString;
  }
  
  public String XX() { return this.bZc; }
  
  protected Object clone() throws CloneNotSupportedException { return super.clone(); }
  
  public long getId() { return this.id; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\opentable\common\entity\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */