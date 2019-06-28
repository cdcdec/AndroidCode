package com.laiqian.print.model.type.usb;

import com.laiqian.print.model.s;
import java.io.Serializable;

public class g extends s implements Serializable {
  private String YH;
  
  private int arQ;
  
  private int arR;
  
  private boolean cIt;
  
  private boolean cIu = false;
  
  public g(int paramInt1, int paramInt2, String paramString) {
    super(stringBuilder.toString(), 1);
    this.arQ = paramInt1;
    this.arR = paramInt2;
    this.YH = paramString;
  }
  
  public boolean agW() { return this.cIu; }
  
  public void fS(boolean paramBoolean) { this.cIt = paramBoolean; }
  
  public void fT(boolean paramBoolean) { this.cIu = paramBoolean; }
  
  public String getPath() { return this.YH; }
  
  public int getProductId() { return this.arR; }
  
  public int getVendorId() { return this.arQ; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\typ\\usb\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */