package com.laiqian.print.model.type.a;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

final class c extends BroadcastReceiver {
  public void onReceive(Context paramContext, Intent paramIntent) {
    BluetoothDevice bluetoothDevice = paramIntent.getAction();
    if (bluetoothDevice.equals("android.bluetooth.device.action.PAIRING_REQUEST")) {
      Log.d(b.Ou(), "intercepted pairing request, set default pin");
      bluetoothDevice = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      if (!b.agQ().containsKey(bluetoothDevice.getAddress()) || ((Boolean)b.agQ().get(bluetoothDevice.getAddress())).booleanValue()) {
        bluetoothDevice.setPin(b.agR());
        b.agQ().put(bluetoothDevice.getAddress(), Boolean.valueOf(false));
        return;
      } 
    } else if (bluetoothDevice.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
      int i = paramIntent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", 10);
      bluetoothDevice = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      switch (i) {
      
      } 
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\type\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */