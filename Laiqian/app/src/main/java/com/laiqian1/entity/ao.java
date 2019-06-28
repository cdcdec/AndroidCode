package com.laiqian.entity;

import com.laiqian.product.a.a;
import com.laiqian.product.models.a;
import com.laiqian.product.models.h;

public class ao extends aa {
  private String aWh;
  
  private String aWi;
  
  private String aWj;
  
  private String aWk;
  
  private String aWl = "";
  
  private a aWm;
  
  private long id;
  
  public ao(h paramh, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, a parama) {
    super(paramh, parama);
    this.aWi = paramString1;
    this.aWj = paramString2;
    this.aWh = paramString3;
    this.id = paramLong;
    this.aWk = paramString4;
    if (paramh instanceof a)
      this.aWm = (a)paramh; 
  }
  
  public String IQ() { return this.aWh; }
  
  public String IR() { return this.aWi; }
  
  public String IS() { return this.aWk; }
  
  public String IT() { return this.aWl; }
  
  public a IU() { return this.aWm; }
  
  public void dx(String paramString) { this.aWl = paramString; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\entity\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */