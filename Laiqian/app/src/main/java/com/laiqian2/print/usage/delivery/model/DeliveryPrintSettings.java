package com.laiqian.print.usage.delivery.model;

import com.laiqian.basic.RootApplication;
import com.laiqian.infrastructure.R;
import com.laiqian.print.printtype.f;
import com.laiqian.print.usage.b;
import com.laiqian.util.by;
import java.io.Serializable;

public class DeliveryPrintSettings implements f, b, Serializable {
  private int cCC = 1;
  
  private String cMC = RootApplication.zv().getString(R.string.printer_usage_bottom_value);
  
  private int cMD = 4;
  
  @Size
  private int cME = 1;
  
  @Size
  private int cMF = 2;
  
  private int cMG = 0;
  
  private String cMH = null;
  
  private int cMI = 0;
  
  private String cMJ = null;
  
  private int delay = 1;
  
  private String title = null;
  
  private int width = 58;
  
  public static boolean iI(int paramInt) { return !(paramInt <= 10 || paramInt >= 100); }
  
  public static boolean iJ(int paramInt) { return (paramInt > 0 && paramInt <= 10); }
  
  public static boolean iK(int paramInt) { return !(paramInt != 2 && paramInt != 1); }
  
  public static boolean iL(int paramInt) { return (paramInt > 0 && paramInt <= 20); }
  
  public static boolean lT(String paramString) { return !(paramString == null); }
  
  public String aiq() { return this.cMC; }
  
  public int air() { return this.cMD; }
  
  @Size
  public int ais() { return this.cME; }
  
  @Size
  public int ait() { return this.cMF; }
  
  public int aiu() { return this.cMG; }
  
  public String aiv() { return this.cMH; }
  
  public int aiw() { return this.cMI; }
  
  public String aix() { return this.cMJ; }
  
  public int aiy() { return this.delay; }
  
  public void cX(int paramInt) { this.delay = paramInt; }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof DeliveryPrintSettings))
      return false; 
    paramObject = (DeliveryPrintSettings)paramObject;
    return (this.width != paramObject.width) ? false : ((this.cCC != paramObject.cCC) ? false : (!by.bw(this.title, paramObject.title) ? false : (!by.bw(this.cMC, paramObject.cMC) ? false : ((this.cMD != paramObject.cMD) ? false : ((this.cME != paramObject.cME) ? false : ((this.cMF != paramObject.cMF) ? false : ((this.cMG != paramObject.cMG) ? false : (!by.bw(this.cMH, paramObject.cMH) ? false : ((this.cMI != paramObject.cMI) ? false : (!!by.bw(this.cMJ, paramObject.cMJ)))))))))));
  }
  
  public int getCopies() { return this.cCC; }
  
  public String getTitle() { return this.title; }
  
  public int getWidth() { return this.width; }
  
  public void iM(int paramInt) { this.cMD = paramInt; }
  
  public void iN(int paramInt) { this.cME = paramInt; }
  
  public void iO(int paramInt) { this.cMF = paramInt; }
  
  public void iP(int paramInt) { this.cMG = paramInt; }
  
  public void iQ(int paramInt) { this.cMI = paramInt; }
  
  public void lU(String paramString) { this.cMC = paramString; }
  
  public void lV(String paramString) { this.cMH = paramString; }
  
  public void lW(String paramString) { this.cMJ = paramString; }
  
  public void setCopies(int paramInt) { this.cCC = paramInt; }
  
  public void setTitle(String paramString) { this.title = paramString; }
  
  public void setWidth(int paramInt) { this.width = paramInt; }
  
  class DeliveryPrintSettings {}
  
  class DeliveryPrintSettings {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\prin\\usage\delivery\model\DeliveryPrintSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */