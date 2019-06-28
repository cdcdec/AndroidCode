package com.laiqian.pos.hardware;

import android.view.View;

class m implements View.OnClickListener {
  m(CustomerDisplaySettingActivity paramCustomerDisplaySettingActivity) {}
  
  public void onClick(View paramView) { // Byte code:
    //   0: bipush #10
    //   2: anewarray java/lang/String
    //   5: astore_1
    //   6: iconst_0
    //   7: istore_2
    //   8: aload_1
    //   9: iconst_0
    //   10: ldc '2400'
    //   12: aastore
    //   13: aload_1
    //   14: iconst_1
    //   15: ldc '4800'
    //   17: aastore
    //   18: aload_1
    //   19: iconst_2
    //   20: ldc '9600'
    //   22: aastore
    //   23: aload_1
    //   24: iconst_3
    //   25: ldc '19200'
    //   27: aastore
    //   28: aload_1
    //   29: iconst_4
    //   30: ldc '38400'
    //   32: aastore
    //   33: aload_1
    //   34: iconst_5
    //   35: ldc '57600'
    //   37: aastore
    //   38: aload_1
    //   39: bipush #6
    //   41: ldc '115200'
    //   43: aastore
    //   44: aload_1
    //   45: bipush #7
    //   47: ldc '230400'
    //   49: aastore
    //   50: aload_1
    //   51: bipush #8
    //   53: ldc '460800'
    //   55: aastore
    //   56: aload_1
    //   57: bipush #9
    //   59: ldc '500000'
    //   61: aastore
    //   62: aload_0
    //   63: getfield ckp : Lcom/laiqian/pos/hardware/CustomerDisplaySettingActivity;
    //   66: invokestatic d : (Lcom/laiqian/pos/hardware/CustomerDisplaySettingActivity;)Lcom/laiqian/pos/hardware/CustomerDisplaySettingActivity$a;
    //   69: getfield cky : Lcom/laiqian/ui/container/w;
    //   72: getfield cAP : Lcom/laiqian/ui/container/ab;
    //   75: invokevirtual getView : ()Landroid/view/View;
    //   78: checkcast android/widget/TextView
    //   81: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   84: invokeinterface toString : ()Ljava/lang/String;
    //   89: invokevirtual trim : ()Ljava/lang/String;
    //   92: astore_3
    //   93: iload_2
    //   94: aload_1
    //   95: arraylength
    //   96: if_icmpge -> 119
    //   99: aload_1
    //   100: iload_2
    //   101: aaload
    //   102: aload_3
    //   103: invokevirtual equals : (Ljava/lang/Object;)Z
    //   106: ifeq -> 112
    //   109: goto -> 121
    //   112: iload_2
    //   113: iconst_1
    //   114: iadd
    //   115: istore_2
    //   116: goto -> 93
    //   119: iconst_m1
    //   120: istore_2
    //   121: new com/laiqian/ui/a/w
    //   124: dup
    //   125: aload_0
    //   126: getfield ckp : Lcom/laiqian/pos/hardware/CustomerDisplaySettingActivity;
    //   129: aload_1
    //   130: new com/laiqian/pos/hardware/n
    //   133: dup
    //   134: aload_0
    //   135: aload_1
    //   136: invokespecial <init> : (Lcom/laiqian/pos/hardware/m;[Ljava/lang/String;)V
    //   139: invokespecial <init> : (Landroid/content/Context;[Ljava/lang/String;Lcom/laiqian/ui/a/w$a;)V
    //   142: astore_1
    //   143: aload_1
    //   144: iload_2
    //   145: invokevirtual gn : (I)V
    //   148: aload_1
    //   149: invokevirtual show : ()V
    //   152: return }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hardware\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */