package com.laiqian.product.models;

import com.laiqian.d.a;
import com.laiqian.ui.a.g;
import com.laiqian.util.by;
import java.io.Serializable;

public class o implements g.b, Serializable, Cloneable {
  private String cVn;
  
  private double cVo;
  
  private int cVp;
  
  private int cVq;
  
  private int cVr;
  
  public boolean cVs;
  
  private long id;
  
  public o(long paramLong, String paramString, double paramDouble, int paramInt) { this(paramLong, paramString, paramDouble, 0, paramInt, 0); }
  
  public o(long paramLong, String paramString, double paramDouble, int paramInt1, int paramInt2, int paramInt3) {
    this.id = paramLong;
    this.cVn = paramString;
    this.cVo = paramDouble;
    this.cVp = paramInt1;
    this.cVq = paramInt2;
    this.cVr = paramInt3;
  }
  
  public long AR() { return this.id; }
  
  public CharSequence AS() { return this.cVn; }
  
  public CharSequence AT() { return this.cVn; }
  
  public String akZ() { return this.cVn; }
  
  public double ala() { return this.cVo; }
  
  public boolean alb() { return (this.cVq == 0); }
  
  public int alc() { return this.cVp; }
  
  public int ald() { return this.cVr; }
  
  protected o ale() throws CloneNotSupportedException { return (o)super.clone(); }
  
  public long getId() { return this.id; }
  
  public boolean mM(String paramString) {
    String str = a.AZ().BX();
    return by.isNull(str) ? false : str.contains(paramString);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\product\models\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */