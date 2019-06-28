package com.laiqian.print.type;

import android.view.View;
import com.laiqian.print.model.type.c.c;

class ab implements View.OnClickListener {
  ab(PrinterEditActivity paramPrinterEditActivity, c paramc, PrinterEditActivity.a.c paramc1) {}
  
  public void onClick(View paramView) { // Byte code:
    //   0: getstatic com/laiqian/print/model/type/c/c.cIj : [I
    //   3: astore_1
    //   4: new java/util/ArrayList
    //   7: dup
    //   8: invokespecial <init> : ()V
    //   11: astore #4
    //   13: aload_1
    //   14: arraylength
    //   15: istore_3
    //   16: iconst_0
    //   17: istore_2
    //   18: iload_2
    //   19: iload_3
    //   20: if_icmpge -> 42
    //   23: aload #4
    //   25: aload_1
    //   26: iload_2
    //   27: iaload
    //   28: invokestatic valueOf : (I)Ljava/lang/String;
    //   31: invokevirtual add : (Ljava/lang/Object;)Z
    //   34: pop
    //   35: iload_2
    //   36: iconst_1
    //   37: iadd
    //   38: istore_2
    //   39: goto -> 18
    //   42: new com/laiqian/ui/a/w
    //   45: dup
    //   46: aload_0
    //   47: getfield cKo : Lcom/laiqian/print/type/PrinterEditActivity;
    //   50: invokevirtual getActivity : ()Lcom/laiqian/ui/ActivityRoot;
    //   53: aload #4
    //   55: iconst_0
    //   56: anewarray java/lang/String
    //   59: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   62: checkcast [Ljava/lang/String;
    //   65: new com/laiqian/print/type/ac
    //   68: dup
    //   69: aload_0
    //   70: aload_1
    //   71: invokespecial <init> : (Lcom/laiqian/print/type/ab;[I)V
    //   74: invokespecial <init> : (Landroid/content/Context;[Ljava/lang/String;Lcom/laiqian/ui/a/w$a;)V
    //   77: invokevirtual show : ()V
    //   80: return }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\print\type\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */