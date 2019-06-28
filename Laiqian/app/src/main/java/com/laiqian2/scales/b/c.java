package com.laiqian.scales.b;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import com.felhr.usbserial.g;

public class c implements a {
  private g aNk = null;
  
  private UsbDevice asC;
  
  private UsbDeviceConnection asD = null;
  
  private UsbManager manager;
  
  public c(UsbManager paramUsbManager, UsbDevice paramUsbDevice) {
    this.manager = paramUsbManager;
    this.asC = paramUsbDevice;
  }
  
  public static boolean b(UsbDevice paramUsbDevice) { return (g.b(paramUsbDevice) && !g.c(paramUsbDevice)); }
  
  public boolean CV() {
    this.asD = this.manager.openDevice(this.asC);
    if (this.asD != null) {
      this.aNk = g.a(this.asC, this.asD);
      this.aNk.uo();
      this.aNk.dv(8);
      this.aNk.dw(1);
      return true;
    } 
    return false;
  }
  
  public boolean CW() {
    if (this.aNk != null)
      this.aNk.up(); 
    if (this.asD != null)
      this.asD.close(); 
    return true;
  }
  
  public UsbDevice Dd() { return this.asC; }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2) { return this.aNk.f(paramArrayOfByte, 1000); }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.asC.getVendorId());
    stringBuilder.append(",");
    stringBuilder.append(this.asC.getProductId());
    return stringBuilder.toString();
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2) { this.aNk.g(paramArrayOfByte, 1000); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\scales\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */