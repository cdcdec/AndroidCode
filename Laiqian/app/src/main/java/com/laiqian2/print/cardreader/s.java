package com.laiqian.print.cardreader;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.b.a.a;
import com.b.a.b;
import com.b.a.c;
import com.google.a.a.a.a.a.a;
import com.laiqian.print.model.type.usb.a.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class s implements ak {
  private static s cEA;
  
  private UsbManager cEB = null;
  
  private Map<String, ExecutorService> cEC = new HashMap();
  
  private a cEw;
  
  private Context mContext;
  
  static  {
  
  }
  
  private s(Context paramContext) { this.mContext = paramContext; }
  
  public static s aZ(Context paramContext) {
    if (cEA == null)
      cEA = new s(paramContext.getApplicationContext()); 
    return cEA;
  }
  
  private UsbManager afm() {
    if (this.cEB == null)
      this.cEB = (UsbManager)this.mContext.getSystemService("usb"); 
    return this.cEB;
  }
  
  private UsbDevice c(a parama) {
    String str = parama.getIdentifier();
    Iterator iterator = afm().getDeviceList().entrySet().iterator();
    while (iterator.hasNext()) {
      UsbDevice usbDevice = (UsbDevice)((Map.Entry)iterator.next()).getValue();
      if ((new a(usbDevice.getDeviceName(), usbDevice.getVendorId(), usbDevice.getProductId())).getIdentifier().equals(str))
        return usbDevice; 
    } 
    return null;
  }
  
  private boolean h(UsbDevice paramUsbDevice) { return (paramUsbDevice == null) ? false : afm().hasPermission(paramUsbDevice); }
  
  public void a(a parama) { this.cEw = parama; }
  
  public c afn() { return new c(this.mContext); }
  
  public boolean d(a parama) { return h(c(parama)); }
  
  public void e(a parama) {
    UsbDevice usbDevice = c(parama);
    if (usbDevice == null)
      return; 
    if (h(usbDevice)) {
      if (this.cEw != null)
        this.cEw.a(parama, true); 
      return;
    } 
    PendingIntent pendingIntent = PendingIntent.getBroadcast(this.mContext, 0, new Intent("com.laiqian.USB_PERMISSION"), 0);
    afm().requestPermission(usbDevice, pendingIntent);
  }
  
  public String f(a parama) {
    b b = new b(afm());
    null = c(parama);
    if (null == null)
      return null; 
    if (!b.k(null))
      return null; 
    a1 = new a(b);
    try {
      a1.axO();
      return a1.a(a.a.dMH);
    } catch (c a1) {
      a.e(a1);
      return null;
    } 
  }
  
  public a g(UsbDevice paramUsbDevice) { // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_1
    //   7: invokevirtual getInterfaceCount : ()I
    //   10: istore_3
    //   11: iconst_0
    //   12: istore_2
    //   13: iload_2
    //   14: iload_3
    //   15: if_icmpge -> 44
    //   18: aload_1
    //   19: iload_2
    //   20: invokevirtual getInterface : (I)Landroid/hardware/usb/UsbInterface;
    //   23: astore #4
    //   25: aload #4
    //   27: invokevirtual getInterfaceClass : ()I
    //   30: iconst_3
    //   31: if_icmpne -> 37
    //   34: goto -> 47
    //   37: iload_2
    //   38: iconst_1
    //   39: iadd
    //   40: istore_2
    //   41: goto -> 13
    //   44: aconst_null
    //   45: astore #4
    //   47: aload #4
    //   49: ifnonnull -> 54
    //   52: aconst_null
    //   53: areturn
    //   54: new com/laiqian/print/model/type/usb/a/a
    //   57: dup
    //   58: aload_1
    //   59: invokevirtual getDeviceName : ()Ljava/lang/String;
    //   62: aload_1
    //   63: invokevirtual getVendorId : ()I
    //   66: aload_1
    //   67: invokevirtual getProductId : ()I
    //   70: invokespecial <init> : (Ljava/lang/String;II)V
    //   73: astore_1
    //   74: aload_1
    //   75: iconst_1
    //   76: invokevirtual setType : (I)V
    //   79: aload_1
    //   80: ldc 'USB HID'
    //   82: invokevirtual setName : (Ljava/lang/String;)V
    //   85: aload_1
    //   86: areturn }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\cardreader\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */