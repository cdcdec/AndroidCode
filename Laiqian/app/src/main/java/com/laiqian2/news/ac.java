package com.laiqian.news;

import com.laiqian.network.i;
import com.laiqian.pos.hold.PendingFullOrderDetail;

class ac implements y.a.a {
  ac(ab paramab, PendingFullOrderDetail paramPendingFullOrderDetail) {}
  
  public void a(i parami) { // Byte code:
    //   0: ldc 'autoConfirm'
    //   2: aload_1
    //   3: getfield message : Ljava/lang/String;
    //   6: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_1
    //   11: getfield bUi : Z
    //   14: ifeq -> 71
    //   17: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   20: invokevirtual zC : ()Lcom/laiqian/pos/hardware/a/b;
    //   23: ldc2_w 3
    //   26: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   29: invokevirtual c : (JLjava/util/concurrent/TimeUnit;)V
    //   32: aload_0
    //   33: getfield bXu : Lcom/laiqian/pos/hold/PendingFullOrderDetail;
    //   36: ifnull -> 50
    //   39: aload_0
    //   40: getfield bXu : Lcom/laiqian/pos/hold/PendingFullOrderDetail;
    //   43: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   46: iconst_1
    //   47: putfield cpb : I
    //   50: aload_0
    //   51: getfield bXv : Lcom/laiqian/news/ab;
    //   54: getfield bXt : Lcom/laiqian/news/aa$a;
    //   57: getfield bXs : Lcom/laiqian/news/aa;
    //   60: invokestatic a : (Lcom/laiqian/news/aa;)Landroid/content/Context;
    //   63: aload_0
    //   64: getfield bXu : Lcom/laiqian/pos/hold/PendingFullOrderDetail;
    //   67: iconst_1
    //   68: invokestatic a : (Landroid/content/Context;Lcom/laiqian/pos/hold/PendingFullOrderDetail;Z)V
    //   71: return }
  
  public void onPreExecute() {}
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\news\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */