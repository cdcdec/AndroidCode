package com.laiqian.customerdisplay.a;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import com.felhr.usbserial.g;

public class d implements a {
  private g aNk = null;
  
  private UsbDevice asC;
  
  private UsbDeviceConnection asD = null;
  
  private UsbManager manager;
  
  public d(UsbManager paramUsbManager, UsbDevice paramUsbDevice) {
    this.manager = paramUsbManager;
    this.asC = paramUsbDevice;
  }
  
  public boolean CV() {
    if (!this.manager.hasPermission(this.asC))
      return false; 
    this.asD = this.manager.openDevice(this.asC);
    if (this.asD != null) {
      this.aNk = g.a(this.asC, this.asD);
      this.aNk.uo();
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
  
  public void setBaudrate(int paramInt) {
    if (this.aNk == null)
      throw new IllegalStateException("this method cannot be invoked before success open"); 
    this.aNk.du(paramInt);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.asC.getVendorId());
    stringBuilder.append(",");
    stringBuilder.append(this.asC.getProductId());
    return stringBuilder.toString();
  }
  
  public int write(byte[] paramArrayOfByte, int paramInt1, int paramInt2) { return this.aNk.g(paramArrayOfByte, 1000); }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\customerdisplay\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */