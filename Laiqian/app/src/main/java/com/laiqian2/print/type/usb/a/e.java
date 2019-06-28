package com.laiqian.print.type.usb.a;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.laiqian.infrastructure.R;
import com.laiqian.print.a.a;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.e;
import com.laiqian.print.model.g;
import com.laiqian.print.model.type.usb.UsbPrintManager;
import com.laiqian.print.model.type.usb.g;
import com.laiqian.util.r;
import java.util.Iterator;

public class e extends a {
  private int arQ;
  
  private int arR;
  
  private Context context;
  
  public e(Context paramContext, int paramInt1, int paramInt2) {
    super(paramContext.getString(R.string.diagnose_usb_printer_transmit_title));
    this.context = paramContext;
    this.arQ = paramInt1;
    this.arR = paramInt2;
  }
  
  public void run() {
    UsbDevice usbDevice = (UsbManager)r.E(this.context, "usb");
    UsbPrintManager usbPrintManager = UsbPrintManager.INSTANCE;
    Iterator iterator = usbDevice.getDeviceList().values().iterator();
    usbDevice = null;
    while (iterator.hasNext()) {
      UsbDevice usbDevice1 = (UsbDevice)iterator.next();
      if (usbDevice1.getVendorId() == this.arQ && usbDevice1.getProductId() == this.arR)
        usbDevice = usbDevice1; 
    } 
    if (usbDevice == null) {
      la(this.context.getString(R.string.diagnose_usb_printer_device_not_found));
      afv();
      return;
    } 
    g g = usbPrintManager.convertDeviceToPrinter(usbDevice);
    if (g == null) {
      la(this.context.getString(R.string.diagnose_usb_printer_not_printer));
      afv();
      return;
    } 
    PrintContent printContent = (new PrintContent.a()).ln("hello printer\n").afV();
    e e1 = g.cGS.f(g).a(printContent);
    e1.a(new f(this));
    usbPrintManager.print(e1);
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\typ\\usb\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */