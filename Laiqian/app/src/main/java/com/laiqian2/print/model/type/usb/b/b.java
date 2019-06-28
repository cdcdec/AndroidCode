package com.laiqian.print.model.type.usb.b;

import android.hardware.usb.UsbDevice;

public class b {
  private final UsbDevice cIw;
  
  private String cIx = null;
  
  private String vendor = null;
  
  public b(UsbDevice paramUsbDevice) { this.cIw = paramUsbDevice; }
  
  public String agY() { return this.cIx; }
  
  public UsbDevice agZ() { return this.cIw; }
  
  public String getVendor() { return this.vendor; }
  
  public void ly(String paramString) { this.cIx = paramString; }
  
  public void lz(String paramString) { this.vendor = paramString; }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\typ\\usb\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */