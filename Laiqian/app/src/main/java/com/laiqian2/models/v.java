package com.laiqian.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import com.google.a.a.a.a.a.a;
import com.laiqian.db.multidatabase.d.b;
import com.laiqian.main.bb;
import com.laiqian.product.models.g;
import com.laiqian.product.models.m;
import com.laiqian.util.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class v extends x {
  public v(Context paramContext) { super(paramContext); }
  
  public String a(m paramm, double paramDouble, int paramInt) {
    ArrayList arrayList = new ArrayList();
    arrayList.add(paramm);
    beginTransaction();
    String str = a(arrayList, paramDouble, paramInt, null);
    if (str == null)
      setTransactionSuccessful(); 
    endTransaction();
    return str;
  }
  
  public String a(ArrayList<m> paramArrayList, double paramDouble, int paramInt, @Nullable bb parambb) { // Byte code:
    //   0: iload #4
    //   2: istore #8
    //   4: aload_1
    //   5: ifnull -> 1230
    //   8: aload_1
    //   9: invokevirtual isEmpty : ()Z
    //   12: ifeq -> 18
    //   15: goto -> 1230
    //   18: new com/laiqian/product/models/g
    //   21: dup
    //   22: aload_0
    //   23: getfield mContext : Landroid/content/Context;
    //   26: invokespecial <init> : (Landroid/content/Context;)V
    //   29: astore #13
    //   31: iload #8
    //   33: ldc 100051
    //   35: if_icmpne -> 73
    //   38: aload #5
    //   40: ifnonnull -> 67
    //   43: aload #13
    //   45: invokevirtual close : ()V
    //   48: ldc '销售时，必须有结算类'
    //   50: areturn
    //   51: astore #5
    //   53: aload #13
    //   55: astore_1
    //   56: goto -> 1223
    //   59: astore_1
    //   60: aload #13
    //   62: astore #5
    //   64: goto -> 1199
    //   67: lconst_0
    //   68: lstore #10
    //   70: goto -> 389
    //   73: aload #13
    //   75: astore #14
    //   77: aload #13
    //   79: astore #15
    //   81: new java/util/Date
    //   84: dup
    //   85: invokespecial <init> : ()V
    //   88: astore #17
    //   90: aload #13
    //   92: astore #14
    //   94: aload #13
    //   96: astore #15
    //   98: aload #17
    //   100: invokevirtual getTime : ()J
    //   103: lstore #10
    //   105: aload #13
    //   107: astore #14
    //   109: aload #13
    //   111: astore #15
    //   113: invokestatic getLaiqianPreferenceManager : ()Lcom/laiqian/util/av;
    //   116: invokevirtual Ea : ()Ljava/lang/String;
    //   119: invokestatic pn : (Ljava/lang/String;)Ljava/lang/String;
    //   122: astore #16
    //   124: aload #13
    //   126: astore #14
    //   128: aload #13
    //   130: astore #15
    //   132: new java/text/SimpleDateFormat
    //   135: dup
    //   136: ldc 'yyyyMMddHHmmssSSS'
    //   138: invokespecial <init> : (Ljava/lang/String;)V
    //   141: aload #17
    //   143: invokevirtual format : (Ljava/util/Date;)Ljava/lang/String;
    //   146: astore #17
    //   148: aload #13
    //   150: astore #14
    //   152: aload #13
    //   154: astore #15
    //   156: new java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial <init> : ()V
    //   163: astore #18
    //   165: aload #13
    //   167: astore #14
    //   169: aload #13
    //   171: astore #15
    //   173: aload #18
    //   175: ldc 'PD-'
    //   177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload #13
    //   183: astore #14
    //   185: aload #13
    //   187: astore #15
    //   189: aload #18
    //   191: aload #16
    //   193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload #13
    //   199: astore #14
    //   201: aload #13
    //   203: astore #15
    //   205: aload #18
    //   207: ldc '-'
    //   209: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload #13
    //   215: astore #14
    //   217: aload #13
    //   219: astore #15
    //   221: aload #18
    //   223: aload #17
    //   225: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload #13
    //   231: astore #14
    //   233: aload #13
    //   235: astore #15
    //   237: aload_0
    //   238: ldc 'sOrderNo'
    //   240: aload #18
    //   242: invokevirtual toString : ()Ljava/lang/String;
    //   245: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   248: pop
    //   249: aload #13
    //   251: astore #14
    //   253: aload #13
    //   255: astore #15
    //   257: new java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial <init> : ()V
    //   264: astore #16
    //   266: aload #13
    //   268: astore #14
    //   270: aload #13
    //   272: astore #15
    //   274: aload #16
    //   276: lload #10
    //   278: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload #13
    //   284: astore #14
    //   286: aload #13
    //   288: astore #15
    //   290: aload #16
    //   292: ldc ''
    //   294: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload #13
    //   300: astore #14
    //   302: aload #13
    //   304: astore #15
    //   306: aload_0
    //   307: ldc 'nDateTime'
    //   309: aload #16
    //   311: invokevirtual toString : ()Ljava/lang/String;
    //   314: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   317: pop
    //   318: aload #13
    //   320: astore #14
    //   322: aload #13
    //   324: astore #15
    //   326: new java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial <init> : ()V
    //   333: astore #16
    //   335: aload #13
    //   337: astore #14
    //   339: aload #13
    //   341: astore #15
    //   343: aload #16
    //   345: aload_0
    //   346: invokevirtual VC : ()Ljava/lang/String;
    //   349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload #13
    //   355: astore #14
    //   357: aload #13
    //   359: astore #15
    //   361: aload #16
    //   363: ldc ''
    //   365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload #13
    //   371: astore #14
    //   373: aload #13
    //   375: astore #15
    //   377: aload_0
    //   378: ldc 'nWarehouseID'
    //   380: aload #16
    //   382: invokevirtual toString : ()Ljava/lang/String;
    //   385: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   388: pop
    //   389: aload #13
    //   391: astore #14
    //   393: aload #13
    //   395: astore #15
    //   397: aload_0
    //   398: ldc 'fDiscount'
    //   400: ldc '100'
    //   402: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   405: pop
    //   406: aload #13
    //   408: astore #14
    //   410: aload #13
    //   412: astore #15
    //   414: aload_0
    //   415: ldc 'fPrice'
    //   417: ldc '0'
    //   419: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   422: pop
    //   423: aload #13
    //   425: astore #14
    //   427: aload #13
    //   429: astore #15
    //   431: aload_0
    //   432: ldc 'fAmount'
    //   434: ldc '0'
    //   436: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   439: pop
    //   440: aload #13
    //   442: astore #14
    //   444: aload #13
    //   446: astore #15
    //   448: aload_0
    //   449: ldc 'fReceived'
    //   451: ldc '0'
    //   453: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   456: pop
    //   457: aload #13
    //   459: astore #14
    //   461: aload #13
    //   463: astore #15
    //   465: aload_0
    //   466: ldc 'fSpareField1'
    //   468: ldc '0'
    //   470: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   473: pop
    //   474: aload #13
    //   476: astore #14
    //   478: aload #13
    //   480: astore #15
    //   482: new java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial <init> : ()V
    //   489: astore #16
    //   491: aload #13
    //   493: astore #14
    //   495: aload #13
    //   497: astore #15
    //   499: aload #16
    //   501: iload #8
    //   503: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload #13
    //   509: astore #14
    //   511: aload #13
    //   513: astore #15
    //   515: aload #16
    //   517: ldc ''
    //   519: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload #13
    //   525: astore #14
    //   527: aload #13
    //   529: astore #15
    //   531: aload_0
    //   532: ldc 'nProductTransacType'
    //   534: aload #16
    //   536: invokevirtual toString : ()Ljava/lang/String;
    //   539: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   542: pop
    //   543: iconst_0
    //   544: istore #8
    //   546: iload #4
    //   548: istore #9
    //   550: aload #13
    //   552: astore #14
    //   554: aload #13
    //   556: astore #15
    //   558: iload #8
    //   560: aload_1
    //   561: invokevirtual size : ()I
    //   564: if_icmpge -> 1179
    //   567: aload #13
    //   569: astore #14
    //   571: aload #13
    //   573: astore #15
    //   575: aload_1
    //   576: iload #8
    //   578: invokevirtual get : (I)Ljava/lang/Object;
    //   581: checkcast com/laiqian/product/models/m
    //   584: astore #16
    //   586: aload #13
    //   588: astore #14
    //   590: aload #13
    //   592: astore #15
    //   594: aload #16
    //   596: getfield cVm : D
    //   599: dstore #6
    //   601: dload #6
    //   603: dconst_0
    //   604: dcmpl
    //   605: ifne -> 617
    //   608: aload #16
    //   610: dload_2
    //   611: putfield cVm : D
    //   614: goto -> 617
    //   617: iload #9
    //   619: tableswitch default -> 648, 100051 -> 704, 100052 -> 678, 100053 -> 667, 100054 -> 651
    //   648: goto -> 1163
    //   651: aload #16
    //   653: getfield cVm : D
    //   656: aload #16
    //   658: invokevirtual akU : ()D
    //   661: dsub
    //   662: dstore #6
    //   664: goto -> 712
    //   667: aload #16
    //   669: getfield cVm : D
    //   672: dneg
    //   673: dstore #6
    //   675: goto -> 712
    //   678: aload #16
    //   680: getfield cVm : D
    //   683: dstore #6
    //   685: goto -> 712
    //   688: astore #5
    //   690: aload #13
    //   692: astore_1
    //   693: goto -> 1223
    //   696: astore_1
    //   697: aload #13
    //   699: astore #5
    //   701: goto -> 1199
    //   704: aload #16
    //   706: getfield cVm : D
    //   709: dneg
    //   710: dstore #6
    //   712: aload #13
    //   714: astore #14
    //   716: dload #6
    //   718: aload #16
    //   720: getfield cVl : D
    //   723: dmul
    //   724: dstore #6
    //   726: dload #6
    //   728: invokestatic bc : (D)Z
    //   731: istore #12
    //   733: iload #12
    //   735: ifeq -> 741
    //   738: goto -> 1134
    //   741: iload #9
    //   743: ldc 100051
    //   745: if_icmpne -> 791
    //   748: new java/lang/StringBuilder
    //   751: dup
    //   752: invokespecial <init> : ()V
    //   755: astore #15
    //   757: aload #15
    //   759: aload #5
    //   761: invokevirtual Lx : ()J
    //   764: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload #15
    //   770: ldc ''
    //   772: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: pop
    //   776: aload_0
    //   777: ldc '_id'
    //   779: aload #15
    //   781: invokevirtual toString : ()Ljava/lang/String;
    //   784: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   787: pop
    //   788: goto -> 903
    //   791: new java/lang/StringBuilder
    //   794: dup
    //   795: invokespecial <init> : ()V
    //   798: astore #15
    //   800: aload #15
    //   802: lload #10
    //   804: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   807: pop
    //   808: aload #15
    //   810: ldc ''
    //   812: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: aload_0
    //   817: ldc '_id'
    //   819: aload #15
    //   821: invokevirtual toString : ()Ljava/lang/String;
    //   824: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   827: pop
    //   828: dload #6
    //   830: dconst_0
    //   831: dcmpl
    //   832: ifle -> 842
    //   835: ldc '300001'
    //   837: astore #15
    //   839: goto -> 846
    //   842: ldc '300002'
    //   844: astore #15
    //   846: aload_0
    //   847: ldc 'nStcokDirection'
    //   849: aload #15
    //   851: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   854: pop
    //   855: new java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial <init> : ()V
    //   862: astore #15
    //   864: aload #15
    //   866: iload #8
    //   868: iconst_1
    //   869: iadd
    //   870: bipush #10
    //   872: imul
    //   873: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   876: pop
    //   877: aload #15
    //   879: ldc ''
    //   881: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: pop
    //   885: aload_0
    //   886: ldc 'sItemNo'
    //   888: aload #15
    //   890: invokevirtual toString : ()Ljava/lang/String;
    //   893: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   896: pop
    //   897: lload #10
    //   899: lconst_1
    //   900: ladd
    //   901: lstore #10
    //   903: dload #6
    //   905: dconst_0
    //   906: dcmpl
    //   907: ifle -> 945
    //   910: new java/lang/StringBuilder
    //   913: dup
    //   914: invokespecial <init> : ()V
    //   917: astore #15
    //   919: aload #15
    //   921: dload #6
    //   923: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   926: pop
    //   927: aload #15
    //   929: ldc ''
    //   931: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: pop
    //   935: aload #15
    //   937: invokevirtual toString : ()Ljava/lang/String;
    //   940: astore #15
    //   942: goto -> 978
    //   945: new java/lang/StringBuilder
    //   948: dup
    //   949: invokespecial <init> : ()V
    //   952: astore #15
    //   954: aload #15
    //   956: dload #6
    //   958: dneg
    //   959: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   962: pop
    //   963: aload #15
    //   965: ldc ''
    //   967: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   970: pop
    //   971: aload #15
    //   973: invokevirtual toString : ()Ljava/lang/String;
    //   976: astore #15
    //   978: aload_0
    //   979: ldc 'nProductQty'
    //   981: aload #15
    //   983: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   986: pop
    //   987: new java/lang/StringBuilder
    //   990: dup
    //   991: invokespecial <init> : ()V
    //   994: astore #15
    //   996: aload #15
    //   998: aload #16
    //   1000: getfield aSW : J
    //   1003: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1006: pop
    //   1007: aload #15
    //   1009: ldc ''
    //   1011: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: pop
    //   1015: aload_0
    //   1016: ldc 'nProductID'
    //   1018: aload #15
    //   1020: invokevirtual toString : ()Ljava/lang/String;
    //   1023: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1026: pop
    //   1027: aload_0
    //   1028: ldc 'sProductName'
    //   1030: aload #16
    //   1032: invokevirtual getName : ()Ljava/lang/String;
    //   1035: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1038: pop
    //   1039: new java/lang/StringBuilder
    //   1042: dup
    //   1043: invokespecial <init> : ()V
    //   1046: astore #15
    //   1048: aload #15
    //   1050: aload #16
    //   1052: invokevirtual Ww : ()J
    //   1055: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   1058: pop
    //   1059: aload #15
    //   1061: ldc ''
    //   1063: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: pop
    //   1067: aload_0
    //   1068: ldc 'nProductUnit'
    //   1070: aload #15
    //   1072: invokevirtual toString : ()Ljava/lang/String;
    //   1075: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1078: pop
    //   1079: aload_0
    //   1080: ldc 'nSpareField3'
    //   1082: ldc '1'
    //   1084: invokevirtual am : (Ljava/lang/String;Ljava/lang/String;)Z
    //   1087: pop
    //   1088: aload_0
    //   1089: invokevirtual QL : ()Z
    //   1092: ifne -> 1103
    //   1095: aload #14
    //   1097: invokevirtual close : ()V
    //   1100: ldc '创建原材料记录失败'
    //   1102: areturn
    //   1103: aload #14
    //   1105: astore #15
    //   1107: aload #15
    //   1109: astore #13
    //   1111: aload #15
    //   1113: aload #16
    //   1115: getfield aSW : J
    //   1118: dload #6
    //   1120: invokevirtual c : (JD)Z
    //   1123: ifne -> 1134
    //   1126: aload #15
    //   1128: invokevirtual close : ()V
    //   1131: ldc '修改原材料库存失败'
    //   1133: areturn
    //   1134: iload #8
    //   1136: iconst_1
    //   1137: iadd
    //   1138: istore #8
    //   1140: aload #14
    //   1142: astore #13
    //   1144: goto -> 546
    //   1147: astore #5
    //   1149: aload #13
    //   1151: astore_1
    //   1152: goto -> 1191
    //   1155: astore_1
    //   1156: aload #13
    //   1158: astore #5
    //   1160: goto -> 1199
    //   1163: aload #13
    //   1165: invokevirtual close : ()V
    //   1168: ldc '选择的业务类型错误。'
    //   1170: areturn
    //   1171: astore_1
    //   1172: aload #15
    //   1174: astore #5
    //   1176: goto -> 1199
    //   1179: aload #13
    //   1181: invokevirtual close : ()V
    //   1184: aconst_null
    //   1185: areturn
    //   1186: astore #5
    //   1188: aload #14
    //   1190: astore_1
    //   1191: goto -> 1223
    //   1194: astore_1
    //   1195: aload #15
    //   1197: astore #5
    //   1199: aload #5
    //   1201: astore #13
    //   1203: aload_1
    //   1204: invokestatic e : (Ljava/lang/Throwable;)V
    //   1207: aload #5
    //   1209: invokevirtual close : ()V
    //   1212: ldc '未知错误'
    //   1214: areturn
    //   1215: astore #5
    //   1217: aload #13
    //   1219: astore_1
    //   1220: goto -> 1191
    //   1223: aload_1
    //   1224: invokevirtual close : ()V
    //   1227: aload #5
    //   1229: athrow
    //   1230: aconst_null
    //   1231: areturn
    // Exception table:
    //   from	to	target	type
    //   81	90	1194	java/lang/Throwable
    //   81	90	1186	finally
    //   98	105	1194	java/lang/Throwable
    //   98	105	1186	finally
    //   113	124	1194	java/lang/Throwable
    //   113	124	1186	finally
    //   132	148	1194	java/lang/Throwable
    //   132	148	1186	finally
    //   156	165	1194	java/lang/Throwable
    //   156	165	1186	finally
    //   173	181	1194	java/lang/Throwable
    //   173	181	1186	finally
    //   189	197	1194	java/lang/Throwable
    //   189	197	1186	finally
    //   205	213	1194	java/lang/Throwable
    //   205	213	1186	finally
    //   221	229	1194	java/lang/Throwable
    //   221	229	1186	finally
    //   237	249	1194	java/lang/Throwable
    //   237	249	1186	finally
    //   257	266	1194	java/lang/Throwable
    //   257	266	1186	finally
    //   274	282	1194	java/lang/Throwable
    //   274	282	1186	finally
    //   290	298	1194	java/lang/Throwable
    //   290	298	1186	finally
    //   306	318	1194	java/lang/Throwable
    //   306	318	1186	finally
    //   326	335	1194	java/lang/Throwable
    //   326	335	1186	finally
    //   343	353	1194	java/lang/Throwable
    //   343	353	1186	finally
    //   361	369	1194	java/lang/Throwable
    //   361	369	1186	finally
    //   377	389	1194	java/lang/Throwable
    //   377	389	1186	finally
    //   397	406	1194	java/lang/Throwable
    //   397	406	1186	finally
    //   414	423	1194	java/lang/Throwable
    //   414	423	1186	finally
    //   431	440	1194	java/lang/Throwable
    //   431	440	1186	finally
    //   448	457	1194	java/lang/Throwable
    //   448	457	1186	finally
    //   465	474	1194	java/lang/Throwable
    //   465	474	1186	finally
    //   482	491	1194	java/lang/Throwable
    //   482	491	1186	finally
    //   499	507	1194	java/lang/Throwable
    //   499	507	1186	finally
    //   515	523	1194	java/lang/Throwable
    //   515	523	1186	finally
    //   531	543	1194	java/lang/Throwable
    //   531	543	1186	finally
    //   558	567	1194	java/lang/Throwable
    //   558	567	1186	finally
    //   575	586	1194	java/lang/Throwable
    //   575	586	1186	finally
    //   594	601	1194	java/lang/Throwable
    //   594	601	1186	finally
    //   608	614	59	java/lang/Throwable
    //   608	614	51	finally
    //   651	664	696	java/lang/Throwable
    //   651	664	688	finally
    //   667	675	696	java/lang/Throwable
    //   667	675	688	finally
    //   678	685	696	java/lang/Throwable
    //   678	685	688	finally
    //   704	712	1155	java/lang/Throwable
    //   704	712	1147	finally
    //   716	733	1155	java/lang/Throwable
    //   716	733	1147	finally
    //   748	788	696	java/lang/Throwable
    //   748	788	688	finally
    //   791	828	1155	java/lang/Throwable
    //   791	828	1147	finally
    //   846	897	1155	java/lang/Throwable
    //   846	897	1147	finally
    //   910	942	696	java/lang/Throwable
    //   910	942	688	finally
    //   945	978	1155	java/lang/Throwable
    //   945	978	1147	finally
    //   978	1095	1155	java/lang/Throwable
    //   978	1095	1147	finally
    //   1111	1126	1171	java/lang/Throwable
    //   1111	1126	1215	finally
    //   1203	1207	1215	finally }
  
  public void a(String paramString, long paramLong1, long paramLong2) {
    SQLiteDatabase sQLiteDatabase = aNE;
    String str1 = VC();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramLong1);
    stringBuilder1.append("");
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLong2);
    stringBuilder2.append("");
    sQLiteDatabase.execSQL("UPDATE t_productdoc set nUpdateFlag= case when nUpdateFlag is null then 2 else nUpdateFlag+2 end, nIsUpdated = 1  Where sOrderNo = ? and nShopID = ? and (nOperationTime =? or nOperationTime =?)", new String[] { paramString, str1, str2, stringBuilder2.toString() });
  }
  
  public ArrayList<x.a> d(String paramString, long paramLong) {
    try {
      exception = b.f(paramLong, paramLong);
    } catch (Exception exception) {
      a.e(exception);
      exception = null;
    } 
    null = exception.entrySet();
    null = "";
    for (Map.Entry entry : null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(null);
      stringBuilder.append("select * from ");
      stringBuilder.append((String)entry.getValue());
      stringBuilder.append(".T_PRODUCTDOC  where sOrderNo = '");
      stringBuilder.append(paramString);
      stringBuilder.append("' and nShopID = ");
      stringBuilder.append(VC());
      stringBuilder.append(" and nIsUpdated=0 and nOperationTime=");
      stringBuilder.append(paramLong);
      null = stringBuilder.toString();
    } 
    try {
      Cursor cursor = r(paramLong, paramLong).rawQuery(null, null);
    } catch (Exception paramString) {
      a.e(paramString);
      paramString = null;
    } 
    if (paramString == null)
      throw new NullPointerException("wrong sql"); 
    ArrayList arrayList = new ArrayList();
    while (paramString.moveToNext()) {
      x.a a = new x.a();
      ao.a(paramString, a);
      arrayList.add(a);
    } 
    paramString.close();
    return arrayList;
  }
  
  public String rawStorage(long[] paramArrayOfLong, double[] paramArrayOfDouble) {
    null = new StringBuilder();
    null.append("这里是原材料入库，ID：");
    null.append(Arrays.toString(paramArrayOfLong));
    null.append(",数量：");
    null.append(Arrays.toString(paramArrayOfDouble));
    n.println(null.toString());
    if (paramArrayOfLong == null || paramArrayOfDouble == null || paramArrayOfLong.length == 0 || paramArrayOfDouble.length == 0 || paramArrayOfLong.length != paramArrayOfDouble.length)
      return "数据错误"; 
    g g = new g(this.mContext);
    g.beginTransaction();
    try {
      ArrayList arrayList = new ArrayList();
      for (byte b = 0; b < paramArrayOfLong.length; b++) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(VC());
        stringBuilder.append(paramArrayOfLong[b]);
        m m = g.mG(stringBuilder.toString());
        if (m == null) {
          String str1 = this.mContext.getString(2131627588);
          g.endTransaction();
          g.close();
          return str1;
        } 
        m.cVm = paramArrayOfDouble[b];
        arrayList.add(m);
      } 
      String str = a(arrayList, 0.0D, 100052, null);
      if (str == null)
        g.setTransactionSuccessful(); 
      g.endTransaction();
      g.close();
      return str;
    } catch (Throwable paramArrayOfLong) {
      a.e(paramArrayOfLong);
      g.endTransaction();
      g.close();
      return "未知异常";
    } finally {}
    g.endTransaction();
    g.close();
    throw paramArrayOfLong;
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqian\models\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */