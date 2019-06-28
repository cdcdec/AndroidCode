package com.laiqian.main.module.hardware.cardreader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class a extends BroadcastReceiver {
  a(PosActivityCardReaderFragment paramPosActivityCardReaderFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) { // Byte code:
    //   0: aload_2
    //   1: invokevirtual getAction : ()Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: invokevirtual hashCode : ()I
    //   9: istore_3
    //   10: iload_3
    //   11: ldc -1608292967
    //   13: if_icmpeq -> 79
    //   16: iload_3
    //   17: ldc -911426228
    //   19: if_icmpeq -> 65
    //   22: iload_3
    //   23: ldc 525114847
    //   25: if_icmpeq -> 51
    //   28: iload_3
    //   29: ldc 624110142
    //   31: if_icmpeq -> 37
    //   34: goto -> 93
    //   37: aload_1
    //   38: ldc 'pos_activity_change_data_cardreader'
    //   40: invokevirtual equals : (Ljava/lang/Object;)Z
    //   43: ifeq -> 93
    //   46: iconst_1
    //   47: istore_3
    //   48: goto -> 95
    //   51: aload_1
    //   52: ldc 'action_usb_card_read_once'
    //   54: invokevirtual equals : (Ljava/lang/Object;)Z
    //   57: ifeq -> 93
    //   60: iconst_3
    //   61: istore_3
    //   62: goto -> 95
    //   65: aload_1
    //   66: ldc 'com.laiqian.USB_PERMISSION'
    //   68: invokevirtual equals : (Ljava/lang/Object;)Z
    //   71: ifeq -> 93
    //   74: iconst_2
    //   75: istore_3
    //   76: goto -> 95
    //   79: aload_1
    //   80: ldc 'android.hardware.usb.action.USB_DEVICE_DETACHED'
    //   82: invokevirtual equals : (Ljava/lang/Object;)Z
    //   85: ifeq -> 93
    //   88: iconst_0
    //   89: istore_3
    //   90: goto -> 95
    //   93: iconst_m1
    //   94: istore_3
    //   95: iload_3
    //   96: tableswitch default -> 128, 0 -> 173, 1 -> 190, 2 -> 143, 3 -> 129
    //   128: return
    //   129: aload_0
    //   130: getfield bft : Lcom/laiqian/main/module/hardware/cardreader/PosActivityCardReaderFragment;
    //   133: aload_2
    //   134: ldc 'extra_card_read_number'
    //   136: invokevirtual getStringExtra : (Ljava/lang/String;)Ljava/lang/String;
    //   139: invokestatic a : (Lcom/laiqian/main/module/hardware/cardreader/PosActivityCardReaderFragment;Ljava/lang/String;)V
    //   142: return
    //   143: aload_2
    //   144: ldc 'device'
    //   146: invokevirtual getParcelableExtra : (Ljava/lang/String;)Landroid/os/Parcelable;
    //   149: checkcast android/hardware/usb/UsbDevice
    //   152: ifnull -> 190
    //   155: aload_2
    //   156: ldc 'permission'
    //   158: iconst_0
    //   159: invokevirtual getBooleanExtra : (Ljava/lang/String;Z)Z
    //   162: ifeq -> 190
    //   165: aload_0
    //   166: getfield bft : Lcom/laiqian/main/module/hardware/cardreader/PosActivityCardReaderFragment;
    //   169: invokestatic a : (Lcom/laiqian/main/module/hardware/cardreader/PosActivityCardReaderFragment;)V
    //   172: return
    //   173: aload_2
    //   174: ldc 'device'
    //   176: invokevirtual getParcelableExtra : (Ljava/lang/String;)Landroid/os/Parcelable;
    //   179: checkcast android/hardware/usb/UsbDevice
    //   182: astore_1
    //   183: aload_0
    //   184: getfield bft : Lcom/laiqian/main/module/hardware/cardreader/PosActivityCardReaderFragment;
    //   187: invokestatic a : (Lcom/laiqian/main/module/hardware/cardreader/PosActivityCardReaderFragment;)V
    //   190: return }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\hardware\cardreader\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */