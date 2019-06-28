package com.laiqian.print.model.type.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class e extends BroadcastReceiver {
  e(d paramd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) { // Byte code:
    //   0: aload_2
    //   1: invokevirtual getAction : ()Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: invokevirtual hashCode : ()I
    //   9: istore_3
    //   10: iload_3
    //   11: ldc -1780914469
    //   13: if_icmpeq -> 59
    //   16: iload_3
    //   17: ldc 6759640
    //   19: if_icmpeq -> 45
    //   22: iload_3
    //   23: ldc 1167529923
    //   25: if_icmpeq -> 31
    //   28: goto -> 73
    //   31: aload_1
    //   32: ldc 'android.bluetooth.device.action.FOUND'
    //   34: invokevirtual equals : (Ljava/lang/Object;)Z
    //   37: ifeq -> 73
    //   40: iconst_2
    //   41: istore_3
    //   42: goto -> 75
    //   45: aload_1
    //   46: ldc 'android.bluetooth.adapter.action.DISCOVERY_STARTED'
    //   48: invokevirtual equals : (Ljava/lang/Object;)Z
    //   51: ifeq -> 73
    //   54: iconst_0
    //   55: istore_3
    //   56: goto -> 75
    //   59: aload_1
    //   60: ldc 'android.bluetooth.adapter.action.DISCOVERY_FINISHED'
    //   62: invokevirtual equals : (Ljava/lang/Object;)Z
    //   65: ifeq -> 73
    //   68: iconst_1
    //   69: istore_3
    //   70: goto -> 75
    //   73: iconst_m1
    //   74: istore_3
    //   75: iload_3
    //   76: tableswitch default -> 104, 0 -> 173, 1 -> 165, 2 -> 105
    //   104: return
    //   105: aload_2
    //   106: ldc 'android.bluetooth.device.extra.DEVICE'
    //   108: invokevirtual getParcelableExtra : (Ljava/lang/String;)Landroid/os/Parcelable;
    //   111: checkcast android/bluetooth/BluetoothDevice
    //   114: astore_1
    //   115: invokestatic Un : ()Ljava/lang/String;
    //   118: aload_1
    //   119: invokestatic d : (Landroid/bluetooth/BluetoothDevice;)Ljava/lang/String;
    //   122: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   125: pop
    //   126: aload_1
    //   127: invokestatic a : (Landroid/bluetooth/BluetoothDevice;)Lcom/laiqian/print/model/type/a/f;
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull -> 180
    //   135: aload_0
    //   136: getfield cHL : Lcom/laiqian/print/model/type/a/d;
    //   139: aload_1
    //   140: invokestatic a : (Lcom/laiqian/print/model/type/a/d;Landroid/bluetooth/BluetoothDevice;)Z
    //   143: ifne -> 180
    //   146: aload_0
    //   147: getfield cHL : Lcom/laiqian/print/model/type/a/d;
    //   150: aload_0
    //   151: getfield cHL : Lcom/laiqian/print/model/type/a/d;
    //   154: invokestatic b : (Lcom/laiqian/print/model/type/a/d;)Lcom/laiqian/print/model/g;
    //   157: aload_2
    //   158: invokevirtual f : (Lcom/laiqian/print/model/s;)Lcom/laiqian/print/model/q;
    //   161: invokestatic a : (Lcom/laiqian/print/model/type/a/d;Lcom/laiqian/print/model/q;)V
    //   164: return
    //   165: aload_0
    //   166: getfield cHL : Lcom/laiqian/print/model/type/a/d;
    //   169: invokevirtual afa : ()V
    //   172: return
    //   173: aload_0
    //   174: getfield cHL : Lcom/laiqian/print/model/type/a/d;
    //   177: invokestatic a : (Lcom/laiqian/print/model/type/a/d;)V
    //   180: return }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\model\type\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */