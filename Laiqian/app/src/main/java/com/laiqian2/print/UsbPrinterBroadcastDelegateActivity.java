package com.laiqian.print;

import android.app.Activity;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.os.Bundle;
import android.os.Parcelable;
import com.laiqian.print.model.s;
import com.laiqian.print.model.type.usb.UsbPrintManager;
import com.laiqian.print.model.type.usb.d;
import com.laiqian.print.model.type.usb.g;
import com.laiqian.print.usage.c;
import com.laiqian.print.usage.g;
import com.orhanobut.logger.d;
import java.util.ArrayList;
import java.util.Iterator;

public class UsbPrinterBroadcastDelegateActivity extends Activity {
  private boolean a(s params, ArrayList<ac> paramArrayList) {
    Iterator iterator = paramArrayList.iterator();
    while (iterator.hasNext()) {
      s s1 = ((ac)iterator.next()).aew();
      if (params.getIdentifier().equals(s1.getIdentifier()))
        return true; 
    } 
    return false;
  }
  
  protected void onCreate(Bundle paramBundle) { super.onCreate(paramBundle); }
  
  protected void onResume() {
    super.onResume();
    System.out.println("UsbPrinterBroadcastDelegateActivity onResume()");
    Intent intent = getIntent();
    d.b("Delegating USB attach broadcast %s", new Object[] { intent.getAction() });
    if (intent.getAction().equals("android.hardware.usb.action.USB_DEVICE_ATTACHED")) {
      Parcelable parcelable = intent.getParcelableExtra("device");
      null = (UsbDevice)parcelable;
      UsbPrintManager usbPrintManager = UsbPrintManager.INSTANCE;
      g g = usbPrintManager.convertDeviceToPrinter(null);
      if (g != null) {
        d d = usbPrintManager.findPrinterProperty(g);
        if (d != null) {
          ac ac;
          g.ii(d.agF());
          g.setName(d.getName());
          g.fT(d.agW());
          d = null;
          if (g.agF() == 1) {
            ac = new ac(g, g.aic());
          } else if (g.agF() == 2) {
            ac = new ac(g, g.aie());
          } 
          if (ac != null) {
            c c = c.bi(this);
            ArrayList arrayList = c.afs();
            if (!a(ac.aew(), arrayList))
              c.f(ac); 
          } 
        } 
      } 
      Intent intent1 = new Intent("com.laiqian.print.ACTION_USB_DEVICE_ATTACHED");
      intent1.putExtra("device", parcelable);
      sendBroadcast(intent1);
    } 
    finish();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\UsbPrinterBroadcastDelegateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */