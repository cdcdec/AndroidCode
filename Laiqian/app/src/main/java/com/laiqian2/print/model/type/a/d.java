package com.laiqian.print.model.type.a;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.google.a.a.a.a.a.a;
import com.laiqian.print.model.a;
import com.laiqian.print.model.g;
import com.laiqian.print.model.q;
import java.util.Iterator;
import java.util.Set;

public class d extends a {
  private static final String TAG = "d";
  
  private BroadcastReceiver cDk = new e(this);
  
  BluetoothAdapter cHI = null;
  
  private Set<BluetoothDevice> cHK = null;
  
  private g cHj;
  
  private Context mContext;
  
  static  {
  
  }
  
  public d(g paramg, Context paramContext) {
    this.cHj = paramg;
    this.mContext = paramContext;
    this.cHI = BluetoothAdapter.getDefaultAdapter();
  }
  
  private boolean c(BluetoothDevice paramBluetoothDevice) {
    if (this.cHK == null)
      return false; 
    for (BluetoothDevice bluetoothDevice : this.cHK) {
      if (paramBluetoothDevice.getAddress().equals(bluetoothDevice.getAddress()))
        return true; 
    } 
    return false;
  }
  
  protected void afa() {
    try {
      this.mContext.unregisterReceiver(this.cDk);
    } catch (Exception exception) {
      a.e(exception);
    } 
    super.afa();
  }
  
  public void cancel() {
    this.cHI.cancelDiscovery();
    onCancelled();
  }
  
  protected void onCancelled() {
    try {
      this.mContext.unregisterReceiver(this.cDk);
    } catch (Exception exception) {
      a.e(exception);
    } 
    super.onCancelled();
  }
  
  public void start() {
    if (!this.cHI.isEnabled())
      return; 
    this.cHK = this.cHI.getBondedDevices();
    Iterator iterator = this.cHK.iterator();
    while (iterator.hasNext()) {
      f f = b.a((BluetoothDevice)iterator.next());
      if (f != null)
        m(this.cHj.f(f)); 
    } 
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
    intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
    intentFilter.addAction("android.bluetooth.device.action.FOUND");
    this.mContext.registerReceiver(this.cDk, intentFilter);
    this.cHI.startDiscovery();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\type\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */