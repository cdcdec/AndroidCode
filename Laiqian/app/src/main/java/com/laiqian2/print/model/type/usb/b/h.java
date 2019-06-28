package com.laiqian.print.model.type.usb.b;

import android.hardware.usb.UsbEndpoint;
import com.google.a.a.a.a.a.a;
import java.io.File;

public class h {
  private final int cIH;
  
  private final int cII;
  
  private final int cIJ;
  
  private final int cIK;
  
  public h(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.cIH = paramInt1;
    this.cII = paramInt2;
    this.cIJ = paramInt3;
    this.cIK = paramInt4;
  }
  
  public static h C(File paramFile) {
    if (paramFile == null)
      return null; 
    if (!paramFile.exists())
      return null; 
    if (!paramFile.isDirectory())
      return null; 
    a a = new a(paramFile.getAbsolutePath());
    String str1 = a.lx("bEndpointAddress");
    String str2 = a.lx("bInterval");
    String str3 = a.lx("bmAttributes");
    String str4 = a.lx("wMaxPacketSize");
    int i = e.parseInt(str1, 16);
    int j = e.parseInt(str3, 16);
    int k = e.parseInt(str4, 16);
    int m = e.parseInt(str2, 16);
    return (i == 0) ? null : new h(i, j, k, m);
  }
  
  public UsbEndpoint ahd() {
    try {
      return (UsbEndpoint)UsbEndpoint.class.getDeclaredConstructor(new Class[] { int.class, int.class, int.class, int.class }).newInstance(new Object[] { Integer.valueOf(this.cIH), Integer.valueOf(this.cII), Integer.valueOf(this.cIJ), Integer.valueOf(this.cIK) });
    } catch (NoSuchMethodException|InstantiationException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException noSuchMethodException) {
      a.e(noSuchMethodException);
      return null;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\typ\\usb\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */