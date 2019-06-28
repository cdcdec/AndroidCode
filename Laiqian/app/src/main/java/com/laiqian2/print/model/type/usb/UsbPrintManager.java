package com.laiqian.print.model.type.usb;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.support.annotation.NonNull;
import com.google.a.a.a.a.a.a;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.b.a;
import com.laiqian.print.model.c;
import com.laiqian.print.model.e;
import com.laiqian.print.model.s;
import com.laiqian.print.model.type.usb.b.b;
import com.laiqian.print.model.type.usb.b.c;
import com.laiqian.print.util.LqkEncrypt;
import com.laiqian.print.util.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(12)
public static enum UsbPrintManager implements c {
  INSTANCE;
  
  private static UsbPrintManager instance;
  
  private static final List<String> lowVoltagePrinters;
  
  private static final List<String> spPrinters;
  
  private static final List<String> switchWidthHeightPrinters;
  
  private Context context = null;
  
  private boolean debug = false;
  
  private c exManager;
  
  private boolean initialized = false;
  
  private UsbManager manager;
  
  static  {
    $VALUES = new UsbPrintManager[] { INSTANCE };
    lowVoltagePrinters = new ArrayList();
    switchWidthHeightPrinters = new ArrayList();
    spPrinters = new ArrayList();
    lowVoltagePrinters.add("1305,8211");
    lowVoltagePrinters.add("10473,649");
    switchWidthHeightPrinters.add("1305,8213");
    spPrinters.addAll(lowVoltagePrinters);
    spPrinters.addAll(switchWidthHeightPrinters);
  }
  
  private UsbDevice findDevice(String paramString) {
    Iterator iterator = this.exManager.getDeviceList().entrySet().iterator();
    while (iterator.hasNext()) {
      b b = (b)((Map.Entry)iterator.next()).getValue();
      g g = convertDeviceToPrinter(b);
      if (g != null && g.getIdentifier().equals(paramString))
        return b.agZ(); 
    } 
    return null;
  }
  
  private ArrayList<g> findPrinters(HashMap<String, b> paramHashMap) {
    ArrayList arrayList = new ArrayList();
    Iterator iterator = paramHashMap.entrySet().iterator();
    while (iterator.hasNext()) {
      g g = convertDeviceToPrinter((b)((Map.Entry)iterator.next()).getValue());
      if (g != null)
        arrayList.add(g); 
    } 
    return arrayList;
  }
  
  public static String getErrorMessage(int paramInt) {
    switch (paramInt) {
      default:
        return "";
      case 13:
        return "not a printer";
      case 12:
        return "execute error";
      case 10:
        return "claim interface failed";
      case 9:
        return "decode error";
      case 8:
        return "timeout";
      case 7:
        return "internal error";
      case 6:
        return "not supported data type";
      case 5:
        return "printer error";
      case 4:
        return "no printer connected";
      case 3:
        return "data transfer lost";
      case 2:
        return "no permission for the device";
      case 1:
        return "device not found";
      case 0:
        break;
    } 
    return "printer active";
  }
  
  private UsbEndpoint getInEndpoint(UsbInterface paramUsbInterface) {
    int i = paramUsbInterface.getEndpointCount();
    for (byte b = 0; b < i; b++) {
      UsbEndpoint usbEndpoint = paramUsbInterface.getEndpoint(b);
      if (usbEndpoint.getDirection() == 128)
        return usbEndpoint; 
    } 
    return null;
  }
  
  private UsbEndpoint getOutEndpoint(UsbInterface paramUsbInterface) {
    int i = paramUsbInterface.getEndpointCount();
    for (byte b = 0; b < i; b++) {
      UsbEndpoint usbEndpoint = paramUsbInterface.getEndpoint(b);
      if (usbEndpoint.getDirection() == 0)
        return usbEndpoint; 
    } 
    return null;
  }
  
  private UsbInterface getPrinterInterface(UsbDevice paramUsbDevice) {
    int i = paramUsbDevice.getInterfaceCount();
    for (byte b = 0; b < i; b++) {
      UsbInterface usbInterface = paramUsbDevice.getInterface(b);
      if (usbInterface.getInterfaceClass() == 7)
        return usbInterface; 
    } 
    return null;
  }
  
  private int transferDataToEndpoint(UsbDeviceConnection paramUsbDeviceConnection, UsbEndpoint paramUsbEndpoint, byte[] paramArrayOfByte) {
    char c1;
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    if (paramUsbEndpoint.getMaxPacketSize() != 0) {
      c1 = paramUsbEndpoint.getMaxPacketSize();
    } else {
      c1 = 'Ȁ';
    } 
    int i = 0;
    while (byteArrayInputStream.available() > 0) {
      try {
        byte[] arrayOfByte = new byte[c1];
        int j = byteArrayInputStream.read(arrayOfByte);
        j = paramUsbDeviceConnection.bulkTransfer(paramUsbEndpoint, arrayOfByte, j, getTimeOut(j));
        i += j;
      } catch (IOException paramUsbDeviceConnection) {
        a.e(paramUsbDeviceConnection);
        return 3;
      } 
    } 
    return (i < 0) ? 5 : ((i < paramArrayOfByte.length) ? 3 : 0);
  }
  
  private String verify(UsbDeviceConnection paramUsbDeviceConnection, UsbEndpoint paramUsbEndpoint1, UsbEndpoint paramUsbEndpoint2) {
    byte[] arrayOfByte = LqkEncrypt.ajc();
    return (transferDataToEndpoint(paramUsbDeviceConnection, paramUsbEndpoint1, a.a(arrayOfByte, LqkEncrypt.y(arrayOfByte), LqkEncrypt.aje())) == 0) ? "00000X" : "000000";
  }
  
  private boolean verifyEnd(UsbDeviceConnection paramUsbDeviceConnection, UsbEndpoint paramUsbEndpoint) {
    byte[] arrayOfByte = a.agN();
    return !(transferDataToEndpoint(paramUsbDeviceConnection, paramUsbEndpoint, arrayOfByte) != arrayOfByte.length);
  }
  
  public boolean checkPermission(UsbDevice paramUsbDevice) { return this.manager.hasPermission(paramUsbDevice); }
  
  public boolean connect(s params) {
    if (params.getType() == 1) {
      if (!(params instanceof g))
        return false; 
      UsbDevice usbDevice = findDevice(params.getIdentifier());
      if (usbDevice == null)
        return false; 
      if (checkPermission(usbDevice))
        return true; 
      grantPermission(usbDevice);
      return false;
    } 
    return false;
  }
  
  public g convertDeviceToPrinter(UsbDevice paramUsbDevice) {
    paramUsbDevice.getDeviceName();
    if (getPrinterInterface(paramUsbDevice) == null)
      return null; 
    g g = new g(paramUsbDevice.getVendorId(), paramUsbDevice.getProductId(), paramUsbDevice.getDeviceName());
    g.fS(checkPermission(paramUsbDevice));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramUsbDevice);
    stringBuilder.append(" ");
    stringBuilder.append(paramUsbDevice);
    g.setName(stringBuilder.toString());
    return g;
  }
  
  public g convertDeviceToPrinter(b paramb) {
    g g = convertDeviceToPrinter(paramb.agZ());
    if (g != null) {
      if (paramb.agY() != null && paramb.getVendor() != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramb.getVendor());
        stringBuilder.append("-");
        stringBuilder.append(paramb.agY());
        g.setName(stringBuilder.toString());
        return g;
      } 
      g.setName("USB Printer");
    } 
    return g;
  }
  
  public d findPrinterProperty(g paramg) {
    b b = e.bf(this.context).lw(paramg.getIdentifier());
    return (b != null && b instanceof d) ? (d)b : null;
  }
  
  public String generatePrinterName(g paramg) {
    d d = findPrinterProperty(paramg);
    return (d == null) ? "USB Printer" : d.getName();
  }
  
  public ArrayList<g> getPrinterList() { return findPrinters(this.exManager.getDeviceList()); }
  
  public int getTimeOut(int paramInt) { return 5000; }
  
  public void grantPermission(UsbDevice paramUsbDevice) {
    if (paramUsbDevice == null)
      return; 
    if (!this.manager.hasPermission(paramUsbDevice)) {
      PendingIntent pendingIntent = PendingIntent.getBroadcast(this.context, 0, new Intent("com.laiqian.USB_PERMISSION"), 0);
      this.manager.requestPermission(paramUsbDevice, pendingIntent);
    } 
  }
  
  public void init(@NonNull Context paramContext) throws IllegalStateException {
    Object object = paramContext.getSystemService("usb");
    if (object == null)
      throw new IllegalStateException("usb not available"); 
    object = (UsbManager)object;
    try {
      object.getDeviceList();
      this.context = paramContext;
      this.manager = object;
      this.exManager = new c(this.manager);
      this.initialized = true;
      return;
    } catch (NullPointerException paramContext) {
      object = new IllegalStateException("usb not available");
      object.initCause(paramContext);
      throw object;
    } 
  }
  
  public boolean isConnected(s params) {
    int i = params.getType();
    byte b = 0;
    if (i == 1) {
      if (!(params instanceof g))
        return false; 
      UsbDevice usbDevice = findDevice(params.getIdentifier());
      int j = b;
      if (usbDevice != null) {
        j = b;
        if (checkPermission(usbDevice))
          j = 1; 
      } 
      return j;
    } 
    return false;
  }
  
  public boolean isInitialized() { return this.initialized; }
  
  public int print(s params, byte[] paramArrayOfByte) {
    if (params.getType() != 1 || !(params instanceof g))
      return 4; 
    params = (g)params;
    null = findDevice(params.getIdentifier());
    if (null == null)
      return 1; 
    UsbInterface usbInterface = getPrinterInterface(null);
    if (usbInterface == null)
      return 13; 
    if (!checkPermission(null))
      return 2; 
    UsbDeviceConnection usbDeviceConnection = this.manager.openDevice(null);
    if (usbDeviceConnection == null)
      return 1; 
    if (!usbDeviceConnection.claimInterface(usbInterface, true))
      return 10; 
    UsbEndpoint usbEndpoint1 = getOutEndpoint(usbInterface);
    UsbEndpoint usbEndpoint2 = getInEndpoint(usbInterface);
    byte[] arrayOfByte = new byte[80];
    Arrays.fill(arrayOfByte, (byte)0);
    transferDataToEndpoint(usbDeviceConnection, usbEndpoint1, arrayOfByte);
    if (params.agW() && "000000".equals(verify(usbDeviceConnection, usbEndpoint1, usbEndpoint2)))
      return 14; 
    int i = transferDataToEndpoint(usbDeviceConnection, usbEndpoint1, paramArrayOfByte);
    if (params.agW())
      verifyEnd(usbDeviceConnection, usbEndpoint1); 
    usbDeviceConnection.releaseInterface(usbInterface);
    usbDeviceConnection.close();
    return i;
  }
  
  public void print(e parame) {
    parame.onStart();
    s s = parame.aew();
    if (s.getType() != 1) {
      parame.afv();
      return;
    } 
    null = (g)s;
    int i = 0;
    b b = new b(false);
    List list = parame.ags();
    int j = list.size();
    while (i < j) {
      PrintContent printContent = (PrintContent)list.get(i);
      b.s(parame.agt().a(printContent, s));
      i++;
    } 
    i = print(parame.aew(), b.toByteArray());
    parame.setResultCode(i);
    parame.lp(getErrorMessage(i));
    if (i == 0) {
      parame.xx();
      return;
    } 
    parame.afv();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\typ\\usb\UsbPrintManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */