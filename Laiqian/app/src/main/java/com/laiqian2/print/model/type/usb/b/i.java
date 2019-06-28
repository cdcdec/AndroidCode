package com.laiqian.print.model.type.usb.b;

import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import com.google.a.a.a.a.a.a;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class i {
  private final int cHl;
  
  private final int cIL;
  
  private final int cIM;
  
  private final int cIN;
  
  private h[] cIO;
  
  private final int mId;
  
  private final String mName;
  
  public i(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5) {
    this.mId = paramInt1;
    this.cIL = paramInt2;
    this.mName = paramString;
    this.cIM = paramInt3;
    this.cIN = paramInt4;
    this.cHl = paramInt5;
  }
  
  public static i D(File paramFile) {
    if (paramFile == null)
      return null; 
    if (!paramFile.exists())
      return null; 
    if (!paramFile.isDirectory())
      return null; 
    a a = new a(paramFile.getAbsolutePath());
    String str1 = a.lx("bAlternateSetting");
    null = a.lx("bInterfaceClass");
    String str2 = a.lx("bInterfaceNumber");
    String str3 = a.lx("bInterfaceProtocol");
    String str4 = a.lx("bInterfaceSubClass");
    i i1 = new i(e.parseInt(str2, 16), e.parseInt(str1), null, e.parseInt(null, 16), e.parseInt(str4, 16), e.parseInt(str3, 16));
    File[] arrayOfFile = paramFile.listFiles(new j());
    if (arrayOfFile == null)
      return null; 
    ArrayList arrayList = new ArrayList();
    int j = arrayOfFile.length;
    for (byte b = 0; b < j; b++) {
      h h1 = h.C(arrayOfFile[b]);
      if (h1 != null)
        arrayList.add(h1); 
    } 
    i1.a((h[])arrayList.toArray(new h[0]));
    return i1;
  }
  
  public void a(h[] paramArrayOfh) { this.cIO = paramArrayOfh; }
  
  public UsbInterface ahe() {
    try {
      UsbInterface usbInterface = (UsbInterface)UsbInterface.class.getDeclaredConstructor(new Class[] { int.class, int.class, String.class, int.class, int.class, int.class }).newInstance(new Object[] { Integer.valueOf(this.mId), Integer.valueOf(this.cIL), this.mName, Integer.valueOf(this.cIM), Integer.valueOf(this.cIN), Integer.valueOf(this.cHl) });
      Method method = UsbInterface.class.getDeclaredMethod("setEndpoints", new Class[] { android.os.Parcelable[].class });
      UsbEndpoint[] arrayOfUsbEndpoint = new UsbEndpoint[this.cIO.length];
      for (byte b = 0; b < this.cIO.length; b++)
        arrayOfUsbEndpoint[b] = this.cIO[b].ahd(); 
      method.invoke(usbInterface, new Object[] { arrayOfUsbEndpoint });
      return usbInterface;
    } catch (NoSuchMethodException|InstantiationException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException noSuchMethodException) {
      a.e(noSuchMethodException);
      return null;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\typ\\usb\b\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */