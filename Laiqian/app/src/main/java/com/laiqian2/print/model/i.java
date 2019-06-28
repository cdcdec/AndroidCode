package com.laiqian.print.model;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import com.google.a.a.a.a.a.a;
import com.laiqian.print.model.type.a.b;
import com.laiqian.print.model.type.a.f;
import com.laiqian.print.model.type.usb.g;

class i extends BroadcastReceiver {
  i(g paramg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    g g1;
    UsbDevice usbDevice = paramIntent.getAction();
    boolean bool2 = usbDevice.equals("com.laiqian.USB_PERMISSION");
    boolean bool1 = false;
    if (bool2) {
      usbDevice = (UsbDevice)paramIntent.getParcelableExtra("device");
      bool1 = paramIntent.getBooleanExtra("permission", false);
      g1 = new g(usbDevice.getVendorId(), usbDevice.getProductId(), usbDevice.getDeviceName());
      if (g.a(this.cHe) != null)
        g.a(this.cHe).g(g1.getIdentifier(), bool1); 
      try {
        paramContext.unregisterReceiver(this);
        return;
      } catch (Exception paramContext) {
        a.e(paramContext);
        return;
      } 
    } 
    if (usbDevice.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
      int j = g1.getIntExtra("android.bluetooth.device.extra.BOND_STATE", 10);
      f f = b.a((BluetoothDevice)g1.getParcelableExtra("android.bluetooth.device.extra.DEVICE"));
      if (f != null && g.a(this.cHe) != null) {
        g.c c = g.a(this.cHe);
        String str = f.getIdentifier();
        if (j == 12)
          bool1 = true; 
        c.g(str, bool1);
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */