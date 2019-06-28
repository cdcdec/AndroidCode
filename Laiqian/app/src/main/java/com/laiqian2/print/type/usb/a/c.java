package com.laiqian.print.type.usb.a;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import com.laiqian.infrastructure.R;
import com.laiqian.print.a.a;
import com.laiqian.util.r;
import java.util.Iterator;

public class c extends a {
  private int arQ;
  
  private int arR;
  
  private Context context;
  
  public c(Context paramContext, int paramInt1, int paramInt2) {
    super(paramContext.getString(R.string.diagnose_usb_printer_duplication_title));
    this.context = paramContext;
    this.arQ = paramInt1;
    this.arR = paramInt2;
  }
  
  public void run() {
    Iterator iterator = ((UsbManager)r.E(this.context, "usb")).getDeviceList().values().iterator();
    boolean bool = false;
    byte b = 0;
    while (iterator.hasNext()) {
      UsbDevice usbDevice = (UsbDevice)iterator.next();
      if (usbDevice.getVendorId() == this.arQ && usbDevice.getProductId() == this.arR)
        b++; 
    } 
    if (b == 0) {
      la(this.context.getString(R.string.diagnose_usb_printer_device_not_found));
      afv();
      return;
    } 
    if (b >= 2)
      bool = true; 
    if (bool) {
      la(this.context.getString(R.string.diagnose_usb_printer_duplication_1_failed));
      afv();
      return;
    } 
    la(this.context.getString(R.string.diagnose_usb_printer_duplication_1_success));
    afu();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\typ\\usb\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */