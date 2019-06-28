package com.laiqian.print.cardreader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;

class d extends BroadcastReceiver {
  d(CardReaderEditActivity paramCardReaderEditActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    Object object = paramIntent.getAction();
    if (object.equals("com.laiqian.print.ACTION_USB_DEVICE_ATTACHED")) {
      object = paramIntent.getExtras().get("device");
      if (object != null) {
        CardReaderEditActivity.a(this.cEp).e((UsbDevice)object);
        return;
      } 
    } else {
      if (object.equals("com.laiqian.USB_PERMISSION")) {
        boolean bool = ((Boolean)paramIntent.getExtras().get("permission")).booleanValue();
        CardReaderEditActivity.a(this.cEp).fy(bool);
        return;
      } 
      if (object.equals("android.hardware.usb.action.USB_DEVICE_DETACHED"))
        CardReaderEditActivity.a(this.cEp).afj(); 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\cardreader\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */