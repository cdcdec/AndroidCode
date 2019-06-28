package com.laiqian.print;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ah extends BroadcastReceiver {
  ah(PrinterSettingsActivity paramPrinterSettingsActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) { // Byte code:
    //   0: aload_2
    //   1: invokevirtual getAction : ()Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: invokevirtual hashCode : ()I
    //   9: istore_3
    //   10: iload_3
    //   11: ldc -2046111188
    //   13: if_icmpeq -> 59
    //   16: iload_3
    //   17: ldc -1608292967
    //   19: if_icmpeq -> 45
    //   22: iload_3
    //   23: ldc -911426228
    //   25: if_icmpeq -> 31
    //   28: goto -> 73
    //   31: aload_1
    //   32: ldc 'com.laiqian.USB_PERMISSION'
    //   34: invokevirtual equals : (Ljava/lang/Object;)Z
    //   37: ifeq -> 73
    //   40: iconst_1
    //   41: istore_3
    //   42: goto -> 75
    //   45: aload_1
    //   46: ldc 'android.hardware.usb.action.USB_DEVICE_DETACHED'
    //   48: invokevirtual equals : (Ljava/lang/Object;)Z
    //   51: ifeq -> 73
    //   54: iconst_2
    //   55: istore_3
    //   56: goto -> 75
    //   59: aload_1
    //   60: ldc 'com.laiqian.print.ACTION_USB_DEVICE_ATTACHED'
    //   62: invokevirtual equals : (Ljava/lang/Object;)Z
    //   65: ifeq -> 73
    //   68: iconst_0
    //   69: istore_3
    //   70: goto -> 75
    //   73: iconst_m1
    //   74: istore_3
    //   75: iload_3
    //   76: tableswitch default -> 104, 0 -> 145, 1 -> 134, 2 -> 105
    //   104: return
    //   105: aload_2
    //   106: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   109: ldc 'device'
    //   111: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   114: astore_1
    //   115: aload_1
    //   116: ifnull -> 173
    //   119: aload_0
    //   120: getfield cDq : Lcom/laiqian/print/PrinterSettingsActivity;
    //   123: invokestatic a : (Lcom/laiqian/print/PrinterSettingsActivity;)Lcom/laiqian/print/be;
    //   126: aload_1
    //   127: checkcast android/hardware/usb/UsbDevice
    //   130: invokevirtual f : (Landroid/hardware/usb/UsbDevice;)V
    //   133: return
    //   134: aload_0
    //   135: getfield cDq : Lcom/laiqian/print/PrinterSettingsActivity;
    //   138: invokestatic a : (Lcom/laiqian/print/PrinterSettingsActivity;)Lcom/laiqian/print/be;
    //   141: invokevirtual aeL : ()V
    //   144: return
    //   145: aload_2
    //   146: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   149: ldc 'device'
    //   151: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   154: astore_1
    //   155: aload_1
    //   156: ifnull -> 173
    //   159: aload_0
    //   160: getfield cDq : Lcom/laiqian/print/PrinterSettingsActivity;
    //   163: invokestatic a : (Lcom/laiqian/print/PrinterSettingsActivity;)Lcom/laiqian/print/be;
    //   166: aload_1
    //   167: checkcast android/hardware/usb/UsbDevice
    //   170: invokevirtual e : (Landroid/hardware/usb/UsbDevice;)V
    //   173: return }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */