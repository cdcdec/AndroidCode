package com.laiqian.print.cardreader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;

class t extends BroadcastReceiver {
  t(CardReaderSearchActivity paramCardReaderSearchActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    Object object = paramIntent.getAction();
    if (object.equals("com.laiqian.print.ACTION_USB_DEVICE_ATTACHED")) {
      object = paramIntent.getExtras().get("device");
      if (object != null) {
        CardReaderSearchActivity.a(this.cEE).e((UsbDevice)object);
        return;
      } 
    } else {
      if (object.equals("com.laiqian.USB_PERMISSION")) {
        CardReaderSearchActivity.a(this.cEE).aeL();
        return;
      } 
      if (object.equals("android.hardware.usb.action.USB_DEVICE_DETACHED")) {
        object = paramIntent.getExtras().get("device");
        if (object != null)
          CardReaderSearchActivity.a(this.cEE).f((UsbDevice)object); 
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\cardreader\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */