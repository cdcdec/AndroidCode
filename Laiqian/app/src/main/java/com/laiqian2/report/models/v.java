package com.laiqian.report.models;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.google.a.a.a.a.a.a;
import com.laiqian.entity.b;
import com.laiqian.pos.model.orders.b;
import com.laiqian.print.c.d;
import com.laiqian.print.j;
import com.laiqian.print.model.g;
import com.laiqian.print.usage.kitchen.a.a;
import com.laiqian.print.usage.receipt.model.a;
import com.laiqian.util.av;
import java.io.IOException;
import java.util.List;

public class v {
  d bga;
  
  Context context;
  
  a dbR;
  
  a dbS;
  
  b dbT;
  
  @Nullable
  private b dbU;
  
  public boolean isUserCashReturn = false;
  
  String mOrderNo;
  
  public v(Context paramContext, o paramo, String paramString1, b paramb, String paramString2) {
    this.context = paramContext;
    this.mOrderNo = paramString1;
    this.dbU = paramb;
    this.dbT = a(paramo, paramString1, (new av(paramContext)).atm(), paramString2);
    this.dbR = a.bo(paramContext);
    this.dbS = a.bm(paramContext);
    this.bga = d.bg(paramContext);
  }
  
  private b a(o paramo, String paramString1, String paramString2, String paramString3) { // Byte code:
    //   0: aload_0
    //   1: astore #32
    //   3: new java/util/ArrayList
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: astore #38
    //   12: new com/laiqian/models/b
    //   15: dup
    //   16: aload #32
    //   18: getfield context : Landroid/content/Context;
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: astore #31
    //   26: aload #31
    //   28: aload_2
    //   29: iconst_1
    //   30: aload #4
    //   32: invokestatic parseLong : (Ljava/lang/String;)J
    //   35: invokevirtual a : (Ljava/lang/String;ZJ)Ljava/util/ArrayList;
    //   38: astore #43
    //   40: aload #31
    //   42: invokevirtual close : ()V
    //   45: aload #43
    //   47: invokevirtual iterator : ()Ljava/util/Iterator;
    //   50: astore #31
    //   52: aload #31
    //   54: invokeinterface hasNext : ()Z
    //   59: ifeq -> 87
    //   62: aload #31
    //   64: invokeinterface next : ()Ljava/lang/Object;
    //   69: checkcast com/laiqian/report/models/l
    //   72: getfield aTv : I
    //   75: sipush #10006
    //   78: if_icmpne -> 52
    //   81: iconst_1
    //   82: istore #27
    //   84: goto -> 90
    //   87: iconst_0
    //   88: istore #27
    //   90: new com/laiqian/models/x
    //   93: dup
    //   94: aload #32
    //   96: getfield context : Landroid/content/Context;
    //   99: invokespecial <init> : (Landroid/content/Context;)V
    //   102: astore #33
    //   104: aload #33
    //   106: aload_2
    //   107: aload #4
    //   109: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   112: invokevirtual longValue : ()J
    //   115: invokevirtual f : (Ljava/lang/String;J)Landroid/database/Cursor;
    //   118: astore #31
    //   120: aload #33
    //   122: aload_2
    //   123: aload #4
    //   125: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   128: invokevirtual longValue : ()J
    //   131: invokevirtual g : (Ljava/lang/String;J)Ljava/lang/Double;
    //   134: pop
    //   135: aload #33
    //   137: aload_2
    //   138: aload #4
    //   140: invokevirtual ai : (Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;
    //   143: astore #34
    //   145: aload #33
    //   147: aload_2
    //   148: invokevirtual hB : (Ljava/lang/String;)Ljava/lang/Double;
    //   151: astore #41
    //   153: aload #31
    //   155: ifnull -> 2186
    //   158: aload #31
    //   160: invokeinterface moveToFirst : ()Z
    //   165: ifeq -> 2186
    //   168: aload_3
    //   169: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   172: aload #32
    //   174: getfield context : Landroid/content/Context;
    //   177: invokestatic d : (Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   180: astore #39
    //   182: aload #31
    //   184: aload #31
    //   186: ldc 'sSpareField1'
    //   188: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   193: invokeinterface getString : (I)Ljava/lang/String;
    //   198: astore #44
    //   200: aload #31
    //   202: aload #31
    //   204: ldc 'sSpareField2'
    //   206: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   211: invokeinterface getString : (I)Ljava/lang/String;
    //   216: astore #4
    //   218: aload #31
    //   220: aload #31
    //   222: ldc 'nBPartnerID'
    //   224: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   229: invokeinterface getLong : (I)J
    //   234: lstore #29
    //   236: lload #29
    //   238: invokestatic valueOf : (J)Ljava/lang/Long;
    //   241: lconst_0
    //   242: invokestatic valueOf : (J)Ljava/lang/Long;
    //   245: invokevirtual equals : (Ljava/lang/Object;)Z
    //   248: ifne -> 366
    //   251: new com/laiqian/models/j
    //   254: dup
    //   255: aload #32
    //   257: getfield context : Landroid/content/Context;
    //   260: invokespecial <init> : (Landroid/content/Context;)V
    //   263: astore #33
    //   265: aload #33
    //   267: aload_2
    //   268: invokevirtual ha : (Ljava/lang/String;)Lcom/laiqian/entity/b;
    //   271: astore_3
    //   272: goto -> 282
    //   275: astore_3
    //   276: aload_3
    //   277: invokestatic e : (Ljava/lang/Throwable;)V
    //   280: aconst_null
    //   281: astore_3
    //   282: aload #33
    //   284: invokevirtual close : ()V
    //   287: aload #32
    //   289: getfield dbU : Lcom/laiqian/entity/b;
    //   292: ifnull -> 366
    //   295: aload_3
    //   296: ifnull -> 366
    //   299: iload #27
    //   301: ifeq -> 334
    //   304: aload #32
    //   306: getfield dbU : Lcom/laiqian/entity/b;
    //   309: astore #33
    //   311: aload #33
    //   313: aload #33
    //   315: getfield aWo : D
    //   318: aload_3
    //   319: getfield aWy : D
    //   322: aload_3
    //   323: getfield aRt : D
    //   326: dsub
    //   327: dsub
    //   328: putfield aWo : D
    //   331: goto -> 334
    //   334: aload #32
    //   336: getfield dbU : Lcom/laiqian/entity/b;
    //   339: astore #33
    //   341: aload #33
    //   343: aload #33
    //   345: getfield aWp : J
    //   348: aload_3
    //   349: getfield aWp : J
    //   352: lsub
    //   353: putfield aWp : J
    //   356: aload #32
    //   358: getfield dbU : Lcom/laiqian/entity/b;
    //   361: astore #33
    //   363: goto -> 369
    //   366: aconst_null
    //   367: astore #33
    //   369: aload_1
    //   370: getfield orderSource : I
    //   373: istore #27
    //   375: new com/laiqian/product/models/l
    //   378: dup
    //   379: aload #32
    //   381: getfield context : Landroid/content/Context;
    //   384: invokespecial <init> : (Landroid/content/Context;)V
    //   387: astore #35
    //   389: aload #35
    //   391: invokevirtual Vi : ()Ljava/util/ArrayList;
    //   394: astore_3
    //   395: aload #35
    //   397: invokevirtual close : ()V
    //   400: new com/laiqian/models/ab
    //   403: dup
    //   404: aload #32
    //   406: getfield context : Landroid/content/Context;
    //   409: invokespecial <init> : (Landroid/content/Context;)V
    //   412: astore #36
    //   414: new java/util/ArrayList
    //   417: dup
    //   418: invokespecial <init> : ()V
    //   421: astore #35
    //   423: dconst_0
    //   424: dstore #13
    //   426: dload #13
    //   428: dstore #11
    //   430: dload #11
    //   432: dstore #5
    //   434: dload #5
    //   436: dstore #7
    //   438: dload #7
    //   440: dstore #15
    //   442: aconst_null
    //   443: astore #37
    //   445: ldc2_w 100.0
    //   448: dstore #9
    //   450: aload #4
    //   452: astore #32
    //   454: aload #31
    //   456: astore #4
    //   458: aload #38
    //   460: astore #31
    //   462: aload #4
    //   464: invokeinterface isFirst : ()Z
    //   469: ifeq -> 526
    //   472: aload #4
    //   474: aload #4
    //   476: ldc 'nDateTime'
    //   478: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   483: invokeinterface getString : (I)Ljava/lang/String;
    //   488: invokestatic parseLong : (Ljava/lang/String;)J
    //   491: lstore #29
    //   493: new java/util/Date
    //   496: dup
    //   497: lload #29
    //   499: invokespecial <init> : (J)V
    //   502: astore #38
    //   504: aload #38
    //   506: astore #37
    //   508: goto -> 526
    //   511: astore #38
    //   513: goto -> 518
    //   516: astore #38
    //   518: aload #38
    //   520: invokestatic e : (Ljava/lang/Throwable;)V
    //   523: goto -> 526
    //   526: aload #4
    //   528: aload #4
    //   530: ldc 'nSpareField3'
    //   532: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   537: invokeinterface getInt : (I)I
    //   542: istore #28
    //   544: iload #28
    //   546: iconst_1
    //   547: if_icmpne -> 595
    //   550: aload #4
    //   552: astore #38
    //   554: dload #13
    //   556: dstore #17
    //   558: dload #5
    //   560: dstore #13
    //   562: dload #7
    //   564: dstore #19
    //   566: dload #9
    //   568: dstore #21
    //   570: aload_3
    //   571: astore #4
    //   573: dload #17
    //   575: dstore #5
    //   577: aload #38
    //   579: astore_3
    //   580: dload #11
    //   582: dstore #7
    //   584: dload #19
    //   586: dstore #9
    //   588: dload #21
    //   590: dstore #11
    //   592: goto -> 1823
    //   595: aload #4
    //   597: aload #4
    //   599: ldc 'fDiscount'
    //   601: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   606: invokeinterface getDouble : (I)D
    //   611: dstore #19
    //   613: dload #19
    //   615: invokestatic isInfinite : (D)Z
    //   618: ifne -> 640
    //   621: dload #19
    //   623: invokestatic isNaN : (D)Z
    //   626: ifne -> 640
    //   629: dload #19
    //   631: dstore #17
    //   633: dload #19
    //   635: dconst_0
    //   636: dcmpl
    //   637: ifne -> 645
    //   640: ldc2_w 100.0
    //   643: dstore #17
    //   645: dload #17
    //   647: ldc2_w 100.0
    //   650: dsub
    //   651: invokestatic bc : (D)Z
    //   654: ifne -> 664
    //   657: dload #17
    //   659: dstore #9
    //   661: goto -> 664
    //   664: aload #4
    //   666: aload #4
    //   668: ldc_w 'nProductTransacType'
    //   671: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   676: invokeinterface getLong : (I)J
    //   681: invokestatic valueOf : (J)Ljava/lang/Long;
    //   684: astore #46
    //   686: aload #4
    //   688: aload #4
    //   690: ldc_w 'sProductName'
    //   693: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   698: invokeinterface getString : (I)Ljava/lang/String;
    //   703: astore #50
    //   705: aload #4
    //   707: aload #4
    //   709: getstatic com/laiqian/models/x.bQu : Lcom/laiqian/models/ao$b;
    //   712: invokevirtual getName : ()Ljava/lang/String;
    //   715: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   720: invokeinterface getLong : (I)J
    //   725: lstore #29
    //   727: aload #4
    //   729: aload #4
    //   731: ldc_w 'nProductQty'
    //   734: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   739: invokeinterface getDouble : (I)D
    //   744: dstore #19
    //   746: aload #4
    //   748: aload #4
    //   750: ldc_w 'fPrice'
    //   753: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   758: invokeinterface getDouble : (I)D
    //   763: dstore #21
    //   765: aload #4
    //   767: aload #4
    //   769: ldc_w 'fAmount'
    //   772: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   777: invokeinterface getDouble : (I)D
    //   782: dstore #23
    //   784: aload #4
    //   786: aload #4
    //   788: ldc_w 'fReceived'
    //   791: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   796: invokeinterface getDouble : (I)D
    //   801: dstore #17
    //   803: aload #4
    //   805: aload #4
    //   807: ldc_w 'fSpareField1'
    //   810: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   815: invokeinterface getDouble : (I)D
    //   820: dstore #25
    //   822: aload #4
    //   824: aload #4
    //   826: getstatic com/laiqian/models/x.bPY : Lcom/laiqian/models/ao$b;
    //   829: invokevirtual getName : ()Ljava/lang/String;
    //   832: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   837: invokeinterface getLong : (I)J
    //   842: pop2
    //   843: dload #11
    //   845: dload #17
    //   847: dadd
    //   848: dstore #11
    //   850: dload #13
    //   852: dload #25
    //   854: dload #19
    //   856: dmul
    //   857: dadd
    //   858: dstore #17
    //   860: aload #46
    //   862: ldc2_w 100060
    //   865: invokestatic valueOf : (J)Ljava/lang/Long;
    //   868: invokevirtual equals : (Ljava/lang/Object;)Z
    //   871: ifeq -> 1056
    //   874: aload #4
    //   876: aload #4
    //   878: getstatic com/laiqian/models/x.bQu : Lcom/laiqian/models/ao$b;
    //   881: invokevirtual getName : ()Ljava/lang/String;
    //   884: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   889: invokeinterface getLong : (I)J
    //   894: lstore #29
    //   896: new com/laiqian/models/ba
    //   899: dup
    //   900: aload_0
    //   901: getfield context : Landroid/content/Context;
    //   904: invokespecial <init> : (Landroid/content/Context;)V
    //   907: astore #38
    //   909: aload #38
    //   911: lload #29
    //   913: invokevirtual bO : (J)Lcom/laiqian/product/models/o;
    //   916: astore #40
    //   918: dload #5
    //   920: dstore #13
    //   922: aload #40
    //   924: ifnull -> 1014
    //   927: aload #4
    //   929: aload #4
    //   931: ldc_w 'fAmount'
    //   934: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   939: invokeinterface getDouble : (I)D
    //   944: dstore #13
    //   946: aload #35
    //   948: new com/laiqian/product/models/p
    //   951: dup
    //   952: lload #29
    //   954: aload #40
    //   956: invokevirtual akZ : ()Ljava/lang/String;
    //   959: aload #40
    //   961: invokevirtual ala : ()D
    //   964: dload #13
    //   966: aload #4
    //   968: aload #4
    //   970: ldc_w 'fSpareField4'
    //   973: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   978: invokeinterface getDouble : (I)D
    //   983: aload #4
    //   985: aload #4
    //   987: ldc_w 'fSpareField1'
    //   990: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   995: invokeinterface getDouble : (I)D
    //   1000: invokespecial <init> : (JLjava/lang/String;DDDD)V
    //   1003: invokevirtual add : (Ljava/lang/Object;)Z
    //   1006: pop
    //   1007: dload #5
    //   1009: dload #13
    //   1011: dadd
    //   1012: dstore #13
    //   1014: aload #38
    //   1016: invokevirtual close : ()V
    //   1019: aload #4
    //   1021: astore #38
    //   1023: dload #17
    //   1025: dstore #5
    //   1027: dload #7
    //   1029: dstore #17
    //   1031: dload #9
    //   1033: dstore #19
    //   1035: aload_3
    //   1036: astore #4
    //   1038: aload #38
    //   1040: astore_3
    //   1041: dload #11
    //   1043: dstore #7
    //   1045: dload #17
    //   1047: dstore #9
    //   1049: dload #19
    //   1051: dstore #11
    //   1053: goto -> 1823
    //   1056: aload #46
    //   1058: ldc2_w 100068
    //   1061: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1064: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1067: ifeq -> 1154
    //   1070: aload #4
    //   1072: aload #4
    //   1074: getstatic com/laiqian/models/x.bPh : Lcom/laiqian/models/ao$b;
    //   1077: invokevirtual getName : ()Ljava/lang/String;
    //   1080: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1085: invokeinterface getDouble : (I)D
    //   1090: dstore #7
    //   1092: aload #4
    //   1094: aload #4
    //   1096: getstatic com/laiqian/models/x.bNL : Lcom/laiqian/models/ao$b;
    //   1099: invokevirtual getName : ()Ljava/lang/String;
    //   1102: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1107: invokeinterface getDouble : (I)D
    //   1112: dstore #21
    //   1114: aload #4
    //   1116: astore #38
    //   1118: dload #5
    //   1120: dstore #13
    //   1122: dload #9
    //   1124: dstore #19
    //   1126: dload #7
    //   1128: dstore #9
    //   1130: dload #17
    //   1132: dload #21
    //   1134: dadd
    //   1135: dstore #5
    //   1137: dload #11
    //   1139: dstore #7
    //   1141: aload_3
    //   1142: astore #4
    //   1144: aload #38
    //   1146: astore_3
    //   1147: dload #19
    //   1149: dstore #11
    //   1151: goto -> 1823
    //   1154: new java/util/HashMap
    //   1157: dup
    //   1158: invokespecial <init> : ()V
    //   1161: astore #45
    //   1163: aload #45
    //   1165: ldc 'nSpareField3'
    //   1167: iload #28
    //   1169: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1172: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1175: pop
    //   1176: aload #36
    //   1178: lload #29
    //   1180: invokevirtual bp : (J)Landroid/database/Cursor;
    //   1183: astore #47
    //   1185: aload #47
    //   1187: invokeinterface moveToFirst : ()Z
    //   1192: ifeq -> 1552
    //   1195: aload #47
    //   1197: aload #47
    //   1199: getstatic com/laiqian/models/ab.bQQ : Lcom/laiqian/models/ao$b;
    //   1202: invokevirtual getName : ()Ljava/lang/String;
    //   1205: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1210: invokeinterface getLong : (I)J
    //   1215: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1218: astore #40
    //   1220: aload #45
    //   1222: ldc_w 'nProductType'
    //   1225: aload #40
    //   1227: invokevirtual toString : ()Ljava/lang/String;
    //   1230: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1233: pop
    //   1234: aload #47
    //   1236: aload #47
    //   1238: ldc_w 'sProductName'
    //   1241: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1246: invokeinterface getString : (I)Ljava/lang/String;
    //   1251: astore #48
    //   1253: aload #47
    //   1255: aload #47
    //   1257: ldc_w 'sSpareField5'
    //   1260: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1265: invokeinterface getString : (I)Ljava/lang/String;
    //   1270: astore #49
    //   1272: aload #47
    //   1274: aload #47
    //   1276: ldc_w 'fDiscountSalePrice'
    //   1279: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1284: invokeinterface isNull : (I)Z
    //   1289: ifne -> 1328
    //   1292: aload #47
    //   1294: aload #47
    //   1296: ldc_w 'fDiscountSalePrice'
    //   1299: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1304: invokeinterface getDouble : (I)D
    //   1309: dstore #13
    //   1311: aload #45
    //   1313: ldc_w 'fMemberPrice'
    //   1316: dload #13
    //   1318: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1321: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1324: pop
    //   1325: goto -> 1331
    //   1328: dconst_0
    //   1329: dstore #13
    //   1331: aload #47
    //   1333: aload #47
    //   1335: ldc_w 'fSalePrice'
    //   1338: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1343: invokeinterface getDouble : (I)D
    //   1348: dstore #15
    //   1350: aload #45
    //   1352: ldc_w 'fDbOrigPrice'
    //   1355: dload #15
    //   1357: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1360: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1363: pop
    //   1364: ldc_w ''
    //   1367: astore #42
    //   1369: aload #50
    //   1371: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1374: ifne -> 1419
    //   1377: aload #50
    //   1379: aload #48
    //   1381: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1384: ifeq -> 1419
    //   1387: aload #42
    //   1389: astore #38
    //   1391: aload #50
    //   1393: invokevirtual length : ()I
    //   1396: aload #48
    //   1398: invokevirtual length : ()I
    //   1401: if_icmple -> 1474
    //   1404: aload #50
    //   1406: aload #48
    //   1408: invokevirtual length : ()I
    //   1411: invokevirtual substring : (I)Ljava/lang/String;
    //   1414: astore #38
    //   1416: goto -> 1474
    //   1419: aload #42
    //   1421: astore #38
    //   1423: aload #50
    //   1425: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1428: ifne -> 1474
    //   1431: aload #42
    //   1433: astore #38
    //   1435: aload #50
    //   1437: aload #49
    //   1439: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1442: ifeq -> 1474
    //   1445: aload #42
    //   1447: astore #38
    //   1449: aload #50
    //   1451: invokevirtual length : ()I
    //   1454: aload #49
    //   1456: invokevirtual length : ()I
    //   1459: if_icmple -> 1474
    //   1462: aload #50
    //   1464: aload #49
    //   1466: invokevirtual length : ()I
    //   1469: invokevirtual substring : (I)Ljava/lang/String;
    //   1472: astore #38
    //   1474: aload #45
    //   1476: ldc_w 'sSpareField5'
    //   1479: aload #49
    //   1481: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1484: pop
    //   1485: new java/lang/StringBuilder
    //   1488: dup
    //   1489: invokespecial <init> : ()V
    //   1492: astore #42
    //   1494: aload #42
    //   1496: aload #48
    //   1498: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1501: pop
    //   1502: aload #42
    //   1504: aload #38
    //   1506: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1509: pop
    //   1510: aload #45
    //   1512: ldc_w 'sProductName'
    //   1515: aload #42
    //   1517: invokevirtual toString : ()Ljava/lang/String;
    //   1520: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1523: pop
    //   1524: aload #45
    //   1526: ldc_w 'nFoodCategory'
    //   1529: iload #28
    //   1531: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1534: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1537: pop
    //   1538: dload #15
    //   1540: dload #13
    //   1542: dsub
    //   1543: dstore #13
    //   1545: aload #40
    //   1547: astore #38
    //   1549: goto -> 1559
    //   1552: dload #15
    //   1554: dstore #13
    //   1556: aconst_null
    //   1557: astore #38
    //   1559: aload #47
    //   1561: invokeinterface close : ()V
    //   1566: aload #45
    //   1568: ldc_w 'nProductTransacType'
    //   1571: aload #46
    //   1573: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1576: pop
    //   1577: new java/lang/StringBuilder
    //   1580: dup
    //   1581: invokespecial <init> : ()V
    //   1584: astore #40
    //   1586: aload #40
    //   1588: dload #21
    //   1590: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1593: pop
    //   1594: aload #40
    //   1596: ldc_w ''
    //   1599: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: pop
    //   1603: aload #45
    //   1605: ldc_w 'fPrice'
    //   1608: aload #40
    //   1610: invokevirtual toString : ()Ljava/lang/String;
    //   1613: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1616: pop
    //   1617: new java/lang/StringBuilder
    //   1620: dup
    //   1621: invokespecial <init> : ()V
    //   1624: astore #40
    //   1626: aload #40
    //   1628: dload #23
    //   1630: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1633: pop
    //   1634: aload #40
    //   1636: ldc_w ''
    //   1639: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: pop
    //   1643: aload #45
    //   1645: ldc_w 'fAmount'
    //   1648: aload #40
    //   1650: invokevirtual toString : ()Ljava/lang/String;
    //   1653: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1656: pop
    //   1657: aload #45
    //   1659: ldc_w 'nProductQty'
    //   1662: dload #19
    //   1664: invokestatic valueOf : (D)Ljava/lang/String;
    //   1667: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1670: pop
    //   1671: aload #45
    //   1673: ldc_w 'fAmount'
    //   1676: aload #4
    //   1678: aload #4
    //   1680: ldc_w 'fAmount'
    //   1683: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   1688: invokeinterface getString : (I)Ljava/lang/String;
    //   1693: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1696: pop
    //   1697: new java/lang/StringBuilder
    //   1700: dup
    //   1701: invokespecial <init> : ()V
    //   1704: astore #40
    //   1706: aload #40
    //   1708: dload #25
    //   1710: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   1713: pop
    //   1714: aload #40
    //   1716: ldc_w ''
    //   1719: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1722: pop
    //   1723: aload #45
    //   1725: ldc_w 'fOriginalPrice'
    //   1728: aload #40
    //   1730: invokevirtual toString : ()Ljava/lang/String;
    //   1733: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1736: pop
    //   1737: aload_3
    //   1738: astore #40
    //   1740: aload #40
    //   1742: aload #38
    //   1744: invokevirtual contains : (Ljava/lang/Object;)Z
    //   1747: ifne -> 1753
    //   1750: goto -> 1766
    //   1753: aload #45
    //   1755: ldc_w 'noDiscount'
    //   1758: iconst_1
    //   1759: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   1762: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1765: pop
    //   1766: aload #45
    //   1768: ldc_w 'fMemberPriceDiscount'
    //   1771: dload #13
    //   1773: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1776: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1779: pop
    //   1780: aload #31
    //   1782: aload #45
    //   1784: invokevirtual add : (Ljava/lang/Object;)Z
    //   1787: pop
    //   1788: dload #11
    //   1790: dstore #19
    //   1792: dload #13
    //   1794: dstore #15
    //   1796: dload #5
    //   1798: dstore #13
    //   1800: dload #9
    //   1802: dstore #11
    //   1804: dload #7
    //   1806: dstore #9
    //   1808: dload #19
    //   1810: dstore #7
    //   1812: aload #4
    //   1814: astore_3
    //   1815: dload #17
    //   1817: dstore #5
    //   1819: aload #40
    //   1821: astore #4
    //   1823: aload_3
    //   1824: invokeinterface moveToNext : ()Z
    //   1829: ifne -> 2145
    //   1832: aload #36
    //   1834: invokevirtual close : ()V
    //   1837: aload #34
    //   1839: new com/laiqian/report/models/w
    //   1842: dup
    //   1843: aload_0
    //   1844: invokespecial <init> : (Lcom/laiqian/report/models/v;)V
    //   1847: invokestatic a : (Ljava/util/Collection;Lcom/laiqian/util/k$b;)D
    //   1850: dstore #15
    //   1852: new com/laiqian/pos/model/orders/b
    //   1855: dup
    //   1856: invokespecial <init> : ()V
    //   1859: astore #4
    //   1861: aload #4
    //   1863: aload_2
    //   1864: putfield orderNo : Ljava/lang/String;
    //   1867: aload #41
    //   1869: ifnull -> 1898
    //   1872: aload #41
    //   1874: invokevirtual isInfinite : ()Z
    //   1877: ifne -> 1898
    //   1880: aload #41
    //   1882: invokevirtual isNaN : ()Z
    //   1885: ifne -> 1898
    //   1888: aload #4
    //   1890: aload #41
    //   1892: invokevirtual doubleValue : ()D
    //   1895: putfield cyL : D
    //   1898: aload #4
    //   1900: iconst_0
    //   1901: putfield aWg : Z
    //   1904: aload #4
    //   1906: iconst_1
    //   1907: putfield aWa : Z
    //   1910: aload #4
    //   1912: aload #37
    //   1914: putfield bkf : Ljava/util/Date;
    //   1917: aload #4
    //   1919: iload #27
    //   1921: i2l
    //   1922: putfield bcf : J
    //   1925: aload #4
    //   1927: aload #32
    //   1929: invokestatic a : (Lcom/laiqian/pos/model/orders/b;Ljava/lang/String;)Lcom/laiqian/pos/model/orders/b;
    //   1932: astore_2
    //   1933: aload_1
    //   1934: getfield orderSource : I
    //   1937: istore #27
    //   1939: iload #27
    //   1941: bipush #7
    //   1943: if_icmpne -> 1952
    //   1946: aload_2
    //   1947: aload #32
    //   1949: putfield bch : Ljava/lang/String;
    //   1952: aload_2
    //   1953: aconst_null
    //   1954: putfield openTableName : Ljava/lang/String;
    //   1957: aload_2
    //   1958: aload_1
    //   1959: getfield coJ : Ljava/lang/String;
    //   1962: putfield coJ : Ljava/lang/String;
    //   1965: aload_2
    //   1966: aload_1
    //   1967: getfield openTableName : Ljava/lang/String;
    //   1970: putfield openTableName : Ljava/lang/String;
    //   1973: aload_2
    //   1974: ldc_w ''
    //   1977: putfield cyJ : Ljava/lang/String;
    //   1980: aload_2
    //   1981: dload #5
    //   1983: invokestatic valueOf : (D)Ljava/lang/Double;
    //   1986: putfield cyP : Ljava/lang/Double;
    //   1989: aload_2
    //   1990: dload #9
    //   1992: putfield cpa : D
    //   1995: aload_2
    //   1996: dload #7
    //   1998: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2001: putfield cyO : Ljava/lang/Double;
    //   2004: aload_2
    //   2005: dconst_0
    //   2006: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2009: putfield cyH : Ljava/lang/Double;
    //   2012: aload_2
    //   2013: dload #11
    //   2015: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2018: putfield ceX : Ljava/lang/Double;
    //   2021: aload_2
    //   2022: aload_1
    //   2023: getfield daT : D
    //   2026: aload_1
    //   2027: invokevirtual amN : ()D
    //   2030: dsub
    //   2031: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2034: putfield cyI : Ljava/lang/Double;
    //   2037: aload_2
    //   2038: getfield cyN : Ljava/util/ArrayList;
    //   2041: aload #34
    //   2043: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   2046: pop
    //   2047: aload_2
    //   2048: aload_2
    //   2049: getfield cyI : Ljava/lang/Double;
    //   2052: invokevirtual doubleValue : ()D
    //   2055: aload_2
    //   2056: getfield cyL : D
    //   2059: dsub
    //   2060: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2063: putfield cyI : Ljava/lang/Double;
    //   2066: aload_2
    //   2067: aload_2
    //   2068: getfield cyI : Ljava/lang/Double;
    //   2071: invokevirtual doubleValue : ()D
    //   2074: dload #15
    //   2076: dadd
    //   2077: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2080: putfield cyI : Ljava/lang/Double;
    //   2083: aload_2
    //   2084: getfield bbS : Ljava/util/ArrayList;
    //   2087: aload #43
    //   2089: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   2092: pop
    //   2093: aload_2
    //   2094: getfield bJf : Ljava/util/ArrayList;
    //   2097: aload #31
    //   2099: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   2102: pop
    //   2103: aload_2
    //   2104: aload #39
    //   2106: putfield ceV : Ljava/lang/String;
    //   2109: aload_2
    //   2110: aload #33
    //   2112: putfield vipEntity : Lcom/laiqian/entity/aq;
    //   2115: aload_2
    //   2116: getfield cyR : Ljava/util/ArrayList;
    //   2119: aload #35
    //   2121: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   2124: pop
    //   2125: aload_2
    //   2126: dload #13
    //   2128: invokestatic valueOf : (D)Ljava/lang/Double;
    //   2131: putfield cyQ : Ljava/lang/Double;
    //   2134: aload_2
    //   2135: aload #44
    //   2137: putfield billNumber : Ljava/lang/String;
    //   2140: aload_2
    //   2141: astore_1
    //   2142: goto -> 2191
    //   2145: dload #13
    //   2147: dstore #17
    //   2149: dload #7
    //   2151: dstore #19
    //   2153: dload #9
    //   2155: dstore #7
    //   2157: dload #11
    //   2159: dstore #9
    //   2161: aload_3
    //   2162: astore #38
    //   2164: aload #4
    //   2166: astore_3
    //   2167: aload #38
    //   2169: astore #4
    //   2171: dload #5
    //   2173: dstore #13
    //   2175: dload #19
    //   2177: dstore #11
    //   2179: dload #17
    //   2181: dstore #5
    //   2183: goto -> 462
    //   2186: aload #31
    //   2188: astore_3
    //   2189: aconst_null
    //   2190: astore_1
    //   2191: aload_3
    //   2192: ifnull -> 2201
    //   2195: aload_3
    //   2196: invokeinterface close : ()V
    //   2201: aload_1
    //   2202: areturn
    // Exception table:
    //   from	to	target	type
    //   265	272	275	java/lang/Exception
    //   472	493	516	java/lang/Exception
    //   493	504	511	java/lang/Exception }
  
  private void anw() {
    if (this.dbT == null)
      return; 
    try {
      List list = j.cCx.a(this.dbT, new String[] { "settle_receipt" });
      g.cGS.o(list);
      if (this.isUserCashReturn) {
        g.cGS.o(j.cCx.a(new Object(), new String[] { "cash_drawer" }));
        this.context.sendBroadcast(new Intent("android.intent.money_test.action"));
        runtime = Runtime.getRuntime();
        try {
          runtime.exec("echo 0 > /sys/devices/platform/att_test/test");
          return;
        } catch (IOException runtime) {
          a.e(runtime);
          return;
        } 
      } 
    } catch (Exception exception) {
      a.e(exception);
    } 
  }
  
  public void anv() {
    anw();
    anx();
  }
  
  void anx() {
    if (this.dbT == null)
      return; 
    try {
      List list = j.cCx.a(this.dbT, new String[] { "kitchen_total", "kitchen_port" });
      this.bga.p(list);
      g.cGS.o(list);
      return;
    } catch (Exception exception) {
      a.e(exception);
      return;
    } 
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\report\models\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */