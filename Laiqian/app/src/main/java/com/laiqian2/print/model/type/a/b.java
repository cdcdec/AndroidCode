package com.laiqian.print.model.type.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.a.a.a.a.a.a;
import com.laiqian.print.model.PrintContent;
import com.laiqian.print.model.c;
import com.laiqian.print.model.e;
import com.laiqian.print.model.s;
import com.laiqian.print.util.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(19)
public static enum b implements c {
  cHB;
  
  private static final String TAG = "b";
  
  private static BroadcastReceiver cDk;
  
  private static final UUID cHC;
  
  private static final byte[] cHD;
  
  private static final byte[] cHE;
  
  private static ConcurrentHashMap<String, Boolean> cHF;
  
  private static ThreadLocal<BluetoothSocket> cHG;
  
  private static String cHH = "";
  
  private BluetoothAdapter cHI;
  
  private boolean initialized = false;
  
  private Context mContext;
  
  static  {
    cHC = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    cHD = a.lt("0000");
    cHE = a.lt("1234");
    cHF = new ConcurrentHashMap();
    cHG = new ThreadLocal();
    cDk = new c();
  }
  
  @Nullable
  public static f a(BluetoothDevice paramBluetoothDevice) {
    String str = paramBluetoothDevice.getAddress();
    int i = paramBluetoothDevice.getBluetoothClass().getMajorDeviceClass();
    if (i == 1536 || i == 7936 || i == 1024 || i == 0) {
      f f = new f(str);
      f.setName(paramBluetoothDevice.getName());
      if (paramBluetoothDevice.getUuids() != null)
        f.a(paramBluetoothDevice.getUuids()); 
      return f;
    } 
    return null;
  }
  
  @TargetApi(19)
  private void b(@NonNull BluetoothDevice paramBluetoothDevice) {
    paramBluetoothDevice.createBond();
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
    intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
    this.mContext.registerReceiver(cDk, intentFilter);
  }
  
  private boolean b(@Nullable BluetoothSocket paramBluetoothSocket) {
    if (paramBluetoothSocket == null)
      return false; 
    if (!paramBluetoothSocket.isConnected())
      return false; 
    try {
      paramBluetoothSocket.getOutputStream().write(0);
      return true;
    } catch (IOException paramBluetoothSocket) {
      return false;
    } 
  }
  
  private static String getErrorMessage(int paramInt) {
    switch (paramInt) {
      default:
        return "";
      case 4:
        return cHH;
      case 3:
        return "Not connected";
      case 2:
        return "Not paired";
      case 1:
        return "No such device";
      case 0:
        break;
    } 
    return "Success";
  }
  
  private BluetoothDevice m(s params) {
    if (params.getType() != 3)
      return null; 
    params = (f)params;
    return this.cHI.getRemoteDevice(params.getMacAddress());
  }
  
  public boolean connect(s params) {
    if (params.getType() != 3)
      return false; 
    BluetoothDevice bluetoothDevice = m((f)params);
    if (bluetoothDevice == null)
      return false; 
    this.cHI.cancelDiscovery();
    if (bluetoothDevice.getBondState() == 12) {
      Log.d(TAG, "already bonded, try connect");
      UUID uUID = cHC;
      BluetoothSocket bluetoothSocket2 = (BluetoothSocket)cHG.get();
      bluetoothSocket1 = bluetoothSocket2;
      if (!b(bluetoothSocket2))
        try {
          bluetoothSocket1 = a.a(bluetoothDevice, uUID);
        } catch (Exception bluetoothSocket1) {
          cHH = bluetoothSocket1.getMessage();
          a.e(bluetoothSocket1);
          return false;
        }  
      cHG.set(bluetoothSocket1);
      return true;
    } 
    Log.d(TAG, "requesting bond to device");
    b(bluetoothDevice);
    return false;
  }
  
  public void init(@NonNull Context paramContext) throws IllegalStateException {
    if (Build.VERSION.SDK_INT < 19)
      throw new IllegalStateException("bluetooth function require features added in API 19"); 
    this.mContext = paramContext;
    this.cHI = BluetoothAdapter.getDefaultAdapter();
    if (this.cHI == null)
      throw new IllegalStateException("bluetooth function not available"); 
    this.initialized = true;
  }
  
  public boolean isConnected(s params) { return false; }
  
  public boolean isInitialized() { return this.initialized; }
  
  public int print(s params, byte[] paramArrayOfByte) {
    bluetoothDevice = m(params);
    if (bluetoothDevice == null)
      return 1; 
    if (bluetoothDevice.getBondState() != 12)
      return 3; 
    this.cHI.cancelDiscovery();
    UUID uUID = cHC;
    bluetoothSocket = (BluetoothSocket)cHG.get();
    if (!b(bluetoothSocket)) {
      try {
        BluetoothSocket bluetoothSocket1 = a.a(bluetoothDevice, uUID);
        bluetoothSocket = bluetoothSocket1;
      } catch (Exception bluetoothDevice) {
        cHH = bluetoothDevice.getMessage();
        a.e(bluetoothDevice);
      } 
    } else {
      Log.d(TAG, "reusing connected socket");
    } 
    if (bluetoothSocket == null)
      return 3; 
    try {
      cHG.set(bluetoothSocket);
      OutputStream outputStream = bluetoothSocket.getOutputStream();
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      while (byteArrayInputStream.available() > 0) {
        arrayOfByte = new byte[Math.min(1024, byteArrayInputStream.available())];
        byteArrayInputStream.read(arrayOfByte);
        outputStream.write(arrayOfByte);
        outputStream.flush();
        try {
          Thread.sleep(100L);
        } catch (InterruptedException arrayOfByte) {
          a.e(arrayOfByte);
        } 
      } 
      return 0;
    } catch (IOException bluetoothSocket) {
      cHH = bluetoothSocket.getMessage();
      a.e(bluetoothSocket);
      return 4;
    } finally {}
    throw bluetoothSocket;
  }
  
  public void print(e parame) {
    parame.onStart();
    int i = 0;
    b b1 = new b(false);
    List list = parame.ags();
    int j = list.size();
    while (i < j) {
      b1.s(parame.agt().a((PrintContent)list.get(i), parame.aew()));
      i++;
    } 
    i = print(parame.aew(), b1.toByteArray());
    parame.setResultCode(i);
    parame.lp(getErrorMessage(i));
    if (i == 0) {
      parame.xx();
      return;
    } 
    parame.afv();
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\type\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */