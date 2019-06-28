package com.laiqian.print.model.type.usb.a;

import java.io.Serializable;

public class a implements Serializable {
  private String YH;
  
  private final int arQ;
  
  private final int arR;
  
  private final String cIm;
  
  private int cIp = 0;
  
  private boolean connected = false;
  
  private String name;
  
  private int type = 0;
  
  public a(String paramString, int paramInt1, int paramInt2) {
    this.YH = paramString;
    this.arQ = paramInt1;
    this.arR = paramInt2;
    this.name = paramString;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append(",");
    stringBuilder.append(paramInt2);
    this.cIm = stringBuilder.toString();
  }
  
  public int agF() { return this.cIp; }
  
  public String getIdentifier() { return this.cIm; }
  
  public String getName() { return this.name; }
  
  public int getProductId() { return this.arR; }
  
  public int getType() { return this.type; }
  
  public int getVendorId() { return this.arQ; }
  
  public void ii(int paramInt) { this.cIp = paramInt; }
  
  public boolean isConnected() { return this.connected; }
  
  public void setConnected(boolean paramBoolean) { this.connected = paramBoolean; }
  
  public void setName(String paramString) { this.name = paramString; }
  
  public void setType(int paramInt) { this.type = paramInt; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\typ\\usb\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */