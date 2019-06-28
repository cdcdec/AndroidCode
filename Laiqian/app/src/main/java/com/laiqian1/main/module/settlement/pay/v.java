package com.laiqian.main.module.settlement.pay;

import com.laiqian.auth.au;

public class v {
  public static final v boY = new v("-1", au.aEu, true);
  
  private String aEY;
  
  private au boW;
  
  private boolean boX;
  
  public v() {}
  
  public v(String paramString, au paramau, boolean paramBoolean) {
    this.aEY = paramString;
    this.boW = paramau;
    this.boX = paramBoolean;
  }
  
  public static boolean a(v paramv) { return (paramv == null) ? true : au.a(paramv.boW); }
  
  public static boolean b(v paramv1, v paramv2) {
    boolean bool = a(paramv1);
    boolean bool1 = false;
    if (bool && !a(paramv2))
      return false; 
    if (!a(paramv1) && a(paramv2))
      return false; 
    if (a(paramv1) && a(paramv2))
      return true; 
    bool = bool1;
    if (paramv1.aEY.equals(paramv2.aEY)) {
      bool = bool1;
      if (paramv1.boW.aEs == paramv2.boW.aEs) {
        bool = bool1;
        if (paramv1.boX == paramv2.boX)
          bool = true; 
      } 
    } 
    return bool;
  }
  
  public String Pb() { return this.aEY; }
  
  public au Pc() { return this.boW; }
  
  public boolean Pd() { return this.boX; }
  
  public void dB(boolean paramBoolean) { this.boX = paramBoolean; }
  
  public void fh(String paramString) { this.aEY = paramString; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\pay\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */