package com.laiqian.main.module.settlement;

import com.laiqian.main.b.c;
import com.laiqian.main.module.settlement.pay.a;
import com.laiqian.main.module.settlement.pay.b;
import com.laiqian.pos.AliPayPreorderDetail;
import io.reactivex.c.m;

class av extends Object implements m<a, c, b, Double, Double, Double, Double, AliPayPreorderDetail> {
  av(ag paramag) {}
  
  public AliPayPreorderDetail a(a parama, c paramc, b paramb, Double paramDouble1, Double paramDouble2, Double paramDouble3, Double paramDouble4) throws Exception { // Byte code:
    //   0: getstatic com/laiqian/pos/AliPayPreorderDetail.ceT : Lcom/laiqian/pos/AliPayPreorderDetail;
    //   3: astore #10
    //   5: aload_1
    //   6: invokevirtual OQ : ()Z
    //   9: ifne -> 19
    //   12: aload_1
    //   13: invokevirtual OP : ()Lcom/laiqian/main/module/settlement/pay/a$e;
    //   16: ifnull -> 539
    //   19: invokestatic Ou : ()Ljava/lang/String;
    //   22: ldc '扫码框回调 生成订单prepareAlipayPreorder '
    //   24: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   27: pop
    //   28: iconst_m1
    //   29: istore #9
    //   31: aload_2
    //   32: getfield aTe : J
    //   35: ldc2_w 8
    //   38: lcmp
    //   39: ifeq -> 108
    //   42: aload_3
    //   43: invokevirtual OT : ()Lcom/laiqian/main/b/b;
    //   46: ifnull -> 65
    //   49: aload_3
    //   50: invokevirtual OT : ()Lcom/laiqian/main/b/b;
    //   53: getfield aTv : I
    //   56: sipush #10009
    //   59: if_icmpne -> 65
    //   62: goto -> 108
    //   65: aload_2
    //   66: getfield aTe : J
    //   69: lconst_0
    //   70: lcmp
    //   71: ifeq -> 102
    //   74: iload #9
    //   76: istore #8
    //   78: aload_3
    //   79: invokevirtual OT : ()Lcom/laiqian/main/b/b;
    //   82: ifnull -> 111
    //   85: iload #9
    //   87: istore #8
    //   89: aload_3
    //   90: invokevirtual OT : ()Lcom/laiqian/main/b/b;
    //   93: getfield aTv : I
    //   96: sipush #10007
    //   99: if_icmpne -> 111
    //   102: iconst_1
    //   103: istore #8
    //   105: goto -> 111
    //   108: iconst_2
    //   109: istore #8
    //   111: new com/laiqian/pos/AliPayPreorderDetail
    //   114: dup
    //   115: invokespecial <init> : ()V
    //   118: astore #10
    //   120: aload #10
    //   122: new java/util/Date
    //   125: dup
    //   126: invokespecial <init> : ()V
    //   129: putfield bkf : Ljava/util/Date;
    //   132: aload #10
    //   134: aload #4
    //   136: invokestatic aU : (Ljava/lang/Object;)D
    //   139: putfield ceZ : D
    //   142: aload #10
    //   144: aload #5
    //   146: invokestatic aU : (Ljava/lang/Object;)D
    //   149: putfield aJW : D
    //   152: aload #10
    //   154: aload #6
    //   156: invokevirtual doubleValue : ()D
    //   159: aload #10
    //   161: getfield aJW : D
    //   164: dsub
    //   165: invokestatic valueOf : (D)Ljava/lang/Double;
    //   168: putfield ceX : Ljava/lang/Double;
    //   171: aload #10
    //   173: iload #8
    //   175: putfield type : I
    //   178: aload #10
    //   180: getfield bbS : Ljava/util/ArrayList;
    //   183: aload_0
    //   184: getfield bnl : Lcom/laiqian/main/module/settlement/ag;
    //   187: aload_2
    //   188: aload #4
    //   190: invokevirtual toString : ()Ljava/lang/String;
    //   193: invokestatic aU : (Ljava/lang/Object;)D
    //   196: invokestatic a : (Lcom/laiqian/main/module/settlement/ag;Lcom/laiqian/main/b/c;D)Lcom/laiqian/main/b/b;
    //   199: invokevirtual add : (Ljava/lang/Object;)Z
    //   202: pop
    //   203: aload_3
    //   204: invokevirtual OT : ()Lcom/laiqian/main/b/b;
    //   207: astore_1
    //   208: aload_1
    //   209: ifnull -> 246
    //   212: aload #7
    //   214: invokevirtual doubleValue : ()D
    //   217: dconst_0
    //   218: dcmpl
    //   219: ifeq -> 246
    //   222: new com/laiqian/entity/z
    //   225: dup
    //   226: aload_1
    //   227: aload #7
    //   229: invokevirtual doubleValue : ()D
    //   232: invokespecial <init> : (Lcom/laiqian/entity/z;D)V
    //   235: astore_1
    //   236: aload #10
    //   238: getfield bbS : Ljava/util/ArrayList;
    //   241: aload_1
    //   242: invokevirtual add : (Ljava/lang/Object;)Z
    //   245: pop
    //   246: aload_0
    //   247: getfield bnl : Lcom/laiqian/main/module/settlement/ag;
    //   250: getfield bng : Lcom/jakewharton/b/b;
    //   253: invokevirtual getValue : ()Ljava/lang/Object;
    //   256: checkcast java/lang/Long
    //   259: invokevirtual longValue : ()J
    //   262: lconst_0
    //   263: lcmp
    //   264: ifeq -> 313
    //   267: aload_0
    //   268: getfield bnl : Lcom/laiqian/main/module/settlement/ag;
    //   271: getfield bng : Lcom/jakewharton/b/b;
    //   274: invokevirtual getValue : ()Ljava/lang/Object;
    //   277: checkcast java/lang/Long
    //   280: invokevirtual toString : ()Ljava/lang/String;
    //   283: invokevirtual length : ()I
    //   286: ifle -> 313
    //   289: aload #10
    //   291: aload_0
    //   292: getfield bnl : Lcom/laiqian/main/module/settlement/ag;
    //   295: getfield bng : Lcom/jakewharton/b/b;
    //   298: invokevirtual getValue : ()Ljava/lang/Object;
    //   301: checkcast java/lang/Long
    //   304: invokevirtual longValue : ()J
    //   307: invokestatic valueOf : (J)Ljava/lang/Long;
    //   310: putfield ceW : Ljava/lang/Long;
    //   313: aload #10
    //   315: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   318: invokevirtual Ea : ()Ljava/lang/String;
    //   321: putfield ceV : Ljava/lang/String;
    //   324: aload_0
    //   325: getfield bnl : Lcom/laiqian/main/module/settlement/ag;
    //   328: getfield blR : Lcom/laiqian/main/dl;
    //   331: getfield bea : Lcom/laiqian/main/dl$e;
    //   334: getfield beO : Lcom/laiqian/rx/util/a;
    //   337: invokevirtual aoL : ()Ljava/util/List;
    //   340: invokeinterface iterator : ()Ljava/util/Iterator;
    //   345: astore_3
    //   346: aload_3
    //   347: invokeinterface hasNext : ()Z
    //   352: ifeq -> 533
    //   355: aload_3
    //   356: invokeinterface next : ()Ljava/lang/Object;
    //   361: checkcast com/laiqian/entity/aa
    //   364: astore #4
    //   366: new java/util/HashMap
    //   369: dup
    //   370: invokespecial <init> : ()V
    //   373: astore #5
    //   375: aload #4
    //   377: getfield name : Ljava/lang/String;
    //   380: astore_2
    //   381: aload #4
    //   383: invokevirtual GL : ()Ljava/util/ArrayList;
    //   386: astore #6
    //   388: aload_2
    //   389: astore_1
    //   390: aload #6
    //   392: invokevirtual size : ()I
    //   395: ifeq -> 442
    //   398: new java/lang/StringBuilder
    //   401: dup
    //   402: invokespecial <init> : ()V
    //   405: astore_1
    //   406: aload_1
    //   407: aload_2
    //   408: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload_1
    //   413: ldc '['
    //   415: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload_1
    //   420: aconst_null
    //   421: aload #6
    //   423: invokestatic a : (Ljava/lang/StringBuilder;Ljava/util/ArrayList;)Ljava/lang/StringBuilder;
    //   426: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload_1
    //   431: ldc ']'
    //   433: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload_1
    //   438: invokevirtual toString : ()Ljava/lang/String;
    //   441: astore_1
    //   442: aload #5
    //   444: ldc 'sProductName'
    //   446: aload_1
    //   447: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   450: pop
    //   451: aload #5
    //   453: ldc 'nProductQty'
    //   455: aload #4
    //   457: invokevirtual Gw : ()D
    //   460: iconst_3
    //   461: invokestatic e : (DI)Ljava/lang/String;
    //   464: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   467: pop
    //   468: aload #5
    //   470: ldc_w 'fPrice'
    //   473: aload #4
    //   475: invokevirtual GA : ()D
    //   478: invokestatic ba : (D)Ljava/lang/String;
    //   481: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   484: pop
    //   485: aload #5
    //   487: ldc_w 'fAmount'
    //   490: aload #4
    //   492: invokevirtual AO : ()D
    //   495: invokestatic ba : (D)Ljava/lang/String;
    //   498: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   501: pop
    //   502: aload #5
    //   504: ldc_w 'fOriginalPrice'
    //   507: aload #4
    //   509: invokevirtual GA : ()D
    //   512: invokestatic ba : (D)Ljava/lang/String;
    //   515: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   518: pop
    //   519: aload #10
    //   521: getfield bJf : Ljava/util/ArrayList;
    //   524: aload #5
    //   526: invokevirtual add : (Ljava/lang/Object;)Z
    //   529: pop
    //   530: goto -> 346
    //   533: aload #10
    //   535: aconst_null
    //   536: putfield ceY : Landroid/graphics/Bitmap;
    //   539: aload #10
    //   541: areturn }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes-dex2jar.jar!\com\laiqian\main\module\settlement\av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */