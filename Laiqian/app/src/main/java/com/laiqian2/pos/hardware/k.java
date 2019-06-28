package com.laiqian.pos.hardware;

import android.view.View;

class k implements View.OnClickListener {
  k(CustomerDisplaySettingActivity paramCustomerDisplaySettingActivity) {}
  
  public void onClick(View paramView) { // Byte code:
    //   0: new me/raid/libserialport/serialport/SerialPortFinder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: invokevirtual getAllDevicesPath : ()[Ljava/lang/String;
    //   10: astore_1
    //   11: aload_0
    //   12: getfield ckp : Lcom/laiqian/pos/hardware/CustomerDisplaySettingActivity;
    //   15: invokestatic d : (Lcom/laiqian/pos/hardware/CustomerDisplaySettingActivity;)Lcom/laiqian/pos/hardware/CustomerDisplaySettingActivity$a;
    //   18: getfield ckx : Lcom/laiqian/ui/container/w;
    //   21: getfield cAP : Lcom/laiqian/ui/container/ab;
    //   24: invokevirtual getView : ()Landroid/view/View;
    //   27: checkcast android/widget/TextView
    //   30: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   33: invokeinterface toString : ()Ljava/lang/String;
    //   38: invokevirtual trim : ()Ljava/lang/String;
    //   41: astore_3
    //   42: iconst_0
    //   43: istore_2
    //   44: iload_2
    //   45: aload_1
    //   46: arraylength
    //   47: if_icmpge -> 70
    //   50: aload_1
    //   51: iload_2
    //   52: aaload
    //   53: aload_3
    //   54: invokevirtual equals : (Ljava/lang/Object;)Z
    //   57: ifeq -> 63
    //   60: goto -> 72
    //   63: iload_2
    //   64: iconst_1
    //   65: iadd
    //   66: istore_2
    //   67: goto -> 44
    //   70: iconst_m1
    //   71: istore_2
    //   72: new com/laiqian/ui/a/w
    //   75: dup
    //   76: aload_0
    //   77: getfield ckp : Lcom/laiqian/pos/hardware/CustomerDisplaySettingActivity;
    //   80: aload_1
    //   81: new com/laiqian/pos/hardware/l
    //   84: dup
    //   85: aload_0
    //   86: aload_1
    //   87: invokespecial <init> : (Lcom/laiqian/pos/hardware/k;[Ljava/lang/String;)V
    //   90: invokespecial <init> : (Landroid/content/Context;[Ljava/lang/String;Lcom/laiqian/ui/a/w$a;)V
    //   93: astore_1
    //   94: aload_1
    //   95: iload_2
    //   96: invokevirtual gn : (I)V
    //   99: aload_1
    //   100: invokevirtual show : ()V
    //   103: return }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\hardware\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */