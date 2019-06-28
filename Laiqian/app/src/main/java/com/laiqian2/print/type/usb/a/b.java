package com.laiqian.print.type.usb.a;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.support.annotation.NonNull;
import com.laiqian.infrastructure.R;
import com.laiqian.print.a.a;
import java.util.Iterator;

public class b extends a {
  private int arQ;
  
  private int arR;
  
  private UsbManager cEB;
  
  private Context context;
  
  public b(Context paramContext, @NonNull UsbManager paramUsbManager, int paramInt1, int paramInt2) {
    super(paramContext.getString(R.string.diagnose_usb_printer_android_title));
    this.context = paramContext;
    this.cEB = paramUsbManager;
    this.arQ = paramInt1;
    this.arR = paramInt2;
  }
  
  public void run() {
    la(this.context.getString(R.string.diagnose_usb_printer_android_1));
    Iterator iterator = this.cEB.getDeviceList().values().iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      UsbDevice usbDevice = (UsbDevice)iterator.next();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.context.getString(R.string.diagnose_usb_printer_android_1_found));
      stringBuilder.append(usbDevice.toString());
      la(stringBuilder.toString());
      if (this.arQ == usbDevice.getVendorId() && this.arR == usbDevice.getProductId())
        bool = true; 
    } 
    la(this.context.getString(R.string.diagnose_usb_printer_android_1_finish));
    if (!bool) {
      la(this.context.getString(R.string.diagnose_usb_printer_android_1_failed));
      afv();
      return;
    } 
    la(this.context.getString(R.string.diagnose_usb_printer_android_1_success));
    afu();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\typ\\usb\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */