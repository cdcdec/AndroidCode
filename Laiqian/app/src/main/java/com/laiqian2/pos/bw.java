package com.laiqian.pos;

import android.os.Handler;
import android.os.Message;

class bw extends Handler {
  bw(ProductPictureManagementActivity paramProductPictureManagementActivity) {}
  
  public void handleMessage(Message paramMessage) { // Byte code:
    //   0: aload_1
    //   1: getfield obj : Ljava/lang/Object;
    //   4: checkcast com/laiqian/pos/ProductPictureManagementActivity$a$a
    //   7: astore #6
    //   9: aload_1
    //   10: getfield what : I
    //   13: istore_2
    //   14: iload_2
    //   15: iconst_m1
    //   16: if_icmpeq -> 261
    //   19: iload_2
    //   20: iconst_1
    //   21: if_icmpeq -> 77
    //   24: aload_0
    //   25: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
    //   28: aload_0
    //   29: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
    //   32: getstatic com/laiqian/infrastructure/R$string.wechat_product_photo_upload_fail : I
    //   35: invokevirtual getString : (I)Ljava/lang/String;
    //   38: iconst_0
    //   39: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   42: invokevirtual show : ()V
    //   45: aload #6
    //   47: getfield chK : Lcom/laiqian/ui/ProgressBarCircularIndeterminate;
    //   50: bipush #8
    //   52: invokevirtual setVisibility : (I)V
    //   55: aload #6
    //   57: getfield chI : Landroid/widget/TextView;
    //   60: iconst_0
    //   61: invokevirtual setVisibility : (I)V
    //   64: aload #6
    //   66: getfield chJ : Landroid/widget/ImageView;
    //   69: bipush #8
    //   71: invokevirtual setVisibility : (I)V
    //   74: goto -> 311
    //   77: new com/laiqian/product/models/g
    //   80: dup
    //   81: aload_0
    //   82: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
    //   85: invokespecial <init> : (Landroid/content/Context;)V
    //   88: astore #5
    //   90: aload_0
    //   91: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
    //   94: getfield chu : Ljava/lang/String;
    //   97: ifnull -> 224
    //   100: aload #5
    //   102: ifnull -> 224
    //   105: aload_0
    //   106: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
    //   109: getfield chu : Ljava/lang/String;
    //   112: invokestatic parseLong : (Ljava/lang/String;)J
    //   115: lstore_3
    //   116: new java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial <init> : ()V
    //   123: astore #7
    //   125: aload #7
    //   127: getstatic com/laiqian/pos/hardware/RootUrlParameter.cll : Ljava/lang/String;
    //   130: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload #7
    //   136: aload_0
    //   137: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
    //   140: getfield chv : Ljava/lang/String;
    //   143: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload #5
    //   149: lload_3
    //   150: aload #7
    //   152: invokevirtual toString : ()Ljava/lang/String;
    //   155: invokevirtual y : (JLjava/lang/String;)Z
    //   158: ifeq -> 224
    //   161: aload_0
    //   162: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
    //   165: invokevirtual getActivity : ()Lcom/laiqian/ui/ActivityRoot;
    //   168: invokestatic cx : (Landroid/content/Context;)Lcom/squareup/a/ab;
    //   171: astore #6
    //   173: new java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial <init> : ()V
    //   180: astore #7
    //   182: aload #7
    //   184: getstatic com/laiqian/pos/hardware/RootUrlParameter.cll : Ljava/lang/String;
    //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload #7
    //   193: aload_0
    //   194: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
    //   197: getfield chv : Ljava/lang/String;
    //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload #6
    //   206: aload #7
    //   208: invokevirtual toString : ()Ljava/lang/String;
    //   211: invokevirtual sX : (Ljava/lang/String;)V
    //   214: aload_0
    //   215: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
    //   218: invokestatic m : (Lcom/laiqian/pos/ProductPictureManagementActivity;)V
    //   221: goto -> 253
    //   224: aload #6
    //   226: getfield chK : Lcom/laiqian/ui/ProgressBarCircularIndeterminate;
    //   229: bipush #8
    //   231: invokevirtual setVisibility : (I)V
    //   234: aload #6
    //   236: getfield chI : Landroid/widget/TextView;
    //   239: iconst_0
    //   240: invokevirtual setVisibility : (I)V
    //   243: aload #6
    //   245: getfield chJ : Landroid/widget/ImageView;
    //   248: bipush #8
    //   250: invokevirtual setVisibility : (I)V
    //   253: aload #5
    //   255: invokevirtual close : ()V
    //   258: goto -> 311
    //   261: aload_0
    //   262: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
    //   265: aload_0
    //   266: getfield chz : Lcom/laiqian/pos/ProductPictureManagementActivity;
    //   269: getstatic com/laiqian/infrastructure/R$string.wechat_product_photo_upload_fail_network : I
    //   272: invokevirtual getString : (I)Ljava/lang/String;
    //   275: iconst_0
    //   276: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   279: invokevirtual show : ()V
    //   282: aload #6
    //   284: getfield chK : Lcom/laiqian/ui/ProgressBarCircularIndeterminate;
    //   287: bipush #8
    //   289: invokevirtual setVisibility : (I)V
    //   292: aload #6
    //   294: getfield chI : Landroid/widget/TextView;
    //   297: iconst_0
    //   298: invokevirtual setVisibility : (I)V
    //   301: aload #6
    //   303: getfield chJ : Landroid/widget/ImageView;
    //   306: bipush #8
    //   308: invokevirtual setVisibility : (I)V
    //   311: aload_0
    //   312: aload_1
    //   313: invokespecial handleMessage : (Landroid/os/Message;)V
    //   316: return }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\pos\bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */