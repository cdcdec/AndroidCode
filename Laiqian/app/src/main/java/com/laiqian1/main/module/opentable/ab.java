package com.laiqian.main.module.opentable;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ab extends BroadcastReceiver {
  ab(PosActivityOpenTableFragment paramPosActivityOpenTableFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) { // Byte code:
    //   0: aload_2
    //   1: invokevirtual getAction : ()Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: invokevirtual hashCode : ()I
    //   9: istore_3
    //   10: iload_3
    //   11: ldc -1941033034
    //   13: if_icmpeq -> 79
    //   16: iload_3
    //   17: ldc -343630553
    //   19: if_icmpeq -> 65
    //   22: iload_3
    //   23: ldc 819614115
    //   25: if_icmpeq -> 51
    //   28: iload_3
    //   29: ldc 1377476408
    //   31: if_icmpeq -> 37
    //   34: goto -> 93
    //   37: aload_1
    //   38: ldc 'pos_activity_change_data_area'
    //   40: invokevirtual equals : (Ljava/lang/Object;)Z
    //   43: ifeq -> 93
    //   46: iconst_0
    //   47: istore_3
    //   48: goto -> 95
    //   51: aload_1
    //   52: ldc 'pos_activity_network_resume'
    //   54: invokevirtual equals : (Ljava/lang/Object;)Z
    //   57: ifeq -> 93
    //   60: iconst_3
    //   61: istore_3
    //   62: goto -> 95
    //   65: aload_1
    //   66: ldc 'android.net.wifi.STATE_CHANGE'
    //   68: invokevirtual equals : (Ljava/lang/Object;)Z
    //   71: ifeq -> 93
    //   74: iconst_1
    //   75: istore_3
    //   76: goto -> 95
    //   79: aload_1
    //   80: ldc 'pos_activity_network_disconnection'
    //   82: invokevirtual equals : (Ljava/lang/Object;)Z
    //   85: ifeq -> 93
    //   88: iconst_2
    //   89: istore_3
    //   90: goto -> 95
    //   93: iconst_m1
    //   94: istore_3
    //   95: iload_3
    //   96: tableswitch default -> 128, 0 -> 171, 1 -> 163, 2 -> 146, 3 -> 129
    //   128: return
    //   129: aload_0
    //   130: getfield bhq : Lcom/laiqian/main/module/opentable/PosActivityOpenTableFragment;
    //   133: invokestatic m : (Lcom/laiqian/main/module/opentable/PosActivityOpenTableFragment;)Lcom/laiqian/util/ay;
    //   136: invokevirtual get : ()Ljava/lang/Object;
    //   139: checkcast com/laiqian/opentable/common/b/c
    //   142: invokevirtual dismiss : ()V
    //   145: return
    //   146: aload_0
    //   147: getfield bhq : Lcom/laiqian/main/module/opentable/PosActivityOpenTableFragment;
    //   150: invokestatic m : (Lcom/laiqian/main/module/opentable/PosActivityOpenTableFragment;)Lcom/laiqian/util/ay;
    //   153: invokevirtual get : ()Ljava/lang/Object;
    //   156: checkcast com/laiqian/opentable/common/b/c
    //   159: invokevirtual show : ()V
    //   162: return
    //   163: aload_0
    //   164: getfield bhq : Lcom/laiqian/main/module/opentable/PosActivityOpenTableFragment;
    //   167: invokestatic l : (Lcom/laiqian/main/module/opentable/PosActivityOpenTableFragment;)V
    //   170: return
    //   171: aload_0
    //   172: getfield bhq : Lcom/laiqian/main/module/opentable/PosActivityOpenTableFragment;
    //   175: invokestatic k : (Lcom/laiqian/main/module/opentable/PosActivityOpenTableFragment;)Lcom/laiqian/main/module/opentable/PosActivityOpenTableFragment$e;
    //   178: getfield biB : Lcom/jakewharton/b/b;
    //   181: invokevirtual getValue : ()Ljava/lang/Object;
    //   184: checkcast java/lang/Boolean
    //   187: invokevirtual booleanValue : ()Z
    //   190: ifne -> 210
    //   193: aload_0
    //   194: getfield bhq : Lcom/laiqian/main/module/opentable/PosActivityOpenTableFragment;
    //   197: invokestatic k : (Lcom/laiqian/main/module/opentable/PosActivityOpenTableFragment;)Lcom/laiqian/main/module/opentable/PosActivityOpenTableFragment$e;
    //   200: getfield biB : Lcom/jakewharton/b/b;
    //   203: iconst_1
    //   204: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   207: invokevirtual accept : (Ljava/lang/Object;)V
    //   210: return }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\opentable\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */