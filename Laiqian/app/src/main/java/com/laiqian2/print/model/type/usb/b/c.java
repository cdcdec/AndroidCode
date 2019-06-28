package com.laiqian.print.model.type.usb.b;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class c {
  public static boolean DEBUG = false;
  
  private boolean cIA = false;
  
  private final UsbManager cIy;
  
  private a cIz;
  
  static  {
  
  }
  
  public c(@NonNull UsbManager paramUsbManager) {
    this.cIy = paramUsbManager;
    this.cIz = new a(DEBUG);
  }
  
  private boolean a(UsbDevice paramUsbDevice, i[] paramArrayOfi) {
    if (paramArrayOfi == null)
      return false; 
    UsbInterface[] arrayOfUsbInterface = new UsbInterface[paramArrayOfi.length];
    for (byte b = 0; b < paramArrayOfi.length; b++)
      arrayOfUsbInterface[b] = paramArrayOfi[b].ahe(); 
    try {
      Field field = UsbDevice.class.getDeclaredField("mInterfaces");
      field.setAccessible(true);
      field.set(paramUsbDevice, arrayOfUsbInterface);
      return true;
    } catch (NoSuchFieldException|IllegalAccessException|IllegalArgumentException paramUsbDevice) {
      a.e(paramUsbDevice);
      return false;
    } 
  }
  
  private HashMap<String, b> b(HashMap<String, UsbDevice> paramHashMap, boolean paramBoolean) {
    HashMap hashMap = new HashMap();
    if (paramBoolean) {
      this.cIz.lA("starting injection");
      this.cIz.aha();
      HashMap hashMap1 = (new k()).ahf();
      this.cIz.lB("get sys usb devices takes %d ms");
      this.cIz.aha();
      for (Map.Entry entry : paramHashMap.entrySet()) {
        String str = (String)entry.getKey();
        UsbDevice usbDevice = (UsbDevice)entry.getValue();
        if (!hashMap1.containsKey(str))
          continue; 
        f f = (f)hashMap1.get(str);
        if (usbDevice.getInterfaceCount() == 0 && !a(usbDevice, ((f)hashMap1.get(str)).ahc()))
          Log.i("tag", String.format("inject %s failed", new Object[] { str })); 
        b b = new b(usbDevice);
        b.ly(f.getProductName());
        b.lz(f.ahb());
        hashMap.put(str, b);
      } 
      this.cIz.lB("inject interfaces takes %d ms");
      return hashMap;
    } 
    for (Map.Entry null : paramHashMap.entrySet()) {
      String str = (String)null.getKey();
      UsbDevice usbDevice = (UsbDevice)null.getValue();
      if (!j(usbDevice))
        hashMap.put(str, new b(usbDevice)); 
    } 
    return hashMap;
  }
  
  private boolean j(UsbDevice paramUsbDevice) { // Byte code:
    //   0: aload_1
    //   1: invokevirtual getDeviceName : ()Ljava/lang/String;
    //   4: astore_1
    //   5: new java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial <init> : (Ljava/lang/String;)V
    //   13: astore #4
    //   15: aload #4
    //   17: invokevirtual getParentFile : ()Ljava/io/File;
    //   20: astore #5
    //   22: aload #5
    //   24: ifnull -> 103
    //   27: aload #5
    //   29: invokevirtual exists : ()Z
    //   32: ifeq -> 103
    //   35: aload #5
    //   37: invokevirtual list : ()[Ljava/lang/String;
    //   40: astore #5
    //   42: aload #5
    //   44: ifnull -> 101
    //   47: aload #5
    //   49: arraylength
    //   50: ifne -> 55
    //   53: iconst_0
    //   54: ireturn
    //   55: aload #5
    //   57: arraylength
    //   58: istore_3
    //   59: iconst_0
    //   60: istore_2
    //   61: iload_2
    //   62: iload_3
    //   63: if_icmpge -> 86
    //   66: aload #5
    //   68: iload_2
    //   69: aaload
    //   70: aload_1
    //   71: invokevirtual equals : (Ljava/lang/Object;)Z
    //   74: ifeq -> 79
    //   77: iconst_1
    //   78: ireturn
    //   79: iload_2
    //   80: iconst_1
    //   81: iadd
    //   82: istore_2
    //   83: goto -> 61
    //   86: aload #4
    //   88: invokevirtual getAbsoluteFile : ()Ljava/io/File;
    //   91: invokevirtual exists : ()Z
    //   94: ifne -> 99
    //   97: iconst_1
    //   98: ireturn
    //   99: iconst_0
    //   100: ireturn
    //   101: iconst_0
    //   102: ireturn
    //   103: iconst_0
    //   104: ireturn }
  
  public HashMap<String, b> getDeviceList() { return b(this.cIy.getDeviceList(), this.cIA); }
  
  private static class a {
    private long cIB = 0L;
    
    private boolean enabled = false;
    
    public a(boolean param1Boolean) { this.enabled = param1Boolean; }
    
    public void aha() {
      if (!this.enabled)
        return; 
      this.cIB = System.currentTimeMillis();
    }
    
    public void lA(String param1String) {
      if (!this.enabled)
        return; 
      Log.i("tag", param1String);
    }
    
    public void lB(String param1String) {
      if (!this.enabled)
        return; 
      Log.i("tag", String.format(param1String, new Object[] { Long.valueOf(System.currentTimeMillis() - this.cIB) }));
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\typ\\usb\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */