package com.laiqian.print.model.type.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.ParcelFileDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.UUID;

public class a {
  @TargetApi(14)
  public static BluetoothSocket a(BluetoothDevice paramBluetoothDevice, UUID paramUUID) throws Exception {
    BluetoothSocket bluetoothSocket;
    StringBuilder stringBuilder = new StringBuilder();
    try {
      bluetoothSocket = (BluetoothSocket)paramBluetoothDevice.getClass().getMethod("createRfcommSocket", new Class[] { int.class }).invoke(paramBluetoothDevice, new Object[] { Integer.valueOf(1) });
      try {
        bluetoothSocket.connect();
        exception = bluetoothSocket;
      } catch (Exception null) {}
    } catch (Exception exception) {
      bluetoothSocket = null;
    } 
    stringBuilder.append(exception.getMessage());
    stringBuilder.append("\n");
    a(bluetoothSocket);
    exception = null;
  }
  
  public static boolean a(BluetoothSocket paramBluetoothSocket) {
    try {
      Field field = BluetoothSocket.class.getDeclaredField("mPfd");
      field.setAccessible(true);
      ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor)field.get(paramBluetoothSocket);
      if (parcelFileDescriptor == null)
        return false; 
      parcelFileDescriptor.close();
      return true;
    } catch (Exception paramBluetoothSocket) {
      return false;
    } 
  }
  
  public static byte[] lt(String paramString) {
    if (paramString == null)
      return null; 
    try {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      return (arrayOfByte.length > 0) ? ((arrayOfByte.length > 16) ? null : arrayOfByte) : null;
    } catch (UnsupportedEncodingException paramString) {
      return null;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\type\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */