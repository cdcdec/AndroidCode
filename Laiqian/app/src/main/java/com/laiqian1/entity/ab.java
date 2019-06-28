package com.laiqian.entity;

import com.google.a.a.a.a.a.a;
import java.io.Serializable;
import java.util.ArrayList;

public class ab implements Serializable, Cloneable {
  private boolean aRR;
  
  private boolean aUf;
  
  private boolean aUg;
  
  private ArrayList<f> aUh;
  
  private int aUi;
  
  public boolean GW() { return this.aUg; }
  
  public boolean GX() { return (this.aRR || this.aUf); }
  
  public ab GZ() {
    try {
      ab ab1 = (ab)super.clone();
      if (this.aUh != null)
        ab1.p((ArrayList)this.aUh.clone()); 
      return ab1;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      a.e(cloneNotSupportedException);
      return null;
    } 
  }
  
  public ArrayList<f> Ha() { return this.aUh; }
  
  public int Hb() { return this.aUi; }
  
  public void p(ArrayList<f> paramArrayList) { this.aUh = paramArrayList; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */