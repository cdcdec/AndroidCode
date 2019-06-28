package com.laiqian.print.type.usb.a;

import android.content.Context;
import android.hardware.usb.UsbManager;
import com.laiqian.infrastructure.R;
import com.laiqian.print.a.a;
import com.laiqian.print.model.type.usb.b.b;
import com.laiqian.print.model.type.usb.b.c;
import java.util.Iterator;

public class a extends a {
  private int arQ;
  
  private int arR;
  
  Context context;
  
  public a(Context paramContext, int paramInt1, int paramInt2) {
    super(paramContext.getString(R.string.diagnose_usb_printer_sys_title));
    this.context = paramContext;
    this.arQ = paramInt1;
    this.arR = paramInt2;
  }
  
  public void run() {
    null = new c((UsbManager)this.context.getSystemService("usb"));
    la(this.context.getString(R.string.diagnose_usb_printer_sys_1));
    Iterator iterator = null.getDeviceList().values().iterator();
    boolean bool = false;
    while (iterator.hasNext()) {
      b b = (b)iterator.next();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.context.getString(R.string.diagnose_usb_printer_sys_1_found));
      stringBuilder.append(b.agZ().toString());
      la(stringBuilder.toString());
      if (this.arQ == b.agZ().getVendorId() && this.arR == b.agZ().getProductId())
        bool = true; 
    } 
    la(this.context.getString(R.string.diagnose_usb_printer_sys_1_finish));
    if (!bool) {
      la(this.context.getString(R.string.diagnose_usb_printer_sys_1_failed));
      afv();
      return;
    } 
    la(this.context.getString(R.string.diagnose_usb_printer_sys_1_success));
    afu();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\typ\\usb\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */