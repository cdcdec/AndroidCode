package com.laiqian.ordertool.c;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import com.google.a.a.a.a.a.a;
import com.laiqian.basic.RootApplication;
import com.laiqian.db.b;
import com.laiqian.dcb.api.a.b;
import com.laiqian.dcb.api.b.c;
import com.laiqian.dcb.api.b.e;
import com.laiqian.dcb.api.b.j;
import com.laiqian.dcb.api.b.k;
import com.laiqian.dcb.api.server.ServerService;
import com.laiqian.dcb.api.server.a;
import com.laiqian.dcb.api.server.a.c;
import com.laiqian.f.b;
import com.laiqian.f.e;
import com.laiqian.models.p;
import com.laiqian.opentable.c;
import com.laiqian.opentable.common.a.ac;
import com.laiqian.opentable.common.b;
import com.laiqian.opentable.common.entity.TableEntity;
import com.laiqian.opentable.common.entity.c;
import com.laiqian.ordertool.a.a;
import com.laiqian.util.av;
import com.laiqian.util.by;
import io.netty.channel.n;
import org.json.JSONException;
import org.json.JSONObject;

class h implements a {
  private void b(Context paramContext, String paramString, int paramInt, long paramLong) {
    p p = new p(paramContext);
    p.a(paramLong, paramString, paramInt, 0L);
    p.close();
  }
  
  public int a(String paramString, boolean paramBoolean, Context paramContext, n paramn, int paramInt, a parama, b paramb, StringBuffer paramStringBuffer) { // Byte code:
    //   0: new org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial <init> : (Ljava/lang/String;)V
    //   8: astore #6
    //   10: ldc '2'
    //   12: aload #7
    //   14: invokevirtual DP : ()J
    //   17: aload #6
    //   19: invokestatic a : (Ljava/lang/String;JLorg/json/JSONObject;)Lorg/json/JSONObject;
    //   22: astore #18
    //   24: aload #18
    //   26: ldc 'type'
    //   28: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   31: pop
    //   32: new org/json/JSONObject
    //   35: dup
    //   36: aload #18
    //   38: ldc 'header'
    //   40: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   43: ldc '\'
    //   45: ldc ''
    //   47: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   50: invokespecial <init> : (Ljava/lang/String;)V
    //   53: astore #6
    //   55: aload #18
    //   57: ldc 'should_print_receipt'
    //   59: iconst_1
    //   60: invokevirtual optBoolean : (Ljava/lang/String;Z)Z
    //   63: istore #14
    //   65: aload #6
    //   67: ldc 'order_status'
    //   69: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   72: astore #19
    //   74: aload #6
    //   76: ldc 'machine_type'
    //   78: invokevirtual optInt : (Ljava/lang/String;)I
    //   81: pop
    //   82: aload #6
    //   84: ldc 'table_id'
    //   86: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   89: pop
    //   90: aload #19
    //   92: ldc '0'
    //   94: invokevirtual equals : (Ljava/lang/Object;)Z
    //   97: ifeq -> 744
    //   100: aload_1
    //   101: invokestatic iY : (Ljava/lang/String;)Lcom/laiqian/pos/hold/PendingFullOrderDetail;
    //   104: astore #20
    //   106: aload #20
    //   108: ifnull -> 1071
    //   111: new java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial <init> : ()V
    //   118: astore #17
    //   120: aload #17
    //   122: ldc '智能点菜局域网下单，订单号：'
    //   124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload #17
    //   130: aload #20
    //   132: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   135: getfield orderNo : Ljava/lang/String;
    //   138: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload #17
    //   144: ldc '\\n接收订单\\ndata: '
    //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload #17
    //   152: aload_1
    //   153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload #17
    //   159: invokevirtual toString : ()Ljava/lang/String;
    //   162: astore #17
    //   164: aload #17
    //   166: invokestatic je : (Ljava/lang/String;)V
    //   169: aload #20
    //   171: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   174: astore #21
    //   176: new java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial <init> : ()V
    //   183: astore #22
    //   185: aload #22
    //   187: aload #20
    //   189: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   192: getfield aEI : J
    //   195: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload #22
    //   201: ldc ''
    //   203: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload #21
    //   209: aload #22
    //   211: invokevirtual toString : ()Ljava/lang/String;
    //   214: putfield coK : Ljava/lang/String;
    //   217: new com/laiqian/pos/model/a
    //   220: dup
    //   221: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   224: invokespecial <init> : (Landroid/content/Context;)V
    //   227: astore #21
    //   229: new com/laiqian/opentable/b/q
    //   232: dup
    //   233: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   236: invokespecial <init> : (Landroid/content/Context;)V
    //   239: astore #22
    //   241: aload #21
    //   243: invokevirtual beginTransaction : ()V
    //   246: aload #22
    //   248: aload #20
    //   250: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   253: getfield coJ : Ljava/lang/String;
    //   256: invokestatic parseLong : (Ljava/lang/String;)J
    //   259: invokevirtual ck : (J)Lcom/laiqian/opentable/common/entity/TableEntity;
    //   262: astore #23
    //   264: aload #20
    //   266: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   269: getfield coM : I
    //   272: istore #9
    //   274: aload #20
    //   276: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   279: getfield orderNo : Ljava/lang/String;
    //   282: astore #24
    //   284: aload #20
    //   286: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   289: getfield coE : Ljava/util/Date;
    //   292: invokevirtual getTime : ()J
    //   295: lstore #15
    //   297: aload #20
    //   299: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   302: getfield bZM : I
    //   305: istore #10
    //   307: aload #20
    //   309: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   312: getfield cpd : I
    //   315: istore #11
    //   317: aload #23
    //   319: new com/laiqian/opentable/common/entity/c
    //   322: dup
    //   323: iload #9
    //   325: aload #24
    //   327: lload #15
    //   329: iload #10
    //   331: iload #11
    //   333: aload #20
    //   335: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   338: getfield coJ : Ljava/lang/String;
    //   341: invokestatic parseLong : (Ljava/lang/String;)J
    //   344: invokespecial <init> : (ILjava/lang/String;JIIJ)V
    //   347: invokevirtual c : (Lcom/laiqian/opentable/common/entity/c;)V
    //   350: aload #23
    //   352: iconst_2
    //   353: invokevirtual setState : (I)V
    //   356: aload #23
    //   358: aload #20
    //   360: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   363: getfield coE : Ljava/util/Date;
    //   366: invokevirtual getTime : ()J
    //   369: invokevirtual cf : (J)V
    //   372: aload #23
    //   374: invokevirtual getID : ()J
    //   377: aload #23
    //   379: invokevirtual Yg : ()Lcom/laiqian/opentable/common/entity/c;
    //   382: invokestatic a : (JLcom/laiqian/opentable/common/entity/c;)Lcom/laiqian/opentable/common/b/b;
    //   385: astore #24
    //   387: aload #24
    //   389: getfield bUi : Z
    //   392: ifeq -> 405
    //   395: aload #24
    //   397: getfield message : Ljava/lang/String;
    //   400: astore #6
    //   402: goto -> 464
    //   405: aload #24
    //   407: getfield bUi : Z
    //   410: ifne -> 540
    //   413: aload #24
    //   415: getfield cay : I
    //   418: ifle -> 540
    //   421: aload #6
    //   423: ldc 'number_id'
    //   425: aload #24
    //   427: getfield cay : I
    //   430: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   433: pop
    //   434: aload #20
    //   436: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   439: aload #24
    //   441: getfield cay : I
    //   444: putfield coM : I
    //   447: aload #18
    //   449: ldc 'header'
    //   451: aload #6
    //   453: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   456: pop
    //   457: aload #24
    //   459: getfield message : Ljava/lang/String;
    //   462: astore #6
    //   464: aload #22
    //   466: aload #23
    //   468: iconst_3
    //   469: aload #6
    //   471: invokevirtual a : (Lcom/laiqian/opentable/common/entity/TableEntity;ILjava/lang/String;)Z
    //   474: istore #13
    //   476: iload #13
    //   478: istore #12
    //   480: iload #13
    //   482: ifeq -> 508
    //   485: aload #21
    //   487: aload #20
    //   489: aload #20
    //   491: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   494: getfield coE : Ljava/util/Date;
    //   497: invokevirtual getTime : ()J
    //   500: invokevirtual a : (Lcom/laiqian/pos/hold/PendingFullOrderDetail;J)Z
    //   503: istore #12
    //   505: goto -> 508
    //   508: iload #12
    //   510: ifeq -> 522
    //   513: iload #12
    //   515: istore #13
    //   517: aload #21
    //   519: invokevirtual setTransactionSuccessful : ()V
    //   522: aload #21
    //   524: invokevirtual endTransaction : ()V
    //   527: aload #22
    //   529: invokevirtual close : ()V
    //   532: aload #21
    //   534: invokevirtual close : ()V
    //   537: goto -> 594
    //   540: aload #21
    //   542: invokevirtual endTransaction : ()V
    //   545: aload #22
    //   547: invokevirtual close : ()V
    //   550: aload #21
    //   552: invokevirtual close : ()V
    //   555: bipush #-2
    //   557: ireturn
    //   558: astore #6
    //   560: goto -> 569
    //   563: astore_1
    //   564: goto -> 727
    //   567: astore #6
    //   569: iconst_0
    //   570: istore #13
    //   572: aload #6
    //   574: invokestatic e : (Ljava/lang/Throwable;)V
    //   577: aload #21
    //   579: invokevirtual endTransaction : ()V
    //   582: aload #22
    //   584: invokevirtual close : ()V
    //   587: iload #13
    //   589: istore #12
    //   591: goto -> 532
    //   594: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   597: astore #6
    //   599: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   602: invokevirtual Bk : ()Z
    //   605: ifeq -> 1043
    //   608: invokestatic zR : ()Lcom/laiqian/c/a;
    //   611: invokevirtual Af : ()Z
    //   614: ifne -> 1043
    //   617: iconst_1
    //   618: istore #13
    //   620: goto -> 623
    //   623: aload #6
    //   625: aload #20
    //   627: iload #13
    //   629: iload #14
    //   631: invokestatic a : (Landroid/content/Context;Lcom/laiqian/pos/hold/PendingFullOrderDetail;ZZ)V
    //   634: iload #12
    //   636: ifeq -> 1049
    //   639: new java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial <init> : ()V
    //   646: astore #6
    //   648: aload #6
    //   650: ldc '智能点菜局域网下单，订单号：'
    //   652: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: pop
    //   656: aload #6
    //   658: aload #20
    //   660: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   663: getfield orderNo : Ljava/lang/String;
    //   666: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: aload #6
    //   672: ldc_w '\\n打印'
    //   675: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload #6
    //   681: invokevirtual toString : ()Ljava/lang/String;
    //   684: astore #6
    //   686: goto -> 1053
    //   689: new java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial <init> : ()V
    //   696: astore #17
    //   698: aload #17
    //   700: iload #9
    //   702: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload #17
    //   708: ldc ''
    //   710: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload #6
    //   716: aload #17
    //   718: invokevirtual toString : ()Ljava/lang/String;
    //   721: invokestatic au : (Ljava/lang/String;Ljava/lang/String;)V
    //   724: goto -> 1075
    //   727: aload #21
    //   729: invokevirtual endTransaction : ()V
    //   732: aload #22
    //   734: invokevirtual close : ()V
    //   737: aload #21
    //   739: invokevirtual close : ()V
    //   742: aload_1
    //   743: athrow
    //   744: aload #19
    //   746: ldc_w '1'
    //   749: invokevirtual equals : (Ljava/lang/Object;)Z
    //   752: istore #12
    //   754: iload #12
    //   756: ifeq -> 1082
    //   759: aload_0
    //   760: aload_1
    //   761: aload_3
    //   762: invokevirtual c : (Ljava/lang/String;Landroid/content/Context;)I
    //   765: istore #9
    //   767: goto -> 1075
    //   770: iconst_m1
    //   771: iload #10
    //   773: if_icmpne -> 862
    //   776: aload #19
    //   778: ldc '0'
    //   780: invokevirtual equals : (Ljava/lang/Object;)Z
    //   783: ifeq -> 846
    //   786: aload_1
    //   787: invokestatic iY : (Ljava/lang/String;)Lcom/laiqian/pos/hold/PendingFullOrderDetail;
    //   790: astore #17
    //   792: new java/lang/StringBuilder
    //   795: dup
    //   796: invokespecial <init> : ()V
    //   799: astore #19
    //   801: aload #19
    //   803: ldc '智能点菜局域网下单，订单号：'
    //   805: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: pop
    //   809: aload #19
    //   811: aload #17
    //   813: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   816: getfield orderNo : Ljava/lang/String;
    //   819: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: aload #19
    //   825: ldc_w '\\n刷新列表'
    //   828: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: aload #19
    //   834: invokevirtual toString : ()Ljava/lang/String;
    //   837: getstatic com/laiqian/util/b$a.dEC : Lcom/laiqian/util/b$a;
    //   840: getfield value : Ljava/lang/String;
    //   843: invokestatic bD : (Ljava/lang/String;Ljava/lang/String;)V
    //   846: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   849: new android/content/Intent
    //   852: dup
    //   853: ldc_w 'pos_activity_change_data_area'
    //   856: invokespecial <init> : (Ljava/lang/String;)V
    //   859: invokevirtual sendBroadcast : (Landroid/content/Intent;)V
    //   862: iload_2
    //   863: ifne -> 934
    //   866: new java/lang/StringBuilder
    //   869: dup
    //   870: invokespecial <init> : ()V
    //   873: astore #17
    //   875: aload #17
    //   877: ldc_w '处理提交创建编辑的消息,处理消息的结果码'
    //   880: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: pop
    //   884: aload #17
    //   886: iload #10
    //   888: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: ldc_w '主收银处理提交订单数据'
    //   895: aload #17
    //   897: invokevirtual toString : ()Ljava/lang/String;
    //   900: invokestatic au : (Ljava/lang/String;Ljava/lang/String;)V
    //   903: aload #4
    //   905: iload #5
    //   907: iload #10
    //   909: ldc ''
    //   911: aload #18
    //   913: invokevirtual toString : ()Ljava/lang/String;
    //   916: invokestatic encode : (Ljava/lang/String;)Ljava/lang/String;
    //   919: ldc '0'
    //   921: invokestatic a : (Lio/netty/channel/n;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   924: goto -> 934
    //   927: astore #17
    //   929: aload #17
    //   931: invokestatic e : (Ljava/lang/Throwable;)V
    //   934: new java/lang/StringBuilder
    //   937: dup
    //   938: invokespecial <init> : ()V
    //   941: astore #17
    //   943: aload #17
    //   945: ldc_w 'OrderSubmit result is: '
    //   948: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: pop
    //   952: aload #17
    //   954: iload #10
    //   956: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   959: pop
    //   960: aload #17
    //   962: ldc_w '\\n'
    //   965: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: pop
    //   969: aload #8
    //   971: aload #17
    //   973: invokevirtual toString : ()Ljava/lang/String;
    //   976: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   979: pop
    //   980: iload #9
    //   982: iconst_m1
    //   983: if_icmpne -> 1017
    //   986: aload #6
    //   988: aload_3
    //   989: aload #18
    //   991: invokevirtual toString : ()Ljava/lang/String;
    //   994: aconst_null
    //   995: aload #7
    //   997: aload #4
    //   999: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/laiqian/dcb/api/a/b;Lio/netty/channel/n;)V
    //   1002: aload #6
    //   1004: aload_3
    //   1005: aload_1
    //   1006: sipush #2002
    //   1009: aload #7
    //   1011: invokevirtual DP : ()J
    //   1014: invokespecial b : (Landroid/content/Context;Ljava/lang/String;IJ)V
    //   1017: iload #9
    //   1019: ireturn
    //   1020: astore_1
    //   1021: ldc_w 'dcbe'
    //   1024: aload_1
    //   1025: invokevirtual toString : ()Ljava/lang/String;
    //   1028: invokestatic e : (Ljava/lang/String;Ljava/lang/Object;)V
    //   1031: aload_1
    //   1032: invokestatic e : (Ljava/lang/Throwable;)V
    //   1035: bipush #-2
    //   1037: ireturn
    //   1038: astore #6
    //   1040: goto -> 572
    //   1043: iconst_0
    //   1044: istore #13
    //   1046: goto -> 623
    //   1049: aload #17
    //   1051: astore #6
    //   1053: iload #12
    //   1055: ifeq -> 1064
    //   1058: iconst_m1
    //   1059: istore #9
    //   1061: goto -> 689
    //   1064: bipush #-2
    //   1066: istore #9
    //   1068: goto -> 689
    //   1071: bipush #-2
    //   1073: istore #9
    //   1075: goto -> 1086
    //   1078: astore_1
    //   1079: goto -> 1021
    //   1082: bipush #-2
    //   1084: istore #9
    //   1086: aload_0
    //   1087: astore #6
    //   1089: iload #9
    //   1091: bipush #-3
    //   1093: if_icmpne -> 1102
    //   1096: iconst_m1
    //   1097: istore #10
    //   1099: goto -> 770
    //   1102: iload #9
    //   1104: istore #10
    //   1106: goto -> 770
    // Exception table:
    //   from	to	target	type
    //   0	106	1020	java/lang/Exception
    //   111	241	1020	java/lang/Exception
    //   241	317	567	java/lang/Exception
    //   241	317	563	finally
    //   317	402	558	java/lang/Exception
    //   317	402	563	finally
    //   405	464	558	java/lang/Exception
    //   405	464	563	finally
    //   464	476	558	java/lang/Exception
    //   464	476	563	finally
    //   485	505	1038	java/lang/Exception
    //   485	505	563	finally
    //   517	522	1038	java/lang/Exception
    //   517	522	563	finally
    //   522	532	1020	java/lang/Exception
    //   532	537	1020	java/lang/Exception
    //   540	555	1020	java/lang/Exception
    //   572	577	563	finally
    //   577	587	1020	java/lang/Exception
    //   594	617	1020	java/lang/Exception
    //   623	634	1020	java/lang/Exception
    //   639	686	1020	java/lang/Exception
    //   689	724	1020	java/lang/Exception
    //   727	744	1020	java/lang/Exception
    //   744	754	1020	java/lang/Exception
    //   759	767	1078	java/lang/Exception
    //   776	846	1078	java/lang/Exception
    //   846	862	1078	java/lang/Exception
    //   866	924	927	java/lang/Exception
    //   929	934	1078	java/lang/Exception
    //   934	980	1078	java/lang/Exception
    //   986	1017	1078	java/lang/Exception }
  
  public void a(Context paramContext, String paramString, n paramn, int paramInt, b paramb) {}
  
  public void a(Context paramContext, String paramString1, n paramn, int paramInt, String paramString2, b paramb) {
    byte b2 = 0;
    try {
      JSONObject jSONObject1 = new JSONObject(b.decode(paramString2));
      int i = b2;
      jSONObject2 = jSONObject1;
      try {
        if (jSONObject1.has("type")) {
          av av = new av(RootApplication.zv());
          av.Tx();
          av.close();
          String str = jSONObject1.getString("type");
          jSONObject1.getString("sub_type");
          i = b2;
          JSONObject jSONObject = jSONObject1;
          if (str.equals("table")) {
            long l = by.parseLong(jSONObject1.getString("table_id"));
            int j = by.parseInt(jSONObject1.getString("table_status"));
            i = by.parseInt(jSONObject1.optString("actual_person"));
            if (jSONObject1.has("number_actual_person"))
              i = by.parseInt(jSONObject1.optString("number_actual_person")); 
            int k = jSONObject1.optInt("number_id");
            TableEntity tableEntity = b.bY(l);
            c c = b.b(tableEntity.Yh(), k);
            c.gy(i);
            c.gz(j);
            if (tableEntity.Yg().Yl() == c.Yl())
              tableEntity.c(c); 
            b.a(tableEntity.Yh(), k, c);
            b.j(tableEntity);
            i = 1;
            JSONObject jSONObject3 = jSONObject1;
          } 
        } 
      } catch (Exception jSONObject2) {}
    } catch (Exception paramString2) {
      paramString1 = null;
    } 
    a.e(paramString2);
    paramString2 = paramString1;
    byte b1 = b2;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, b paramb, n paramn) {
    try {
      if (ServerService.aPG != null)
        for (n n1 : ServerService.aPG) {
          if (paramb.DP() > 0L && paramn != null && n1.equals(paramn))
            continue; 
          c.a(n1, 3002, -1, "", b.encode(paramString1.toString()), "0", new k(this));
        }  
    } catch (Exception paramContext) {
      a.e(paramContext);
    } 
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, n paramn, int paramInt, long paramLong, b paramb) {
    try {
      null = new b();
      null = new StringBuilder();
      null.append("/data/data/");
      null.append(paramContext.getPackageName());
      null.append("/laiqian.db");
      null = null.toString();
      null = new StringBuilder();
      null.append("download_");
      null.append(paramString1);
      null.append(".lq");
      String str2 = null.toString();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(a.DS());
      stringBuilder1.append(str2);
      stringBuilder1.append("copy");
      String str3 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(a.DS());
      stringBuilder2.append(str2);
      stringBuilder2.append("final");
      String str4 = stringBuilder2.toString();
      c.B(null, str3);
      null = SQLiteDatabase.openDatabase(str3, null, 16);
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(a.DS());
      stringBuilder3.append(str2);
      stringBuilder3.append("final");
      c.cE(stringBuilder3.toString());
      String str7 = a.DS();
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append(str2);
      stringBuilder4.append("final");
      null.a(null, str7, stringBuilder4.toString(), "T_STRING", "all", false);
      str7 = a.DS();
      stringBuilder4 = new StringBuilder();
      stringBuilder4.append(str2);
      stringBuilder4.append("final");
      null.a(null, str7, stringBuilder4.toString(), "T_USER", "all", false);
      str7 = a.DS();
      stringBuilder4 = new StringBuilder();
      stringBuilder4.append(str2);
      stringBuilder4.append("final");
      null.a(null, str7, stringBuilder4.toString(), "T_SHOP", "all", false);
      str7 = a.DS();
      stringBuilder4 = new StringBuilder();
      stringBuilder4.append(str2);
      stringBuilder4.append("final");
      null.a(null, str7, stringBuilder4.toString(), false);
      null.close();
      null = new StringBuilder();
      null.append(a.DS());
      null.append(str2);
      String str5 = null.toString();
      null = new StringBuilder();
      null.append(a.DR());
      null.append(str2);
      String str6 = null.toString();
      boolean bool2 = (new k(paramContext, str4, str5, "", k.aQg)).aQh;
      null = new StringBuilder();
      null.append(paramString2);
      null.append(paramString3);
      null.append(paramString1);
      str1 = null.toString();
      boolean bool1 = bool2;
      if (bool2)
        bool1 = e.n(str5, str6, str1); 
      c.cE(str5);
      c.cE(str3);
      c.cE(str4);
      try {
        byte b1;
        i i = new i(this);
        if (bool1) {
          b1 = 1;
        } else {
          b1 = 0;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://");
        stringBuilder.append(e.cs(true));
        stringBuilder.append(":");
        stringBuilder.append(j.Z(paramLong));
        stringBuilder.append("/");
        stringBuilder.append(str2);
        c.a(paramn, paramInt, b1, "", stringBuilder.toString(), "", i);
        return;
      } catch (Exception str1) {}
    } catch (Exception paramContext) {}
    c.a(paramn, paramInt, 0, "", "", "");
  }
  
  public void a(StringBuffer paramStringBuffer, Context paramContext, boolean paramBoolean, String paramString, n paramn, int paramInt, a parama, b paramb) {}
  
  public void a(StringBuffer paramStringBuffer, boolean paramBoolean, String paramString, Context paramContext, n paramn, int paramInt, a parama, b paramb) {
    new Intent();
    paramString = b.decode(paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("data parsed result is: ");
    stringBuilder.append(paramString);
    stringBuilder.append("\n");
    paramStringBuffer.append(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("局域网处理提交创建编辑的消息,");
    stringBuilder.append(paramString);
    b.je(stringBuilder.toString());
    try {
      new JSONObject(paramString);
      a(paramString, paramBoolean, paramContext, paramn, paramInt, parama, paramb, paramStringBuffer);
      return;
    } catch (JSONException paramStringBuffer) {
      a.e(paramStringBuffer);
      return;
    } catch (Exception paramStringBuffer) {
      a.e(paramStringBuffer);
      return;
    } 
  }
  
  public void b(Context paramContext, String paramString, n paramn, int paramInt, b paramb) {
    try {
      byte b1;
      String str;
      paramString = b.a(paramContext, b.decode(paramString), paramb.DQ());
      if (by.isNull(paramString)) {
        c.a(paramn, paramInt, -2, "", b.encode(paramString), "0");
        return;
      } 
      JSONObject jSONObject2 = new JSONObject(paramString);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("局域网获取订单");
      if (!by.isNull(paramString)) {
        str = "提交订单成功";
      } else {
        str = "提交订单失败";
      } 
      stringBuilder.append(str);
      b.au("主收银处理客户端创建编辑数据", stringBuilder.toString());
      JSONObject jSONObject1 = b.a("2", paramb.DP(), jSONObject2);
      if (!by.isNull(paramString)) {
        b1 = -1;
      } else {
        b1 = -3;
      } 
      c.a(paramn, paramInt, b1, "", b.encode(jSONObject1.toString()), "0");
      return;
    } catch (Exception paramContext) {
      a.e(paramContext);
      try {
        JSONObject jSONObject = new JSONObject();
        c.a(paramn, paramInt, -2, "", b.encode(b.a("2", paramb.DP(), jSONObject).toString()), "0");
        return;
      } catch (Exception paramContext) {
        a.e(paramContext);
        return;
      } 
    } 
  }
  
  public void b(StringBuffer paramStringBuffer, boolean paramBoolean, String paramString, Context paramContext, n paramn, int paramInt, a parama, b paramb) {
    try {
      new ac(paramContext, new c(b.Xy()));
      String str1 = b.decode(paramString);
      JSONObject jSONObject = new JSONObject(str1);
      String str2 = b.encode(b.a("2", paramb.DP(), jSONObject).toString());
      b(paramContext, str1, 3004, paramb.DP());
      c.bYa.a(paramString, new j(this, paramn, paramInt, str2, paramContext, paramb));
      return;
    } catch (Exception paramStringBuffer) {
      a.e(paramStringBuffer);
      return;
    } 
  }
  
  public int c(String paramString, Context paramContext) { // Byte code:
    //   0: new org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial <init> : (Ljava/lang/String;)V
    //   8: astore #15
    //   10: aload #15
    //   12: ldc_w 'table_info'
    //   15: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   18: astore #16
    //   20: aload #15
    //   22: ldc 'header'
    //   24: invokevirtual getJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   27: astore #14
    //   29: aload #15
    //   31: ldc 'should_print_receipt'
    //   33: iconst_1
    //   34: invokevirtual optBoolean : (Ljava/lang/String;Z)Z
    //   37: istore #7
    //   39: aload #16
    //   41: ldc 'table_id'
    //   43: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   46: invokestatic parseLong : (Ljava/lang/String;)J
    //   49: lstore #8
    //   51: aload #16
    //   53: ldc_w 'from_table_id'
    //   56: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   59: invokestatic parseLong : (Ljava/lang/String;)J
    //   62: lstore #12
    //   64: aload #16
    //   66: ldc_w 'create_time'
    //   69: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   72: invokestatic parseLong : (Ljava/lang/String;)J
    //   75: pop2
    //   76: aload #16
    //   78: ldc_w 'actual_person'
    //   81: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   84: invokestatic parseInt : (Ljava/lang/String;)I
    //   87: pop
    //   88: aload #16
    //   90: ldc 'number_id'
    //   92: invokevirtual has : (Ljava/lang/String;)Z
    //   95: ifeq -> 1337
    //   98: aload #16
    //   100: ldc 'number_id'
    //   102: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
    //   105: invokestatic parseInt : (Ljava/lang/String;)I
    //   108: istore_3
    //   109: goto -> 112
    //   112: aload #14
    //   114: ldc_w 'user_id'
    //   117: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   120: astore #20
    //   122: aload #14
    //   124: ldc 'machine_type'
    //   126: invokevirtual optInt : (Ljava/lang/String;)I
    //   129: pop
    //   130: lload #8
    //   132: aload_2
    //   133: invokestatic a : (JLandroid/content/Context;)Lcom/laiqian/opentable/common/entity/TableEntity;
    //   136: astore #14
    //   138: lload #12
    //   140: lconst_0
    //   141: lcmp
    //   142: ifle -> 165
    //   145: lload #12
    //   147: aload_2
    //   148: invokestatic a : (JLandroid/content/Context;)Lcom/laiqian/opentable/common/entity/TableEntity;
    //   151: astore #16
    //   153: aload #14
    //   155: invokevirtual getState : ()I
    //   158: iconst_2
    //   159: if_icmpne -> 176
    //   162: bipush #-5
    //   164: ireturn
    //   165: aload #14
    //   167: invokevirtual getState : ()I
    //   170: ifne -> 1342
    //   173: bipush #-4
    //   175: ireturn
    //   176: new com/laiqian/pos/model/a
    //   179: dup
    //   180: aload_2
    //   181: invokespecial <init> : (Landroid/content/Context;)V
    //   184: astore #17
    //   186: new com/laiqian/models/ba
    //   189: dup
    //   190: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   193: invokespecial <init> : (Landroid/content/Context;)V
    //   196: astore #18
    //   198: aload_1
    //   199: invokestatic iX : (Ljava/lang/String;)Lcom/laiqian/pos/hold/PendingFullOrderDetail;
    //   202: astore #19
    //   204: aload #19
    //   206: ifnonnull -> 227
    //   209: aload #17
    //   211: invokevirtual endTransaction : ()V
    //   214: aload #18
    //   216: invokevirtual close : ()V
    //   219: aload #17
    //   221: invokevirtual close : ()V
    //   224: bipush #-2
    //   226: ireturn
    //   227: aload #19
    //   229: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   232: getfield orderNo : Ljava/lang/String;
    //   235: invokestatic isNull : (Ljava/lang/String;)Z
    //   238: ifne -> 1380
    //   241: aload #17
    //   243: invokevirtual beginTransaction : ()V
    //   246: new java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial <init> : ()V
    //   253: astore_1
    //   254: aload_1
    //   255: aload #19
    //   257: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   260: getfield orderNo : Ljava/lang/String;
    //   263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_1
    //   268: ldc ''
    //   270: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload #17
    //   276: aload_1
    //   277: invokevirtual toString : ()Ljava/lang/String;
    //   280: invokevirtual ky : (Ljava/lang/String;)Lcom/laiqian/pos/hold/PendingFullOrderDetail;
    //   283: astore #21
    //   285: aload #21
    //   287: ifnonnull -> 308
    //   290: aload #17
    //   292: invokevirtual endTransaction : ()V
    //   295: aload #18
    //   297: invokevirtual close : ()V
    //   300: aload #17
    //   302: invokevirtual close : ()V
    //   305: bipush #-2
    //   307: ireturn
    //   308: invokestatic currentTimeMillis : ()J
    //   311: lstore #8
    //   313: new com/laiqian/pos/hold/PendingFullOrderDetail$c
    //   316: dup
    //   317: invokespecial <init> : ()V
    //   320: astore #22
    //   322: aload #19
    //   324: getfield coy : Ljava/util/ArrayList;
    //   327: astore #15
    //   329: aload #21
    //   331: getfield coy : Ljava/util/ArrayList;
    //   334: astore #23
    //   336: aload #14
    //   338: astore_1
    //   339: aload #15
    //   341: aload #17
    //   343: aload #23
    //   345: aload #21
    //   347: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   350: lload #8
    //   352: aload #18
    //   354: invokestatic a : (Ljava/util/ArrayList;Lcom/laiqian/pos/model/a;Ljava/util/ArrayList;Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;JLcom/laiqian/models/ba;)Lcom/laiqian/ordertool/a/d$a;
    //   357: astore #15
    //   359: aload #14
    //   361: astore_1
    //   362: aload #22
    //   364: getfield cpg : Ljava/util/ArrayList;
    //   367: aload #15
    //   369: getfield cdy : Lcom/laiqian/pos/hold/PendingFullOrderDetail$c;
    //   372: getfield cpg : Ljava/util/ArrayList;
    //   375: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   378: pop
    //   379: aload #14
    //   381: astore_1
    //   382: aload #15
    //   384: getfield time : J
    //   387: lstore #8
    //   389: iconst_0
    //   390: istore #4
    //   392: aload #14
    //   394: astore_1
    //   395: iload #4
    //   397: aload #19
    //   399: getfield coz : Ljava/util/ArrayList;
    //   402: invokevirtual size : ()I
    //   405: if_icmpge -> 537
    //   408: aload #14
    //   410: astore_1
    //   411: aload #19
    //   413: getfield coz : Ljava/util/ArrayList;
    //   416: iload #4
    //   418: invokevirtual get : (I)Ljava/lang/Object;
    //   421: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$c
    //   424: astore #15
    //   426: iconst_0
    //   427: istore #5
    //   429: aload #14
    //   431: astore_1
    //   432: iload #5
    //   434: aload #21
    //   436: getfield coz : Ljava/util/ArrayList;
    //   439: invokevirtual size : ()I
    //   442: if_icmpge -> 1348
    //   445: aload #14
    //   447: astore_1
    //   448: aload #21
    //   450: getfield coz : Ljava/util/ArrayList;
    //   453: iload #5
    //   455: invokevirtual get : (I)Ljava/lang/Object;
    //   458: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$c
    //   461: astore #23
    //   463: aload #14
    //   465: astore_1
    //   466: aload_1
    //   467: astore #14
    //   469: aload #15
    //   471: getfield cpg : Ljava/util/ArrayList;
    //   474: aload #17
    //   476: aload #23
    //   478: getfield cpg : Ljava/util/ArrayList;
    //   481: aload #21
    //   483: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   486: lload #8
    //   488: aload #18
    //   490: invokestatic a : (Ljava/util/ArrayList;Lcom/laiqian/pos/model/a;Ljava/util/ArrayList;Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;JLcom/laiqian/models/ba;)Lcom/laiqian/ordertool/a/d$a;
    //   493: astore #23
    //   495: aload_1
    //   496: astore #14
    //   498: aload #22
    //   500: getfield cpg : Ljava/util/ArrayList;
    //   503: aload #23
    //   505: getfield cdy : Lcom/laiqian/pos/hold/PendingFullOrderDetail$c;
    //   508: getfield cpg : Ljava/util/ArrayList;
    //   511: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   514: pop
    //   515: aload_1
    //   516: astore #14
    //   518: aload #23
    //   520: getfield time : J
    //   523: lstore #8
    //   525: iload #5
    //   527: iconst_1
    //   528: iadd
    //   529: istore #5
    //   531: aload_1
    //   532: astore #14
    //   534: goto -> 429
    //   537: aload #14
    //   539: astore #15
    //   541: aload #15
    //   543: astore #14
    //   545: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   548: astore_1
    //   549: aload #15
    //   551: astore #14
    //   553: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   556: invokevirtual Bk : ()Z
    //   559: ifeq -> 1357
    //   562: aload #15
    //   564: astore #14
    //   566: invokestatic zR : ()Lcom/laiqian/c/a;
    //   569: invokevirtual Af : ()Z
    //   572: ifne -> 1357
    //   575: iconst_1
    //   576: istore #6
    //   578: goto -> 581
    //   581: aload #15
    //   583: astore #14
    //   585: aload_1
    //   586: aload #19
    //   588: aload #22
    //   590: iload #6
    //   592: iload #7
    //   594: invokestatic a : (Landroid/content/Context;Lcom/laiqian/pos/hold/PendingFullOrderDetail;Lcom/laiqian/pos/hold/PendingFullOrderDetail$c;ZZ)V
    //   597: aload #15
    //   599: astore_1
    //   600: aload #15
    //   602: astore #14
    //   604: aload #19
    //   606: getfield coz : Ljava/util/ArrayList;
    //   609: invokevirtual size : ()I
    //   612: aload #21
    //   614: getfield coz : Ljava/util/ArrayList;
    //   617: invokevirtual size : ()I
    //   620: if_icmpeq -> 819
    //   623: aload #15
    //   625: astore #14
    //   627: aload #19
    //   629: getfield coz : Ljava/util/ArrayList;
    //   632: aload #19
    //   634: getfield coz : Ljava/util/ArrayList;
    //   637: invokevirtual size : ()I
    //   640: iconst_1
    //   641: isub
    //   642: invokevirtual get : (I)Ljava/lang/Object;
    //   645: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$c
    //   648: astore_1
    //   649: aload #15
    //   651: astore #14
    //   653: invokestatic currentTimeMillis : ()J
    //   656: lstore #10
    //   658: iconst_0
    //   659: istore #4
    //   661: aload #15
    //   663: astore #14
    //   665: iload #4
    //   667: aload_1
    //   668: getfield cpg : Ljava/util/ArrayList;
    //   671: invokevirtual size : ()I
    //   674: if_icmpge -> 756
    //   677: aload #15
    //   679: astore #14
    //   681: aload_1
    //   682: getfield cpg : Ljava/util/ArrayList;
    //   685: iload #4
    //   687: invokevirtual get : (I)Ljava/lang/Object;
    //   690: checkcast com/laiqian/pos/hold/PendingFullOrderDetail$d
    //   693: astore #22
    //   695: aload #15
    //   697: astore #14
    //   699: aload #22
    //   701: aload #18
    //   703: aload #22
    //   705: getfield id : J
    //   708: ldc_w '86003'
    //   711: invokevirtual s : (JLjava/lang/String;)Ljava/util/ArrayList;
    //   714: putfield aTR : Ljava/util/ArrayList;
    //   717: aload #15
    //   719: astore #14
    //   721: aload #17
    //   723: aload #22
    //   725: lload #8
    //   727: iload #4
    //   729: i2l
    //   730: aload #21
    //   732: getfield bXb : Lcom/laiqian/pos/hold/PendingFullOrderDetail$a;
    //   735: lload #10
    //   737: invokevirtual a : (Lcom/laiqian/pos/hold/PendingFullOrderDetail$d;JJLcom/laiqian/pos/hold/PendingFullOrderDetail$a;J)Z
    //   740: pop
    //   741: iload #4
    //   743: iconst_1
    //   744: iadd
    //   745: istore #4
    //   747: lload #8
    //   749: lconst_1
    //   750: ladd
    //   751: lstore #8
    //   753: goto -> 661
    //   756: aload #15
    //   758: astore #14
    //   760: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   763: astore #21
    //   765: aload #15
    //   767: astore #14
    //   769: invokestatic AZ : ()Lcom/laiqian/d/a;
    //   772: invokevirtual Bk : ()Z
    //   775: ifeq -> 1363
    //   778: aload #15
    //   780: astore #14
    //   782: invokestatic zR : ()Lcom/laiqian/c/a;
    //   785: invokevirtual Af : ()Z
    //   788: ifne -> 1363
    //   791: iconst_1
    //   792: istore #6
    //   794: goto -> 797
    //   797: aload #15
    //   799: astore #14
    //   801: aload #21
    //   803: aload #19
    //   805: aload_1
    //   806: iload #6
    //   808: iload #7
    //   810: invokestatic a : (Landroid/content/Context;Lcom/laiqian/pos/hold/PendingFullOrderDetail;Lcom/laiqian/pos/hold/PendingFullOrderDetail$c;ZZ)V
    //   813: aload #15
    //   815: astore_1
    //   816: goto -> 819
    //   819: lload #12
    //   821: lconst_0
    //   822: lcmp
    //   823: ifne -> 843
    //   826: aload_1
    //   827: astore #14
    //   829: aload #19
    //   831: invokestatic n : (Lcom/laiqian/pos/hold/PendingFullOrderDetail;)Z
    //   834: istore #6
    //   836: goto -> 846
    //   839: astore_1
    //   840: goto -> 895
    //   843: iconst_0
    //   844: istore #6
    //   846: aload #17
    //   848: invokevirtual setTransactionSuccessful : ()V
    //   851: iload #6
    //   853: ifeq -> 1386
    //   856: ldc_w '编辑成功'
    //   859: astore #14
    //   861: goto -> 864
    //   864: ldc_w '主收银处理客户端编辑数据'
    //   867: aload #14
    //   869: invokestatic au : (Ljava/lang/String;Ljava/lang/String;)V
    //   872: aload #17
    //   874: invokevirtual endTransaction : ()V
    //   877: aload #18
    //   879: invokevirtual close : ()V
    //   882: goto -> 919
    //   885: astore #15
    //   887: goto -> 904
    //   890: astore_1
    //   891: goto -> 1312
    //   894: astore_1
    //   895: aload_1
    //   896: astore #15
    //   898: iconst_0
    //   899: istore #6
    //   901: aload #14
    //   903: astore_1
    //   904: aload #15
    //   906: invokestatic e : (Ljava/lang/Throwable;)V
    //   909: aload #17
    //   911: invokevirtual endTransaction : ()V
    //   914: aload #18
    //   916: invokevirtual close : ()V
    //   919: aload #17
    //   921: invokevirtual close : ()V
    //   924: lload #12
    //   926: lconst_0
    //   927: lcmp
    //   928: ifle -> 1407
    //   931: ldc ''
    //   933: astore #18
    //   935: iload_3
    //   936: iconst_m1
    //   937: if_icmpne -> 1105
    //   940: aload #16
    //   942: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   945: invokevirtual iterator : ()Ljava/util/Iterator;
    //   948: astore #14
    //   950: aload #14
    //   952: invokeinterface hasNext : ()Z
    //   957: ifeq -> 1015
    //   960: aload #14
    //   962: invokeinterface next : ()Ljava/lang/Object;
    //   967: checkcast com/laiqian/opentable/common/entity/c
    //   970: astore #15
    //   972: invokestatic XB : ()Z
    //   975: ifeq -> 1394
    //   978: aload #15
    //   980: aload_1
    //   981: invokevirtual getID : ()J
    //   984: invokestatic valueOf : (J)Ljava/lang/String;
    //   987: invokevirtual da : (Ljava/lang/String;)V
    //   990: goto -> 993
    //   993: aload #15
    //   995: aload_1
    //   996: invokevirtual getID : ()J
    //   999: invokevirtual ch : (J)V
    //   1002: aload_1
    //   1003: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   1006: aload #15
    //   1008: invokevirtual add : (Ljava/lang/Object;)Z
    //   1011: pop
    //   1012: goto -> 950
    //   1015: aload_1
    //   1016: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   1019: invokestatic sort : (Ljava/util/List;)V
    //   1022: aload_1
    //   1023: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   1026: invokevirtual size : ()I
    //   1029: ifle -> 1047
    //   1032: aload_1
    //   1033: aload_1
    //   1034: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   1037: iconst_0
    //   1038: invokevirtual get : (I)Ljava/lang/Object;
    //   1041: checkcast com/laiqian/opentable/common/entity/c
    //   1044: invokevirtual c : (Lcom/laiqian/opentable/common/entity/c;)V
    //   1047: aload_1
    //   1048: invokevirtual Yg : ()Lcom/laiqian/opentable/common/entity/c;
    //   1051: aload #16
    //   1053: invokevirtual Yg : ()Lcom/laiqian/opentable/common/entity/c;
    //   1056: invokevirtual xq : ()Ljava/lang/String;
    //   1059: invokevirtual da : (Ljava/lang/String;)V
    //   1062: aload_1
    //   1063: aload #16
    //   1065: invokevirtual getState : ()I
    //   1068: invokevirtual setState : (I)V
    //   1071: aload_1
    //   1072: aload #16
    //   1074: invokevirtual DP : ()J
    //   1077: invokevirtual cf : (J)V
    //   1080: aload_1
    //   1081: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   1084: invokestatic Q : (Ljava/util/ArrayList;)Ljava/lang/String;
    //   1087: astore #15
    //   1089: aload #16
    //   1091: invokevirtual Yc : ()Lcom/laiqian/opentable/common/entity/TableEntity;
    //   1094: pop
    //   1095: aload #18
    //   1097: astore #14
    //   1099: aload_1
    //   1100: astore #17
    //   1102: goto -> 1397
    //   1105: aload #16
    //   1107: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   1110: iload_3
    //   1111: invokestatic b : (Ljava/util/ArrayList;I)Lcom/laiqian/opentable/common/entity/c;
    //   1114: astore #14
    //   1116: aload #16
    //   1118: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   1121: aload #14
    //   1123: invokevirtual remove : (Ljava/lang/Object;)Z
    //   1126: pop
    //   1127: aload #14
    //   1129: iconst_0
    //   1130: invokevirtual gx : (I)V
    //   1133: aload #14
    //   1135: aload_1
    //   1136: invokevirtual getID : ()J
    //   1139: invokevirtual ch : (J)V
    //   1142: aload_1
    //   1143: iconst_2
    //   1144: invokevirtual setState : (I)V
    //   1147: aload_1
    //   1148: aload #16
    //   1150: invokevirtual DP : ()J
    //   1153: invokevirtual cf : (J)V
    //   1156: aload_1
    //   1157: aload #14
    //   1159: invokevirtual c : (Lcom/laiqian/opentable/common/entity/c;)V
    //   1162: aload_1
    //   1163: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   1166: aload #14
    //   1168: invokevirtual add : (Ljava/lang/Object;)Z
    //   1171: pop
    //   1172: aload #14
    //   1174: invokestatic b : (Lcom/laiqian/opentable/common/entity/c;)Ljava/lang/String;
    //   1177: astore #19
    //   1179: aload #16
    //   1181: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   1184: invokevirtual size : ()I
    //   1187: ifle -> 1210
    //   1190: aload #16
    //   1192: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   1195: invokestatic Q : (Ljava/util/ArrayList;)Ljava/lang/String;
    //   1198: astore #14
    //   1200: aload #19
    //   1202: astore #15
    //   1204: aload_1
    //   1205: astore #17
    //   1207: goto -> 1397
    //   1210: aload #18
    //   1212: astore #14
    //   1214: aload #19
    //   1216: astore #15
    //   1218: aload_1
    //   1219: astore #17
    //   1221: aload #16
    //   1223: invokevirtual Yh : ()Ljava/util/ArrayList;
    //   1226: invokevirtual size : ()I
    //   1229: ifne -> 1397
    //   1232: aload #16
    //   1234: invokevirtual Yc : ()Lcom/laiqian/opentable/common/entity/TableEntity;
    //   1237: pop
    //   1238: aload #18
    //   1240: astore #14
    //   1242: aload #19
    //   1244: astore #15
    //   1246: aload_1
    //   1247: astore #17
    //   1249: goto -> 1397
    //   1252: aload #16
    //   1254: aload #17
    //   1256: aload_2
    //   1257: new com/laiqian/ordertool/c/c
    //   1260: dup
    //   1261: invokestatic Xy : ()I
    //   1264: invokespecial <init> : (I)V
    //   1267: aload #14
    //   1269: aload #15
    //   1271: iload_3
    //   1272: invokestatic a : (Lcom/laiqian/opentable/common/entity/TableEntity;Lcom/laiqian/opentable/common/entity/TableEntity;Landroid/content/Context;Lcom/laiqian/ordertool/c/a;Ljava/lang/String;Ljava/lang/String;I)Z
    //   1275: istore #6
    //   1277: invokestatic zv : ()Lcom/laiqian/basic/RootApplication;
    //   1280: aload #16
    //   1282: aload #17
    //   1284: aload #20
    //   1286: iload_3
    //   1287: invokestatic a : (Landroid/content/Context;Lcom/laiqian/opentable/common/entity/TableEntity;Lcom/laiqian/opentable/common/entity/TableEntity;Ljava/lang/String;I)V
    //   1290: iload #6
    //   1292: ifeq -> 1400
    //   1295: ldc_w '移桌成功'
    //   1298: astore_1
    //   1299: goto -> 1302
    //   1302: ldc_w '主收银处理客户端移桌数据'
    //   1305: aload_1
    //   1306: invokestatic au : (Ljava/lang/String;Ljava/lang/String;)V
    //   1309: goto -> 1407
    //   1312: aload #17
    //   1314: invokevirtual endTransaction : ()V
    //   1317: aload #18
    //   1319: invokevirtual close : ()V
    //   1322: aload #17
    //   1324: invokevirtual close : ()V
    //   1327: aload_1
    //   1328: athrow
    //   1329: astore_1
    //   1330: aload_1
    //   1331: invokestatic e : (Ljava/lang/Throwable;)V
    //   1334: bipush #-2
    //   1336: ireturn
    //   1337: iconst_m1
    //   1338: istore_3
    //   1339: goto -> 112
    //   1342: aconst_null
    //   1343: astore #16
    //   1345: goto -> 176
    //   1348: iload #4
    //   1350: iconst_1
    //   1351: iadd
    //   1352: istore #4
    //   1354: goto -> 392
    //   1357: iconst_0
    //   1358: istore #6
    //   1360: goto -> 581
    //   1363: iconst_0
    //   1364: istore #6
    //   1366: goto -> 797
    //   1369: astore #15
    //   1371: aload_1
    //   1372: astore #14
    //   1374: aload #15
    //   1376: astore_1
    //   1377: goto -> 895
    //   1380: aload #14
    //   1382: astore_1
    //   1383: goto -> 819
    //   1386: ldc_w '编辑失败'
    //   1389: astore #14
    //   1391: goto -> 864
    //   1394: goto -> 993
    //   1397: goto -> 1252
    //   1400: ldc_w '移桌失败'
    //   1403: astore_1
    //   1404: goto -> 1302
    //   1407: iload #6
    //   1409: ifeq -> 1415
    //   1412: bipush #-3
    //   1414: ireturn
    //   1415: bipush #-2
    //   1417: ireturn
    // Exception table:
    //   from	to	target	type
    //   0	109	1329	java/lang/Exception
    //   112	138	1329	java/lang/Exception
    //   145	153	1329	java/lang/Exception
    //   153	162	1329	java/lang/Exception
    //   165	173	1329	java/lang/Exception
    //   176	198	1329	java/lang/Exception
    //   198	204	894	java/lang/Exception
    //   198	204	890	finally
    //   209	224	1329	java/lang/Exception
    //   227	285	894	java/lang/Exception
    //   227	285	890	finally
    //   290	305	1329	java/lang/Exception
    //   308	336	894	java/lang/Exception
    //   308	336	890	finally
    //   339	359	1369	java/lang/Exception
    //   339	359	890	finally
    //   362	379	1369	java/lang/Exception
    //   362	379	890	finally
    //   382	389	1369	java/lang/Exception
    //   382	389	890	finally
    //   395	408	1369	java/lang/Exception
    //   395	408	890	finally
    //   411	426	1369	java/lang/Exception
    //   411	426	890	finally
    //   432	445	1369	java/lang/Exception
    //   432	445	890	finally
    //   448	463	1369	java/lang/Exception
    //   448	463	890	finally
    //   469	495	839	java/lang/Exception
    //   469	495	890	finally
    //   498	515	839	java/lang/Exception
    //   498	515	890	finally
    //   518	525	839	java/lang/Exception
    //   518	525	890	finally
    //   545	549	839	java/lang/Exception
    //   545	549	890	finally
    //   553	562	839	java/lang/Exception
    //   553	562	890	finally
    //   566	575	839	java/lang/Exception
    //   566	575	890	finally
    //   585	597	839	java/lang/Exception
    //   585	597	890	finally
    //   604	623	839	java/lang/Exception
    //   604	623	890	finally
    //   627	649	839	java/lang/Exception
    //   627	649	890	finally
    //   653	658	839	java/lang/Exception
    //   653	658	890	finally
    //   665	677	839	java/lang/Exception
    //   665	677	890	finally
    //   681	695	839	java/lang/Exception
    //   681	695	890	finally
    //   699	717	839	java/lang/Exception
    //   699	717	890	finally
    //   721	741	839	java/lang/Exception
    //   721	741	890	finally
    //   760	765	839	java/lang/Exception
    //   760	765	890	finally
    //   769	778	839	java/lang/Exception
    //   769	778	890	finally
    //   782	791	839	java/lang/Exception
    //   782	791	890	finally
    //   801	813	839	java/lang/Exception
    //   801	813	890	finally
    //   829	836	839	java/lang/Exception
    //   829	836	890	finally
    //   846	851	885	java/lang/Exception
    //   846	851	890	finally
    //   864	872	885	java/lang/Exception
    //   864	872	890	finally
    //   872	882	1329	java/lang/Exception
    //   904	909	890	finally
    //   909	919	1329	java/lang/Exception
    //   919	924	1329	java/lang/Exception
    //   940	950	1329	java/lang/Exception
    //   950	990	1329	java/lang/Exception
    //   993	1012	1329	java/lang/Exception
    //   1015	1047	1329	java/lang/Exception
    //   1047	1095	1329	java/lang/Exception
    //   1105	1200	1329	java/lang/Exception
    //   1221	1238	1329	java/lang/Exception
    //   1252	1290	1329	java/lang/Exception
    //   1302	1309	1329	java/lang/Exception
    //   1312	1329	1329	java/lang/Exception }
  
  public void c(Context paramContext, String paramString, n paramn, int paramInt, b paramb) {
    str = b.aN(paramContext);
    try {
      byte b1;
      JSONObject jSONObject = new JSONObject(str);
      String str1 = b.encode(b.a("2", paramb.DP(), jSONObject).toString());
      if (!by.isNull(str)) {
        b1 = -1;
      } else {
        b1 = -2;
      } 
      c.a(paramn, paramInt, b1, "", str1, "0", new l(this));
      return;
    } catch (Exception str) {
      a.e(str);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\ordertool\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */