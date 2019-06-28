package com.laiqian.pos.hardware;

import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import com.laiqian.util.bg;
import com.laiqian.util.by;

public class c {
  private int baudrate = 2400;
  
  private Pair<Integer, Integer> ckk = null;
  
  private String ckl = null;
  
  boolean enabled = false;
  
  private int type = 2;
  
  public c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
    this.enabled = paramBoolean;
    this.ckk = new Pair(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.baudrate = paramInt3;
  }
  
  public c(boolean paramBoolean, String paramString, int paramInt) {
    this.enabled = paramBoolean;
    this.ckl = paramString;
    this.baudrate = paramInt;
  }
  
  public void a(Pair<Integer, Integer> paramPair) { this.ckk = paramPair; }
  
  @Nullable
  public Pair<Integer, Integer> aap() { return this.ckk; }
  
  public String aaq() { return this.ckl; }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof c))
      return false; 
    paramObject = (c)paramObject;
    return (paramObject.type != this.type) ? false : ((paramObject.enabled != this.enabled) ? false : (!by.bw(paramObject.ckl, this.ckl) ? false : (!!bg.equals(paramObject.ckk, this.ckk))));
  }
  
  public int getBaudrate() { return this.baudrate; }
  
  public int getType() { return this.type; }
  
  public boolean isEnabled() { return this.enabled; }
  
  public void jB(String paramString) { this.ckl = paramString; }
  
  public void setBaudrate(int paramInt) { this.baudrate = paramInt; }
  
  public void setEnabled(boolean paramBoolean) { this.enabled = paramBoolean; }
  
  public void setType(int paramInt) { this.type = paramInt; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hardware\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */