package com.laiqian.main.module.vip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class g extends BroadcastReceiver {
  g(PosActivityVipFragment paramPosActivityVipFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent) { // Byte code:
    //   0: aload_2
    //   1: invokevirtual getAction : ()Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: invokevirtual hashCode : ()I
    //   9: istore_3
    //   10: iload_3
    //   11: ldc 200139552
    //   13: if_icmpeq -> 39
    //   16: iload_3
    //   17: ldc 1429927954
    //   19: if_icmpeq -> 25
    //   22: goto -> 53
    //   25: aload_1
    //   26: ldc 'pos_activity_change_data_vip'
    //   28: invokevirtual equals : (Ljava/lang/Object;)Z
    //   31: ifeq -> 53
    //   34: iconst_0
    //   35: istore_3
    //   36: goto -> 55
    //   39: aload_1
    //   40: ldc 'pos_activity_change_data_vip_online'
    //   42: invokevirtual equals : (Ljava/lang/Object;)Z
    //   45: ifeq -> 53
    //   48: iconst_1
    //   49: istore_3
    //   50: goto -> 55
    //   53: iconst_m1
    //   54: istore_3
    //   55: iload_3
    //   56: tableswitch default -> 80, 0 -> 124, 1 -> 81
    //   80: return
    //   81: aload_0
    //   82: getfield bpm : Lcom/laiqian/main/module/vip/PosActivityVipFragment;
    //   85: iconst_1
    //   86: invokestatic b : (Lcom/laiqian/main/module/vip/PosActivityVipFragment;Z)Z
    //   89: pop
    //   90: aload_0
    //   91: getfield bpm : Lcom/laiqian/main/module/vip/PosActivityVipFragment;
    //   94: invokestatic c : (Lcom/laiqian/main/module/vip/PosActivityVipFragment;)Lcom/laiqian/main/dl;
    //   97: getfield bdM : Lcom/jakewharton/b/b;
    //   100: getstatic com/laiqian/entity/aq.aWG : Lcom/laiqian/entity/aq;
    //   103: invokevirtual accept : (Ljava/lang/Object;)V
    //   106: aload_0
    //   107: getfield bpm : Lcom/laiqian/main/module/vip/PosActivityVipFragment;
    //   110: invokestatic e : (Lcom/laiqian/main/module/vip/PosActivityVipFragment;)Lcom/laiqian/util/ay;
    //   113: aload_0
    //   114: getfield bpm : Lcom/laiqian/main/module/vip/PosActivityVipFragment;
    //   117: invokestatic a : (Lcom/laiqian/main/module/vip/PosActivityVipFragment;)Lcom/laiqian/member/select/PosSelectVipDialog;
    //   120: invokevirtual set : (Ljava/lang/Object;)V
    //   123: return
    //   124: aload_0
    //   125: getfield bpm : Lcom/laiqian/main/module/vip/PosActivityVipFragment;
    //   128: invokevirtual getLifecycle : ()Landroid/arch/lifecycle/g;
    //   131: invokevirtual L : ()Landroid/arch/lifecycle/g$b;
    //   134: getstatic android/arch/lifecycle/g$b.bq : Landroid/arch/lifecycle/g$b;
    //   137: invokevirtual a : (Landroid/arch/lifecycle/g$b;)Z
    //   140: ifeq -> 151
    //   143: aload_0
    //   144: getfield bpm : Lcom/laiqian/main/module/vip/PosActivityVipFragment;
    //   147: invokestatic d : (Lcom/laiqian/main/module/vip/PosActivityVipFragment;)V
    //   150: return
    //   151: aload_0
    //   152: getfield bpm : Lcom/laiqian/main/module/vip/PosActivityVipFragment;
    //   155: iconst_1
    //   156: invokestatic a : (Lcom/laiqian/main/module/vip/PosActivityVipFragment;Z)Z
    //   159: pop
    //   160: return }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\vip\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */